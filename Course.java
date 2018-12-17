import java.util.ArrayList;
import java.util.Iterator;

/**
 * La Classe Course. Une course correspond a un couple vehicule-conducteur capable de transporter une livraison.
 */
public class Course {
	
	/** Le vehicule utlilise pour la course. */
	private Vehicule vehicule;
	
	/** Le conducteur est un salarie qui va conduir le vehicule d'une coure donnee. */
	private Salarie conducteur;
	
	/** Le poids de la livraison a transporter en kg. */
	private double poidsEnKg;
	
	/** La distance entre le local de l'entreprise et le lieu de livarison en km. */
	private double distanceEnKm;
	
	/**
	 * Instantiation d'une nouvelle course.
	 *
	 * @param vehicule le vehicule utlilise
	 * @param conducteur le salarie qui va livrer le commande
	 * @param poids le poids a livrer
	 * @param distance la distance entre le local de l'entreprise et le lieu de livarison
	 */
	public Course(Vehicule vehicule, Salarie conducteur, double poids, double distance) {
		super();
		this.vehicule = vehicule;
		this.conducteur = conducteur;
		this.poidsEnKg = poids;
		this.distanceEnKm = distance;
	}
	
	/**
	 * Une foction qui arrondi un double a un certain nombre de positions decimales.
	 *
	 * @param num Le nombre a arrondir
	 * @param dec Le nombre de positions apres la virgule
	 * @return un double
	 */
	public static final double rnd(double num,double dec) {
		return Math.round(num*Math.pow(10, dec))/Math.pow(10, dec);
	}
	
	/**
	 * La charge utile d'une course correspond au maximum entre la charge utlie du vehicule et celle de son conducteur.
	 *
	 * @return Un int. La charge utile de la course en kg.
	 */
	public int chargeUtileEnKg() {
		return Math.max(this.vehicule.getChargeUtileEnKg(), this.conducteur.chargeUtileEnKg());
	}
	
	/**
	 * Le temps necessaire pour parcourir toute la course (aller-retour)
	 *
	 * @return Un double. Le temps de parcour de la course en heures.
	 */
	public double tempsParcourEnH() {
		return ((2*this.distanceEnKm)/this.vehicule.vitesseMoyenneEnKmH());
	}
	
	/**
	 * Une course est possible ssi le poids a transporter n'excede pas la charge utile de la course et si son temps de parour est inferieur a une heure.
	 *
	 * @return vrai, si la course est possible
	 */
	public boolean estPossible() {
		return (this.chargeUtileEnKg()>=this.poidsEnKg && this.tempsParcourEnH()<=1.0);
	}
	
	/**
	 * La quantite de CO2 produit pendant la course depend de son vehicule et la distance parcouru
	 *
	 * @return Un double. La valeure arrondie d'emission de CO2 en grammes
	 */
	public double emissionCO2EnG() {
		return rnd(this.vehicule.emissionCO2EnGKm()*(2*this.distanceEnKm),2);
	}
	
	/**
	 * Le prix d'une course est la somme entre le salaire du conducteur et le cout d'utilisation du vehicule sur la distance totale a parcourir (aller-retour).
	 *
	 * @return Un double. Le prix total de la course.
	 */
	public double prix() {
		return rnd(this.vehicule.coutUtilisationParKm()*(2*this.distanceEnKm) + this.conducteur.getSalaireParHeure()*this.tempsParcourEnH(),2);
	}
	
	/**
	 * Une course (c1,p1) avec c1 = quantite de CO2 produit et p1 = prix de la course, est pire qu'une autre (c2,p2) ssi : 
	 * ((c1>c2) et (p1>p2)) ou ((c1>c2) et (p1=p2)) ou ((c1=c2) et (p1>p2))
	 *
	 * @param courses La liste des courses de comparaison
	 * @return vrai, si la course est pire qu'au moins une autre.
	 */
	public boolean estPire(ArrayList<Course> courses) {
		Iterator<Course> iter = courses.iterator();
		Course c = iter.next();
		double c1 = this.emissionCO2EnG();
		double p1 = this.prix();
		double c2 = c.emissionCO2EnG();
		double p2 = c.prix();
		
		while (iter.hasNext() && !( ((c1>c2)&&(p1>p2)) || ((c1>c2)&&(p1==p2)) || ((c1==c2)&&(p1>p2)) ) ) {
			c = iter.next();
			c2 = c.emissionCO2EnG();
			p2 = c.prix();
		}
		return ( ((c1>c2)&&(p1>p2)) || ((c1>c2)&&(p1==p2)) || ((c1==c2)&&(p1>p2)) );
	}

	@Override
	public String toString() {
		return this.conducteur+" ----> "+this.vehicule+" ( "+this.prix()+"Eur, "+this.emissionCO2EnG()+"g de CO2, " +rnd(this.tempsParcourEnH()*30,2)+"min )";
	}
	
	

}
