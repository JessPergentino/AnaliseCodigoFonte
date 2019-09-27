package br.ucsal.ev20192.leitor.utils;

public class ContadorBadSmellClasse {

	private static final int LINHASCLASSEDEUS = 800;
	private static final String PADRAOABRIR = "{";
	private static final String PADRAOFECHAR = "}";
	private static Boolean regex = false;
	private static Integer qtdClasseDeus = 0;
	private static Integer qtdLinhas = 0;
	private static Integer abrir = 0;
	private static Integer fechar = 0;

	private ContadorBadSmellClasse() {
		throw new IllegalStateException("Utility class");
	}

	public static void contarClasseDeus(String linha, String padrao) {
		if (linha.matches(padrao)) {
			regex = true;
		}
		if (linha.contains(PADRAOABRIR) && regex) {
			abrir++;
		}

		if (linha.contains(PADRAOFECHAR) && regex) {
			fechar++;
		}

		if (regex) {
			qtdLinhas++;
		}

		if (abrir.equals(fechar) && qtdLinhas > LINHASCLASSEDEUS) {
			qtdClasseDeus++;
		}
	}

	public static void limparNovoArquivo() {
		regex = false;
		setAbrir(0);
		setFechar(0);
		setQtdLinhas(0);
		setQtdClasseDeus(0);
	}

	public static Integer getQtdLinhas() {
		return qtdLinhas;
	}

	public static void setQtdLinhas(Integer qtdLinhas) {
		ContadorBadSmellClasse.qtdLinhas = qtdLinhas;
	}

	public static Integer getAbrir() {
		return abrir;
	}

	public static void setAbrir(Integer abrir) {
		ContadorBadSmellClasse.abrir = abrir;
	}

	public static Integer getFechar() {
		return fechar;
	}

	public static void setFechar(Integer fechar) {
		ContadorBadSmellClasse.fechar = fechar;
	}

	public static Integer getQtdClasseDeus() {
		return qtdClasseDeus;
	}

	public static void setQtdClasseDeus(Integer qtdClasseDeus) {
		ContadorBadSmellClasse.qtdClasseDeus = qtdClasseDeus;
	}

}
