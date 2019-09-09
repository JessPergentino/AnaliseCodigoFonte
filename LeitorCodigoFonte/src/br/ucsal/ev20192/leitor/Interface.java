package br.ucsal.ev20192.leitor;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import br.ucsal.ev20192.geradorcsv.GeradorCsv;

public class Interface {

	private static final String CAMINHODOWNLOAD = "C:" + File.separator + "Users" + File.separator + "100912556"
			+ File.separator + "Downloads" + File.separator + "Analise.csv";

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

	public static void downloadCsv(List<Resultado> result) {
		Boolean baixou = GeradorCsv.geradorArquivoCsv(CAMINHODOWNLOAD, result);
		if (baixou)
			mensagem("Download Concluido com sucesso!!");

	}

	public static void mensagem(String m) {
		System.out.println(m);
	}
}