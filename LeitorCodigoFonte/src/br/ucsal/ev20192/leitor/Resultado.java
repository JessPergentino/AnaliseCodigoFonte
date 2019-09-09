package br.ucsal.ev20192.leitor;

public class Resultado implements Comparable<Resultado> {

	private Integer loc = 0;
	private Integer qtdClasses = 0;
	private Integer qtdMetodos = 0;
	private Integer qtdClassesDeus = 0;
	private Integer qtdMetodosDeus = 0;
	private Integer arquivo = 0;

	public Resultado() {
	}

	public Resultado(Integer loc, Integer qtdClasses, Integer qtdMetodos, Integer qtdClassesDeus,
			Integer qtdMetodosDeus) {
		super();
		this.loc = loc;
		this.qtdClasses = qtdClasses;
		this.qtdMetodos = qtdMetodos;
		this.qtdClassesDeus = qtdClassesDeus;
		this.qtdMetodosDeus = qtdMetodosDeus;
	}

	public Resultado(Integer loc, Integer qtdClasses, Integer qtdMetodos, Integer qtdClassesDeus,
			Integer qtdMetodosDeus, Integer arquivo) {
		super();
		this.loc = loc;
		this.qtdClasses = qtdClasses;
		this.qtdMetodos = qtdMetodos;
		this.qtdClassesDeus = qtdClassesDeus;
		this.qtdMetodosDeus = qtdMetodosDeus;
		this.arquivo = arquivo;
	}

	public Integer getLoc() {
		return loc;
	}

	public void setLoc() {
		this.loc++;
	}

	public Integer getQtdClasses() {
		return qtdClasses;
	}

	public void setQtdClasses() {
		this.qtdClasses++;
	}

	public Integer getQtdMetodos() {
		return qtdMetodos;
	}

	public void setQtdMetodos() {
		this.qtdMetodos++;
	}

	public Integer getArquivo() {
		return arquivo;
	}

	public void setArquivo(Integer arquivo) {
		this.arquivo = arquivo;
	}

	public Integer getQtdClassesDeus() {
		return qtdClassesDeus;
	}

	public void setQtdClassesDeus() {
		this.qtdClassesDeus++;
	}

	public Integer getQtdMetodosDeus() {
		return qtdMetodosDeus;
	}

	public void setQtdMetodosDeus(Integer qtdMetodoDeus) {
		this.qtdMetodosDeus = qtdMetodoDeus;
	}

	@Override
	public String toString() {
		return "Resultado [loc=" + loc + ", qtdClasses=" + qtdClasses + ", qtdMetodos=" + qtdMetodos
				+ ", qtdClassesDeus=" + qtdClassesDeus + ", qtdMetodosDeus=" + qtdMetodosDeus + ", arquivo=" + arquivo
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquivo == null) ? 0 : arquivo.hashCode());
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + ((qtdClasses == null) ? 0 : qtdClasses.hashCode());
		result = prime * result + ((qtdMetodos == null) ? 0 : qtdMetodos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultado other = (Resultado) obj;
		if (arquivo == null) {
			if (other.arquivo != null)
				return false;
		} else if (!arquivo.equals(other.arquivo))
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		if (qtdClasses == null) {
			if (other.qtdClasses != null)
				return false;
		} else if (!qtdClasses.equals(other.qtdClasses))
			return false;
		if (qtdMetodos == null) {
			if (other.qtdMetodos != null)
				return false;
		} else if (!qtdMetodos.equals(other.qtdMetodos))
			return false;
		return true;
	}

	@Override
	public int compareTo(Resultado o) {
		return Integer.compare(this.getArquivo(), o.getArquivo());
	}

}