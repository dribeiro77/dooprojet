package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.JoueDamesChinoisesController;
import domaine.CRUD;
import domaine.Case;
import domaine.DALJoueur;
import domaine.Joueur;
import domaine.PlateauDamesChinoises;
import controller.ChoixPartieController;

public class JoueDamesChinoisesUI extends JFrame implements ActionListener  {
    private JoueDamesChinoisesController control;
    RoundButton cases[] = new RoundButton[122];
    JPanel one[] = new JPanel[17];
    ActionEvent selected;
    boolean first=true;
    int turn=0, pan=0;

    public JoueDamesChinoisesUI(JoueDamesChinoisesController c){
        super("Dames Chinoises");
        control=c;
        setSize(1000, 750);
        setVisible(true);
        setLocationRelativeTo(null);
        draw();
        this.revalidate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
           	 control. Sauvegarde();
                
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

        JButton quit = new JButton(new AbstractAction("Quitter") {
            @Override
            public void actionPerformed(ActionEvent e) {
               
           	 control. Sauvegarde();
                
               
            }
        });
        quit.addActionListener(this);
        tete.add(quit, BorderLayout.EAST);
        this.add(tete, BorderLayout.EAST);

        one[pan] = new JPanel();
        
        /*
        ImageIcon icone = new ImageIcon("tapis_vert.png");
        JLabel image = new JLabel(icone);
        one.add(image);
        */

        cases[1].addActionListener(this);
        one[pan].add(cases[1]);
        one[pan].setBackground(new Color(33,133,86));
        this.add(one[pan]);
        pan++;


        one[pan] = new JPanel();
        cases[2].addActionListener(this);
        one[pan].setBackground(new Color(33,133,86));
        one[pan].add(cases[2]);
        cases[3].addActionListener(this);
        one[pan].setBackground(new Color(33,133,86));
        one[pan].add(cases[3]);
        this.add(one[pan]);
        pan++;

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

        one[pan] = new JPanel();
        cases[121].addActionListener(this);
        one[pan].add(cases[121]);
        one[pan].setBackground(new Color(33,133,86));
        this.add(one[pan]);

        this.setVisible(true);
    }

    /**
     * Ajoute les boutons ronds sur la JFrame
     * @param min
     * @param max
     */
    public void addBetween(int min, int max){
        one[pan] = new JPanel();
        for (int i = min; i <= max ; i++) {
            cases[i].addActionListener(this);
            one[pan].setBackground(new Color(33,133,86));
            one[pan].add(cases[i]);
        }
        this.add(one[pan]);
        pan++;
    }

    
    
    /**
     * Actions quand on clique sur une case
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	

    	
    	
        if(e.getSource().getClass().equals(JButton.class)){
        	
        	for (int j = 0; j < control.getPartie().getJoueurs().size(); j++) {
				System.out.println(control.getPartie().getJoueurs().get(j).getScore());
			}
            dispose();
        }
        
        else{

            System.out.println(((RoundButton)e.getSource()).getCases().getId());

            if(first){
            	selected=e;
            	first=false;
            }
            
            if(control.getPartie().getMode().equalsIgnoreCase("Classique")){
            	jouerClassique(e);
            	System.out.println(control.getPartie().getJoueurs().get(0).getPseudo());
	        }
            else if(control.getPartie().getMode().equalsIgnoreCase("Avec prise")){
            	
            }
            else{
            	
            }
            
            
            if(control.partie_finie()){
                JOptionPane.showMessageDialog(this, "PARTIE FINIE!!");
                control. Sauvegarde();
               
                dispose();
            }
        }
    	
    }
   
    
    public void colloreMouvementsPossibles(ActionEvent e){
    	 //collore mouvements possibles
        if (((RoundButton)e.getSource()).getCases().getPion()!=null){
            ArrayList<Case> res = control.mouvements_possibles(((RoundButton)e.getSource()).getCases());
            for (int i = 0; i < res.size(); i++) {
                cases[res.get(i).getId()].setBackground(Color.PINK);
            }
        }
    }
    
    public void decolloreMouvementsPossibles(ActionEvent e){
    	if (((RoundButton)e.getSource()).getCases().getPion()!=null){
            ArrayList<Case> res = control.mouvements_possibles(((RoundButton)e.getSource()).getCases());
            for (int i = 0; i < res.size(); i++) {
                cases[res.get(i).getId()].setBackground(Color.white);
            }
        }
    }
    
    public void colloreSauts(ActionEvent e){
    	if (((RoundButton)e.getSource()).getCases().getPion()!=null){
            ArrayList<Case> res = control.sauts_possibles(((RoundButton)e.getSource()).getCases());
            res.remove(((RoundButton)selected.getSource()).getCases());
            for (int i = 0; i < res.size(); i++) {
                cases[res.get(i).getId()].setBackground(Color.PINK);
            }
        }
    }
    
    public void repaint(){
    	for (int i = 0; i < one.length; i++) {
			one[i].repaint();
		}
    }
    
    public void jouerClassique(ActionEvent e){
    	
    	if (control.getPartie().getJoueurs().size()>1 || turn%2==0){
    		
    	
    	
    	if(((RoundButton)e.getSource()).getBackground()==Color.PINK){
        	decolloreMouvementsPossibles(selected);
        	
            if(control.getPartie().getPlateau().estVoisin(((RoundButton)e.getSource()).getCases(),((RoundButton)selected.getSource()).getCases())){
                control.deplacementSimple(((RoundButton)selected.getSource()).getCases(), ((RoundButton)e.getSource()).getCases());
                repaint();
                control.sumScore(turn%control.getPartie().getJoueurs().size(),1);
                turn++;
            }
            else {
                control.sautePion(((RoundButton)selected.getSource()).getCases(), ((RoundButton)e.getSource()).getCases());
                control.sumScore(turn%control.getPartie().getJoueurs().size(),3);
                if(control.sauts_possibles(((RoundButton)e.getSource()).getCases()).size()>1){
                    colloreSauts(e);
                    repaint();
                    control.sumScore(turn%control.getPartie().getJoueurs().size(),2);
                }
                else{
                	turn++;
                }
            }
            
            repaint();
        }
        
        else if (((RoundButton)e.getSource()).getCases().getPion()!=null){
        	System.out.println(control.getCouleurdesjoueurs()[turn%control.getPartie().getJoueurs().size()]);
        	System.out.println(((RoundButton)e.getSource()).getStringColor());
        	if  (control.getCouleurdesjoueurs()[turn%control.getPartie().getJoueurs().size()].contains(((RoundButton)e.getSource()).getStringColor())){
        		decolloreMouvementsPossibles(selected);
            	colloreMouvementsPossibles(e);
        	}
        	else{
        		decolloreMouvementsPossibles(selected);
        	}
        	//colloreMouvementsPossibles(e);
        }
        
        else{
        	decolloreMouvementsPossibles(selected);
        }
        
        selected=e;
        
    	}
    	
    	else {
    		System.out.println("IA");
    		control.IA();
    		turn++;
    		repaint();
    		
    	}
    	}
    
}