package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nb_trophees;
	private Equipement[] trophees= new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	//	private String prendreParole() {
	//		return "Le gaulois " + nom + " : ";
	//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";

	}
	//	public void frapper(Romain romain) {
	//		System.out.println(nom + " envoie un grand coup dans la m�choire de "
	//				+ romain.getNom());
	//		romain.recevoirCoup((force / 3)*this.effetPotion);
	//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la	m�choire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) *
				effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
				nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}

	}

	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;
		this.parler("Merci Druide, je sens que ma force est "+ this.effetPotion+ " fois d�cupl�e. ");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
				+ ", effetPotion=" + effetPotion + "]";
	}
	public int getForce() {
		return force;
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix",8);
		Romain centurius = new Romain("centurius", 5);
		System.out.println(asterix.getNom());
		System.out.println(asterix.prendreParole());
		asterix.parler("bonjour");
		asterix.boirePotion(10);
		asterix.frapper(centurius);;

	}
}
