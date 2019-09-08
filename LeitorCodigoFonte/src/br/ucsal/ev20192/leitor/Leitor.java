package br.ucsal.ev20192.leitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leitor {

	private static final List<Resultado> meses = new ArrayList<>();
	public static final String PADRAOCLASSES = "(class|public class|private class|protected class).*";
	public static final String PADRAOMETODOS = ".*(public|private|protected).*\\)\\ \\{";
	public static final String PADRAOLINHA = ".*[\\S]";

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
				if (linha.matches(PADRAOCLASSES)) {
					result.setQtdClasses();
				}
				if (linha.matches(PADRAOMETODOS)) {
					result.setQtdMetodos();
				}
				if (linha.matches(PADRAOLINHA)) {
					result.setLoc();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static File[] listarDiriretorios(File dir) {
		List<File> enc = new ArrayList<>();
		try {
			File[] arquivos = dir.listFiles();
			for (int i = 0; i < arquivos.length; i++) {
				Integer loc = 0;
				Integer met = 0;
				Integer cla = 0;
				if (arquivos[i].isDirectory()) {
					File[] recArq = listarDiriretorios(arquivos[i]);
					for (int j = 0; j < recArq.length; j++) {
						enc.add(recArq[j]);

						Resultado resultado = lerArquivo(new BufferedReader(new FileReader(recArq[j])));
						loc += resultado.getLoc();
						met += resultado.getQtdMetodos();
						cla += resultado.getQtdClasses();

					}

					Resultado mes = new Resultado(loc, cla, met, Integer.parseInt(arquivos[i].getName()));
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