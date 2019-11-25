package br.ucsal.ev20192.leitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ucsal.ev20192.leitor.utils.ContadorBadSmellClasse;
import br.ucsal.ev20192.leitor.utils.ContadorBadSmellMetodo;

public class Leitor {

	private static final List<Resultado> meses = new ArrayList<>();
	public static final String PADRAOCLASSES = ".*(static class|public class|private class|protected class).*";
	public static final String PADRAOMETODOS = ".*(public|private|protected|void|\\ Bitmap)(.*\\)\\ \\{|.*\\ throws.*)";
	/* Regex C: ^(static int|static void|static float|static char|static double|int|float|char|double|void) */
	public static final String PADRAOABRIRCOMENTARIO = "/*";
	public static final String PADRAOFECHARCOMENTARIO = "*/";
	public static final String PADRAOLINHA = ".*[\\S]";
	private static Boolean comentario = false;

	private Leitor() {
	}

	public static List<Resultado> getMeses() {
		return meses;
	}

	public static Resultado lerArquivo(BufferedReader codigo) {
		Resultado resultado = new Resultado();
		String linha = "";

		try {
			while (codigo.ready()) {
				linha = codigo.readLine();
				contarClasses(resultado, linha);

				if (linha.contains(PADRAOABRIRCOMENTARIO)) {
					comentario = true;
				}
				
				if (linha.contains(PADRAOFECHARCOMENTARIO)) {
					comentario = false;
				}

				if (!comentario) {
					contarMetodos(resultado, linha);
				}

				contarLinhas(resultado, linha);
				ContadorBadSmellMetodo.contarMetodosDeus(linha, PADRAOMETODOS);
				ContadorBadSmellClasse.contarClasseDeus(linha, PADRAOCLASSES);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		resultado.setQtdMetodosDeus(ContadorBadSmellMetodo.getQtdMetodosDeus());
		if (ContadorBadSmellClasse.getQtdLinhas() > ContadorBadSmellClasse.getLinhasclassedeus()) {
			ContadorBadSmellClasse.incrementaClasseDeus();
		}
		resultado.setQtdClassesDeus(ContadorBadSmellClasse.getQtdClasseDeus());
		ContadorBadSmellMetodo.limparNovoArquivo();
		ContadorBadSmellClasse.limparNovoArquivo();

		return resultado;
	}

	private static void contarLinhas(Resultado result, String linha) {
		Pattern p = Pattern.compile(PADRAOLINHA);
		Matcher m = p.matcher(linha);

		while (m.find()) {
			result.incrementarLoc();
		}
	}

	private static void contarMetodos(Resultado result, String linha) {
		Pattern pMetodo = Pattern.compile(PADRAOMETODOS);
		Matcher m = pMetodo.matcher(linha);

		while (m.find()) {
			result.incrementarMetodos();
		}
	}

	private static void contarClasses(Resultado result, String linha) {
		Pattern p = Pattern.compile(PADRAOCLASSES);
		Matcher m = p.matcher(linha);

		while (m.find()) {
			result.incrementarClasses();
		}
	}

	public static File[] listarDiriretorios(File dir) {
		List<File> enc = new ArrayList<>();
		try {
			File[] arquivos = dir.listFiles();
			for (int i = 0; i < arquivos.length; i++) {
				Integer loc = 0;
				Integer met = 0;
				Integer cla = 0;
				Integer claDe = 0;
				Integer metDe = 0;

				if (arquivos[i].isDirectory()) {
					File[] recArq = listarDiriretorios(arquivos[i]);
					for (int j = 0; j < recArq.length; j++) {
						enc.add(recArq[j]);

						Resultado resultado = lerArquivo(new BufferedReader(new FileReader(recArq[j])));
						loc += resultado.getLoc();
						met += resultado.getQtdMetodos();
						cla += resultado.getQtdClasses();
						claDe += resultado.getQtdClassesDeus();
						metDe += resultado.getQtdMetodosDeus();
					}

					Resultado mes = new Resultado(loc, cla, met, claDe, metDe, Integer.parseInt(arquivos[i].getName()));
					meses.add(mes);

				} else {
					enc.add(arquivos[i]);
				}

			}
		} catch (FileNotFoundException e) {
			Interface.mensagem("Não foi possivel encontrar o arquivo");
		}

		// Transforma uma lista em um File[]:
		return transformarLista(enc);
	}

	private static File[] transformarLista(List<File> enc) {
		File[] encontrados = new File[enc.size()];
		for (int i = 0; i < enc.size(); i++) {
			encontrados[i] = enc.get(i);
		}
		return encontrados;
	}

	public static File[] filtrarDirertorios(File[] listaArquivos) {
		List<File> arquivos = new ArrayList<>();

		for (int i = 0; i < listaArquivos.length; i++) {
			if (listaArquivos[i].getName().endsWith(".java")) {
				arquivos.add(listaArquivos[i]);
			}
		}

		return transformarLista(arquivos);
	}

	public static List<Resultado> mesesOrdenados() {
		Collections.sort(meses);
		return meses;
	}

}
