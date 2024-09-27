 package pizzeria.model;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "impasto")
public class Impasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "impasto")
	List<Pizza> pizze; 

	public Impasto() {
		super();
	};

	public Impasto( String nome) {
		this.nome = nome;
 	};

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
		return "Impasto [id=" + id + ", nome=" + nome + "]";
	}

}
