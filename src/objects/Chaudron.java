package objects;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public boolean resterPotion() {
		if(this.quantitePotion == 0) {
			return false;
		}
		return true;
	}
	
	public int prendreLouche() {
		if(resterPotion()) {
			quantitePotion--;
		}
		else {
			forcePotion = 0;
		}
		return forcePotion;
	}
	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
}
