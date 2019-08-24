package br.ucsal.ev20192.tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

import br.ucsal.ev20192.domain.leitor.Leitor;
import br.ucsal.ev20192.domain.leitor.Resultado;

public class LeitorTeste {

	BufferedReader codigo;

	@Before
	public void setUp() throws FileNotFoundException {
		String caminho = "C:\\Users\\jessi\\git\\AnaliseCodigoFonte\\LeitorCodigoFonte\\src\\br\\ucsal\\ev20192\\resource\\Teste.java";
		codigo = new BufferedReader(new BufferedReader(new FileReader(caminho)));
	}

	@Test
	public void testLerArquivo() {
		// Valor Esperado
		Resultado resultadoEsperado = new Resultado(46, 1, 9);

		// Execução do método LerArquivo
		Resultado resultadoRetornado = Leitor.lerArquivo(codigo);

		// Comparação do valor retornado com o esperado
		assertEquals(resultadoEsperado, resultadoRetornado);
	}

}
