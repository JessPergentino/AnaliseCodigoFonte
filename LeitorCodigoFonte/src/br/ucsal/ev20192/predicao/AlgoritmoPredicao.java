package br.ucsal.ev20192.predicao;

import java.util.List;

import br.ucsal.ev20192.leitor.Resultado;

public class AlgoritmoPredicao {
	private static final Double ALFA = (2d / (2 + 1d));

	private static Double mediaLoc = 0d;
	private static Double mediaClasse = 0d;
	private static Double mediaMetodo = 0d;
	private static Double mediaClasseDeus = 0d;
	private static Double mediaMetodoDeus = 0d;

	private AlgoritmoPredicao() {
	}

	public static Resultado predicao28Mes(List<Resultado> meses) {
		Resultado mes28 = new Resultado();
		for (int i = 0; i < meses.size(); i++) {
			if (i == 0) {
				setMediaLoc(calcularMediaMovelSimples(meses.get(i).getLoc(), meses.get(i + 1).getLoc()));
				setMediaClasse(
						calcularMediaMovelSimples(meses.get(i).getQtdClasses(), meses.get(i + 1).getQtdClasses()));
				setMediaMetodo(
						calcularMediaMovelSimples(meses.get(i).getQtdMetodos(), meses.get(i + 1).getQtdMetodos()));
				setMediaClasseDeus(calcularMediaMovelSimples(meses.get(i).getQtdClassesDeus(),
						meses.get(i + 1).getQtdClassesDeus()));
				setMediaMetodoDeus(calcularMediaMovelSimples(meses.get(i).getQtdMetodosDeus(),
						meses.get(i + 1).getQtdMetodosDeus()));
			}

			if ((i + 1) < meses.size() && i >= 1) {
				setMediaLoc((meses.get(i).getLoc() - getMediaLoc()) * ALFA + getMediaLoc());
				setMediaClasse((meses.get(i).getQtdClasses() - getMediaClasse()) * ALFA + getMediaClasse());
				setMediaMetodo((meses.get(i).getQtdMetodos() - getMediaMetodo()) * ALFA + getMediaMetodo());
				setMediaClasseDeus((meses.get(i).getQtdClassesDeus() - getMediaClasseDeus()) * ALFA
						+ getMediaClasseDeus());
				setMediaMetodoDeus((meses.get(i).getQtdMetodosDeus() - getMediaMetodoDeus()) * ALFA
						+ getMediaMetodoDeus());
			}
		}

		mes28.setArquivo(meses.size() + 1);
		mes28.setLoc(getMediaLoc().intValue());
		mes28.setQtdClasses(getMediaClasse().intValue());
		mes28.setQtdMetodos(getMediaMetodo().intValue());
		mes28.setQtdClassesDeus(getMediaClasseDeus().intValue());
		mes28.setQtdMetodosDeus(getMediaMetodoDeus().intValue());

		return mes28;
	}

	private static Double calcularMediaMovelSimples(Integer mesAtual, Integer mesSeguinte) {
		return (mesAtual + mesSeguinte) / 2d;
	}

	public static Double getMediaLoc() {
		return mediaLoc;
	}

	public static void setMediaLoc(Double mediaLoc) {
		AlgoritmoPredicao.mediaLoc = mediaLoc;
	}

	public static Double getMediaClasse() {
		return mediaClasse;
	}

	public static void setMediaClasse(Double mediaClasse) {
		AlgoritmoPredicao.mediaClasse = mediaClasse;
	}

	public static Double getMediaMetodo() {
		return mediaMetodo;
	}

	public static void setMediaMetodo(Double mediaMetodo) {
		AlgoritmoPredicao.mediaMetodo = mediaMetodo;
	}

	public static Double getMediaClasseDeus() {
		return mediaClasseDeus;
	}

	public static void setMediaClasseDeus(Double mediaClasseDeus) {
		AlgoritmoPredicao.mediaClasseDeus = mediaClasseDeus;
	}

	public static Double getMediaMetodoDeus() {
		return mediaMetodoDeus;
	}

	public static void setMediaMetodoDeus(Double mediaMetodoDeus) {
		AlgoritmoPredicao.mediaMetodoDeus = mediaMetodoDeus;
	}
}
