package br.ucsal.ev20192.leitor;

import java.util.Scanner;

public class Interface {

	private Interface() {
	}

	public static String menu() {
		Scanner sc = new Scanner(System.in);
		String caminho = "";

		System.out.println("--------------MENU-------------");
		System.out.println("Informe o caminho do arquivo que deseja analisar:");
		caminho = sc.nextLine();

		sc.close();
		return caminho;
	}

	public static void imprimirResultado(Resultado result) {
		System.out.println("----------------------------------------------------");
		System.out.println("O LOC do arquivo �: " + result.getLoc());
		System.out.println("O N� de Classes presente no arquivo � de: " + result.getQtdClass());
		System.out.println("O N� de M�todos presente no arquivo � de: " + result.getQtdMetodos());
	}
}
