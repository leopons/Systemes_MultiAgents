package philosophes;
import plateforme.*;

public class Fourchettes extends Donnee {
	private boolean disponibles[];
	
	public boolean getDispo(int i){
		return disponibles[i];
	}
	
	public void setDispo(int i, boolean b){
		disponibles[i] = b;
	}
	
	public Fourchettes(int effectif){
		boolean disponibles[] = new boolean[effectif];
		for (int i = 0; i<effectif; i++){
			disponibles[i] = true;
		}
		this.disponibles = disponibles;
	}
	
}
