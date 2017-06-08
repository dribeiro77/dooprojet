package domaine;

import java.awt.Color;
import java.util.ArrayList;

public class PlateauDamesChinoises extends Plateau{
	
	public PlateauDamesChinoises(){
		super(); 		
		this.setPlateau(init_plateau());
	}
	
	/**
	 * Initialization du plateau, la construction du graphe.
	 */
	public Case[] init_plateau(){ 
		Case[] plateau=new Case[122];
		
		for(int i=0; i<=121 ; i++){
			plateau[i]=new Case(i);
		}
		
		   /////////////////////////////////  TRIANGLE SOMMET ///////////////////////////////////
		
	    //N1
	    plateau[1].setBas_gauche(plateau[2]); plateau[1].setBas_droite(plateau[3]);
	    
	    //N2
	    plateau[2].setDroite(plateau[3]); plateau[2].setBas_gauche(plateau[4]); plateau[2].setBas_droite(plateau[5]); plateau[2].setHaut_droite(plateau[1]);
	    
	    plateau[3].setGauche(plateau[2]); plateau[3].setBas_gauche(plateau[5]); plateau[3].setBas_droite(plateau[6]); plateau[3].setHaut_gauche(plateau[1]);
	    
	    //N3
	    plateau[4].setDroite(plateau[5]); plateau[4].setBas_gauche(plateau[7]); plateau[4].setBas_droite(plateau[8]); plateau[4].setHaut_droite(plateau[2]);
	    
	    plateau[5].setGauche(plateau[4]); plateau[5].setDroite(plateau[6]); plateau[5].setHaut_gauche(plateau[2]); plateau[5].setHaut_droite(plateau[3]); 
	    plateau[5].setBas_gauche(plateau[8]); plateau[5].setBas_droite(plateau[9]);
	    
	    plateau[6].setHaut_gauche(plateau[3]); plateau[6].setGauche(plateau[5]); plateau[6].setBas_gauche(plateau[9]); 
	    plateau[6].setBas_droite(plateau[10]);
	    
	    
	    ////////////////////////////////  CORPS ETOILE ///////////////////////////////////////
	    
	    //ETAGE 0
	    int i=0;
	    for(i=7 ; i< 7+4 ; i++){
	        plateau[i].setBas_droite(plateau[i+9]); 
	        plateau[i].setBas_gauche(plateau[i+8]); 
	        if(i != 10) {
	            plateau[i].setHaut_droite(plateau[i-3]); 
	            plateau[i].setDroite(plateau[i+1]); 
	        }
	        if(i != 7) {
	            plateau[i].setHaut_gauche(plateau[i-4]); 
	            plateau[i].setGauche(plateau[i-1]); 
	        }
	    }
	    
	    
	    // ETAGE 1
	    for(i=11 ; i< 11+13 ; i++){
	        if(est_bordure_d(i,1)==0) {
	            plateau[i].setDroite(plateau[i+1]); 
	            plateau[i].setBas_droite(plateau[i+13]);
	        }
	        if (est_bordure_g(i,1)==0) {
	        	plateau[i].setGauche(plateau[i-1]);
	        	plateau[i].setBas_gauche(plateau[i+12]); 
	        }
	    }
	    
	    plateau[15].setHaut_droite(plateau[7]); 
	    plateau[16].setHaut_gauche(plateau[7]); plateau[16].setHaut_droite(plateau[8]); 
	    plateau[17].setHaut_gauche(plateau[8]); plateau[17].setHaut_droite(plateau[9]); 
	    plateau[18].setHaut_gauche(plateau[9]); plateau[18].setHaut_droite(plateau[10]); 
	    plateau[19].setHaut_gauche(plateau[10]);

	    // ETAGE 2
	    for(i=24 ; i< 24+12 ; i++){
	        if(est_bordure_d(i,2)==0) {
	        	plateau[i].setDroite(plateau[i+1]); 
	        	plateau[i].setBas_droite(plateau[i+12]);
	        }
	        if (est_bordure_g(i,2)==0) {
	        	plateau[i].setGauche(plateau[i-1]);
	        	plateau[i].setBas_gauche(plateau[i+11]); 
	        }
	        plateau[i].setHaut_gauche(plateau[i-13]); 
	        plateau[i].setHaut_droite(plateau[i-12]);
	    }

	    // ETAGE 3
	    for(i=36 ; i< 36+11 ; i++){
	        if(est_bordure_d(i,3)==0) {
	        	plateau[i].setDroite(plateau[i+1]); 
	        	plateau[i].setBas_droite(plateau[i+11]); 
	        }

	        if (est_bordure_g(i,3)==0) {
	        	plateau[i].setGauche(plateau[i-1]);
	        	plateau[i].setBas_gauche(plateau[i+10]);
	        }
	        plateau[i].setHaut_droite(plateau[i-11]); 
	        plateau[i].setHaut_gauche(plateau[i-12]);
	    }

	    // ETAGE 4
	    for(i=47 ; i< 47+10 ; i++){
	        if(est_bordure_d(i,4)==0) {
	        	plateau[i].setDroite(plateau[i+1]); 
	        	plateau[i].setBas_droite(plateau[i+10]); 
	        }

	        if (est_bordure_g(i,4)==0) {
	        	plateau[i].setGauche(plateau[i-1]);
	        	plateau[i].setBas_gauche(plateau[i+9]); 
	        }
	        plateau[i].setHaut_droite(plateau[i-10]); 
	        plateau[i].setHaut_gauche(plateau[i-11]); 
	    }

	    // ETAGE 5
	    for(i=57 ; i< 57+9 ; i++){
	        if(est_bordure_d(i,5)==0) {
	        	plateau[i].setDroite(plateau[i+1]); 
	        }

	        if (est_bordure_g(i,5)==0) {
	        	plateau[i].setGauche(plateau[i-1]); 
	        }
	        plateau[i].setHaut_droite(plateau[i-9]);
	        plateau[i].setHaut_gauche(plateau[i-10]); 
	        plateau[i].setBas_droite(plateau[i+10]);
	        plateau[i].setBas_gauche(plateau[i+9]);
	    }


	    /////////////////////////////// MILIEU CORPS /////////////////////////////////
	    // ETAGE 6
	    for(i=66 ; i< 66+10 ; i++){
	    	if(est_bordure_d(i,6)==0) {
	    		plateau[i].setDroite(plateau[i+1]); 
	    		plateau[i].setHaut_droite(plateau[i-9]); 
	    	}

	    	if (est_bordure_g(i,6)==0) {
	    		plateau[i].setGauche(plateau[i-1]); 
	    		plateau[i].setHaut_gauche(plateau[i-10]); 
	    	}
	    	plateau[i].setBas_droite(plateau[i+11]); 
	    	plateau[i].setBas_gauche(plateau[i+10]); 
	    }

		// ETAGE 7
		for(i=76 ; i< 76+11 ; i++){
		if(est_bordure_d(i,7)==0) {
			plateau[i].setDroite(plateau[i+1]); 
			plateau[i].setHaut_droite(plateau[i-10]); 
		}
		
		if (est_bordure_g(i,7)==0) {
			plateau[i].setGauche(plateau[i-1]);
			plateau[i].setHaut_gauche(plateau[i-11]); 
		}
		plateau[i].setBas_droite(plateau[i+12]); 
		plateau[i].setBas_gauche(plateau[i+11]); 
		}
		
		// ETAGE 8
		for(i=87 ; i< 87+12 ; i++) {
		if (est_bordure_d(i, 8)==0) {
			plateau[i].setDroite(plateau[i+1]); 
			plateau[i].setHaut_droite(plateau[i-11]); 
		}
		if (est_bordure_g(i,8)==0) {
			plateau[i].setGauche(plateau[i-1]); 
			plateau[i].setHaut_gauche(plateau[i-12]);
		}
		plateau[i].setBas_droite(plateau[i+13]);
		plateau[i].setBas_gauche(plateau[i+12]); 
		}
		
		// ETAGE 9
		for(i=99 ; i< 99+13 ; i++){
		if(est_bordure_d(i,9)==0) {
			plateau[i].setDroite(plateau[i+1]); 
			plateau[i].setHaut_droite(plateau[i-12]);
		}
		
		if (est_bordure_g(i,9)==0) {
			plateau[i].setGauche(plateau[i-1]); 
			plateau[i].setHaut_gauche(plateau[i-13]); 
		}
	
		}
		
		plateau[103].setBas_droite(plateau[112]);
		plateau[104].setBas_gauche(plateau[112]); plateau[104].setBas_droite(plateau[113]); 
		plateau[105].setBas_gauche(plateau[113]); plateau[105].setBas_droite(plateau[114]); 
		plateau[106].setBas_gauche(plateau[114]); plateau[106].setBas_droite(plateau[115]); 
		plateau[107].setBas_gauche(plateau[115]); 
		
		
		/////////////////////////////////  TRIANGLE BASE ///////////////////////////////////
		
		//ETAGE 10
		for(i=112 ; i< 112+4 ; i++){
			plateau[i].setHaut_droite(plateau[i-8]);
			plateau[i].setHaut_gauche(plateau[i-9]);
		if(i != 115) {
			plateau[i].setBas_droite(plateau[i+4]); 
			plateau[i].setDroite(plateau[i+1]); 
		}
		if(i != 112) {
			plateau[i].setBas_gauche(plateau[i+3]); 
			plateau[i].setGauche(plateau[i-1]); 
		}
		}
		
		for(i=116 ; i< 116+3 ; i++){
			plateau[i].setHaut_droite(plateau[i-3]);
			plateau[i].setHaut_gauche(plateau[i-4]);
		if(i != 118) {
			plateau[i].setBas_droite(plateau[i+3]);
			plateau[i].setDroite(plateau[i+1]);
		}
		if(i != 116) {
			plateau[i].setBas_gauche(plateau[i+2]);
			plateau[i].setGauche(plateau[i-1]);
		}
		}
		
		for(i=119 ; i<119+2 ; i++){
			plateau[i].setHaut_droite(plateau[i-2]); 
			plateau[i].setHaut_gauche(plateau[i-3]); 
		if(i  != 120 ) {
			plateau[i].setBas_droite(plateau[i+2]);
			plateau[i].setDroite(plateau[i+1]);
		}
		else if(i != 119 ) {
			plateau[i].setBas_gauche(plateau[i+1]);
			plateau[i].setGauche(plateau[i-1]);
		}
		}
		plateau[121].setHaut_droite(plateau[120]); 
		plateau[121].setHaut_gauche(plateau[119]);
		
		return plateau;
				
	}
	
