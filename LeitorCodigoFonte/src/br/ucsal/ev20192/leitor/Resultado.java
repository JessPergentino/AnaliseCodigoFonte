package br.ucsal.ev20192.leitor;

public class Resultado {

	private Integer loc = 0;
	private Integer qtdClass = 0;
	private Integer qtdMetodos = 0;

	public Resultado() {
	}

	public Resultado(Integer loc, Integer qtdClass, Integer qtdMetodos) {
		super();
		this.loc = loc;
		this.qtdClass = qtdClass;
		this.qtdMetodos = qtdMetodos;
	}

	public Integer getLoc() {
		return loc;
	}

	public void setLoc() {
		this.loc++;
	}

	public Integer getQtdClass() {
		return qtdClass;
	}

	public void setQtdClass() {
		this.qtdClass++;
	}

	public Integer getQtdMetodos() {
		return qtdMetodos;
	}

	public void setQtdMetodos() {
		this.qtdMetodos++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + ((qtdClass == null) ? 0 : qtdClass.hashCode());
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
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc)) {
			return false;
		}

		if (qtdClass == null) {
			if (other.qtdClass != null)
				return false;
		} else if (!qtdClass.equals(other.qtdClass)) {
			return false;
		}

		if (qtdMetodos == null) {
			if (other.qtdMetodos != null)
				return false;
		} else if (!qtdMetodos.equals(other.qtdMetodos)) {
			return false;
		}
		return true;
	}
}