package br.ucsal.ev20192.tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

import br.ucsal.ev20192.leitor.Leitor;
import br.ucsal.ev20192.leitor.Resultado;

public class LeitorTeste {

	BufferedReader codigoArquivo1;
	BufferedReader codigoArquivo2;
	File dataSet;

	@Before
	public void setUp() throws FileNotFoundException {
		String caminhoArquivo1 = "C:\\Users\\jessi\\git\\AnaliseCodigoFonte\\LeitorCodigoFonte\\src\\br\\ucsal\\ev20192\\resource\\Arquivo1.java";
		codigoArquivo1 = new BufferedReader(new BufferedReader(new FileReader(caminhoArquivo1)));

		String caminhoArquivo2 = "C:\\Users\\jessi\\git\\AnaliseCodigoFonte\\LeitorCodigoFonte\\src\\br\\ucsal\\ev20192\\resource\\Arquivo2.java";
		codigoArquivo2 = new BufferedReader(new BufferedReader(new FileReader(caminhoArquivo2)));

		String caminhoDataset = "C:\\Users\\Public\\Documents\\Dataset";
		dataSet = new File(caminhoDataset);
	}

	@Test
	public void testLerArquivo1() {
		// Valor Esperado
		Integer locEsperado = 87;
		Integer qtdClassesEsperado = 1;
		Integer qtdMetodosEsperados = 21;

		// Execução do método LerArquivo
		Resultado resultadoRetornado = Leitor.lerArquivo(codigoArquivo1);

		// Comparação do valor retornado com o esperado
		assertEquals(locEsperado, resultadoRetornado.getLoc());
		assertEquals(qtdClassesEsperado, resultadoRetornado.getQtdClasses());
		assertEquals(qtdMetodosEsperados, resultadoRetornado.getQtdMetodos());
	}

	@Test
	public void testLerArquivo2() {
		// Valor Esperado
		Integer locEsperado = 51;
		Integer qtdClassesEsperado = 2;
		Integer qtdMetodosEsperados = 2;

		// Execução do método LerArquivo
		Resultado resultadoRetornado = Leitor.lerArquivo(codigoArquivo2);

		// Comparação do valor retornado com o esperado
		assertEquals(locEsperado, resultadoRetornado.getLoc());
		assertEquals(qtdClassesEsperado, resultadoRetornado.getQtdClasses());
		assertEquals(qtdMetodosEsperados, resultadoRetornado.getQtdMetodos());
	}

	@Test
	public void testListarDiretorios() throws FileNotFoundException {
		// Valor Esperado
		int totalArquivos = 163;

		// Execução do método LerArquivo
		int resultadoRetornado = Leitor.listarDiriretorios(dataSet).length;

		// Comparação do valor retornado com o esperado
		assertEquals(totalArquivos, resultadoRetornado);
	}

	@Test
	public void testListarDiretoriosFiltrados() throws FileNotFoundException {
		// Valor Esperado
		int totalArquivos = 162;

		// Execução do método LerArquivo
		int resultadoRetornado = Leitor.filtrarDirertorios(Leitor.listarDiriretorios(dataSet)).length;

		// Comparação do valor retornado com o esperado
		assertEquals(totalArquivos, resultadoRetornado);
	}
}