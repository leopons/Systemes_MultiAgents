package philosophes.actions;
import philosophes.*;
import plateforme.*;

// Action d'un philosophe se mettant en famine (ne pense pas et ne mange pas)


public class Famine extends Action {

	public boolean check_conditions(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONDITIONS :
		return ((phil.getEtat() == Etat.en_attente_fourchettes) 
				&& !(phil.regarderDroite() && phil.regarderGauche())
				&& !(phil.aLesFourchettes()) );
	}

	public void effectuer(Agent agent) {
		Philosophe phil = (Philosophe) agent;
		// CONSEQUENCES :
		phil.setFaim(phil.getFaim()+phil.getDeltaFFamine());
		phil.setFamine(phil.getFamine()+1);
		System.out.println("Le philosophe #" + phil.getID() + " est en famine.");
		System.out.println("Faim : " + phil.getFaim());
	}

}
