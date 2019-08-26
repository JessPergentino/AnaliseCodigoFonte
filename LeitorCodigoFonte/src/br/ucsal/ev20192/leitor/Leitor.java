package br.ucsal.ev20192.leitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor {

	// "(public|private|protected)\s()"

	public static final String PATTERCLASS = "(class|public class|private class|protected class).*";
	public static final String PATTERMETHOD = ".*(public String|public void|public Integer|public int|public Double|public double|public Float|public float|public Boolean|public boolean|"
			+ "private String|private void|private Integer|private int|private Double|private double|private Float|private float|private Boolean|private boolean|"
			+ "public static String|public static void|public static Integer|public static int|public static Double|public static double|public static Float|public static float|public static Boolean|public static boolean|"
			+ "private static String|private static void|private static Integer|private static int|private static Double|private static double|private Float|private static float|private static Boolean|private static boolean).*"
			+ "(\\)\\ \\{)$";

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
				if (linha.matches(".*[\\S]")) {
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
		File[] encontrados = new File[enc.size()];
		for (int i = 0; i < enc.size(); i++) {
			encontrados[i] = enc.get(i);
		}
		return encontrados;
	}
}