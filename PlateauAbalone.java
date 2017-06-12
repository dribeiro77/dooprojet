package domaine;
import java.lang.Math;

/**
 * Created by Radu on 09/06/17.
 */
public class PlateauAbalone extends Plateau {
    private int baseHex; // Nombre de cases d'un côté du plateau hexagonal
    private int nbCases; // Nombre total de cases du plateau

    /* GETTERS */
    public int getBaseHex() {
        return baseHex;
    }

    public int getNbCases() {
        return nbCases;
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
        initPlateau();
    }
    
    /* AUTRES METHODES */
    private void calculerNbCases() {
        nbCases = 0;
        for (int i = 0; i < baseHex - 1; i++) {
            nbCases += 2 * (baseHex + i);
        }
        nbCases += 2 * (baseHex - 1) + 1;
    }

    int zigzag(int entier) { // zigzag(n) = somme(k = 1..n, (-1)^ent((k - 1)/4))
        // Produit une suite du type : 0, 1, 2, 3, 4, 3, 2, 1, 0
        int res = 0;
        for (int i = 1; i <= entier; i++) {
            res += Math.pow(-1, Math.floor((i - 1)/4));
        }

        return res;
    }

    public void initPlateau() {
        Case[] plateau = new Case[getNbCases()];

        int j = 0, // Correspond à la ligne du plateau. Artifice utile pour son initialisation
            t = 0, z = 0; // Variables tampon
        for (int i = 0; i < nbCases; i++) {
            plateau[i] = new Case(i);

            z = zigzag(j);
            if (i == t + baseHex + z) { // Indice pour former une nouvelle "ligne"
                t = i; // Correspond à : u_(n+1) = u_n + baseHex + z(n)
                j++;
            }

            if (j > 0) { // Cases ayant une voisine en haut ...
                if (i >= baseHex + z) { // ... à droite
                    plateau[i].setHaut_droite(plateau[i - (baseHex + z)]);
                    System.out.println("    " + i + ".HD : " + (i - (baseHex + z)));
                }
                if (i >= baseHex + z + 1) { // ... à gauche
                    plateau[i].setHaut_gauche(plateau[i - (baseHex + z) - 1]);
                    System.out.println("    " + i + ".HG : " + (i - (baseHex + z) - 1));
                }
            }
            if (i < nbCases - 1 && i != t + baseHex + z - 1 /* case non en fin de ligne */) { // Cases ayant une voisine à droite
                plateau[i].setDroite(plateau[i + 1]);
                System.out.println("    " + i + ".D  : " + (i + 1));
            }
            if (i > 0 && i != t + baseHex + z /* case non en début de ligne */) { // Cases ayant une voisine à gauche
                plateau[i].setGauche(plateau[i - 1]);
                System.out.println("    " + i + ".G  : " + (i - 1));
            }
            if (j < 2 * (baseHex - 1) /* && COND */) { // Cases ayant une voisine en bas ...
                if (i < nbCases - baseHex - z - 1) { // ... à droite
                    plateau[i].setBas_droite(plateau[i + baseHex + j + z + 1]);
                    System.out.println("    " + i + ".BD : " + (i + baseHex + z + 1));
                }
                if (i < nbCases - baseHex - z) { // ... à gauche
                    plateau[i].setBas_gauche(plateau[i + baseHex + z]);
                    System.out.println("    " + i + ".BG : " + (i + baseHex + z));
                }
            }
            System.out.println("j : " + j + "| t : " + t + "| z : " + z);
        }
    }
}
