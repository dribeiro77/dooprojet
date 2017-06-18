package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.JoueAbaloneController;
import domaine.Case;
import domaine.PlateauAbalone;
import domaine.PlateauDamesChinoises;

public class JoueAbaloneUI extends JFrame implements ActionListener  {
    private JoueAbaloneController control;
    RoundButton cases[] = new RoundButton[61];
    RoundButton selected = new RoundButton(new Case(0));

    public JoueAbaloneUI(JoueAbaloneController c){
        super("Abalone");
        control=c;
        setSize(1000, 750);
        setVisible(true);
        setLocationRelativeTo(null);
        draw();
        this.revalidate();


    }

    public void draw() {

 
    PlateauAbalone plateau = (PlateauAbalone) control.getPartie().getPlateau();
        /*
        if (plateau == null){
            System.out.println("plateau null");
        }
        else System.out.println("plateau not null");
        */
      
        for(int i=0; i<=60; i++){
            cases[i]= new RoundButton(plateau.getPlateau()[i]);
            //System.out.println("case"+i);
        }

        this.setLayout(new GridLayout(17, 3));

        //En-tête :
        JPanel header = new JPanel();

        JButton menu = new JButton(new AbstractAction("Menu") {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.choixJeu("Abalone");
                dispose();
                ChoixPartieUI menu = new ChoixPartieUI();
            }
        });
        header.add(menu, BorderLayout.WEST);
        this.add(header, BorderLayout.WEST);

        JLabel abalone = new JLabel("Abalone");
        abalone.setFont(new Font("Batang", 20, 20));
        header.add(abalone, BorderLayout.SOUTH);
        header.setBackground(new Color(33,133,86));
        this.add(header);

        JButton quit = new JButton("Quitter");
        quit.addActionListener(this);
        header.add(quit, BorderLayout.EAST);
        this.add(header, BorderLayout.EAST);


        JPanel one = new JPanel();
        one.setBackground(new Color(33,133,86));
        this.add(one);

        JPanel two = new JPanel();
        two.setBackground(new Color(33,133,86));
        this.add(two);

        addBetween(0, 4);
        addBetween(5, 10);
        addBetween(11, 17);
        addBetween(18, 25);
        addBetween(26, 34);
        addBetween(35, 42);
        addBetween(43, 49);
        addBetween(50, 55);
        addBetween(56, 60);

        JPanel tree = new JPanel();
        tree.setBackground(new Color(33,133,86));
        this.add(tree);

        JPanel four = new JPanel();
        four.setBackground(new Color(33,133,86));
        this.add(four);

        JPanel five = new JPanel();
        five.setBackground(new Color(33,133,86));
        this.add(five);

        JPanel six = new JPanel();
        six.setBackground(new Color(33,133,86));
        this.add(six);

        JPanel seven = new JPanel();
        seven.setBackground(new Color(33,133,86));
        this.add(seven);

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
    }
     /*   if(e.getSource().getClass().equals(JButton.class)){
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
                    //control.sautePion(selected.getCases(), ((RoundButton)e.getSource()).getCases());
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

            /*if(control.partie_finie()){
                JOptionPane.showMessageDialog(this, "PARTIE FINIE!!");
                dispose();
            }
        }
    }*/
}
