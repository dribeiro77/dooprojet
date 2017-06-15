package domaine;

import java.util.ArrayList;

public abstract class Plateau {
	private Case[] plateau;
	private int nbCases ;
	
	public Plateau(){
		
	}
	
	public void print(){
		for(int i=0; i<nbCases ; i++){
			this.afficher_voisins_console(plateau[i]);
		}
	}

	public Case[] getPlateau() {
		return plateau;
	}

	public void setPlateau(Case[] plateau) {
		this.plateau = plateau;
	}
	
	/**
	 * V�rification
	 */
	
	void afficher_voisins_console(Case n){
	    if (n.getDroite() != null){
	        System.out.println("Case "+n.getId()+" -> " + n.getDroite().getId() + "" );
	    }
	    if (n.getGauche() != null){
	    	System.out.println("Case "+n.getId()+" -> " + n.getGauche().getId() + "");
	    }
	    if (n.getBas_droite() != null){
	    	System.out.println("Case "+n.getId()+" -> " + n.getBas_droite().getId() + "");
	    }
	    if (n.getBas_gauche() != null){
	    	System.out.println("Case "+n.getId()+" -> " + n.getBas_gauche().getId() + "");
	    }
	    if (n.getHaut_droite() != null){
	    	System.out.println("Case "+n.getId()+" -> " + n.getHaut_droite().getId() + "");
	    }
	    if (n.getHaut_gauche() != null){
	    	System.out.println("Case "+n.getId()+" -> " + n.getHaut_gauche().getId() + "");
	    }
	}
	
	/**
	 * Retourne les cases voisines o� le pion peut se d�placer � partir de sa case
	 * @param n
	 * @return
	 */
	public ArrayList<Case> deplacements_simples(Case n){
		
		ArrayList<Case> res = new ArrayList();

	    //mouvements � droite
	   
		if (n.getDroite() != null){
	        if (n.getDroite().getPion() == null){
	            res.add(n.getDroite());
	        }
	    }

	    //mouvements � gauche
	    if (n.getGauche() != null){
	        if (n.getGauche().getPion() == null){
	            res.add(n.getGauche());
	        }
	    }

	    //mouvements haut droite
	    if (n.getHaut_droite() != null){
	        if (n.getHaut_droite().getPion() == null){
	            res.add(n.getHaut_droite());
	        }
	    }

	    //mouvements haut gauche
	    if (n.getHaut_gauche() != null){
	        if (n.getHaut_gauche().getPion() == null){
	            res.add(n.getHaut_gauche());
	        }
	    }

	    //mouvements bas droite
	    if (n.getBas_droite() != null){
	        if (n.getBas_droite().getPion() == null){
	            res.add(n.getBas_droite());
	        }
	    }

	    //mouvements bas gauche
	    if (n.getBas_gauche() != null){
	        if (n.getBas_gauche().getPion() == null){
	            res.add(n.getBas_gauche());
	        }
	    }

	    
	    return res;
	}
	
	/**
	 * verifie si 2 cases pass�es en param sont voisines 
	 * @param c1
	 * @param v2
	 * @return
	 */
	public boolean estVoisin(Case c1, Case v2){
		if(c1.getDroite()==v2){
			return true;
		}
		if(c1.getGauche()==v2){
			return true;
		}
		if(c1.getBas_droite()==v2){
			return true;
		}
		if(c1.getBas_gauche()==v2){
			return true;
		}
		if(c1.getHaut_droite()==v2){
			return true;
		}
		if(c1.getHaut_gauche()==v2){
			return true;
		}
		
		return false;
	}

	public int getNbCases() {
		return nbCases;
	}

	public void setNbCases(int nbCases) {
		this.nbCases = nbCases;
	}

	
}
