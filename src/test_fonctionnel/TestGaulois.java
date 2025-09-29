package test_fonctionnel;

import personnage.Druide;
import personnage.Gaulois;
import personnage.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);		
		Druide panoramix = new Druide("Panoramix", 2);
		
		Romain brutus = new Romain("Brutus", 14);
		
		panoramix.fabriquerPotion(4, 3);
		panoramix.boosterGaulois(obelix);
		panoramix.boosterGaulois(asterix);
		
		for(int i = 0; i < 3; ++i) {
			asterix.frapper(brutus);
		}
		
	}
	
}
