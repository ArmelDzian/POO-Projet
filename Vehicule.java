

/**
 * La Classe Vehicule. Un vehicule est un moyen de transporter des livraisons.
 */
public abstract class Vehicule {
	
	/** Le nom d'un vehicule. */
	private String nom;
	
	/** Le prix d'achat en euros. */
	private int prixAchat;
	
	/** La charge utile en kilogrammes. */
	private int chargeUtile;
	
	/**
	 * Instantiation d'un nouveau vehicule.
	 *
	 * @param nom
	 * @param prixAchat
	 * @param chargeUtile
	 */
	public Vehicule(String nom, int prixAchat, int chargeUtile) {
		this.nom = nom;
		this.prixAchat = prixAchat;
		this.chargeUtile = chargeUtile;
	}
	
	/**
	 * Donne le nom.
	 *
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Ddnne le prix achat.
	 *
	 * @return le prix d'achat
	 */
	public int getPrixAchat() {
		return prixAchat;
	}
	
	/**
	 * Donne la charge utile en kg.
	 *
	 * @return la charge utile en kg
	 */
	public int getChargeUtileEnKg() {
		return this.chargeUtile;
	}
	
	/**
	 * Donne la vitesse moyenne en km/h.
	 *
	 * @return un double
	 */
	public abstract double vitesseMoyenneEnKmH();
	
	/**
	 * Donne l'emission de CO2 en g/km.
	 *
	 * @return un double
	 */
	public abstract double emissionCO2EnGKm();
	
	/**
	 * Donne le cout d'utilisation par km.
	 *
	 * @return un double
	 */
	public abstract double coutUtilisationParKm();
	
	/* Reimplementation de la methode toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();
	
	
	
}
