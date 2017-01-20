package philosophes.actions;
import philosophes.*;
import plateforme.*;

public class PrendreFourchettes extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_attente_fourchettes) 
				&& !(phil.isFd() || phil.isFg()) 
				&& (phil.regarderGauche()) 
				&& (phil.regarderDroite()));
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.prendreGauche();
		phil.prendreDroite();
		System.out.println("Le philosophe #" + phil.getID() + " prend les fourchettes.");
		System.out.println("Faim : " + phil.getFaim());
	}

}