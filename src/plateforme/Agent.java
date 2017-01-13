package plateforme;

import java.util.ArrayList;

public class Agent {
	
	protected Environnement env;
	protected ArrayList<Action> actions;

	public void percevoir(){
	}
	public Action deliberer(){
		for (Action a : actions){
			if (a.check_conditions(this)){
				return a;
			}
		}
		return null;
	}
	public void agir(Action a){
		a.effectuer(this);
	}
	
	public void boucle_procedurale(){
		this.percevoir();
		this.agir(this.deliberer());
	}
	
	
	
}
