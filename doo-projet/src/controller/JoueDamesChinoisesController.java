package controller;

import java.awt.Color;
import java.util.ArrayList;

import domaine.Case;
import domaine.Partie;
import domaine.PlateauDamesChinoises;

public class JoueDamesChinoisesController {
	private String Couleurdesjoueurs[];
	private Partie partie;
	
	public JoueDamesChinoisesController(Partie part){
		partie=part;
		init_partie();
		init_couleursDesJoueurs();
	}
	
	public void init_couleursDesJoueurs(){
		if(partie.getJoueurs().size()==1){
			Couleurdesjoueurs = new String[1];
			Couleurdesjoueurs[0]="BLUE";
		}
		else if(partie.getJoueurs().size()==2){
			if (partie.getCouleurParJoueur()==1){
				Couleurdesjoueurs = new String[2];
				Couleurdesjoueurs[0]="BLUE";
				Couleurdesjoueurs[1]="RED";
			}
			else if(partie.getCouleurParJoueur()==2){
				Couleurdesjoueurs = new String[2];
				Couleurdesjoueurs[0]="BLUE MAGENTA";
				Couleurdesjoueurs[1]="RED YELLOW";
			}
			else if(partie.getCouleurParJoueur()==3){
				Couleurdesjoueurs = new String[2];
				Couleurdesjoueurs[0]="BLUE MAGENTA BLACK";
				Couleurdesjoueurs[1]="RED YELLOW GREEN";
			}	
		}
		
		else if(partie.getJoueurs().size()==3){
			if (partie.getCouleurParJoueur()==1){
				Couleurdesjoueurs = new String[3];
				Couleurdesjoueurs[0]="BLUE";
				Couleurdesjoueurs[1]="RED";
				Couleurdesjoueurs[2]="BLACK";
			}
			else if(partie.getCouleurParJoueur()==2){
				Couleurdesjoueurs = new String[3];
				Couleurdesjoueurs[0]="BLUE MAGENTA";
				Couleurdesjoueurs[1]="RED YELLOW";
				Couleurdesjoueurs[2]="BLACK GREEN";
			}	
		}
		else {
				Couleurdesjoueurs = new String[4];
				Couleurdesjoueurs[0]="BLUE";
				Couleurdesjoueurs[1]="RED";
				Couleurdesjoueurs[2]="BLACK";	
				Couleurdesjoueurs[3]="GREEN";	
		}
	}
	
	
	public String[] getCouleurdesjoueurs() {
		return Couleurdesjoueurs;
	}

	public void setCouleurdesjoueurs(String[] couleurdesjoueurs) {
		Couleurdesjoueurs = couleurdesjoueurs;
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
	 * Effectue le d�placement simple d'un pion entre deux cases
	 * @param avant
	 * @param apres
	 */
	public void deplacementSimple(Case avant, Case apres){
		if (avant!=apres){
		apres.setPion(avant.getPion());
		avant.setPion(null);
		}
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
		ArrayList<Case> list1 = partie.getPlateau().deplacements_simples_possibles(n);
		list1.addAll(((PlateauDamesChinoises)partie.getPlateau()).sauts_disponibles(n));
		return list1;
		
	}
	
	public void sumScore(int i,int sc){
		partie.getJoueurs().get(i).addScore(sc);
	}
	
	public ArrayList<Case> sauts_possibles(Case n){
		return ((PlateauDamesChinoises)partie.getPlateau()).sauts_disponibles(n);
	}
	
	
	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}


	/**
	 * V�rifie si la partie est finie
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

	public void IA(){
		ArrayList<Case> cases_Dispo = new ArrayList();
		for (int i = 0; i < partie.getPlateau().getPlateau().length; i++) {
			if(partie.getPlateau().getPlateau()[i].getPion()!=null && partie.getPlateau().getPlateau()[i].getPion().getCouleur()==Color.RED){
				if(sauts_possibles(partie.getPlateau().getPlateau()[i]).size() > 1){
					cases_Dispo.add(partie.getPlateau().getPlateau()[i]);
				}
			}
		}
		
		//si la case a des sauts
		if (!cases_Dispo.isEmpty()){
			for (int i = 0; i < cases_Dispo.size(); i++) {
				ArrayList<Case> dest = sauts_possibles(cases_Dispo.get(i));
				for (int j = 0; j < dest.size(); j++) {
					//si double saut
					if(sauts_possibles(dest.get(j)).size()>1){
						if(dest.get(0)!=cases_Dispo.get(i)){
							dest.get(0).setPion(cases_Dispo.get(i).getPion());
							cases_Dispo.get(i).setPion(null);
							return;
						}
						else{
							dest.get(1).setPion(cases_Dispo.get(i).getPion());
							cases_Dispo.get(i).setPion(null);
							return;
						}
					}
					//sinon saut normal
					if (dest.get(j).getId()>cases_Dispo.get(i).getId()){
						sautePion(cases_Dispo.get(i), dest.get(j));
						return;
					}
				
				}
			}
		}
		
		else{
			cases_Dispo = new ArrayList();
			for (int i = 0; i < partie.getPlateau().getPlateau().length; i++) {
				if(partie.getPlateau().getPlateau()[i].getPion()!=null && partie.getPlateau().getPlateau()[i].getPion().getCouleur()==Color.RED){
					cases_Dispo=partie.getPlateau().deplacements_simples_possibles(partie.getPlateau().getPlateau()[i]);
					for (int j = 0; j < cases_Dispo.size(); j++) {
						if(partie.getPlateau().getPlateau()[i].getId()<cases_Dispo.get(j).getId()){
							deplacementSimple(partie.getPlateau().getPlateau()[i], cases_Dispo.get(j));
							return;
						}
					}
				}
			}
		}
	}
	
	public void choixJeu(String str){
		partie.setJeu(str);
	}
}
