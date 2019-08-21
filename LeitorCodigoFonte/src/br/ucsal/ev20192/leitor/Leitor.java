package br.ucsal.ev20192.leitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {
	
	public static final String PATTERCLASS = "(public class|private class|protected class).*";
	public static final String PATTERMETHOD = ".*(public String|public void|private String).*(\\)\\ \\{)$";
			
	public static void main(String[] args) throws FileNotFoundException {
		Integer qtdLinhas = 0;
		Integer qtdClass = 0;
		Integer qtdMethods = 0;
		
		BufferedReader codigo = new BufferedReader(new FileReader("C:\\Users\\jessi\\git\\AnaliseCodigoFonte\\LeitorCodigoFonte\\src\\br\\ucsal\\ev20192\\leitor\\Teste.java"));
		
		try {
			while (codigo.ready()) {
				String linha = codigo.readLine();
				if(linha.matches(PATTERCLASS)) {
					qtdClass++;
				}
				if(linha.matches(PATTERMETHOD)) {
					qtdMethods++;
				}
				qtdLinhas++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			codigo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("QTD. Linhas: " + qtdLinhas);
		System.out.println("QTD. Classes: " + qtdClass);
		System.out.println("QTD. Métodos: " + qtdMethods);
	}
}
