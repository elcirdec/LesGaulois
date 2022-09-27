package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		Romain Minus = new Romain("Minus", 6);
		asterix.parler(" Bonjour à tous");
		Minus.parler( "UN GAU... UN GAUGAU...");
		asterix.frapper(Minus);
		asterix.frapper(Minus);
		asterix.frapper(Minus);
	}

}
