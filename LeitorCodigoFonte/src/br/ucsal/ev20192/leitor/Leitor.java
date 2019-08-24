package br.ucsal.ev20192.leitor;

import java.io.BufferedReader;
import java.io.IOException;

public class Leitor {

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
				result.setLoc();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}