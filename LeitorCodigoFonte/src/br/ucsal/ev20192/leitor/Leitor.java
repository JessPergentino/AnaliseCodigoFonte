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

public class Leitor {

	private static final int LINHASCLASSEDEUS = 800;
	private static final int LINHASMETODODEUS = 127;
	private static final List<Resultado> meses = new ArrayList<>();
	public static final String PADRAOCLASSES = ".*(static class|public class|private class|protected class.*)";
	public static final String PADRAOMETODOS = ".*(public|private|protected|void|\\ Bitmap)(.*\\)\\ \\{|.*\\ throws.*)";
	public static final String PADRAOMETODOSCOMABSTRATOS = ".*(public|private|protected|void|\\ Bitmap)(.*\\)\\ \\{)|.*(public abstract\\ |private abstract\\ |protected static\\ )(.*\\)\\ \\{)";
	public static final String PADRAOCOMENTARIO = ".*(\\/\\*)|\\*\\/";
	public static final String PADRAOLINHA = ".*[\\S]";
	public static final String PADRAOABRIR = "\\{";
	public static final String PADRAOFECHAR = "\\}";
	

	private Leitor() {
	}

	public static List<Resultado> getMeses() {
		return meses;
	}

	public static Resultado lerArquivo(BufferedReader codigo) {
		Resultado result = new Resultado();
		String linha = "";

		try {
			while (codigo.ready()) {
				linha = codigo.readLine();
				contarClasses(result, linha);
				contarMetodos(result, linha);
				contarLinhas(result, linha);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		contarClasseDeus(codigo, result);
		result.setQtdMetodosDeus(contarMetodosDeus(codigo));

		return result;
	}

	private static void contarLinhas(Resultado result, String linha) {
		Pattern p = Pattern.compile(PADRAOLINHA);
		Matcher m = p.matcher(linha);

		while (m.find()) {
			result.setLoc();
		}
	}

	private static void contarMetodos(Resultado result, String linha) {
		Pattern pMetodo = Pattern.compile(PADRAOMETODOS);
		Matcher m = pMetodo.matcher(linha);

		while (m.find()) {
			result.setQtdMetodos();
		}	
	}

	private static void contarClasses(Resultado result, String linha) {
		Pattern p = Pattern.compile(PADRAOCLASSES);
		Matcher m = p.matcher(linha);

		while (m.find()) {
			result.setQtdClasses();
		}
	}

	private static void contarClasseDeus(BufferedReader codigo, Resultado result) {
		String linha = "";
		Integer qtdLinhas = 0;
		Integer abrir = 0;
		Integer fechar = 0;
		
		try {
			while (codigo.ready()) {
				if(linha.matches(PADRAOABRIR)) {
					qtdLinhas++;
				}
				

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static Integer contarMetodosDeus(BufferedReader codigo) {
		String linha = "";
		Integer qtdMetodosDeus = 0;
		Integer qtdLinhas = 0;
		Integer abrir = 0;
		Integer fechar = 0;
		
		try {
			while (codigo.ready()) {
				if(linha.matches(PADRAOMETODOS)) {
				
				}
				

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return qtdMetodosDeus;
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
