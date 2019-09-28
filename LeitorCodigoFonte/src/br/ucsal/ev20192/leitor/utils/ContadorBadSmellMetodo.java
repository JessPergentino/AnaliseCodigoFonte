package br.ucsal.ev20192.leitor.utils;

import br.ucsal.ev20192.leitor.Leitor;

public class ContadorBadSmellMetodo {

	private static final int LINHASMETODODEUS = 127;
	private static final String PADRAOABRIR = ".*\\{";
	private static final String PADRAOFECHAR = ".*\\}.*";
	private static Boolean regex = false;
	private static Integer qtdMetodosDeus = 0;
	private static Integer qtdLinhas = 0;
	private static Integer abrir = 0;
	private static Integer fechar = 0;

	private ContadorBadSmellMetodo() {
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

		if (regex && linha.matches(Leitor.PADRAOLINHA)) {
			qtdLinhas++;
		}

		if (abrir.equals(fechar)) {
			if (qtdLinhas > LINHASMETODODEUS) {
				qtdMetodosDeus++;
			}
			limparNovoMetodo();
		}
	}

	public static void limparNovoArquivo() {
		setRegex(false);
		setAbrir(0);
		setFechar(0);
		setQtdLinhas(0);
		setQtdMetodosDeus(0);
	}

	private static void limparNovoMetodo() {
		setRegex(false);
		setAbrir(0);
		setFechar(0);
		setQtdLinhas(0);
	}

	public static Boolean getRegex() {
		return regex;
	}

	public static void setRegex(Boolean regex) {
		ContadorBadSmellMetodo.regex = regex;
	}

	public static Integer getQtdLinhas() {
		return qtdLinhas;
	}

	public static void setQtdLinhas(Integer qtdLinhas) {
		ContadorBadSmellMetodo.qtdLinhas = qtdLinhas;
	}

	public static Integer getAbrir() {
		return abrir;
	}

	public static void setAbrir(Integer abrir) {
		ContadorBadSmellMetodo.abrir = abrir;
	}

	public static Integer getFechar() {
		return fechar;
	}

	public static void setFechar(Integer fechar) {
		ContadorBadSmellMetodo.fechar = fechar;
	}

	public static Integer getQtdMetodosDeus() {
		return qtdMetodosDeus;
	}

	public static void setQtdMetodosDeus(Integer qtdMetodosDeus) {
		ContadorBadSmellMetodo.qtdMetodosDeus = qtdMetodosDeus;
	}

}
