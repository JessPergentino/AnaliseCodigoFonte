package br.ucsal.ev20192.leitor.utils;

public class ContadorBadSmell {

	private static final int LINHASCLASSEDEUS = 800;
	private static final int LINHASMETODODEUS = 127;
	public static final String PADRAOABRIR = ".*\\{";
	public static final String PADRAOFECHAR = ".*\\}.*";
	public static Boolean metodo = false;
	private static Integer qtdMetodosDeus = 0;
	private static Integer qtdClasseDeus = 0;
	private static Integer qtdLinhas = 0;
	private static Integer abrir = 0;
	private static Integer fechar = 0;

	private ContadorBadSmell() {
		throw new IllegalStateException("Utility class");
	}

	public static void contarMetodosDeus(String linha, String padrao) {
		if (linha.matches(padrao)) {
			metodo = true;
		}
		if (linha.matches(PADRAOABRIR) && metodo) {
			abrir++;
		}

		if (linha.matches(PADRAOFECHAR) && metodo) {
			fechar++;
		}

		if (metodo) {
			qtdLinhas++;
		}

		if (abrir.equals(fechar)) {
			metodo = false;
			if (qtdLinhas > LINHASMETODODEUS) {
				qtdMetodosDeus++;
			}
			qtdLinhas = 0;
		}
	}

	public static void contarClasseDeus(String linha, String padrao) {
		// TODO: Implementar o método para classe Deus
	}

	public static Integer getQtdMetodosDeus() {
		return qtdMetodosDeus;
	}

	public static void setQtdMetodosDeus(Integer qtdMetodosDeus) {
		ContadorBadSmell.qtdMetodosDeus = qtdMetodosDeus;
	}

	public static Integer getQtdClasseDeus() {
		return qtdClasseDeus;
	}

	public static void setQtdClasseDeus(Integer qtdClasseDeus) {
		ContadorBadSmell.qtdClasseDeus = qtdClasseDeus;
	}

}
