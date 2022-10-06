package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois=0;
	private Gaulois[] villageois;
	public Village(String nom,int nbVillageoisMaximum) {
		this.nom = nom;
		villageois= new Gaulois[nbVillageoisMaximum];
		
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois++]=gaulois;
	}
	public Gaulois trouverHabitant(int noHabitant) {
		return villageois[noHabitant];
	}
	public static void main(String[] args) {
		Village village=new Village("village des Irréductibles", 30);
		Gaulois gaulois = village.trouverHabitant(30);

		
	}
}
