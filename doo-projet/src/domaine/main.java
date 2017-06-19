package domaine;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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
		
		//ChoixPartieUI start= new ChoixPartieUI();
		PlateauAbalone p = new PlateauAbalone(5);
		p.printPlateau();
		
		p.ajout_pions_bas_classique();
		p.ajout_pions_haut_classique();
		p.printPlateau();
		
		ArrayList<Case> selection = new ArrayList();
		selection.add(p.getPlateau()[45]);
		selection.add(p.getPlateau()[46]);
		selection.add(p.getPlateau()[47]);
		
		p.deplacement(selection, "HD");
		
		selection.removeAll(selection);
		selection.add(p.getPlateau()[38]);
		selection.add(p.getPlateau()[39]);
		
		
		
	
		ArrayList<Case> liste = p.deplacements_multiples_possibles(selection);
		for(int i = 0; i < liste.size(); i++)

		      System.out.println(liste.get(i).getId());
		
		
	}
}
