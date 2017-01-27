package plateforme;

public abstract class Action {
	
	// Une action est constituée de deux méthodes : une qui vérifie ses conditions d'éxecution,
	// Et une autre qui effectue l'action proprement dit.
	// Le détail de ces méthodes est implémenté selon le système et selon l'action.
	
	public abstract boolean check_conditions(Agent agent);
	public abstract void effectuer(Agent agent);

}
