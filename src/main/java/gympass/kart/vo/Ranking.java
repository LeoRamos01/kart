package gympass.kart.vo;

import java.time.Duration;

/**
 * 
 * Posição Chegada, Código Piloto, Nome Piloto, Qtde Voltas Completadas e Tempo Total de Prova.
 * 
 * @author leonardorm
 *
 */
public class Ranking {

	private Integer posicaoChegada;
	
	private String idPiloto;
	
	private String nomePiloto;
	
	private Integer voltasCompletas;
	
	private Duration tempoTotal;
	
	private String duracao;
	
	public Ranking() {
	}
	
	public Ranking(Integer posicaoChegada, String idPiloto, String nomePiloto, Integer voltasCompletas,
			Duration tempoTotal) {
		super();
		this.posicaoChegada = posicaoChegada;
		this.idPiloto = idPiloto;
		this.nomePiloto = nomePiloto;
		this.voltasCompletas = voltasCompletas;
		this.tempoTotal = tempoTotal;
	}

	public Duration getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(Duration tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	public Integer getPosicaoChegada() {
		return posicaoChegada;
	}

	public void setPosicaoChegada(Integer posicaoChegada) {
		this.posicaoChegada = posicaoChegada;
	}

	public String getIdPiloto() {
		return idPiloto;
	}

	public void setIdPiloto(String idPiloto) {
		this.idPiloto = idPiloto;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public Integer getVoltasCompletas() {
		return voltasCompletas;
	}

	public void setVoltasCompletas(Integer voltasCompletas) {
		this.voltasCompletas = voltasCompletas;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ranking [posicaoChegada=");
		builder.append(posicaoChegada);
		builder.append(", idPiloto=");
		builder.append(idPiloto);
		builder.append(", nomePiloto=");
		builder.append(nomePiloto);
		builder.append(", voltasCompletas=");
		builder.append(voltasCompletas);
		builder.append(", tempoTotal=");
		builder.append(duracao);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((idPiloto == null) ? 0 : idPiloto.hashCode());
		result = prime * result + ((nomePiloto == null) ? 0 : nomePiloto.hashCode());
		result = prime * result + ((posicaoChegada == null) ? 0 : posicaoChegada.hashCode());
		result = prime * result + ((tempoTotal == null) ? 0 : tempoTotal.hashCode());
		result = prime * result + ((voltasCompletas == null) ? 0 : voltasCompletas.hashCode());
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
		Ranking other = (Ranking) obj;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (idPiloto == null) {
			if (other.idPiloto != null)
				return false;
		} else if (!idPiloto.equals(other.idPiloto))
			return false;
		if (nomePiloto == null) {
			if (other.nomePiloto != null)
				return false;
		} else if (!nomePiloto.equals(other.nomePiloto))
			return false;
		if (posicaoChegada == null) {
			if (other.posicaoChegada != null)
				return false;
		} else if (!posicaoChegada.equals(other.posicaoChegada))
			return false;
		if (tempoTotal == null) {
			if (other.tempoTotal != null)
				return false;
		} else if (!tempoTotal.equals(other.tempoTotal))
			return false;
		if (voltasCompletas == null) {
			if (other.voltasCompletas != null)
				return false;
		} else if (!voltasCompletas.equals(other.voltasCompletas))
			return false;
		return true;
	}
	
}
