
package domaine;
import java.lang.Math;

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
        System.out.println("Base hexagone : " + getBaseHex() + " => nombre de cases du plateau : " + getNbCases());
        
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
        System.out.println(nbCases);
        
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
}


