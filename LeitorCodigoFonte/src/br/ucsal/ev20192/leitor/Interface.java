package br.ucsal.ev20192.leitor;

import java.io.File;
import java.util.Scanner;

import br.ucsal.ev20192.geradorcsv.GeradorCsv;

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

	public static void downloadCsv(Resultado[] result) {
		String download = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator + "Downloads"
				+ File.separator + "Analise.csv";
		Boolean baixou = GeradorCsv.generateCsvFile(download, result);
		if (baixou)
			mensagemDownload("Download Concluido com sucesso!!");

	}

	public static void mensagemDownload(String m) {
		System.out.println(m);
	}
}