	/**
	 * Verifie si la Case est ou pas au bord droit du graph
	 * @param pos
	 * @param etage
	 * @return
	 */
	int est_bordure_d(int pos, int etage){
	    switch(etage){
	        case 0:
	            if(pos == 10) return 1;
	            break;
	        case 1:

	            if(pos == 23) return 1;
	            break;
	        case 2:

	            if(pos == 35) return 1;
	            break;
	        case 3:
	            if(pos == 46) return 1;
	            break;
	        case 4:
	            if(pos == 56) return 1;
	            break;
	        case 5:
	            if(pos == 65) return 1;
	            break;
	        case 6:
	            if(pos == 75) return 1;
	            break;
	        case 7:
	            if(pos == 86) return 1;
	            break;
	        case 8:
	            if(pos == 98) return 1;
	            break;
	        case 9:
	            if(pos == 111) return 1;
	            break;
	        case 10:
	            if(pos == 115) return 1;
	            break;
	    }

	    return 0;
	}
	
	/**
	 * Verifie si la Case est ou pas au bord gauche du graphe
	 * @param pos
	 * @param etage
	 * @return
	 */
	int est_bordure_g(int pos, int etage){
	    switch(etage){
	        case 0:
	            if(pos == 7) return 1;
	            break;
	        case 1:

	            if(pos == 11) return 1;
	            break;
	        case 2:

	            if(pos == 24) return 1;
	            break;
	        case 3:
	            if(pos == 36) return 1;
	            break;
	        case 4:
	            if(pos == 47) return 1;
	            break;
	        case 5:
	            if(pos == 57) return 1;
	            break;
	        case 6:
	            if(pos == 66) return 1;
	            break;
	        case 7:
	            if(pos == 77) return 1;
	            break;
	        case 8:
	            if(pos == 87) return 1;
	            break;
	        case 9:
	            if(pos == 99) return 1;
	            break;
	        case 10:
	            if(pos == 112) return 1;
	            break;
	    }

	    return 0;
	}
	
