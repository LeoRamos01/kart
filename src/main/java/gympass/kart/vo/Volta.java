package gympass.kart.vo;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

/**
 * @author leonardo
 *
 */
public class Volta {
	
	private Integer idVolta;
	
	private Duration tempoVolta;
	
	private BigDecimal velocidadeMediaVolta;
	
	private LocalTime horaTerminoVolta;
	
	public Volta() {	}

	public Volta(Integer idVolta, Duration tempoVolta, BigDecimal velocidadeMediaVolta, LocalTime horaTerminoVolta) {
		super();
		this.idVolta = idVolta;
		this.tempoVolta = tempoVolta;
		this.velocidadeMediaVolta = velocidadeMediaVolta;
		this.horaTerminoVolta = horaTerminoVolta;
	}

	public BigDecimal getVelocidadeMediaVolta() {
		return velocidadeMediaVolta;
	}

	public void setVelocidadeMediaVolta(BigDecimal velocidadeMediaVolta) {
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	public Integer getIdVolta() {
		return idVolta;
	}

	public void setIdVolta(Integer idVolta) {
		this.idVolta = idVolta;
	}

	public Duration getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(Duration tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public LocalTime getHoraTerminoVolta() {
		return horaTerminoVolta;
	}

	public void setHoraTerminoVolta(LocalTime horaTerminoVolta) {
		this.horaTerminoVolta = horaTerminoVolta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Volta [idVolta=");
		builder.append(idVolta);
		builder.append(", tempoVolta=");
		builder.append(tempoVolta);
		builder.append(", velocidadeMediaVolta=");
		builder.append(velocidadeMediaVolta);
		builder.append(", horaTerminoVolta=");
		builder.append(horaTerminoVolta);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horaTerminoVolta == null) ? 0 : horaTerminoVolta.hashCode());
		result = prime * result + ((idVolta == null) ? 0 : idVolta.hashCode());
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
		Volta other = (Volta) obj;
		if (horaTerminoVolta == null) {
			if (other.horaTerminoVolta != null)
				return false;
		} else if (!horaTerminoVolta.equals(other.horaTerminoVolta))
			return false;
		if (idVolta == null) {
			if (other.idVolta != null)
				return false;
		} else if (!idVolta.equals(other.idVolta))
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
