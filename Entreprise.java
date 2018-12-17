import java.util.ArrayList;

/**
 * La Classe Entreprise. L'entreprise possede des salaries et vehicules et elle est capable de livrer une commande.
 */
public class Entreprise {
	
	/** La liste des salaries. */
	private ArrayList<Salarie> salaries;
	
	/** La liste des vehicules. */
	private ArrayList<Vehicule> vehicules;
	
	/**
	 * Instantiation d'une nouvelle entreprise.
	 */
	public Entreprise() {
		this.salaries = new ArrayList<Salarie>();
		this.vehicules = new ArrayList<Vehicule>();
	}
	
	/**
	 * Getter
	 * @return La liste de salaries
	 */
	public ArrayList<Salarie> getSalaries() {
		return salaries;
	}
	
	/**
	 * Getter
	 *
	 * @return La liste de vehicules
	 */
	public ArrayList<Vehicule> getVehicules() {
		return vehicules;
	}

	/**
	 * Ajoute un nouveau salarie dans la liste de salaries.
	 *
	 * @param s le salarie a ajouter
	 */
	public void ajoutSalarie(Salarie s) {
		this.salaries.add(s);
	}
	
	/**
	 * Ajoute un nouveau vehicule dans la liste de vehicules.
	 *
	 * @param v le vehicule a ajouter
	 */
	public void ajoutVehicule(Vehicule v) {
		this.vehicules.add(v);
	}


	/**
	 * Effectuer une livraison correspond a choisir une coursee qui correspond le mieux a la commande.
	 * 
	 * <p>
	 * Choisir la meilleure course consiste a prendre toutes les courses possibles qui ne sont pas pire qu'une autre, 
	 * et ensuite en choisi celle avec la valeure d'emission de CO2 la plus basse.
	 * </p>
	 * 
	 * @param poidsEnKg Le poids a transporter en kg
	 * @param distanceEnKm La distance entre le local de l'entreprise et le lieu de livarison en km.
	 * @return La meilleure course
	 */
	public Course livrer(double poidsEnKg, double distanceEnKm) {
		
		// La liste de courses possibles
		ArrayList<Course> cp = new ArrayList<Course>();
		
		// La liste de courses "optimales" = pas pires qu'une autre
		ArrayList<Course> co = new ArrayList<Course>();
		
		Course choix;
		
		// Constuir la liste des courses possibles
		for(Salarie s: this.salaries) {
			for(Vehicule v:this.vehicules) {
				Course c = new Course(v,s, poidsEnKg, distanceEnKm);
				if(c.estPossible()) {
					cp.add(c);
				}
			}
		}
		
		// S'il y a au moins une course possible, garder que celles qui ne sont pas pire qu'une autre
		if (!cp.isEmpty()) {
			for(Course c:cp) {
				//System.out.println(c.toString());
				if(!c.estPire(cp)) {
					co.add(c);
				}
			}
			// Choisir la course avec la valeure d'emission de CO2 la plus basse
			choix = co.get(0);
			for(Course c:co) {
				//System.out.println(c.toString());
				if(c.emissionCO2EnG()<choix.emissionCO2EnG()) {
					choix = c;
				}
			}
		}else { // Sinon la livraison ne peut pas s'effectuer
			System.out.println("Livraison impossible");
			choix = null;
		}
		
		return choix;
	}
	
	@Override
	public String toString() {
		String texte = "\n Salaries : \n";
		
		for (Salarie s:salaries) {
			texte = texte + s.toString()+"\n";
		}
		texte = texte+"\n Vehicules : \n";
		for (Vehicule v:vehicules) {
			texte = texte + v.toString()+"\n";
		}
		return texte;
	}
		
}
