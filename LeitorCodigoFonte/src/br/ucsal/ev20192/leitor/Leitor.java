package br.ucsal.ev20192.leitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor {

	public static final String PATTERCLASS = "(class|public class|private class|protected class).*";
	public static final String PATTERMETHOD = ".*(public|private|protected).*\\)\\ \\{";
	public static final String PATTERLINE = ".*[\\S]";

	private Leitor() {
	}

	public static Resultado lerArquivo(BufferedReader codigo) {
		Resultado result = new Resultado();
		String linha = "";

		try {
			while (codigo.ready()) {
				linha = codigo.readLine();
				if (linha.matches(PATTERCLASS)) {
					result.setQtdClass();
				}
				if (linha.matches(PATTERMETHOD)) {
					result.setQtdMetodos();
				}
				if (linha.matches(PATTERLINE)) {
					result.setLoc();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static File[] listarDiriretorios(File dir) {
		List<File> enc = new ArrayList<File>();

		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				// Adiciona no Vector os arquivos encontrados dentro de 'files[i]':
				File[] recFiles = listarDiriretorios(files[i]);
				for (int j = 0; j < recFiles.length; j++) {
					enc.add(recFiles[j]);
				}
			} else {
				// Adiciona no Vector o arquivo encontrado dentro de 'dir':
				enc.add(files[i]);
			}
		}

		// Transforma um Vector em um File[]:
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

}