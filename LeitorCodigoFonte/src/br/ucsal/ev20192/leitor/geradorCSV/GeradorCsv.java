package br.ucsal.ev20192.leitor.geradorCSV;

import java.io.FileWriter;
import java.io.IOException;

import br.ucsal.ev20192.leitor.Resultado;

public class GeradorCsv {
	public static void generateCsvFile(String caminhoCSV, Resultado[] meses) {
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
				writer.append(String.valueOf(i));
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
