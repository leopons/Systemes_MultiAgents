package plateforme;

public class Message {

	// Les messages sont créés par les agents au cours de certaines actions (dépend du système), 
	// puis envoyés à leur destinataire via l'environnement (méthode send).
	
	// Leur contenu est codé en String (et non en type énuméré) car on peut trouver différents
	// contenus suivant les systèmes.
	
	// Les messages sont reçus dans la BAL du destinataire, et celui ci les traite au niveau du percevoir
	// (vérification des conditions pour une action)
	// Il supprimme tous les messages qu'il a reçu à la fin de son tour.
	
	private int destinataireID;
	private int emmetteurID;
	private String contenu;
	
	public Message(int d, int e, String c){
		this.destinataireID = d;
		this.emmetteurID = e;
		this.contenu = c;
	}
	
	public String getContenu() {
		return contenu;
	}
	public int getDestinataireID() {
		return destinataireID;
	}
	public int getEmmetteurID() {
		return emmetteurID;
	}
	

	
}
