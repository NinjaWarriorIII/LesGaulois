package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int minPotion;
	private int maxPotion;
	private Chaudron chaudron = new Chaudron();

	public Druide(String nom, int minPotion, int maxPotion) {
		this.nom = nom;
		this.minPotion = minPotion;
		this.maxPotion = maxPotion;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force de " + minPotion +
				" à " + maxPotion);
		
		
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + ": ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a " + "une force " + forcePotion);
	}
	
	public void preparerPotion() {
		chaudron.remplirChaudron(10, (minPotion + maxPotion) / 2);
		parler("J'ai préparer une super potion de force " + (minPotion + maxPotion) / 2);
	}

	public void boosterGaulois(Gaulois gaulois) {
		boolean contientPotion = chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();

		if (contientPotion) {
			if ("Obélix".equals(nomGaulois)) {
				parler("Non, " + nomGaulois + " Non!... Et tu le sais très bien !");
			} else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + nomGaulois + " un peu de potion magique.");
			}
		} else {
			parler("Désolé " + nomGaulois + " il n'y a plus une seule goutte de potion");
		}
	}

}
