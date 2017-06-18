package domaine;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.JoueDamesChinoisesController;
import vue.ChoixPartieUI;
import vue.JoueDamesChinoisesUI;

class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		Partie part = new Partie();
		part.setPlateau(new PlateauDamesChinoises());
		ArrayList<Joueur> joueurs = new ArrayList();
		joueurs.add(new Joueur("michel"));
		joueurs.add(new Joueur("patoche"));
		joueurs.add(new Joueur("phil"));
		part.setJoueurs(joueurs);
		part.setCouleurParJoueur(2);
		
		JoueDamesChinoisesController contr = new JoueDamesChinoisesController(part);
		contr.init_partie();
		
		JoueDamesChinoisesUI joui = new JoueDamesChinoisesUI(contr);
		**/
		
		ChoixPartieUI start= new ChoixPartieUI();

		
	}

}
