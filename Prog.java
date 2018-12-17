
public class Prog {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Entreprise pizzeria = new Entreprise();
		pizzeria.ajoutSalarie(new Salarie("Louise",55,7.4));
		pizzeria.ajoutSalarie(new Salarie("Alfred",80,7.3));
		pizzeria.ajoutSalarie(new Salarie("Camille",67,7.5));
		pizzeria.ajoutSalarie(new Salarie("Pierre",62,7.2));
		pizzeria.ajoutVehicule(new Velo("Velov",450));
		pizzeria.ajoutVehicule(new Velo("Bicloo",500));
		pizzeria.ajoutVehicule(new Scooter("Yamaha",3500, 300, 50, 7.5));
		pizzeria.ajoutVehicule(new Scooter("Vespo",2500, 125, 30, 5.5));
		pizzeria.ajoutVehicule(new Scooter("Piagi",2000, 150, 35, 6));
		
		System.out.print(pizzeria.toString());
		
		System.out.println("\n--- Test scooter ---");
		System.out.println("nom : "+pizzeria.getVehicules().get(3).getNom());
		System.out.println("vitesse moyenne (32.5 km/h): "+pizzeria.getVehicules().get(3).vitesseMoyenneEnKmH());
		System.out.println("Emission CO2 (31.25 g/km) : "+pizzeria.getVehicules().get(3).emissionCO2EnGKm());
		System.out.println("Cout utilisation (0.2048 EUR/km): "+pizzeria.getVehicules().get(3).coutUtilisationParKm()+"\n");
		
		System.out.println("\n--- Test velo ---");
		System.out.println("nom : "+pizzeria.getVehicules().get(1).getNom());
		System.out.println("vitesse moyenne (15 km/h): "+pizzeria.getVehicules().get(1).vitesseMoyenneEnKmH());
		System.out.println("Emission CO2 (0.0 g/km) : "+pizzeria.getVehicules().get(1).emissionCO2EnGKm());
		System.out.println("Cout utilisation (0.01667 EUR/Km): "+pizzeria.getVehicules().get(1).coutUtilisationParKm()+"\n");
		
		System.out.println("\n--- Test salarie ---");
		System.out.println("nom : "+pizzeria.getSalaries().get(1).getNom());
		System.out.println("charge utile (10 kg): "+pizzeria.getSalaries().get(1).chargeUtileEnKg()+"\n");

	
		System.out.println(pizzeria.livrer(0.5,1));
		System.out.println(pizzeria.livrer(5,5));
		System.out.println(pizzeria.livrer(8,2));
		System.out.println(pizzeria.livrer(0.5,15));
		System.out.println(pizzeria.livrer(10,10));

		

	}

}
