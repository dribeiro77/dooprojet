
package domaine;
import java.awt.Color;
import java.lang.Math;
import java.util.ArrayList;

/**
 * Created by Radu et karim on 09/06/17.
 */

public class PlateauAbalone extends Plateau {
    private int baseHex; // Nombre de cases d'un côté du plateau hexagonal
    private int nbCases; // Nombre total de cases du plateau

    /* GETTERS */
    
    
  
    public int getBaseHex() {
        return baseHex;
    }

   

    /* SETTERS */
    public void setBaseHex(int baseHex) {
        this.baseHex = baseHex;
    }
    
    /* CONSTUCTEURS */
    public PlateauAbalone(int baseHex) {
      
    	super();
        this.baseHex = baseHex; // Habituellement : 5
        calculerNbCases();
    	this.setNbCases(this.calculerNbCases());
    	this.setPlateau(initPlateau());
    	
    }
    
    /* AUTRES METHODES */
    private int calculerNbCases() {
        nbCases = 0;
        for (int i = 0; i < baseHex - 1; i++) {
            nbCases += 2 * (baseHex + i);
        }
        nbCases += 2 * (baseHex - 1) + 1;
        
        return nbCases;
    }

    int zigzag(int entier) { // zigzag(n) = somme(k = 1..n, (-1)^ent((k - 1)/4))
        // Produit une suite du type : 0, 1, 2, 3, 4, 3, 2, 1
        int res = 0;
        for (int i = 1; i <= entier; i++) {
            res += Math.pow(-1, Math.floor((i - 1)/4));
        }
        return res;
    }

    
    public Case[] initPlateau() {
        Case[] plateau = new Case[getNbCases()];
        
        for (int i = 0; i < nbCases; i++) { // Impossible de combiner les deux boucles
            plateau[i] = new Case(i);
        }

        int j = 0, // Correspond à la ligne du plateau. Artifice utile pour son initialisation
            t = 0; // Variable tampon
        for (int i = 0; i < nbCases; i++) {
            if (i != t + baseHex + zigzag(j) - 1) { // Toutes les cases, sauf celles en fin de ligne ...
                if (i + 1 < nbCases) { plateau[i].setDroite(plateau[i + 1]); } // ... ont une voisine à droite
            }

            if (i != t + baseHex + zigzag(j)) { // Toutes cles cases, sauf celles en début de ligne ...
                if (i - 1 >= 0) { plateau[i].setGauche(plateau[i - 1]); } // ... ont une voisine à gauche
            }

            // HAUT GAUCHE
            if (j > 0) {
                if (j < baseHex) {
                    if (i != t + baseHex + zigzag(j)) { // Sauf les cases de la moitié haute, en début de ligne
                        plateau[i].setHaut_gauche(plateau[i - baseHex - zigzag(j)]);
                    }
                }
                else {
                    plateau[i].setHaut_gauche(plateau[i - baseHex - zigzag(j)]);
                }
            }

            if (i == t + baseHex + zigzag(j)) { // La case courante est-elle en "début de ligne" ?
                t = i; // Correspond donc à : u_(n+1) = u_n + baseHex + zigzag(n)
                j++; // On incrémente l'indice de la "ligne" courante
            }

            // HAUT DROITE
            if (j > 0) {
                if (j < baseHex) {
                    if (i != t + baseHex + zigzag(j) - 1) { // Sauf les cases de la moitié haute, en fin de ligne

                        plateau[i].setHaut_droite(plateau[i - baseHex - zigzag(j) + 1]);
                    }
                }
                else {
                    plateau[i].setHaut_droite(plateau[i - baseHex - zigzag(j)]);
                }
            }

            /* BAS */
            if (j < baseHex - 1) {
                plateau[i].setBas_droite(plateau[i + baseHex + zigzag(j) + 1]);
                plateau[i].setBas_gauche(plateau[i + baseHex + zigzag(j)]);
            }
            else
            {
                if (i != t + baseHex + zigzag(j) - 1) { // ... sauf celles de la moitié basse, en fin de ligne
                    if (j<baseHex-1) plateau[i].setBas_droite(plateau[i + baseHex + zigzag(j)+1]);
                    else if (i + baseHex + zigzag(j) < nbCases)
                        plateau[i].setBas_droite(plateau[i + baseHex + zigzag(j)]);
                }
                if (j<baseHex-1) plateau[i].setBas_gauche(plateau[i + baseHex + zigzag(j)]);
                else
                    // Si cette ligne est décommentée, seules les cases de 0 à 25 seront initalisées
                    if (i + baseHex + zigzag(j) - 1 < nbCases)
                    {
                        plateau[i].setBas_gauche(plateau[i + baseHex + zigzag(j) - 1]);
                    }

                
                if (plateau[i].getBas_gauche()!= null ) {
                    if (plateau[i].getBas_gauche().getId() == t + baseHex + zigzag(j) - 1) {
                        plateau[i].setBas_gauche(null) ;
                    }
                }
            }

           // if (plateau[i].getHaut_droite() != null) { System.out.println("    " + i + ".HD : " + plateau[i].getHaut_droite().getId()); }
           // if (plateau[i].getDroite() != null)      { System.out.println("    " + i + ".D :  " + plateau[i].getDroite().getId()); }
           // if (plateau[i].getBas_droite() != null)  { System.out.println("    " + i + ".BD : " + plateau[i].getBas_droite().getId()); }
           // if (plateau[i].getBas_gauche() != null)  { System.out.println("    " + i + ".BG : " + plateau[i].getBas_gauche().getId()); }
           //if (plateau[i].getGauche() != null)      { System.out.println("    " + i + ".G :  " + plateau[i].getGauche().getId()); }
           //if (plateau[i].getHaut_gauche() != null) { System.out.println("    " + i + ".HG : " + plateau[i].getHaut_gauche().getId()); }
        }
        plateau[35].setHaut_gauche(plateau[26]);
        return plateau ;
    }
    
