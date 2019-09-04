package br.ucsal.ev20192.geradorcsv;

import java.io.FileWriter;
import java.io.IOException;

import br.ucsal.ev20192.leitor.Interface;
import br.ucsal.ev20192.leitor.Resultado;

public class GeradorCsv {
	private GeradorCsv() {
	}

	public static Boolean generateCsvFile(String caminhoCSV, Resultado[] meses) {
		try {
			FileWriter writer = new FileWriter(caminhoCSV);

			writer.append("Mês");
			writer.append(';');
			writer.append("LOC");
			writer.append(";");
			writer.append("Classes");
			writer.append(";");
			writer.append("Métodos");
			writer.append('\n');

			for (int i = 0; i < meses.length; i++) {
				writer.append(String.valueOf(i + 1));
				writer.append(';');
				writer.append(meses[i].getLoc().toString());
				writer.append(";");
				writer.append(meses[i].getQtdClass().toString());
				writer.append(";");
				writer.append(meses[i].getQtdMetodos().toString());
				writer.append('\n');
			}

			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			Interface.mensagemDownload("O arquivo não pode ser gerado.");
			return false;
		}
	}
}
