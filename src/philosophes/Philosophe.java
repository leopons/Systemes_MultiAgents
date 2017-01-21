package philosophes;
import java.util.ArrayList;
import plateforme.*;
import philosophes.actions.*;


public class Philosophe extends Agent {

	protected Table tab;
	protected int ID;
	protected boolean fg;
	protected boolean fd;
	protected Etat etat;
	protected int faim;
	protected int pensee;
	protected int famine;
	protected int seuilFaim;
	protected int deltaFPenser;
	protected int deltaFManger;
	protected int deltaFFamine;

	public Philosophe(Table tab, int seuilFaim, int deltaFPenser, int deltaFManger, int deltaFFamine, int ID){
		
		this.tab = tab;
		this.ID = ID;
		this.fg = false;
		this.fd = false;
		this.etat = Etat.en_train_penser;
		this.faim = -10;
		this.pensee = 0;
		this.famine = 0;
		this.seuilFaim = seuilFaim;
		this.deltaFPenser = deltaFPenser;
		this.deltaFManger = deltaFManger;
		this.deltaFFamine = deltaFFamine;
		
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
		this.fg = true;
		fourch.setDispo((this.ID+1) % (this.tab.getEffectif()), false);
		this.fd = true;
	}
	
	public void poserFourchettes(){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		fourch.setDispo(this.ID, true);
		this.fg = false;
		fourch.setDispo((this.ID+1) % (this.tab.getEffectif()), true);
		this.fd = false;
	}
	
	public void poser(int i){
		Fourchettes fourch = (Fourchettes) this.tab.getDonnees().get(0);
		fourch.setDispo(i, true);
	}
	
	public int getFamine() {
		return famine;
	}

	public void setFamine(int famine) {
		this.famine = famine;
	}

	public int getDeltaFFamine() {
		return deltaFFamine;
	}

	public void setDeltaFFamine(int deltaFFamine) {
		this.deltaFFamine = deltaFFamine;
	}

	public Table getTab() {
		return tab;
	}

	public void setTab(Table tab) {
		this.tab = tab;
	}

	public boolean isFg() {
		return fg;
	}

	public void setFg(boolean fg) {
		this.fg = fg;
	}

	public boolean isFd() {
		return fd;
	}

	public void setFd(boolean fd) {
		this.fd = fd;
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
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSeuilFaim() {
		return seuilFaim;
	}

	public void setSeuilFaim(int seuilFaim) {
		this.seuilFaim = seuilFaim;
	}

	public int getDeltaFPenser() {
		return deltaFPenser;
	}

	public void setDeltaFPenser(int deltaFPenser) {
		this.deltaFPenser = deltaFPenser;
	}

	public int getDeltaFManger() {
		return deltaFManger;
	}

	public void setDeltaFManger(int deltaFManger) {
		this.deltaFManger = deltaFManger;
	}

	
	
	
	
}
