package philosophes;
import java.util.ArrayList;
import plateforme.*;
import philosophes.actions.*;


public class Philosophe extends Agent {

	protected Table tab;
	protected int ID;
	protected boolean fourchettes;
	protected Etat etat;
	protected int faim;
	protected int pensee;
	protected int famine;

	public Philosophe(Table tab, int ID){
		
		this.tab = tab;
		this.ID = ID;
		this.fourchettes = false;
		this.etat = Etat.en_train_penser;
		this.faim = -10;
		this.pensee = 0;
		this.famine = 0;
		
		ArrayList<Action> listeActions = new ArrayList<Action>();
		// LISTE DES ACTIONS POSSIBLES POUR CET AGENT :
		listeActions.add(new Penser());
		listeActions.add(new FinirPenser());
		listeActions.add(new PrendreFourchettes());
		listeActions.add(new Manger());
		listeActions.add(new FinirManger());
		listeActions.add(new Famine());
		//
		this.actions = listeActions;
		
	}

	// Vérifie si la fourchette à gauche du philosophe est disponible
	
	public boolean regarderGauche(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		return fourch.getDispo(this.ID);
	}
	
	// Vérifie si la fourchette à droite du philosophe est disponible
	
	public boolean regarderDroite(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		return fourch.getDispo((this.ID+1) % (this.tab.getEffectif()));
	}
	
	// Prend les fourchettes
	
	public void prendreFourchettes(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		fourch.setDispo(this.ID, false);
		fourch.setDispo((this.ID+1) % (this.tab.getEffectif()), false);
		this.fourchettes = true;
	}
	
	// Pose les fourchettes (et les rend disponibles)
	
	public void poserFourchettes(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		fourch.setDispo(this.ID, true);
		fourch.setDispo((this.ID+1) % (this.tab.getEffectif()), true);
		this.fourchettes = false;
	}

	public void incrementFamine(){
		this.famine ++;
		tab.setCompteurFamine(tab.getCompteurFamine()+1);
	}
	
	public void incrementPensee(){
		this.pensee ++;
		tab.setCompteurPensee(tab.getCompteurPensee()+1);
	}

	// Vérifie si le philosophe a les fourchettes
	
	public boolean aLesFourchettes() {
		return fourchettes;
	}
	
	// Vérifie l'état (penser, famine, attente) du philosophe

	public Etat getEtat() {
		return etat;
	}
	
	// Modifie l'état du philosophe

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	// Vérifie le compteur de faim du philosophe
	
	public int getFaim() {
		return faim;
	}
	
	// Modifie le compteur de faim du philosophe

	public void setFaim(int faim) {
		this.faim = faim;
	}
	
	// Vérifie l'ID du philosophe
	
	public int getID() {
		return ID;
	}

	// Récupère le seuil de faim du système
	
	public int getSeuilFaim() {
		return tab.getSeuilFaim();
	}
	
	// Récupère le delta de pensée

	public int getDeltaFPenser() {
		return tab.getDeltaFPenser();
	}
	
	// Récupère le delta de faim

	public int getDeltaFManger() {
		return tab.getDeltaFManger();
	}
	
	// Récupère le delta de famine
	
	public int getDeltaFFamine() {
		return tab.getDeltaFFamine();
	}
	
	
}
