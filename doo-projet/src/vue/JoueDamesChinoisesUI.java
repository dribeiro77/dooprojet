package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.JoueDamesChinoisesController;
import domaine.Case;
import domaine.PlateauDamesChinoises;
import controller.ChoixPartieController;

public class JoueDamesChinoisesUI extends JFrame implements ActionListener  {
    private JoueDamesChinoisesController control;
    RoundButton cases[] = new RoundButton[122];
    //JPanel plat = new JPanel();
    RoundButton selected = new RoundButton(new Case(0));

    public JoueDamesChinoisesUI(JoueDamesChinoisesController c){
        super("Dammes Chinoises");
        control=c;
        setSize(1000, 750);
        setVisible(true);
        setLocationRelativeTo(null);
        draw();
        this.revalidate();
    }

     public void draw() {

        PlateauDamesChinoises plateau = (PlateauDamesChinoises) control.getPartie().getPlateau();
        for(int i=1; i<=121; i++){
            cases[i]= new RoundButton(plateau.getPlateau()[i]);

        }

        this.setLayout(new GridLayout(18, 3));
        //En-tête :



        JPanel tete = new JPanel();

        JButton menu = new JButton(new AbstractAction("Menu") {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.choixJeu("Dames Chinoise");

                dispose();
                //ReglageDamesChinoiseUI back = new ReglageDamesChinoiseUI();
                ChoixPartieUI menu = new ChoixPartieUI();
            }
        });
        tete.add(menu, BorderLayout.WEST);
        this.add(tete, BorderLayout.WEST);

        JLabel dames = new JLabel("DAMES CHINOISES");
        dames.setFont(new Font("Batang", 20, 20));
        tete.add(dames, BorderLayout.SOUTH);
        tete.setBackground(new Color(33,133,86));
        add(tete);

        JButton quit = new JButton("Quitter");
        quit.addActionListener(this);
        tete.add(quit, BorderLayout.EAST);
        this.add(tete, BorderLayout.EAST);

        JPanel one = new JPanel();
        /*
        ImageIcon icone = new ImageIcon("tapis_vert.png");
        JLabel image = new JLabel(icone);
        one.add(image);
        */

        cases[1].addActionListener(this);
        one.add(cases[1]);
        one.setBackground(new Color(33,133,86));
        this.add(one);


        one = new JPanel();
        cases[2].addActionListener(this);
        one.setBackground(new Color(33,133,86));
        one.add(cases[2]);
        cases[3].addActionListener(this);
        one.setBackground(new Color(33,133,86));
        one.add(cases[3]);
        this.add(one);

        addBetween(4, 6);
        addBetween(7, 10);
        addBetween(11, 23);
        addBetween(24, 35);
        addBetween(36, 46);
        addBetween(47, 56);
        addBetween(57, 65);
        addBetween(66, 75);
        addBetween(76, 86);
        addBetween(87, 98);
        addBetween(99, 111);
        addBetween(112, 115);
        addBetween(116, 118);
        addBetween(119, 120);

        one = new JPanel();
        cases[121].addActionListener(this);
        one.add(cases[121]);
        one.setBackground(new Color(33,133,86));
        this.add(one);

        this.setVisible(true);
    }

    /**
     * Ajoute les boutons ronds sur la JFrame
     * @param min
     * @param max
     */
    public void addBetween(int min, int max){
        JPanel one = new JPanel();
        for (int i = min; i <= max ; i++) {
            cases[i].addActionListener(this);
            one.setBackground(new Color(33,133,86));
            one.add(cases[i]);
        }
        this.add(one);
    }

    /**
     * Actions quand on clique sur une case
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().getClass().equals(JButton.class)){
            dispose();
        }
        else{

            System.out.println(((RoundButton)e.getSource()).getCases().getId());


            //decolore les mouvements pass�s
            if (((RoundButton)e.getSource()).getCases().getPion()!=null){
                ArrayList<Case> res = control.mouvements_possibles(selected.getCases());
                for (int i = 0; i < res.size(); i++) {
                    cases[res.get(i).getId()].setBackground(Color.white);
                }
                selected.setBackground(Color.white);
            }


            //si il selectione un boutton color�
            if(((RoundButton)e.getSource()).getBackground()==Color.PINK){
                if(control.getPartie().getPlateau().estVoisin(((RoundButton)e.getSource()).getCases(),selected.getCases())){
                    control.deplacementSimple(selected.getCases(), ((RoundButton)e.getSource()).getCases());
                }
                else {
                    control.sautePion(selected.getCases(), ((RoundButton)e.getSource()).getCases());
                }

                //decolore les mouvements pass�s
                if (((RoundButton)e.getSource()).getCases().getPion()!=null){
                    ArrayList<Case> res = control.mouvements_possibles(selected.getCases());
                    for (int i = 0; i < res.size(); i++) {
                        cases[res.get(i).getId()].setBackground(Color.white);
                    }
                }


            }



            //collore mouvements possibles
            if (((RoundButton)e.getSource()).getCases().getPion()!=null){
                ArrayList<Case> res = control.mouvements_possibles(((RoundButton)e.getSource()).getCases());
                for (int i = 0; i < res.size(); i++) {
                    cases[res.get(i).getId()].setBackground(Color.PINK);
                }
            }


            selected=((RoundButton)e.getSource());

            if(control.partie_finie()){
                JOptionPane.showMessageDialog(this, "PARTIE FINIE!!");
                dispose();
            }
        }
    }
}