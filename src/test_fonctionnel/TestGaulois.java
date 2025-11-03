package test_fonctionnel;

import objets.Equipement;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
import villagegaulois.Musee;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);		
		Druide panoramix = new Druide("Panoramix", 2, 2);
		
		Romain brutus = new Romain("Brutus", 14);
		brutus.sEquiper(Equipement.CASQUE);
		brutus.sEquiper(Equipement.BOUCLIER);
		
		Romain romulus = new Romain("Romulus", 1);
		romulus.sEquiper(Equipement.CASQUE);
		romulus.sEquiper(Equipement.BOUCLIER);
		
		panoramix.fabriquerPotion(4, 3);
		panoramix.boosterGaulois(obelix);
		panoramix.boosterGaulois(asterix);
		
		for(int i = 0; i < 3; ++i) {
			asterix.frapper(brutus);
		}
		asterix.frapper(romulus);
		Musee musee = new Musee();
		asterix.faireUneDonnation(musee);
		
	}
	
}
