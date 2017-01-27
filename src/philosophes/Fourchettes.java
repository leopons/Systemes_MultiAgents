package philosophes;
import plateforme.*;

public class Fourchettes extends Donnee {
	private boolean disponibles[];
	
	// Vérifie la disponibilité de la fourchette d'indice i
	
	public boolean getDispo(int i){
		return disponibles[i];
	}
	
	// Rend la fourchette d'indice i disponible
	
	public void setDispo(int i, boolean b){
		disponibles[i] = b;
	}
	
	// CONSTRUCTEUR
	// Crée le tableau de booléens des disponibilités (toutes disponbiles au départ)
	
	public Fourchettes(int effectif){
		boolean disponibles[] = new boolean[effectif];
		for (int i = 0; i<effectif; i++){
			disponibles[i] = true;
		}
		this.disponibles = disponibles;
	}
	
}
