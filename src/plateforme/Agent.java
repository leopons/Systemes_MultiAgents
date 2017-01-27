package plateforme;

import java.util.ArrayList;

public abstract class Agent {
	
	// Un agent est un des objets agissants de notre système.
	// Il est lié à un environnement et à une liste d'actions qu'il peut effectuer.
	
	protected Environnement env;
	protected ArrayList<Action> actions;

	// A chaque fois qu'un agent est appelé, c'est au travers de sa boucle procédurale.
	// Il va donc agir, sur la base de sa délibération. (La partie percevoir est incluse
	// dans la fonction de délibération, au niveai de la vérification des conditions).
	
	public void boucle_procedurale(){
		this.agir(this.deliberer());
	}
	
	// Dans deliberer(), l'agent parcourt la liste des actions qu'il peut effectuer, vérifie les conditions
	// de ces actions en observant l'environnement, et choisit celle qu'il peut effectuer.
	public Action deliberer(){
		for (Action a : actions){
			if (a.check_conditions(this)){
				return a;
			}
		}
		return null;
	}
	
	// Dans agir(), l'agent effectue une action (qui aura été choisie par deliberer())
	public void agir(Action a){
		a.effectuer(this);
	}
	
}
