package personnage;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
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
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int coup) {
		this.force = this.force - coup;
		if (force < 1) {
			parler("J'abandonne");
		} else {
			parler("Aïe");
		}
	}

	@Override
	public String toString() {
		return nom;
	}
}