	/**
	 * Donne la liste de Cases où le pion peut sauter à partir de sa case
	 * @param n
	 * @return
	 */
	public ArrayList<Case> sauts_disponibles(Case n){
	    
		ArrayList<Case> res = new ArrayList();

	    //saut à droite
	    if (n.getDroite() != null && n.getDroite().getPion()!=null){
	        if (n.getDroite().getDroite() != null && n.getDroite().getDroite().getPion() == null){
	            res.add(n.getDroite().getDroite());
	        }
	    }

	    //saut à gauche
	    if (n.getGauche() != null  && n.getGauche().getPion()!=null){
	        if (n.getGauche().getGauche() != null && n.getGauche().getGauche().getPion() == null){
	            res.add(n.getGauche().getGauche());
	        }
	    }

	    //saut haut droite
	    if (n.getHaut_droite() != null  && n.getHaut_droite().getPion()!=null){
	        if (n.getHaut_droite().getHaut_droite() != null && n.getHaut_droite().getHaut_droite().getPion() == null){
	            res.add(n.getHaut_droite().getHaut_droite());
	        }
	    }

	    //saut haut gauche
	    if (n.getHaut_gauche() != null  && n.getHaut_gauche().getPion()!=null){
	        if (n.getHaut_gauche().getHaut_gauche() != null && n.getHaut_gauche().getHaut_gauche().getPion() == null){
	            res.add(n.getHaut_gauche().getHaut_gauche());
	        }
	    }

	    //saut bas droite
	    if (n.getBas_droite() != null  && n.getBas_droite().getPion()!=null){
	        if (n.getBas_droite().getBas_droite() != null && n.getBas_droite().getBas_droite().getPion() == null){
	            res.add(n.getBas_droite().getBas_droite());
	        }
	    }

	    //saut bas gauche
	    if (n.getBas_gauche() != null  && n.getBas_gauche().getPion()!=null){
	        if (n.getBas_gauche().getBas_gauche() != null && n.getBas_gauche().getBas_gauche().getPion() == null){
	            res.add(n.getBas_gauche().getBas_gauche());
	        }
	    }

	    return res;

	}
	
