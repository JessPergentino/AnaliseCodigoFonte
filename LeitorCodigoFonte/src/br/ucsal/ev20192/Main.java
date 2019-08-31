package br.ucsal.ev20192;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import br.ucsal.ev20192.leitor.Interface;
import br.ucsal.ev20192.leitor.Leitor;
import br.ucsal.ev20192.leitor.Resultado;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String caminho = Interface.menu();
		File[] files = Leitor.filtrarDirertorios(Leitor.listarDiriretorios(new File(caminho)));
		for (int i = 0; i < files.length; i++) {
			Resultado result = Leitor.lerArquivo(new BufferedReader(new FileReader(files[i])));
			Interface.imprimirResultado(result);
		}
	}
}
