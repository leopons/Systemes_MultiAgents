package plateforme;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Environnement {

	// L'environnement est l'objet contenant notre système multi-agents.
	// La classe environnement sera donc instanciée une unique fois, puis
	// on utilisera la méthode run pour lancer le système.

	// L'objet regroupe les différents agents, et les données propres à l'environnement.

	protected ArrayList<Agent> agents;
	protected ArrayList<Donnee> donnees;

	protected FileWriter[] fw;
	protected FileWriter fwt;
	protected FileWriter fwp;

	public ArrayList<Donnee> getDonnees(){
		return donnees;
	}

	// On choisira un mode de fonctionnement synchrone pour nos systèmes.
	// Les différents agents effectuent donc leurs boucles procédurales tour à tour.
	// La fonction bilan est appelée après chaque tour des agents. Elle est là pour
	// afficher si besoin certaines valeurs représentatives du système.
	// (Il faudra l'implémenter dans le modèle, en fonction des données à afficher)

	public void run() throws IOException{
		
		// EXPORT DANS DES FICHIERS CSV
		fwt = new FileWriter("philosophes.csv");
		fwt.write("Tour, Faim, Pensee"+"\n");
		fw = new FileWriter[agents.size()];
		for (int i = 0; i < agents.size(); i++){
			fw[i] = new FileWriter("philosophes"+i+".csv");
			fw[i].write("Tour, Faim, Pensee"+"\n");
		}
		
		fwp = new FileWriter("philosophes_all.csv");
		fwp.write("Tour,");
		for (int i = 0; i < agents.size(); i++){
			fwp.write("Faim"+i+","+"Pensee"+i+",");
		}
		fwp.write("\n");
		
		int tour = 0;
		while (tour<1000) {
			for (Agent ag : agents){
				ag.boucle_procedurale();
			}
			this.bilan();
			tour++;
		}
		for (int j = 0; j < agents.size(); j++){
			fw[j].close();
		}
		fwt.close();
	}

	public abstract void bilan() throws IOException;


	
	// Un agent peut envoyer des messages aux autres agents.
	// Pour cela, il en informe l'environnement en appelant send(message), 
	// et l'environnement rajoute le message dans la BAL du destinataire.
	
	public void send(Message m){
		agents.get(m.getDestinataireID()).BAL.add(m);
	}
	
}
