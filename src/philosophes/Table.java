package philosophes;
import java.util.ArrayList;

import plateforme.*;

public class Table extends Environnement {

	protected int effectif;
	protected int seuilFaim;
	protected int deltaFPenser;
	protected int deltaFManger;
	
	public Table(int effectif, int seuilFaim, int deltaFPenser, int deltaFManger){
		this.effectif = effectif;
		this.seuilFaim = seuilFaim;
		this.deltaFPenser = deltaFPenser;
		this.deltaFManger = deltaFManger;
		ArrayList<Agent> listeAgents = new ArrayList<Agent>();
		for (int i = 0; i < effectif; i++){
			listeAgents.add(new Philosophe(this, seuilFaim, deltaFPenser, deltaFManger, i));
		}
		this.agents = listeAgents;
		ArrayList<Donnee> listeDonnees = new ArrayList<Donnee>();
		listeDonnees.add(new Fourchettes(effectif));
		this.donnees = listeDonnees;
	}

	
	public int getEffectif(){
		return effectif;
	}
	
}
