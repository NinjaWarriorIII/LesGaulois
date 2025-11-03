package personnages;

import java.util.Objects;

import objets.Equipement;
import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
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
		return "Le gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return nom;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] romainDrops = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; romainDrops != null && i < romainDrops.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = romainDrops[i];
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void sePresenter() {
		String ligneBonjour = "Bonjour, je m'appelle ";
		if (village != null) {
			if (Objects.equals(village.getChef().getNom(), nom)) {
				parler(ligneBonjour + nom + ". Je suis le chef du village " + village.getNom());
			} else {
				parler(ligneBonjour + nom + ". J'habite le village " + village.getNom());
			}
		} else {
			parler(ligneBonjour + nom + ". Je voyage de villages en villages.");
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		if(trophees[0] != null) {
			parler("Je donne au musee tous mes trophees : ");
			int i = 0;
			while(i < 100 && trophees[i] != null) {
				System.out.println("- " + trophees[i]);
				musee.donnerTrophees(this, trophees[i]);
				trophees[i] = null;
				++i;
			}
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}

}
