package domaine;

import java.awt.Color;

public class Pion {
	private Color couleur;
	
	public Pion(Color c){
		couleur=c;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	
}
