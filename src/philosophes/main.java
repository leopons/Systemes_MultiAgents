package philosophes;

public class main {

	public static void main(String[] args) {
		
		Table tab = new Table(8, 10, 50, 5, -2, 1); 	// effectif, seuilFaim, seuilFamine, deltaPenser, deltaManger, deltaFaim
		tab.run();

	}

}
