package philosophes;
import java.util.ArrayList;
import plateforme.*;
import philosophes.actions.*;


public class Philosophe extends Agent {

	protected boolean fg;
	protected boolean fd;
	protected Etat etat;
	protected int faim;
	protected int pensee;
	protected int ID;
	protected int seuilFaim;
	protected int deltaFPenser;
	protected int deltaFManger;

	public Philosophe(Environnement env, int seuilFaim, int deltaFPenser, int deltaFManger, int ID){
		this.env = env;
		this.ID = ID;
		this.fg = true;
		this.fd = true;
		this.etat = Etat.en_train_penser;
		this.faim = -10;
		this.pensee = 0;
		this.seuilFaim = seuilFaim;
		this.deltaFPenser = deltaFPenser;
		this.deltaFManger = deltaFManger;
		
		ArrayList<Action> listeActions = new ArrayList<Action>();
		// LISTE DES ACTIONS POSSIBLES POUR CET AGENT :
		listeActions.add(new Penser());
		listeActions.add(new FinirPenser());
		//
		this.actions = listeActions;
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
