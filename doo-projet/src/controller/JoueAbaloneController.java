package controller;

import java.util.ArrayList;

import domaine.Case;
import domaine.Partie;
import domaine.PlateauAbalone;
import domaine.PlateauDamesChinoises;

public class JoueAbaloneController {
	private Partie partie;
	
	public JoueAbaloneController(Partie part){
		partie=part;
		init_partie();
	}
	
	/**
	 * Ajoute les pions en fonction de la partie choisie
	 */
	public void init_partie() {

		if (partie.getMode() == "Classique") {
			((PlateauAbalone) partie.getPlateau()).ajout_pions_bas_classique();
			((PlateauAbalone) partie.getPlateau()).ajout_pions_haut_classique();
		}

		else if (partie.getMode() == "Version 2") {
			((PlateauAbalone) partie.getPlateau()).ajout_pions_bas_original();
			((PlateauAbalone) partie.getPlateau()).ajout_pions_haut_original();
		}
	}
	
	/**
	 * Effectue le d�placement simple d'un pion entre deux cases
	 * @param avant
	 * @param apres
	 */
	public void deplacementSimple(Case avant, Case apres){
		apres.setPion(avant.getPion());
		avant.setPion(null);
	}
	
	
	
	/**
	 * Liste de tous les mouvements possibles
	 * @param n
	 * @return
	 */
	
	public ArrayList<Case> mouvements_possibles(Case n){
		ArrayList<Case> list1 = partie.getPlateau().deplacements_simples_possibles(n);
		list1.addAll(((PlateauDamesChinoises)partie.getPlateau()).sauts_disponibles(n));
		return list1;
		
	}
	
	
	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}


	

	public void choixJeu(String str){
		partie.setJeu(str);
	}
}
