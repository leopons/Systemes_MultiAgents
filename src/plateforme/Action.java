package plateforme;

public abstract class Action {
	
	public abstract boolean check_conditions(Agent agent);
	public abstract void effectuer(Agent agent);

}
