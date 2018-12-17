
/**
 * La Classe Velo qui est une sous-classe d'un vehicule. Elle est characteristique par sa vitesse constante de 15km/h et l'emission de CO2 nulle.
 */
public class Velo extends Vehicule{
	
	/**
	 * Instantiation d'un nouveau velo.
	 *
	 * @param nom
	 * @param prixAchat
	 */
	public Velo(String nom, int prixAchat) {
		super(nom, prixAchat,0);
	}

	@Override
	public double vitesseMoyenneEnKmH() {
		return 15;
	}
	
	@Override
	public double emissionCO2EnGKm() {
		return 0;
	}
	
	@Override
	public double coutUtilisationParKm() {
		return super.getPrixAchat()/30000.0;
	}

	@Override
	public String toString() {
		return "velo : "+super.getNom();
	}
	
	
	
}
