package br.ucsal.ev20192;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import br.ucsal.ev20192.leitor.Interface;
import br.ucsal.ev20192.leitor.Leitor;
import br.ucsal.ev20192.leitor.Resultado;
import br.ucsal.ev20192.predicao.AlgoritmoPredicao;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String caminho = Interface.menu();
		Leitor.filtrarDirertorios(Leitor.listarDiriretorios(new File(caminho)));
		List<Resultado> meses = Leitor.mesesOrdenados();
		meses.add(AlgoritmoPredicao.predicaoProximoMes(meses));
		Interface.downloadCsv(meses);
	}
}
