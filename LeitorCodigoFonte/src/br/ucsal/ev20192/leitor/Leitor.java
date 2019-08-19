package br.ucsal.ev20192.leitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Leitor {
	
	public static final String PATTERCLASS = ".*public class.*";
	public static final String PATTERMETHOD = "() {$";
			
	
	public static void main(String[] args) throws FileNotFoundException {
		Integer qtdLinhas = 0;
		Integer qtdClass = 0;
		Integer qtdMethods = 0;
		
		BufferedReader codigo = new BufferedReader(new FileReader("C:\\Users\\100912556\\LeitorCodigoFonte\\src\\br\\ucsal\\ev20192\\leitor\\Teste.java"));
		
		try {
			while (codigo.ready()) {
				String linha = codigo.readLine();
				if(linha.matches(PATTERCLASS)) {
					qtdClass++;
				}
				if(!Pattern.compile("[^a-z0-9\\._]").matcher(linha).find()) {
					qtdMethods++;
				}
				qtdLinhas++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			codigo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("QTD. Linhas: " + qtdLinhas);
		System.out.println("QTD. Classes: " + qtdClass);
		System.out.println("QTD. Métodos: " + qtdMethods);
	}
}
