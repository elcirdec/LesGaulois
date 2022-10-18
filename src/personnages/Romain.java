package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2]; 
	int nbEquipement=0;
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
	public void recevoirCoup(int forceCoup) {
		assert(force>=0);
		int var=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert(force<var);
	}
	public void sEquiper(Equipement equipement) {
			switch(nbEquipement) {			
				case 0:
					if(equipements[0]==equipement) {
						equipements[nbEquipement++]=equipement;
						System.out.println("Le soldat "+this.getNom()+" possède déjà un "+equipement);
					}else {
						equipements[nbEquipement++]=equipement;
					}
				case 1:
					System.out.println("Le soldat"+this.getNom()+"est déjà bien protégé !");
				default:
					equipements[nbEquipement++]=equipement;
					System.out.println("Le soldat"+this.getNom()+"s’équipe avec un "+equipement);
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
}
