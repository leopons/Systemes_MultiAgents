package philosophes.actions;
import philosophes.*;
import plateforme.*;

// Action d'un philosophe en train de penser

public class Penser extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_train_penser) 
				&& (phil.getFaim()<phil.getSeuilFaim()) );
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.incrementPensee();
		phil.setFaim(phil.getFaim()+phil.getDeltaFPenser());
		System.out.println("Le philosophe #" + phil.getID() + " pense.");
		System.out.println("Faim : " + phil.getFaim());
	}

}
