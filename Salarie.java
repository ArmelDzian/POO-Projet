
/**
 * La Classe Salarie. Un salarie va trasporter des livraisons en conduisant un vehicule.
 */
public class Salarie {
	
	/** Le nom d'un salarie. */
	private String nom;
	
	/** Le poids d'un salarie en kg. */
	private int poidsEnKg;
	
	/** Le salaire par heure d'un salarie (en euro). */
	private double salaireParHeure;
	
	/**
	 * Instantiation d'un nouveau salarie.
	 *
	 * @param nom le nom du salarie
	 * @param poids le poids en kg
	 * @param salaireParHeure le salaire par heure en euro
	 */
	public Salarie(String nom, int poids, double salaireParHeure) {
		this.nom = nom;
		this.poidsEnKg = poids;
		this.salaireParHeure = salaireParHeure;
	}
	
	
	/**
	 * Donne le nom d'un salarie nom.
	 *
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Donne le poids en kg d'un salarie.
	 *
	 * @return le poids en kg
	 */
	public int getPoidsEnKg() {
		return poidsEnKg;
	}
	
	/**
	 * Donne le salaire par heure d'un salarie en euro.
	 *
	 * @return le salaire par heure
	 */
	public double getSalaireParHeure() {
		return salaireParHeure;
	}
	
	
	/**
	 * Donne la charge utile d'un salarie en kg.
	 *
	 * @return un int
	 */
	public int chargeUtileEnKg() {
		return this.poidsEnKg/8;
	}

	@Override
	public String toString() {
		return this.nom;
	}
	
	
}