	/**
	 * Ajoute des pions au triangle du haut
	 */
	public void init_triangleHaut(){
		    
		for(int i=1; i<=10 ; i++){
			this.getPlateau()[i].setPion(new Pion(Color.RED));
		}	
	}
	
	/**
	 * Ajoute des pions au triangle du bas
	 */
	public void init_triangleBas(){
	    
	    for(int i=112; i<=121 ; i++){
	    	this.getPlateau()[i].setPion(new Pion(Color.BLUE));
	    }
	}
	
	/**
	 * Ajoute des pions au triangle droit en haut
	 */
	public void init_DoiteHaut(){
		this.getPlateau()[56].setPion(new Pion(Color.YELLOW));
		this.getPlateau()[45].setPion(new Pion(Color.YELLOW));this.getPlateau()[46].setPion(new Pion(Color.YELLOW));
		this.getPlateau()[33].setPion(new Pion(Color.YELLOW));this.getPlateau()[34].setPion(new Pion(Color.YELLOW));
		this.getPlateau()[35].setPion(new Pion(Color.YELLOW));
	    for(int i=20; i<=23; i++){
	    	this.getPlateau()[i].setPion(new Pion(Color.YELLOW));
	    }
	}
	
	/**
	 * Ajoute des pions au triangle droit en bas
	 */
	public void init_DroiteBas(){
		this.getPlateau()[75].setPion(new Pion(Color.BLACK));
		this.getPlateau()[85].setPion(new Pion(Color.BLACK));this.getPlateau()[86].setPion(new Pion(Color.BLACK));
		this.getPlateau()[96].setPion(new Pion(Color.BLACK));this.getPlateau()[97].setPion(new Pion(Color.BLACK));
		this.getPlateau()[98].setPion(new Pion(Color.BLACK));
	    for(int i=108; i<=111; i++){
	    	this.getPlateau()[i].setPion(new Pion(Color.BLACK));
	    }

	}
	
	/**
	 * Ajoute des pions au triangle gauche en haut
	 */
	public void init_GaucheHaut(){
	    
		this.getPlateau()[47].setPion(new Pion(Color.GREEN));
		this.getPlateau()[36].setPion(new Pion(Color.GREEN));this.getPlateau()[37].setPion(new Pion(Color.GREEN));
		this.getPlateau()[24].setPion(new Pion(Color.GREEN));this.getPlateau()[25].setPion(new Pion(Color.GREEN));
		this.getPlateau()[26].setPion(new Pion(Color.GREEN));
	    for(int i=11; i<=14; i++){
	    	this.getPlateau()[i].setPion(new Pion(Color.GREEN));
	    }
	}
	
