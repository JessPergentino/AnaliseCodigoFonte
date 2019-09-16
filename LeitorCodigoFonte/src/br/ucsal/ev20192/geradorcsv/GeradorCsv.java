package br.ucsal.ev20192.geradorcsv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.ucsal.ev20192.leitor.Interface;
import br.ucsal.ev20192.leitor.Resultado;

public class GeradorCsv {
	private static final char SEPARADOR = ',';
	private static final String QUEBRALINHA = "\n";

	private GeradorCsv() {
	}

	public static Boolean geradorArquivoCsv(String caminhoCSV, List<Resultado> meses) {
		try {
			FileWriter writer = new FileWriter(caminhoCSV);

			writer.append("Mês");
			writer.append(SEPARADOR);
			writer.append("LOC");
			writer.append(SEPARADOR);
			writer.append("Classes");
			writer.append(SEPARADOR);
			writer.append("Métodos");
			writer.append(SEPARADOR);
			writer.append("Classes Deus");
			writer.append(SEPARADOR);
			writer.append("Métodos Deus");
			writer.append(QUEBRALINHA);

			for (Resultado resultado : meses) {
				writer.append(String.valueOf(resultado.getArquivo()));
				writer.append(SEPARADOR);
				writer.append(resultado.getLoc().toString());
				writer.append(SEPARADOR);
				writer.append(resultado.getQtdClasses().toString());
				writer.append(SEPARADOR);
				writer.append(resultado.getQtdMetodos().toString());
				writer.append(SEPARADOR);
				writer.append(resultado.getQtdClassesDeus().toString());
				writer.append(SEPARADOR);
				writer.append(resultado.getQtdMetodosDeus().toString());
				writer.append(QUEBRALINHA);
			}

			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {

			e.printStackTrace();
			Interface.mensagem("O arquivo não pode ser gerado.");
			return false;
		}
	}
}