    /**
	 * Ajout des pions en haut du plateau
	 */
    
    public void ajout_pions_haut_classique(){
	    
	    for(int i=0; i<=15 ; i++){
	    	if (i != 11 && i !=12)
	    	this.getPlateau()[i].setPion(new Pion(Color.RED));
	    }
	}

    public void ajout_pions_haut_original(){

        for(int i=0; i<17 ; i++){
            if (i != 1 && i !=1 && i!=5 && i!=10 && i!=11)
            this.getPlateau()[i].setPion(new Pion(Color.RED));

        }
        this.getPlateau()[22].setPion(new Pion(Color.BLACK));
        this.getPlateau()[21].setPion(new Pion(Color.BLACK));

    }

    /**
    * Ajout des pions en bas du plateau
    */

    public void ajout_pions_bas_classique(){
   
   for(int i=60; i>= 45 ; i--){
	   if(i!= 48 && i!=49)
   	this.getPlateau()[i].setPion(new Pion(Color.BLACK));
   }
}


    public void ajout_pions_bas_original(){
	
	for(int i=60; i> 43 ; i--){
		   if(i!= 60 && i!=50 && i!=56 && i!=55 )
	   	this.getPlateau()[i].setPion(new Pion(Color.BLACK));
	   }
	this.getPlateau()[38].setPion(new Pion(Color.BLACK));
	this.getPlateau()[39].setPion(new Pion(Color.BLACK));
	
}

    /**
    * Vérification du placement des pions
    */

    public void lister_pions()
    {
        for(int i=0 ; i< nbCases ; i++)
        {	if (this.getPlateau()[i].getPion()!=null )
            System.out.println(i);
        }

	}


