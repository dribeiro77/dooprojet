package controller;

import domaine.Joueur;
import domaine.Partie;
import domaine.PlateauDamesChinoises;

public class ChoixPartieController {
	private Partie partie;
	
	public ChoixPartieController(){
		partie=new Partie();
	}
	
	/**
	 * ajoute un joueur à la partie
	 * @param pseudo
	 * @return
	 */
	public boolean ajouteJoueurDames(String pseudo){
		if(pseudo=="" || pseudo==null){
			return false;
		}
		else if (partie.getJoueurs().size() < 4){
			partie.addJouer(new Joueur(pseudo));
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean ajouteJoueurAbalone(String pseudo){
		if(pseudo=="" || pseudo==null){
			return false;
		}
		else if (partie.getJoueurs().size() < 2){
			partie.addJouer(new Joueur(pseudo));
			return true;
		}
		else {
			return false;
		}
	}
		
	/**
	 * ajoute le nombre de couleurs par joueur
	 * @param nbr
	 * @return
	 */
	public boolean choixCouleurParJoueur(int nbr){

		if (partie.getJoueurs().size() == 4){
			if (nbr != 1){
				return false;
			}
			else{
				partie.setCouleurParJoueur(nbr);
			}
		}
		if (partie.getJoueurs().size() == 3){
			if (nbr > 2 || nbr < 1){
				return false;
			}
			else{
				partie.setCouleurParJoueur(nbr);
			}
		}
		if (partie.getJoueurs().size() == 2 || partie.getJoueurs().size() == 1 ){
			if (nbr > 3 || nbr < 1){
				return false;
			}
			else{
				partie.setCouleurParJoueur(nbr);
			}
		}
		
		return false;
		
	}
		
	/**
	 * choisi le jeu
	 * @param str
	 */
	public void choixJeu(String str){
		partie.setJeu(str);
	}
	
	/**
	 * vérifie si la partie peut être lancée, crée le plateau
	 * @return
	 */
	public boolean lancePartie(){
		if (partie.getJeu()!=null){
			if (partie.getJeu().equalsIgnoreCase("Dames Chinoises")){
				partie.setPlateau(new PlateauDamesChinoises());
			}
			
			return true;
		}
		else return false;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	
}
