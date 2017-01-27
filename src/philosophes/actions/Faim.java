package philosophes.actions;
import philosophes.*;
import plateforme.*;

// Action d'un philosophe se mettant en famine (ne pense pas et ne mange pas)


public class Faim extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_attente_fourchettes) 
				&& !(phil.regarderDroite() && phil.regarderGauche())
				&& !(phil.aLesFourchettes()) )
				&& (phil.getFaim()<phil.getSeuilFamine());
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.setFaim(phil.getFaim()+phil.getDeltaFFaim());
		System.out.println("Le philosophe #" + phil.getID() + " a faim");
		System.out.println("Faim : " + phil.getFaim());
	}

}
