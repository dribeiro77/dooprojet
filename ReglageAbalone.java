package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

import controller.ChoixPartieController;
import controller.JoueDamesChinoisesController;
import domaine.Joueur;
/**
 * Created by Vicnesh on 2017-06-09.
 */


public class ReglageAbalone extends JFrame implements ActionListener {
    private ChoixPartieController control;
    public ReglageAbalone(){
        super("Réglage Abalone");
        control = new ChoixPartieController();
        setSize(850,650);
        setVisible(true);
        setLocationRelativeTo(null);
        //add(new JLabel(new ImageIcon("fondchoix.jpeg")));
        draw();
        revalidate();

    }

    public void draw(){

        JPanel flow = new JPanel();




        this.setLayout(new GridLayout(1, 1));

    flow = new JPanel();
		flow.setLayout(new FlowLayout());
		setLayout(new GridLayout(5, 1));

    JLabel abalone = new JLabel("ABALONE");
		abalone.setFont(new Font("Batang",20,40));
		flow.add(abalone,BorderLayout.SOUTH);
		flow.setBackground(Color.lightGray);
		add(flow);

    flow = new JPanel();
		flow.setLayout(new FlowLayout());

    JLabel joueurs_A = new JLabel("Liste des joueur(s) : ");
		flow.add(joueurs_A,BorderLayout.SOUTH);
		joueurs_A.setFont(new Font("Batang",20,15));

    Object listeJ[] = control.getPartie().getJoueurs().toArray();
    JList listeJoueursAb = new JList(listeJ);
		flow.add(listeJoueursAb);
		flow.setBackground(Color.lightGray);
		add(flow);

    flow = new JPanel();
		flow.setLayout(new FlowLayout());

    JButton ajoutAba = new JButton( new AbstractAction("Ajouter joueur") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            String pseudo=JOptionPane.showInputDialog(null, "Pseudo � ajouter");
            if(control.ajouteJoueurAbalone(pseudo)){
                Object listeeJ[]=control.getPartie().getJoueurs().toArray();
                String p[] = new String[listeeJ.length];
                for (int i = 0; i < listeeJ.length; i++) {
                    p[i]=((Joueur)listeeJ[i]).getPseudo();
                }
                listeJoueursAb.setListData(p);
                revalidate();

            }
            else{
                JOptionPane.showMessageDialog(null, "Impossible d'ajouter le joueur", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
		flow.add(ajoutAba);
		flow.setBackground(Color.lightGray);
		add(flow);


    flow = new JPanel();
		flow.setLayout(new FlowLayout());

    JLabel mode_A = new JLabel("Mode de jeu : ");
		flow.add(mode_A,BorderLayout.SOUTH);
		mode_A.setFont(new Font("Batang",20,15));

    String modes[] = {"Classique", "Version2"};
    JComboBox comboBoxModesAba = new JComboBox(modes);
		comboBoxModesAba.setSize(20, 30);
		flow.add(comboBoxModesAba);
		flow.setBackground(Color.lightGray);
		add(flow);

    flow = new JPanel();
		flow.setLayout(new FlowLayout());

    JButton playAba = new JButton( new AbstractAction("Jouer") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            control.choixJeu("Abalone");
            if(control.lancePartie()){
                dispose();
                //JoueAbalone
            }
            else {
                JOptionPane.showMessageDialog(null, "Ne peut pas lancer la partie", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
		flow.add(playAba);
		flow.setBackground(Color.lightGray);
		add(flow);
        JButton retour = new JButton(new AbstractAction("Retour") {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.choixJeu("Abalone");
                if(control.test_clic()){
                    dispose();
                    ChoixPartieUI back = new ChoixPartieUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Ne peut pas lancer la partie", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        flow.add(retour);
        flow.setBackground(Color.lightGray);
        add(flow);


}

    @Override
    public void actionPerformed(ActionEvent but) {
        // TODO Auto-generated method stub
        System.out.println(((JButton)but.getSource()).getName());

    }

}
