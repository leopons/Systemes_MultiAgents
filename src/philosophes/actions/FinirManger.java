package philosophes.actions;
import philosophes.*;
import plateforme.*;

// Action d'un philosophe ayant fini de manger (seuil de faim dépassé, pose les fourchettes)

public class FinirManger extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ( (phil.getEtat() == Etat.en_train_manger) 
				&& ((phil.getFaim() <= 0) || (phil.contenuMess().equals("Help"))) );
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		if (phil.getFaim() < phil.getSeuilFaim()){
			phil.setEtat(Etat.en_train_penser);
			System.out.println("Le philosophe #" + phil.getID() + " a fini de manger.");
		}
		else {
			phil.setEtat(Etat.en_attente_fourchettes);
			System.out.println("Le philosophe #" + phil.getID() + " pose ses fourchettes pour aider son voisin.");
		}
		phil.poserFourchettes();
		System.out.println("Faim : " + phil.getFaim());
	}

}