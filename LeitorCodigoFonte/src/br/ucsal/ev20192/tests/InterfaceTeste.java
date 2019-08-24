package br.ucsal.ev20192.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ucsal.ev20192.leitor.Interface;

public class InterfaceTeste {

	@Test
	public void testMenu() {
		// Valor Esperado
		String caminhoEsperado = "C:\\Users\\jessi\\git\\AnaliseCodigoFonte\\LeitorCodigoFonte\\src\\br\\ucsal\\ev20192\\resource\\Teste.java";
		// Execu��o do m�todo Menu
		String caminhoRetornado = Interface.menu();
		
		// Compara��o do valor retornado com o esperado
		assertEquals(caminhoEsperado, caminhoRetornado);
	}
}
