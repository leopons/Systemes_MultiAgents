package philosophes.actions;
import philosophes.*;
import plateforme.*;

// Action d'un philosophe ayant fini de manger (seuil de faim dépassé, pose les fourchettes)

public class FinirManger extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_train_manger) 
				&& (phil.getFaim() <= 0)
				);
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.setEtat(Etat.en_train_penser);
		phil.poserFourchettes();
		System.out.println("Le philosophe #" + phil.getID() + " a fini de manger.");
		System.out.println("Faim : " + phil.getFaim());
	}

}