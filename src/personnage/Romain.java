package personnage;

public class Romain {
	private String nom;
	private int force;

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
		return force>=0;
	}

	@Override
	public String toString() {
		return nom;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minux", -6);
	}
}
