package controller;

import domaine.Case;
import domaine.Partie;
import domaine.PlateauDamesChinoises;

public class JoueDamesChinoisesController {
	private Partie partie;
	
	public JoueDamesChinoisesController(Partie part){
		partie=part;
	}
	
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
	
	public void deplacementSimple(Case avant, Case apres){
		apres.setPion(avant.getPion());
		avant.setPion(null);
	}
	
	public void mangePion(Case saute, Case mangee){
		
		if(saute.getBas_droite()==mangee){
			mangee.setPion(null);
			mangee.getBas_droite().setPion(saute.getPion());
			saute.setPion(null);
		}
		else if(saute.getBas_gauche()==mangee){
			mangee.setPion(null);
			mangee.getBas_gauche().setPion(saute.getPion());
			saute.setPion(null);
		}
		else if(saute.getHaut_droite()==mangee){
			mangee.setPion(null);
			mangee.getHaut_droite().setPion(saute.getPion());
			saute.setPion(null);
		}
		else if(saute.getHaut_gauche()==mangee){
			mangee.setPion(null);
			mangee.getHaut_gauche().setPion(saute.getPion());
			saute.setPion(null);
		}
		else if(saute.getDroite()==mangee){
			mangee.setPion(null);
			mangee.getDroite().setPion(saute.getPion());
			saute.setPion(null);
		}
		else if(saute.getGauche()==mangee){
			mangee.setPion(null);
			mangee.getGauche().setPion(saute.getPion());
			saute.setPion(null);
		}
	}
	
}
