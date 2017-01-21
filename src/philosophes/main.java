package philosophes;

public class main {

	public static void main(String[] args) {
		
		Table tab = new Table(6, 5, 5, -2, 1); 	// effectif, seuilFaim, deltaPenser, deltaManger, deltaFamine
		tab.run();

	}

}
