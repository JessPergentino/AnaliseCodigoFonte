package br.ucsal.ev20192.leitor;

import java.util.Scanner;

import br.ucsal.ev20192.leitor.geradorCSV.GeradorCsv;

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

	public static void imprimirResultado(Resultado[] result) {
		System.out.println("------------------------------------------------");

		Scanner sc = new Scanner(System.in);
		String download = "";

		System.out.println("Informe o caminho de download do arquivo:");
		download = sc.nextLine();

		GeradorCsv.generateCsvFile(download, result);

		sc.close();

	}
}