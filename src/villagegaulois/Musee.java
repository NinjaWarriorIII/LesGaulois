package villagegaulois;

import objets.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if(nbTrophee < 200) {
			trophees[nbTrophee] = new Trophee(gaulois, equipement);
			++nbTrophee;
		}
	}
	public String extraireInstructionOCaml() {
		String texteString = "let musee = [\n";
		for(int i = 0; i < nbTrophee; ++i) {
			texteString += "    \"" + trophees[i].getGaulois() + "\", \"" + trophees[i].getEquipement()
					+ "\";\n";
		}
		texteString += "]";
		return texteString;
	}
	
}
