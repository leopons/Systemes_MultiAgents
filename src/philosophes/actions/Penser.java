package philosophes.actions;
import philosophes.*;
import plateforme.*;

public class Penser extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_train_penser) && (phil.getFaim()<phil.getSeuilFaim()) );
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.setPensee(phil.getPensee()+1);
		phil.setFaim(phil.getFaim()+phil.getDeltaFPenser());
		System.out.println("Le philosophe #" + phil.getID() + " pense.");
	}

}
