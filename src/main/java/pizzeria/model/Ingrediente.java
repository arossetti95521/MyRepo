package pizzeria.model;

import javax.persistence.*;


@Entity
@Table(name = "ingrediente")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

	public Ingrediente() {
		super();
	}

	public Ingrediente( String nome) {
		this.nome = nome;
 	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return nome + " ";
	}
}
