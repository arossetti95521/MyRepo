package pizzeria.model;

 
public class Wrapper {

	private String nomepizza;
	private int idpizza;
	private int idutente;
	private int impasto;
	private int[] ingredienti;
	public String getNomepizza() {
		return nomepizza;
	}
	public void setNomepizza(String nomepizza) {
		this.nomepizza = nomepizza;
	}
	public int getIdpizza() {
		return idpizza;
	}
	public void setIdpizza(int idpizza) {
		this.idpizza = idpizza;
	}
	public int getIdutente() {
		return idutente;
	}
	public void setIdutente(int idutente) {
		this.idutente = idutente;
	}
	public int getImpasto() {
		return impasto;
	}
	public void setImpasto(int impasto) {
		this.impasto = impasto;
	}
 
	 
	public Wrapper(String nomepizza, int idpizza, int idutente, int impasto, int[] ingredienti) {
		super();
		this.nomepizza = nomepizza;
		this.idpizza = idpizza;
		this.idutente = idutente;
		this.impasto = impasto;
		this.ingredienti = ingredienti;
	}
	public int[] getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(int[] ingredienti) {
		this.ingredienti = ingredienti;
	}
	public Wrapper( ) {
 	}
	
	@Override
	public String toString() {
		return "Wrapper [nomepizza=" + nomepizza + ", idpizza=" + idpizza + ", idutente=" + idutente + ", impasto="
				+ impasto + ", ingredienti=" + ingredientiStampa() + "]";
	}
	
	public String ingredientiStampa () 
	{
		
		String i=" ";
		for(int intero : ingredienti)
		{i+=intero+" ";
			 
		}
		return i;
	}
	
	
	
}
