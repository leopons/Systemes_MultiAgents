
/*
package philosophes.actions;
import philosophes.*;
import plateforme.*;

public class PrendreFourchette extends Action {

	public boolean check_conditions(Agent agent, Environnement env) {
		Philosophe phil = (Philosophe) agent;
		Table tab = (Table) env;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_attente_fourchettes) && (phil.getFaim()<tab.getSeuilFaim()) );
	}

	public void effectuer(Agent agent, Environnement env) {
		Philosophe phil = (Philosophe) agent;
		Table tab = (Table) env;
		// CONSEQUENCES :
		phil.setPensee(phil.getPensee()+1);
		phil.setFaim(phil.getFaim()+tab.getDeltaFPenser());
		System.out.println("Le philosophe #" + phil.getID() + " pense.");
	}

}

*/