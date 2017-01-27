package philosophes;
import java.util.ArrayList;
import plateforme.*;
import philosophes.actions.*;


public class Philosophe extends Agent {

	protected Table tab;
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
		this.BAL = new ArrayList<Message>();
		
		ArrayList<Action> listeActions = new ArrayList<Action>();
		// LISTE DES ACTIONS POSSIBLES POUR CET AGENT :
		listeActions.add(new Penser());
		listeActions.add(new FinirPenser());
		listeActions.add(new PrendreFourchettes());
		listeActions.add(new Manger());
		listeActions.add(new FinirManger());
		listeActions.add(new Faim());
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
	
	// Retourne le contenu du premier message de la boite aux lettres.
	// En effet, au vu des messages de notre système, on considère que le philosophe ne lit qu'un seul message,
	// le dernier qu'il a reçu, et qu'il n'a pas besoin de connaitre le destinataire de celui-ci.
	public String contenuMess(){
		if (BAL.isEmpty()) {
			return "";
		}
		else {
			return BAL.get(BAL.size()-1).getContenu();
		}
	}
	
	// Envoie un message aux deux voisins leur demandant leurs fourchettes (cas de Famine)
	
	public void demanderVoisinsFourchettes(){
		Message mess1 = new Message((this.ID+1) % (this.tab.getEffectif()), this.ID, "Help");
		tab.send(mess1);
		
		// je rajoute l'effectif total à ID-1 car dans le cas ID=0 java n'aime pas faire du modulo
		// sur des nombres négatifs. (et ça ne change rien au résultat)
		Message mess2 = new Message((this.ID-1+this.tab.getEffectif()) % (this.tab.getEffectif()), this.ID, "Help");
		tab.send(mess2);
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

	// Incrémente le compteur de famine
	
	public void incrementFamine(){
		this.famine ++;
		tab.setCompteurFamine(tab.getCompteurFamine()+1);
	}
	
	// Incrémente le compteur de pensée
	
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
	
	// Vérifie le compteur de pensée du philosophe
	
	public int getPensee() {
		return pensee;
	}
	
	// Vérifie l'ID du philosophe
	
	public int getID() {
		return ID;
	}

	// Récupère le seuil de faim du système
	
	public int getSeuilFaim() {
		return tab.getSeuilFaim();
	}
	
	// Récupère le seuil de famine du système
	
	public int getSeuilFamine() {
		return tab.getSeuilFamine();
	}
	
	// Récupère le delta faim en train de penser

	public int getDeltaFPenser() {
		return tab.getDeltaFPenser();
	}
	
	// Récupère le delta faim en train de manger

	public int getDeltaFManger() {
		return tab.getDeltaFManger();
	}
	
	// Récupère le delta faim en famine
	
	public int getDeltaFFaim() {
		return tab.getDeltaFFaim();
	}
	
	
}
