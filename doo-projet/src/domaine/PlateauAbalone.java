
package domaine;

import java.awt.*;
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


    boolean appartientTableau(int element, int[] tableau) { // Renvoie VRAI ssi element est dans tableau
        boolean res = false;
        int i = 0;
        while (i < tableau.length) {
            if (tableau[i] == element) {
                res = true;
                break;
            }
            i++;
        }
        return res;
    }

    public Case[] initPlateau() { // Initialise le graphe
        Case[] plateau = new Case[getNbCases()];

        for (int i = 0; i < nbCases; i++) { // Impossible de combiner les deux boucles
            plateau[i] = new Case(i);
        }

        int j = 0; // Correspond à la ligne du plateau. Artifice utile pour son initialisation
        int[] indicesFin = new int[2 * baseHex - 1]; // Indices de fin de ligne
        indicesFin[0] = baseHex - 1;
        for (int i = 1; i < indicesFin.length; i++) { // Définis par récurrence
            indicesFin[i] = baseHex + indicesFin[i - 1] + zigzag(++j);
        }

        j = 0;
        for (int i = 0; i < nbCases; i++) {
            // On exploite les symétries : Les cases voisines, selon une direction, forment des paires
            if (!appartientTableau(i, indicesFin)) { // Ailleurs qu'en fin de ligne, ...
                plateau[i].setDroite(plateau[i + 1]); // ... chque case a une voisine à droite ...
                plateau[i].getDroite().setGauche(plateau[i]); // ... et en est la voisine gauche
            }
            if (j > 0 ) { // Ailleurs que sur la première "ligne", presque chaque case a une voisine en haut à droite
                if (j < baseHex) {
                    if (!appartientTableau(i, indicesFin)) {
                        plateau[i].setHaut_droite(plateau[i - baseHex - zigzag(j - 1)]);
                    }
                }
                else {
                    plateau[i].setHaut_droite(plateau[i - baseHex - zigzag(j)]);
                }
            }
            if (plateau[i].getHaut_droite() != null) {
                plateau[i].getHaut_droite().setBas_gauche(plateau[i]);
            }
            if (j < 2 * (baseHex - 1)) {
                if (j < baseHex - 1) {
                    plateau[i].setBas_droite(plateau[i + baseHex + zigzag(j + 1)]);
                }
                else {
                    if (!appartientTableau(i, indicesFin)) {
                        plateau[i].setBas_droite(plateau[i + baseHex + zigzag(j)]);
                    }
                }
            }
            if (plateau[i].getBas_droite() != null) {
                plateau[i].getBas_droite().setHaut_gauche(plateau[i]);
            }

            if (appartientTableau(i, indicesFin)) { // Si on est en fin de "ligne", ...
                j++; // ... on passe à la "ligne" suivante
            }
        }
/*
        for (Case aCase : plateau) {
            System.out.print(aCase.getId() + " -> ");
            if (aCase.getHaut_droite() != null) { System.out.print("|HD :" + aCase.getHaut_droite().getId()); }
            if (aCase.getDroite() != null)      { System.out.print("|D :" + aCase.getDroite().getId()); }
            if (aCase.getBas_droite() != null)  { System.out.print("|BD :" + aCase.getBas_droite().getId()); }
            if (aCase.getBas_gauche() != null)  { System.out.print("|BG :" + aCase.getBas_gauche().getId()); }
            if (aCase.getGauche() != null)      { System.out.print("|G :" + aCase.getGauche().getId()); }
            if (aCase.getHaut_gauche() != null) { System.out.print("|HG :" + aCase.getHaut_gauche().getId()); }
            System.out.println("");
        }
*/
       
        return plateau ;
    }

    
    public void ajout_pions_haut_classique(){ // Ajout des pions en haut du plateau

        for(int i=0; i<=15 ; i++){
            if ((i != 11) && (i !=12))
                this.getPlateau()[i].setPion(new Pion(Color.RED));
            	
        }
    }
    public void ajout_pions_haut_original(){

        for(int i=0; i<17 ; i++){
            if ( i !=0 && i!=4 && i!=5 && i!=10 && i!=11)
                this.getPlateau()[i].setPion(new Pion(Color.RED));

        }
        this.getPlateau()[22].setPion(new Pion(Color.RED));
        this.getPlateau()[21].setPion(new Pion(Color.RED));

    }


    public void ajout_pions_bas_classique(){ // Ajout des pions en bas du plateau

        for(int i=60; i>= 45 ; i--){
            if(i!= 48 && i!=49)
                this.getPlateau()[i].setPion(new Pion(Color.BLACK));
        }
    }
    public void ajout_pions_bas_original(){

        for(int i=60; i> 43 ; i--){
            if(i!= 60 && i!=50 && i!=56 && i!=55 && i!=49 )
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
            if (getPlateau()[i].getPion() != null) {
                System.out.print("  x ");
            }
            else {
                System.out.print("  . ");
            }
            i++;
        }while(i < nbCases);
        System.out.println("\n");
    }


    /**
     *  DEPLACEMENTS
     */

    public void changePlacePion(Case source, Case destination) {
        if (destination != source && destination != null) {
            destination.setPion(source.getPion());
            source.setPion(null);
            //System.out.println("\n" + source.getId() + " -> " + destination.getId());
        }
    }

    
    public void deplacementSimple(Case source, String direction) { // Pas de sumito
        Pion pion = source.getPion();
        Case destination = source;
        switch (direction)
        {
            case "HD" :
                //if (source.getHaut_droite().getPion() == null)
                destination = source.getHaut_droite();
                break;
            case "D" :
                //if (source.getDroite().getPion() == null)
                destination = source.getDroite();
                break;
            case "BD" :
                //if (source.getBas_droite().getPion() == null)
                destination = source.getBas_droite();
                break;
            case "BG" :
                //if (source.getBas_gauche().getPion() == null)
                destination = source.getBas_gauche();
                break;
            case "G" :
                //if (source.getGauche().getPion() == null)
                destination = source.getGauche();
                break;
            case "HG" :
                //if (source.getHaut_gauche().getPion() == null)
                destination = source.getHaut_gauche();
                break;

            default:
                break;
        }
        changePlacePion(source, destination);
    }

    public void deplacementLineaire(ArrayList<Case> selection, String direction) { // Pas de sumito
        // On suppose que la liste des pions sélectionnés est triée par indice de case croissant
        int taille = selection.size(); // Longueur de la liste des pions sélectionnés
        Case source = null, destination = null;
        switch (direction)
        {
            case "HD" : // L'indice décroît
                // Le dernier pion change de place en HD du premier
                source = selection.get(taille - 1);
                destination = selection.get(0).getHaut_droite();
                break;
            case "D" : // L'indice croît
                // Le premier pion change de place à D du dernier
                source = selection.get(0);
                destination = selection.get(taille - 1).getDroite();
                break;
            case "BD" : // L'indice croît
                // Le premier pion change de place en BD du dernier
                source = selection.get(0);
                destination = selection.get(taille - 1).getBas_droite();
                break;

            case "BG" : // L'indice croît
                // Le premier pion change de place en BG du dernier
                source = selection.get(0);
                destination = selection.get(taille - 1).getBas_gauche();
                break;

            case "G" : // L'indice décroît
                // Le dernier pion change de place à G du premier
                source = selection.get(taille - 1);
                destination = selection.get(0).getGauche();
                break;

            case "HG" : // L'indice décroît
                // Le dernier pion change de place en HG du premier
                source = selection.get(taille - 1);
                destination = selection.get(0).getHaut_gauche();
                break;

            default:
                break;
        }
        if (destination != null && destination.getPion() == null) { // Si la case d'arrivée est vide
            changePlacePion(source, destination);
        }
        //System.out.println("\n" + source.getId() + " -> " + destination.getId());
    }

    public void deplacementLateral(ArrayList<Case> selection, String direction) { // Pas de sumito
        // On suppose que la liste des pions sélectionnés est triée par indice de case croissant
        for (Case aSelection : selection) {
            deplacementSimple(aSelection, direction);
        }
    }

    public void deplacement(ArrayList<Case> selection, String direction) { // Pas de sumito
        for (Case aSelection : selection) {
            deplacementSimple(aSelection, direction);
        }

    }

    
/*
    public void deplacement(ArrayList<Case> selection, String direction) { // Pas de sumito
        int indice = 0;
        for (Case aSelection : selection) {
            if(aSelection.getId() == indice + 1) {
                indice++;
            }
        }

    }
*/
}