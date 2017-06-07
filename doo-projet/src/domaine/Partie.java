package domaine;

import java.util.ArrayList;


public class Partie {
	
	private String jeu;
	private String mode;
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private Plateau plateau;
	

	public String getJeu() {
		return jeu;
	}

	public void setJeu(String jeu) {
		this.jeu = jeu;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	public void addJouer(Joueur j){
		joueurs.add(j);
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	
	
	
}
