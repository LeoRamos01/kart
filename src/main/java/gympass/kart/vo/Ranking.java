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
	
}
