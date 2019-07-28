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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((voltas == null) ? 0 : voltas.hashCode());
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
		Piloto other = (Piloto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (voltas == null) {
			if (other.voltas != null)
				return false;
		} else if (!voltas.equals(other.voltas))
			return false;
		return true;
	}

}