	/**
	 * Ajoute des pions au triangle gauche en bas
	 */
	public void init_GaucheBas(){
		this.getPlateau()[66].setPion(new Pion(Color.MAGENTA));
		this.getPlateau()[76].setPion(new Pion(Color.MAGENTA));this.getPlateau()[77].setPion(new Pion(Color.MAGENTA));
		this.getPlateau()[87].setPion(new Pion(Color.MAGENTA));this.getPlateau()[88].setPion(new Pion(Color.MAGENTA));
		this.getPlateau()[89].setPion(new Pion(Color.MAGENTA));
	    for(int i=99; i<=102; i++){
	    	this.getPlateau()[i].setPion(new Pion(Color.MAGENTA));
	    }
	}
	
	
	public boolean triangleHautConquis(){
		Color couleur_presente=Color.WHITE;
		int v= 0;
		for(int i=1; i<=10 ; i++){
			if (getPlateau()[i].getPion()!=null && getPlateau()[i].getPion().getCouleur()!=Color.RED){
				if (v==0){
					couleur_presente=getPlateau()[i].getPion().getCouleur();
					v++;
				}
				else if(couleur_presente != getPlateau()[i].getPion().getCouleur()){
					return false;
				}
				
			}
			else{
				return false;
			}
		}	
		if (v>0){
			return true;
		}
		return false;
	}
	
	public boolean triangleBasConquis(){
		Color couleur_presente=Color.WHITE;
		int v= 0;
		for(int i=112; i<=121 ; i++){
			if (getPlateau()[i].getPion()!=null && getPlateau()[i].getPion().getCouleur()!=Color.BLUE){
				if (v==0){
					couleur_presente=getPlateau()[i].getPion().getCouleur();
					v++;
				}
				else if(couleur_presente != getPlateau()[i].getPion().getCouleur()){
					return false;
				}
				
			}
			else{
				return false;
			}
		}	
		if (v>0){
			return true;
		}
		return false;
	}
	
