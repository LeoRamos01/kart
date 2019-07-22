package gympass.kart.vo;

import java.util.List;

/**
 * @author leonardo
 *
 */
public class Piloto {
	
	private String id;
	
	private String nome;
	
	private List<Volta> voltas;
	
	public Piloto() {
	}

	public Piloto(String id, String nome, List<Volta> voltas) {
		super();
		this.id = id;
		this.nome = nome;
		this.voltas = voltas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Volta> getVoltas() {
		return voltas;
	}

	public void setVoltas(List<Volta> voltas) {
		this.voltas = voltas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Piloto [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", voltas=");
		builder.append(voltas);
		builder.append("]");
		return builder.toString();
	}

}
