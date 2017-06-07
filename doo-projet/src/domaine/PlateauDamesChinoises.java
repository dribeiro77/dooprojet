package domaine;

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
		
		for(i=119 ; i< 119+2 ; i++){
			plateau[i].setHaut_droite(plateau[i-2]); 
			plateau[i].setHaut_gauche(plateau[i-3]); 
		if(i < 119 ) {
			plateau[i].setBas_droite(plateau[i+2]);
			plateau[i].setDroite(plateau[i+1]);
		}
		if(i < 120 ) {
			plateau[i].setBas_gauche(plateau[i+1]);
			plateau[i].setGauche(plateau[i-1]);
		}
		}
		plateau[121].setHaut_droite(plateau[120]); 
		plateau[121].setHaut_gauche(plateau[119]);
		
		return plateau;
				
	}
	
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
	
	
}
