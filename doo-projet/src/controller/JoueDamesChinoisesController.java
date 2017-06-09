package controller;

import java.util.ArrayList;

import domaine.Case;
import domaine.Partie;
import domaine.PlateauDamesChinoises;

public class JoueDamesChinoisesController {
	private Partie partie;
	
	public JoueDamesChinoisesController(Partie part){
		partie=part;
		init_partie();
	}
	
	/**
	 * Ajoute les pions en fonction de la partie choisie
	 */
	public void init_partie(){
		switch (partie.getJoueurs().size()) {
			case 1:
				((PlateauDamesChinoises)partie.getPlateau()).init_triangleBas();
				((PlateauDamesChinoises)partie.getPlateau()).init_triangleHaut();
				break;
			case 2:
				if(partie.getCouleurParJoueur()==1){
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleBas();
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleHaut();
					break;
				}
				if(partie.getCouleurParJoueur()==2){
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleBas();
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleHaut();
					((PlateauDamesChinoises)partie.getPlateau()).init_GaucheBas();
					((PlateauDamesChinoises)partie.getPlateau()).init_DoiteHaut();
					break;
				}
				if(partie.getCouleurParJoueur()==3){
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleBas();
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleHaut();
					((PlateauDamesChinoises)partie.getPlateau()).init_GaucheBas();
					((PlateauDamesChinoises)partie.getPlateau()).init_GaucheHaut();
					((PlateauDamesChinoises)partie.getPlateau()).init_DoiteHaut();
					((PlateauDamesChinoises)partie.getPlateau()).init_DroiteBas();
					break;
				}
					break;
			case 3:
				if(partie.getCouleurParJoueur()==1){
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleBas();
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleHaut();
					((PlateauDamesChinoises)partie.getPlateau()).init_DroiteBas();
					
					break;
				}
				if(partie.getCouleurParJoueur()==2){
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleBas();
					((PlateauDamesChinoises)partie.getPlateau()).init_triangleHaut();
					((PlateauDamesChinoises)partie.getPlateau()).init_GaucheBas();
					((PlateauDamesChinoises)partie.getPlateau()).init_GaucheHaut();
					((PlateauDamesChinoises)partie.getPlateau()).init_DoiteHaut();
					((PlateauDamesChinoises)partie.getPlateau()).init_DroiteBas();
					break;
				}
				break;
			case 4:
				((PlateauDamesChinoises)partie.getPlateau()).init_triangleBas();
				((PlateauDamesChinoises)partie.getPlateau()).init_triangleHaut();
				((PlateauDamesChinoises)partie.getPlateau()).init_DroiteBas();
				((PlateauDamesChinoises)partie.getPlateau()).init_GaucheHaut();				
		}
	}
	
	/**
	 * Effectue le déplacement simple d'un pion entre deux cases
	 * @param avant
	 * @param apres
	 */
	public void deplacementSimple(Case avant, Case apres){
		apres.setPion(avant.getPion());
		avant.setPion(null);
	}
	
	/**
	 * Un Pion saute par dessus un autre 
	 * @param saute
	 * @param mangee
	 */
	public void sautePion(Case saute, Case aterit){
			aterit.setPion(saute.getPion());
			saute.setPion(null);
		
	}
	
	/**
	 * Liste de tous les mouvements possibles
	 * @param n
	 * @return
	 */
	public ArrayList<Case> mouvements_possibles(Case n){
		ArrayList<Case> list1 = partie.getPlateau().deplacements_simples(n);
		list1.addAll(((PlateauDamesChinoises)partie.getPlateau()).sauts_disponibles(n));
		return list1;
	}
	
	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	/**
	 * Vérifie si la partie est finie
	 * 
	 * @return
	 */
	public boolean partie_finie(){
		switch (partie.getJoueurs().size()) {
		case 1:
			return ((PlateauDamesChinoises)partie.getPlateau()).triangleBasConquis() 
					|| ((PlateauDamesChinoises)partie.getPlateau()).triangleHautConquis();
		case 2:
			if(partie.getCouleurParJoueur()==1){
				return ((PlateauDamesChinoises)partie.getPlateau()).triangleBasConquis() 
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleHautConquis();
			}
			if(partie.getCouleurParJoueur()==2){
				return ((PlateauDamesChinoises)partie.getPlateau()).triangleBasConquis() 
				|| ((PlateauDamesChinoises)partie.getPlateau()).triangleHautConquis()
				|| ((PlateauDamesChinoises)partie.getPlateau()).triangleGaucheBasConquis()
				|| ((PlateauDamesChinoises)partie.getPlateau()).triangleDoiteHautConquis();
			}
			if(partie.getCouleurParJoueur()==3){
				return ((PlateauDamesChinoises)partie.getPlateau()).triangleBasConquis() 
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleHautConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleGaucheBasConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleDoiteHautConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleDoiteBasConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleGaucheHautConquis();
			}
				break;
		case 3:
			if(partie.getCouleurParJoueur()==1){
				return ((PlateauDamesChinoises)partie.getPlateau()).triangleBasConquis() 
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleHautConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleDoiteBasConquis();
				
			}
			if(partie.getCouleurParJoueur()==2){
				return ((PlateauDamesChinoises)partie.getPlateau()).triangleBasConquis() 
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleHautConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleGaucheBasConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleDoiteHautConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleDoiteBasConquis()
						|| ((PlateauDamesChinoises)partie.getPlateau()).triangleGaucheHautConquis();
			}
			break;
		case 4:
			return ((PlateauDamesChinoises)partie.getPlateau()).triangleBasConquis() 
					|| ((PlateauDamesChinoises)partie.getPlateau()).triangleHautConquis()
					|| ((PlateauDamesChinoises)partie.getPlateau()).triangleDoiteBasConquis()
					|| ((PlateauDamesChinoises)partie.getPlateau()).triangleGaucheHautConquis();
			
		
				
	}
		return false;
	}
	
}
