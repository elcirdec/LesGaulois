package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2]; 
	int nbEquipement=0;
	private String texte;
	public Romain(String nom, int force) {
		assert(force>=0);
		this.nom = nom;	
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	//	public void recevoirCoup(int forceCoup) {
	//		assert(force>=0);
	//		int var=force;
	//		force -= forceCoup;
	//		if (force > 0) {
	//			parler("Aïe");
	//		} else {
	//			parler("J'abandonne...");
	//		}
	//		assert(force<var);
	//	}
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du	coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null &&
						equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if(force==0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {			
		case 2:
			System.out.println("Le soldat "+this.getNom()+" est déjà bien protégé !");
			break;
		case 1:
			if(equipements[0]==equipement) {						
				System.out.println("Le soldat "+this.getNom()+" possède déjà un "+equipement);
			}else {
				equipements[1]=equipement;
				nbEquipement++;
				System.out.println("Le soldat "+this.getNom()+" s’équipe avec un "+equipement);
			}
			break;
		default:
			equipements[0]=equipement;
			nbEquipement++;
			System.out.println("Le soldat "+this.getNom()+" s’équipe avec un "+equipement);
			break;
		}
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		Romain centurius = new Romain("centurius",6);
		Romain Minus = new Romain("minus",3);

		Minus.sEquiper(Equipement.CASQUE);
		Minus.sEquiper(Equipement.CASQUE);
		Minus.sEquiper(Equipement.BOUCLIER);
		Minus.sEquiper(Equipement.BOUCLIER);

		System.out.println(centurius.getNom());
		System.out.println(centurius.prendreParole());
		centurius.parler("bonjour");
		centurius.recevoirCoup(10);
		System.out.println(Equipement.BOUCLIER+"\n"+Equipement.CASQUE);

	}
	public int getForce() {
		return force;
	}
}
