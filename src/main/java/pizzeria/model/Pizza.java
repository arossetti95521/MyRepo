package pizzeria.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

	@ManyToOne(targetEntity = Impasto.class)
	@JoinColumn(name = "id_impasto", nullable = false)
	private Impasto impasto;

	@ManyToOne(targetEntity = Utente.class)
	@JoinColumn(name = "id_utente", nullable = false)
	private Utente utente;

	@ManyToMany(targetEntity = Ingrediente.class)
	@JoinTable(name = "pizza_ingrediente", joinColumns = { @JoinColumn(name = "id_pizza") }, inverseJoinColumns = {
			@JoinColumn(name = "id_ingrediente") })
	private List<Ingrediente> ingredienti;

	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public Pizza() {
		super();
	}

	public Pizza(String nome, Utente utente, Impasto impasto, List<Ingrediente> ingredienti) {

		this.impasto = impasto;
		this.nome = nome;
		this.utente = utente;
		this.ingredienti = ingredienti;

	}

	public int getId() {
		return id;
	}

	public Impasto getImpasto() {
		return impasto;
	}

	public void setImpasto(Impasto impasto) {
		this.impasto = impasto;
	}

	public void Impasto(Impasto impasto) {
		this.impasto = impasto;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
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

	public String toStringIngredienti() {
		StringBuffer sb = new StringBuffer();
		for (Ingrediente i : ingredienti) {
			sb.append(i.toString());
		}
		return sb.toString();

	}

	public String toString() {
		return "Pizza [id=" + id + ", nome=" + nome + ", impasto=" + impasto.getNome() + ", utente="
				+ utente.getUsername() + ", ingredienti=" + toStringIngredienti() + "]";
	}

}
