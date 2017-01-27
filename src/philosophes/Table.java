package philosophes;
import java.util.ArrayList;

import plateforme.*;

public class Table extends Environnement {

	protected int effectif;
	protected int seuilFaim;
	protected int deltaFPenser;
	protected int deltaFManger;
	protected int deltaFFamine;
	protected int compteurFamine;
	protected int compteurPensee;
	
	public Table(int effectif, int seuilFaim, int deltaFPenser, int deltaFManger, int deltaFFamine){
		
		this.effectif = effectif;
		this.seuilFaim = seuilFaim;
		this.deltaFPenser = deltaFPenser;
		this.deltaFManger = deltaFManger;
		this.deltaFFamine = deltaFFamine;
		
		ArrayList<Agent> listeAgents = new ArrayList<Agent>();
		for (int i = 0; i < effectif; i++){
			listeAgents.add(new Philosophe(this, i));
		}
		this.agents = listeAgents;
		
		ArrayList<Donnee> listeDonnees = new ArrayList<Donnee>();
		listeDonnees.add(new Fourchettes(effectif));
		this.donnees = listeDonnees;
		
	}

	public void bilan(){
		System.out.println("BILAN : Famine Totale = " + compteurFamine + ", Pensée Totale = " + compteurPensee);
	}
	
	public int getSeuilFaim() {
		return seuilFaim;
	}


	public int getDeltaFPenser() {
		return deltaFPenser;
	}


	public int getDeltaFManger() {
		return deltaFManger;
	}


	public int getDeltaFFamine() {
		return deltaFFamine;
	}


	public int getEffectif(){
		return effectif;
	}

	public int getCompteurFamine() {
		return compteurFamine;
	}

	public void setCompteurFamine(int compteurFamine) {
		this.compteurFamine = compteurFamine;
	}

	public int getCompteurPensee() {
		return compteurPensee;
	}

	public void setCompteurPensee(int compteurPensee) {
		this.compteurPensee = compteurPensee;
	}

	
}
