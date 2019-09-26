package br.ucsal.ev20192.leitor.utils;

public class ContadorBadSmell {

	private static final int LINHASCLASSEDEUS = 800;
	private static final int LINHASMETODODEUS = 127;
	public static final String PADRAOABRIR = ".*\\{";
	public static final String PADRAOFECHAR = ".*\\}.*";
	public static Boolean regex = false;
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
			regex = true;
		}
		if (linha.matches(PADRAOABRIR) && regex) {
			abrir++;
		}

		if (linha.matches(PADRAOFECHAR) && regex) {
			fechar++;
		}

		if (regex) {
			qtdLinhas++;
		}

		if (abrir.equals(fechar)) {
			if (qtdLinhas > LINHASMETODODEUS) {
				qtdMetodosDeus++;
			}
			limparNovoMetodo();
		}
	}

	public static void contarClasseDeus(String linha, String padrao) {
		if (linha.matches(padrao)) {
			regex = true;
		}
		if (linha.matches(PADRAOABRIR) && regex) {
			abrir++;
		}

		if (linha.matches(PADRAOFECHAR) && regex) {
			fechar++;
		}

		if (regex) {
			qtdLinhas++;
		}

		if (abrir.equals(fechar)) {
			if (qtdLinhas > LINHASCLASSEDEUS) {
				qtdClasseDeus++;
			}
			limparNovoMetodo();		
		}
	}

	public static void limparNovoMes() {
		setMetodo(false);
		setAbrir(0);
		setFechar(0);
		setQtdLinhas(0);
		setQtdMetodosDeus(0);
		setQtdClasseDeus(0);
	}

	private static void limparNovoMetodo() {
		setMetodo(false);
		setAbrir(0);
		setFechar(0);
		setQtdLinhas(0);
	}
	
	public static Boolean getMetodo() {
		return regex;
	}

	public static void setMetodo(Boolean metodo) {
		ContadorBadSmell.regex = metodo;
	}

	public static Integer getQtdLinhas() {
		return qtdLinhas;
	}

	public static void setQtdLinhas(Integer qtdLinhas) {
		ContadorBadSmell.qtdLinhas = qtdLinhas;
	}

	public static Integer getAbrir() {
		return abrir;
	}

	public static void setAbrir(Integer abrir) {
		ContadorBadSmell.abrir = abrir;
	}

	public static Integer getFechar() {
		return fechar;
	}

	public static void setFechar(Integer fechar) {
		ContadorBadSmell.fechar = fechar;
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