	public boolean triangleDoiteHautConquis(){
		
		if (this.getPlateau()[56].getPion()== null || this.getPlateau()[45].getPion()== null ||
				this.getPlateau()[46].getPion()== null || this.getPlateau()[33].getPion()== null ||
				this.getPlateau()[34].getPion()== null || this.getPlateau()[35].getPion()== null ||
				this.getPlateau()[20].getPion()== null || this.getPlateau()[21].getPion()== null ||
				this.getPlateau()[22].getPion()== null || this.getPlateau()[23].getPion()== null)
		{
			return false;
		}
		
		
		else if (this.getPlateau()[56].getPion().getCouleur()!=Color.YELLOW) {
			Color couleur_presente=(this.getPlateau()[56].getPion().getCouleur());
			
			if (this.getPlateau()[45].getPion().getCouleur()== couleur_presente ||
					this.getPlateau()[46].getPion().getCouleur()== couleur_presente || 
					this.getPlateau()[33].getPion().getCouleur()== couleur_presente ||
					this.getPlateau()[34].getPion().getCouleur()== couleur_presente || 
					this.getPlateau()[35].getPion().getCouleur()== couleur_presente ||
					this.getPlateau()[20].getPion().getCouleur()== couleur_presente || 
					this.getPlateau()[21].getPion().getCouleur()== couleur_presente ||
					this.getPlateau()[22].getPion().getCouleur()== couleur_presente || 
					this.getPlateau()[23].getPion().getCouleur()== couleur_presente)
			{	
				return true;	
			}
			
			return false;
		}
		
		else{
			return false;
		}
	}
	
	
public boolean triangleDoiteBasConquis(){
		
		if (this.getPlateau()[75].getPion()== null || this.getPlateau()[85].getPion()== null ||
				this.getPlateau()[86].getPion()== null || this.getPlateau()[96].getPion()== null ||
				this.getPlateau()[97].getPion()== null || this.getPlateau()[98].getPion()== null ||
				this.getPlateau()[108].getPion()== null || this.getPlateau()[109].getPion()== null ||
				this.getPlateau()[110].getPion()== null || this.getPlateau()[111].getPion()== null)
		{
			return false;
		}
		
		
		else if (this.getPlateau()[75].getPion().getCouleur()!=Color.BLACK) {
			Color couleur_presente=(this.getPlateau()[56].getPion().getCouleur());
			
			if (this.getPlateau()[85].getPion().getCouleur()== couleur_presente ||
					this.getPlateau()[86].getPion().getCouleur()== couleur_presente || 
					this.getPlateau()[96].getPion().getCouleur()== couleur_presente ||
					this.getPlateau()[97].getPion().getCouleur()== couleur_presente || 
					this.getPlateau()[98].getPion().getCouleur()== couleur_presente ||
					this.getPlateau()[108].getPion().getCouleur()== couleur_presente || 
					this.getPlateau()[109].getPion().getCouleur()== couleur_presente ||
					this.getPlateau()[110].getPion().getCouleur()== couleur_presente || 
					this.getPlateau()[111].getPion().getCouleur()== couleur_presente)
			{	
				return true;	
			}
			
			return false;
		}
		
		else{
			return false;
		}
	}


public boolean triangleGaucheHautConquis(){
	
	if (this.getPlateau()[47].getPion()== null || this.getPlateau()[36].getPion()== null ||
			this.getPlateau()[37].getPion()== null || this.getPlateau()[24].getPion()== null ||
			this.getPlateau()[25].getPion()== null || this.getPlateau()[26].getPion()== null ||
			this.getPlateau()[11].getPion()== null || this.getPlateau()[12].getPion()== null ||
			this.getPlateau()[13].getPion()== null || this.getPlateau()[14].getPion()== null)
	{
		return false;
	}
	
	
	else if (this.getPlateau()[47].getPion().getCouleur()!=Color.GREEN) {
		Color couleur_presente=(this.getPlateau()[56].getPion().getCouleur());
		
		if (this.getPlateau()[36].getPion().getCouleur()== couleur_presente ||
				this.getPlateau()[37].getPion().getCouleur()== couleur_presente || 
				this.getPlateau()[24].getPion().getCouleur()== couleur_presente ||
				this.getPlateau()[25].getPion().getCouleur()== couleur_presente || 
				this.getPlateau()[26].getPion().getCouleur()== couleur_presente ||
				this.getPlateau()[11].getPion().getCouleur()== couleur_presente || 
				this.getPlateau()[12].getPion().getCouleur()== couleur_presente ||
				this.getPlateau()[13].getPion().getCouleur()== couleur_presente || 
				this.getPlateau()[14].getPion().getCouleur()== couleur_presente)
		{	
			return true;	
		}
		
		return false;
	}
	
	else{
		return false;
	}
}

public boolean triangleGaucheBasConquis(){
	
	if (this.getPlateau()[66].getPion()== null || this.getPlateau()[76].getPion()== null ||
			this.getPlateau()[77].getPion()== null || this.getPlateau()[87].getPion()== null ||
			this.getPlateau()[88].getPion()== null || this.getPlateau()[89].getPion()== null ||
			this.getPlateau()[99].getPion()== null || this.getPlateau()[100].getPion()== null ||
			this.getPlateau()[101].getPion()== null || this.getPlateau()[102].getPion()== null)
	{
		return false;
	}
	
	
	else if (this.getPlateau()[66].getPion().getCouleur()!=Color.MAGENTA) {
		Color couleur_presente=(this.getPlateau()[56].getPion().getCouleur());
		
		if (this.getPlateau()[76].getPion().getCouleur()== couleur_presente ||
				this.getPlateau()[77].getPion().getCouleur()== couleur_presente || 
				this.getPlateau()[87].getPion().getCouleur()== couleur_presente ||
				this.getPlateau()[88].getPion().getCouleur()== couleur_presente || 
				this.getPlateau()[89].getPion().getCouleur()== couleur_presente ||
				this.getPlateau()[99].getPion().getCouleur()== couleur_presente || 
				this.getPlateau()[100].getPion().getCouleur()== couleur_presente ||
				this.getPlateau()[101].getPion().getCouleur()== couleur_presente || 
				this.getPlateau()[102].getPion().getCouleur()== couleur_presente)
		{	
			return true;	
		}
		
		return false;
	}
	
	else{
		return false;
	}
}




}
