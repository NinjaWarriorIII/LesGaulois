package test_fonctionnel;

import personnage.Gaulois;
import personnage.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 16);		
		
		Romain minus = new Romain("Minus", 6);
		
		asterix.parler("Bonjour Obélix.");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des\r\n"
				+ "sangliers ?");
		asterix.parler("Oui très bonne idée.");
		
		System.out.println("Dans la forêt " + asterix + " et "+ obelix +" tombent nez à\r\n"
				+ "nez sur le romain "+ minus);
		
		for(int i = 0; i < 3; ++i) {
			asterix.frapper(minus);
		}
	}
	
}
