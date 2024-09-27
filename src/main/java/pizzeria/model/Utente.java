package pizzeria.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "psw")
	private String psw;
	
	@JsonIgnore
	@OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
	private List<Pizza> pizze;

	public Utente() {
		super();
	}

	public Utente(String username, String psw) {

		this.psw = psw;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", psw=" + psw + ", pizze=" + toStringPizze() + "]";
	}

	public String toStringPizze() {
		StringBuffer sb = new StringBuffer();
		for (Pizza p : pizze) {
			sb.append(p.toString()+"\n");
		}
		return sb.toString();

	}

	public void deleteMyPizza(int id) {
		for (Pizza p : pizze) {
			if (p.getId() == id)
				pizze.remove(p);
			break;
		}
	}

}