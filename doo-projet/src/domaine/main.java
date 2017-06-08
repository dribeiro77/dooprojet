package domaine;

import java.util.ArrayList;

import controller.JoueDamesChinoisesController;
import vue.JoueDamesChinoisesUI;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partie part = new Partie();
		part.setPlateau(new PlateauDamesChinoises());
		ArrayList<Joueur> joueurs = new ArrayList();
		joueurs.add(new Joueur("michel"));
		part.setJoueurs(joueurs);
		((PlateauDamesChinoises)part.getPlateau()).init_triangleBas();
		((PlateauDamesChinoises)part.getPlateau()).init_triangleHaut();
		
		JoueDamesChinoisesController contr = new JoueDamesChinoisesController(part);
		
		JoueDamesChinoisesUI joui = new JoueDamesChinoisesUI(contr);
		
	}

}
