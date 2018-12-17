
/**
 * La Classe Scooter qui est un sous-classe d'un vehicule.
 */
public class Scooter extends Vehicule{
	
	/** La cylindree en cm^3. */
	private int cylindre;
	
	/** La consomation d'essence par km. */
	private double consoEssenceParKm;
	
	/** Le prix d'essence par litre. */
	public static double prixLitreEssence = 1.45;
	
	/**
	 * Instantiation d'un nouveau scooter.
	 *
	 * @param nom le nom
	 * @param prixAchat le prix d'achat
	 * @param cylindre la cylindree
	 * @param chargeUtileEnKg la charge utile en kg
	 * @param consoEssence la consomation d'essence
	 */
	public Scooter(String nom, int prixAchat, int cylindre, int chargeUtileEnKg, double consoEssence) {
		super(nom, prixAchat,chargeUtileEnKg);
		this.cylindre = cylindre;
		this.consoEssenceParKm = consoEssence;
	}
	
	

	@Override
	public double vitesseMoyenneEnKmH() {
		return 30.0+(this.cylindre/50.0);
	}

	@Override
	public double emissionCO2EnGKm() {
		return this.cylindre/4.0;
	}

	@Override
	public double coutUtilisationParKm() {
		return super.getPrixAchat()/20000.0 + ((this.consoEssenceParKm/100)*prixLitreEssence);
	}
	
	public String toString() {
		return "scooter : "+super.getNom();
	}
	
	
}
