package br.ucsal.ev20192;

import java.io.File;
import java.io.FileNotFoundException;

import br.ucsal.ev20192.leitor.Interface;
import br.ucsal.ev20192.leitor.Leitor;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String caminho = Interface.menu();
		Leitor.filtrarDirertorios(Leitor.listarDiriretorios(new File(caminho)));
		Interface.downloadCsv(Leitor.mesesOrdenados());
	}
}