	public void printPlateau() {
        int i = 0, j = 0, t = 0;
        Case c;
        for (int k = 0; k < zigzag(j + 4); k++) {
            System.out.print("  ");
        }
        do {
            if (i == t + baseHex + zigzag(j)) {
                t = i;
                j++;
                System.out.print("\n");
                for (int k = 0; k < zigzag(j + 4); k++) {
                    System.out.print("  ");
                }
            }
            //c = getPlateau()[i];
            if (getPlateau()[i].getPion() != null) {
                System.out.print("  x ");
            }
            else {
                System.out.print("  . ");
            }

            i++;
        }while(i < nbCases);

    }


    /* DEPLACEMENTS */

        public void deplacementSimple(Case source, String direction) { // Un mouvement simple change le pion de place
            Pion pion = source.getPion();
            Case destination = source;
            switch (direction)
            {
                case "HD" :
                    if (source.getHaut_droite().getPion() == null)
                        //source.getHaut_droite().setPion(pion);
                        destination = source.getHaut_droite();
                    break;
                case "D" :
                    if (source.getDroite().getPion() == null)
                        //source.getDroite().setPion(pion);
                        destination = source.getDroite();
                    break;
                case "BD" :
                    if (source.getBas_droite().getPion() == null)
                        //source.getBas_droite().setPion(pion);
                        destination = source.getBas_droite();
                    break;
                case "BG" :
                    if (source.getBas_gauche().getPion() == null)
                        //source.getBas_gauche().setPion(pion);
                        destination = source.getBas_gauche();
                    break;
                case "G" :
                    if (source.getGauche().getPion() == null)
                        //source.getGauche().setPion(pion);
                        destination = source.getGauche();
                    break;
                case "HG" :
                    if (source.getHaut_gauche().getPion() == null)
                        //source.getHaut_gauche().setPion(pion);
                        destination = source.getHaut_gauche();
                    break;
            }
            changePlacePion(source, destination);
        }

    public void changePlacePion(Case source, Case destination) {
        if (destination != source) {
            destination.setPion(source.getPion());
            source.setPion(null);
        }
    }

    public void deplacementLineaire(ArrayList<Case> selection, String direction) {
    // On suppose que la liste des pions sélectionnés est triée par indice de case croissant
        int taille = selection.size(); // Longueur de la liste des pions sélectionnés
        Case source = null, destination = null;
        switch (direction)
        {
            case "HD" : // L'indice décroît
                // Le dernier pion change de place en HD du premier
                //changePlacePion(selection.get(taille - 1), selection.get(0).getHaut_droite());
                source = selection.get(taille - 1);
                destination = selection.get(0).getHaut_droite();
                break;
            case "D" : // L'indice croît
                // Le premier pion change de place à D du dernier
                //changePlacePion(selection.get(0), selection.get(taille - 1).getDroite());
                source = selection.get(0);
                destination = selection.get(taille - 1).getDroite();
                break;
            case "BD" : // L'indice croît
                // Le premier pion change de place en BD du dernier
                //changePlacePion(selection.get(0), selection.get(taille - 1).getBas_droite());
                source = selection.get(0);
                destination = selection.get(taille - 1).getBas_droite();
                break;

            case "BG" : // L'indice croît
                // Le premier pion change de place en BG du dernier
                //changePlacePion(selection.get(0), selection.get(taille - 1).getBas_gauche());
                source = selection.get(0);
                destination = selection.get(taille - 1).getBas_gauche();
                break;

            case "G" : // L'indice décroît
                // Le dernier pion change de place à G du premier
                //changePlacePion(selection.get(taille - 1), selection.get(0).getGauche());
                source = selection.get(taille - 1);
                destination = selection.get(0).getGauche();
                break;

            case "HG" : // L'indice décroît
                // Le dernier pion change de place en HG du premier
                //changePlacePion(selection.get(taille - 1), selection.get(0).getHaut_gauche());
                source = selection.get(taille - 1);
                destination = selection.get(0).getHaut_gauche();
                break;
        }
        changePlacePion(source, destination);
        System.out.println("\n" + source.getId() + " -> " + destination.getId());
    }

    public void deplacementLateral(ArrayList<Case> selection, String direction) {
    // On suppose que la liste des pions sélectionnés est triée par indice de case croissant
    }
}