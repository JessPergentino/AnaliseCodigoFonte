package br.ucsal.ev20192.domain.leitor;

import java.io.BufferedReader;
import java.io.IOException;

public class Leitor {

	public static final String PATTERCLASS = "(public class|private class|protected class).*";
	public static final String PATTERMETHOD = ".*(public String|public void|private String).*(\\)\\ \\{)$";

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
