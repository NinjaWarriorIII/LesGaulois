package personnage;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village = null;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + ": ";
	}

	@Override
	public String toString() {
		return nom;
	}

	public void frapper(Romain romain) {
		System.out.println(this.nom + "envoie un grand coup dans la machoir de " + romain.getNom());
		romain.recevoirCoup((force * effetPotion) / 3);
		if (effetPotion > 1) {
			effetPotion--;
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	public void SetVillage(Village village) {
		this.village = village;
	}

	public void sePresenter() {
		if (village != null) {
			if (village.getChef().getNom() == nom) {
				parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village " + village.getNom());
			} else {
				parler("Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom());
			}
		} else {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}

}
