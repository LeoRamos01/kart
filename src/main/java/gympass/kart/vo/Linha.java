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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((idPiloto == null) ? 0 : idPiloto.hashCode());
		result = prime * result + ((nomePiloto == null) ? 0 : nomePiloto.hashCode());
		result = prime * result + ((numeroVolta == null) ? 0 : numeroVolta.hashCode());
		result = prime * result + ((tempoVolta == null) ? 0 : tempoVolta.hashCode());
		result = prime * result + ((velocidadeMediaVolta == null) ? 0 : velocidadeMediaVolta.hashCode());
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
		Linha other = (Linha) obj;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
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
		if (numeroVolta == null) {
			if (other.numeroVolta != null)
				return false;
		} else if (!numeroVolta.equals(other.numeroVolta))
			return false;
		if (tempoVolta == null) {
			if (other.tempoVolta != null)
				return false;
		} else if (!tempoVolta.equals(other.tempoVolta))
			return false;
		if (velocidadeMediaVolta == null) {
			if (other.velocidadeMediaVolta != null)
				return false;
		} else if (!velocidadeMediaVolta.equals(other.velocidadeMediaVolta))
			return false;
		return true;
	}

}
