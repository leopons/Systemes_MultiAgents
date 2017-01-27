package philosophes;

import java.io.IOException;

public class main {

	protected static Table tab;

	public static void main(String[] args) throws IOException {


		tab = new Table(8, 10, 50, 5, -2, 1); 	// effectif, seuilFaim, seuilFamine, deltaPenser, deltaManger, deltaFamine

		tab.run();

	}
}
