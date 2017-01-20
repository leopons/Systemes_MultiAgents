package philosophes.actions;
import philosophes.*;
import plateforme.*;

public class CommencerManger extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_attente_fourchettes) 
				&& phil.isFg()
				&& phil.isFd());
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.setEtat(Etat.en_train_manger);
		System.out.println("Le philosophe #" + phil.getID() + " commence à manger.");
		System.out.println("Faim : " + phil.getFaim());
	}

}
