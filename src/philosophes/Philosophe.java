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

	public boolean regarderGauche(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		return fourch.getDispo(this.ID);
	}
	
	public boolean regarderDroite(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		return fourch.getDispo((this.ID+1) % (this.tab.getEffectif()));
	}
	
	public void prendreFourchettes(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		fourch.setDispo(this.ID, false);
		fourch.setDispo((this.ID+1) % (this.tab.getEffectif()), false);
		this.fourchettes = true;
	}
	
	public void poserFourchettes(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		fourch.setDispo(this.ID, true);
		fourch.setDispo((this.ID+1) % (this.tab.getEffectif()), true);
		this.fourchettes = false;
	}
	
	public void poser(int i){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		fourch.setDispo(i, true);
	}

	public Table getTab() {
		return tab;
	}

	public void setTab(Table tab) {
		this.tab = tab;
	}

	public boolean aLesFourchettes() {
		return fourchettes;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getFaim() {
		return faim;
	}

	public void setFaim(int faim) {
		this.faim = faim;
	}

	public int getPensee() {
		return pensee;
	}

	public void setPensee(int pensee) {
		this.pensee = pensee;
	}
		
	public int getFamine() {
		return famine;
	}

	public void setFamine(int famine) {
		this.famine = famine;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSeuilFaim() {
		return tab.getSeuilFaim();
	}

	public int getDeltaFPenser() {
		return tab.getDeltaFPenser();
	}

	public int getDeltaFManger() {
		return tab.getDeltaFManger();
	}
	
	public int getDeltaFFamine() {
		return tab.getDeltaFFamine();
	}
	
	
	
	
}
