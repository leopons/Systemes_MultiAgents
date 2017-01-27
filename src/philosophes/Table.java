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
		
		// Création de la liste des philosophes (agents) présents autour de la table (environnement)
		
		ArrayList<Agent> listeAgents = new ArrayList<Agent>();
		for (int i = 0; i < effectif; i++){
			listeAgents.add(new Philosophe(this, i));
		}
		this.agents = listeAgents;
		
		ArrayList<Donnee> listeDonnees = new ArrayList<Donnee>();
		listeDonnees.add(new Fourchettes(effectif));
		this.donnees = listeDonnees;
		
	}

	// Affiche la famine et la pensée dans la console, sera appelée à chaque tour
	
	public void bilan(){
		System.out.println("BILAN : Famine Totale = " + compteurFamine + ", Pensée Totale = " + compteurPensee);
	}
	
	// Récupère le seuil de faim
	
	public int getSeuilFaim() {
		return seuilFaim;
	}


	// Récupère le delta faim en train de penser
	
	public int getDeltaFPenser() {
		return deltaFPenser;
	}

	// Récupère le delta faim en train de manger

	public int getDeltaFManger() {
		return deltaFManger;
	}

	// Récupère le delta faim en famine
	
	public int getDeltaFFamine() {
		return deltaFFamine;
	}

	// Récupère le nombre de philosophes

	public int getEffectif(){
		return effectif;
	}
	
	// Récupère la famine

	public int getCompteurFamine() {
		return compteurFamine;
	}
	
	// Modifie la famine

	public void setCompteurFamine(int compteurFamine) {
		this.compteurFamine = compteurFamine;
	}
	
	// Récupère la pensée

	public int getCompteurPensee() {
		return compteurPensee;
	}

	// Modifie la pensée
	
	public void setCompteurPensee(int compteurPensee) {
		this.compteurPensee = compteurPensee;
	}

	
}
