package gympass.kart.vo;

import java.time.LocalTime;

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
	
	private LocalTime tempoTotal;
	
	public Ranking() {
	}
	
	public Ranking(Integer posicaoChegada, String idPiloto, String nomePiloto, Integer voltasCompletas,
			LocalTime tempoTotal) {
		super();
		this.posicaoChegada = posicaoChegada;
		this.idPiloto = idPiloto;
		this.nomePiloto = nomePiloto;
		this.voltasCompletas = voltasCompletas;
		this.tempoTotal = tempoTotal;
	}

	public LocalTime getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(LocalTime tempoTotal) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ranking [posicaoChegada=").append(posicaoChegada).append(", idPiloto=").append(idPiloto)
				.append(", nomePiloto=").append(nomePiloto).append(", voltasCompletas=").append(voltasCompletas)
				.append(", tempoTotal=").append(tempoTotal).append("]");
		return builder.toString();
	}
	
}
