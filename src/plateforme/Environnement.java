package plateforme;

import java.util.ArrayList;

public class Environnement {

	protected ArrayList<Agent> agents;
	protected ArrayList<Donnee> donnees;
	
	public ArrayList<Donnee> getDonnees(){
		return donnees;
	}
	
	public void bilan(){}
	
	public void run(){
		while (true) {
			for (Agent ag : agents){
				ag.boucle_procedurale();
			}
				this.bilan();
		}
	}
	
}
