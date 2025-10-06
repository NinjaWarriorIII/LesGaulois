package personnage;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Gaulois chef;
	
	public Village(String nom, Gaulois chef, final int NB_VILLAGEIOS_MAX) {
		this.nom = nom;
		this.chef = chef;
		villageois = new Gaulois[NB_VILLAGEIOS_MAX];
		
		
	}

	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if(nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			gaulois.SetVillage(this);
		}
	}
	
	public Gaulois trouverVillageois(int numeroGaulois) {
		if(numeroGaulois-1 < nbVillageois) {
			return villageois[numeroGaulois-1];
		}
		System.out.println("Il n'y a pas autant d'habitant dans notre village !");
		return null;
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village \"Village des Irréductibles\" du chef" + chef + "vivent les légendaires gaulois :");
		for(int i = 0; i < nbVillageois; ++i) {
			System.out.println("- " + villageois[i]);
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourix = new Gaulois("Abraracourix", 6);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois doublePolemix = new Gaulois("DoublePolémix", 4);
		Village village = new Village("Village des Irréductibles", abraracourix, 30);
		village.ajouterVillageois(asterix);
		village.ajouterVillageois(obelix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		
		village.afficherVillageois();
		
		abraracourix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
		
	}
	
}
