package plateforme;

import java.util.ArrayList;

public abstract class Environnement {

	// L'environnement est l'objet contenant notre système multi-agents.
	// La classe environnement sera donc instanciée une unique fois, puis
	// on utilisera la méthode run pour lancer le système.
	
	// L'objet regroupe les différents agents, et les données propres à l'environnement.
	
	protected ArrayList<Agent> agents;
	protected ArrayList<Donnee> donnees;
	
	public ArrayList<Donnee> getDonnees(){
		return donnees;
	}
	
	// On choisira un mode de fonctionnement synchrone pour nos systèmes.
	// Les différents agents effectuent donc leurs boucles procédurales tour à tour.
	// La fonction bilan est appelée après chaque tour des agents. Elle est là pour
	// afficher si besoin certaines valeurs représentatives du système.
	// (Il faudra l'implémenter dans le modèle, en fonction des données à afficher)
	
	public void run(){
		while (true) {
			for (Agent ag : agents){
				ag.boucle_procedurale();
			}
				this.bilan();
		}
	}
	
	public abstract void bilan();
	
	// Un agent peut envoyer des messages aux autres agents.
	// Pour cela, il en informe l'environnement en appelant send(message), 
	// et l'environnement rajoute le message dans la BAL du destinataire.
	
	public void send(Message m){
		agents.get(m.getDestinataireID()).BAL.add(m);
	}
	
}
