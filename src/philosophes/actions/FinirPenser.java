package philosophes.actions;
import philosophes.*;
import plateforme.*;

public class FinirPenser extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_train_penser) 
				&& (phil.getFaim() >= phil.getSeuilFaim()) );
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.setEtat(Etat.en_attente_fourchettes);
		System.out.println("Le philosophe #" + phil.getID() + " passe en attente des fourchettes.");
	}

}
