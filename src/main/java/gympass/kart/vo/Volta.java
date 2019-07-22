package gympass.kart.vo;

import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * @author leonardo
 *
 */
public class Volta {
	
	private Integer idVolta;
	
	private LocalTime tempoVolta;
	
	private BigDecimal velocidadeMediaVolta;
	
	private LocalTime horaTerminoVolta;
	
	public Volta() {	}

	public Volta(Integer idVolta, LocalTime tempoVolta, BigDecimal velocidadeMediaVolta, LocalTime horaTerminoVolta) {
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

	public LocalTime getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(LocalTime tempoVolta) {
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

}
