package personnage;

import objects.Equipement;

public class Romain {
	private String nom;
	private int force;
	Equipement[] equipements = new Equipement[2];
	int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;

		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int coup) {
		assert isInvariantVerified();

		this.force = this.force - coup;
		if (force < 1) {
			parler("J'abandonne");
		} else {
			parler("Aïe");
		}

		assert isInvariantVerified();
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
