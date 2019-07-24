package gympass.kart.vo;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

/**
 * 
 * Classe que representa cada linha do kart.txt.
 * 
 * <ul>
 * Headers:
 * <li>Hora</li>
 * <li>Piloto</li>
 * <li>Nº Volta</li>
 * <li>Tempo Volta</li>
 * <li>Velocidade média da volta</li>
 * </ul>
 * 
 * @author leonardo
 *
 */
public class Linha {

	private LocalTime hora;

	private String nomePiloto;
	
	private String idPiloto;

	private Integer numeroVolta;

	private Duration tempoVolta;

	private BigDecimal velocidadeMediaVolta;
	
	public Linha() {
	}

	public Linha(LocalTime hora, String nomePiloto, String idPiloto, Integer numeroVolta, Duration tempoVolta,
			BigDecimal velocidadeMediaVolta) {
		super();
		this.hora = hora;
		this.nomePiloto = nomePiloto;
		this.idPiloto = idPiloto;
		this.numeroVolta = numeroVolta;
		this.tempoVolta = tempoVolta;
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public String getIdPiloto() {
		return idPiloto;
	}

	public void setIdPiloto(String idPiloto) {
		this.idPiloto = idPiloto;
	}

	public Integer getNumeroVolta() {
		return numeroVolta;
	}

	public void setNumeroVolta(Integer numeroVolta) {
		this.numeroVolta = numeroVolta;
	}

	public Duration getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(Duration tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public BigDecimal getVelocidadeMediaVolta() {
		return velocidadeMediaVolta;
	}

	public void setVelocidadeMediaVolta(BigDecimal velocidadeMediaVolta) {
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Linha [hora=");
		builder.append(hora);
		builder.append(", nomePiloto=");
		builder.append(nomePiloto);
		builder.append(", idPiloto=");
		builder.append(idPiloto);
		builder.append(", numeroVolta=");
		builder.append(numeroVolta);
		builder.append(", tempoVolta=");
		builder.append(tempoVolta);
		builder.append(", velocidadeMediaVolta=");
		builder.append(velocidadeMediaVolta);
		builder.append("]");
		return builder.toString();
	}

}
