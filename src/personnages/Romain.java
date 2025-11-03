package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = true;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;

		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}
	
	public boolean estVainqueur() {
		return vainqueur;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; ++i) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if(resistanceEquipement <= forceCoup) {
			forceCoup -= resistanceEquipement;
		}else {
			forceCoup = 0;
		}
		return forceCoup;
	}

	public int getForce() {
		return force;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		nbEquipement = 0;
		return equipementEjecte;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			
			if(force < 0) {
				vainqueur = false;
			}
		}
		return equipementEjecte;
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	@Override
	public String toString() {
		return nom;
	}

	public void sEquiper(Equipement equipement) {
		System.out.print("Le soldat " + nom + " ");
		switch (nbEquipement) {
		case 0: {
			ajouterEquipement(equipement);
			break;
		}
		case 1:
			if (equipements[0].equals(equipement)) {
				System.out.println("possède déjà un " + equipement);
			} else {
				ajouterEquipement(equipement);
			}
			break;
		default:
			System.out.println("est déjà bien protégé !");
		}

	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		System.out.println("s'équipe avec un " + equipement);
		nbEquipement++;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minux", 0);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
}
