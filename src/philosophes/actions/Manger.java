package philosophes.actions;
import philosophes.*;
import plateforme.*;

public class Manger extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_train_manger) 
				&& (phil.getFaim() > 0 ));
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.setFaim(phil.getFaim()+phil.getDeltaFManger());
		System.out.println("Le philosophe #" + phil.getID() + " mange.");
		System.out.println("Faim : " + phil.getFaim());
	}

}
