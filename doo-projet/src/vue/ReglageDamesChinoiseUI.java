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
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.*;

import controller.ChoixPartieController;
import controller.JoueDamesChinoisesController;
import domaine.CRUD;
import domaine.DALJoueur;
import domaine.Joueur;

/**
 * Created by Vicnesh on 2017-06-09.
 */

public class ReglageDamesChinoiseUI extends JFrame implements ActionListener {
    private ChoixPartieController control;

    public ReglageDamesChinoiseUI() {
        super("Reglage Dames Chinoise");
        control = new ChoixPartieController();
        setSize(850, 650);
        setVisible(true);
        setLocationRelativeTo(null);
      
        draw();
        revalidate();

    }

    public void draw() {
       JPanel flow = new JPanel();
        this.setLayout(new GridLayout(1, 1));




        flow.setLayout(new FlowLayout());
        setLayout(new GridLayout(6, 1));

        JLabel dames = new JLabel("DAMES CHINOISES");
        dames.setFont(new Font("Batang", 20, 40));
        flow.add(dames, BorderLayout.SOUTH);
        flow.setBackground(Color.lightGray);
        add(flow);

        flow = new JPanel();
        flow.setLayout(new FlowLayout());

        Object liste[] = control.getPartie().getJoueurs().toArray();
        JList listeJoueurs = new JList(liste);
        JLabel joueurs_DC = new JLabel("Liste des joueur(s) : ");
        flow.add(joueurs_DC, BorderLayout.SOUTH);
        joueurs_DC.setFont(new Font("Batang", 20, 15));
        flow.add(listeJoueurs);
        flow.setBackground(Color.lightGray);
        add(flow);

        flow = new JPanel();
        flow.setLayout(new FlowLayout());

        JButton ajout = new JButton(new AbstractAction("Ajouter joueur") {
            @Override
            public void actionPerformed(ActionEvent e) {
            	DALJoueur I= new CRUD();
                String pseudo = JOptionPane.showInputDialog(null, "Pseudo a ajouter");
                if (control.ajouteJoueurDames(pseudo)) {
                    Object listee[] = control.getPartie().getJoueurs().toArray();
                    String j[] = new String[listee.length];
                    for (int i = 0; i < listee.length; i++) {
                        j[i] = ((Joueur) listee[i]).getPseudo();
                     
                    }
                    listeJoueurs.setListData(j);
                    revalidate();

                } else {
                    JOptionPane.showMessageDialog(null, "Impossible d'ajouter le joueur", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        flow.add(ajout);
        flow.setBackground(Color.lightGray);
        add(flow);

        flow = new JPanel();
        flow.setLayout(new FlowLayout());

        JLabel nb_joueurs_DC = new JLabel("Nombre de couleurs par joueur : ");
        flow.add(nb_joueurs_DC, BorderLayout.SOUTH);
        nb_joueurs_DC.setFont(new Font("Batang", 20, 15));
        String labels[] = {"1", "2", "3"};
        JComboBox comboBox = new JComboBox(labels);
        comboBox.setSize(20, 30);
        flow.add(comboBox);
        flow.setBackground(Color.lightGray);
        add(flow);

        flow = new JPanel();
        flow.setLayout(new FlowLayout());

        JLabel mode_DC = new JLabel("Mode de jeu : ");
        flow.add(mode_DC, BorderLayout.SOUTH);
        mode_DC.setFont(new Font("Batang", 20, 15));

        String mod[] = {"Classique", "Avec prise", "Rapide"};
        JComboBox comboBoxModes = new JComboBox(mod);
        flow.add(comboBoxModes);
        flow.setBackground(Color.lightGray);
        add(flow);

        flow = new JPanel();
        flow.setLayout(new FlowLayout());

        JButton play = new JButton(new AbstractAction("Jouer") {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.choixJeu("Dames Chinoises");
                if (control.lancePartie() && control.choixCouleurParJoueur(comboBox.getSelectedIndex()+1)) {
                	control.getPartie().setMode((String)comboBoxModes.getSelectedItem());
                    dispose();
                    JoueDamesChinoisesController joue = new JoueDamesChinoisesController(control.getPartie());
                    JoueDamesChinoisesUI ui = new JoueDamesChinoisesUI(joue);

                } else {
                    JOptionPane.showMessageDialog(null, "Ne peut pas lancer la partie", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        flow.add(play);
        flow.setBackground(Color.lightGray);
        add(flow);

        JButton retour = new JButton(new AbstractAction("Retour") {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.choixJeu("Dames Chinoise");
        
                    dispose();
                    ChoixPartieUI back = new ChoixPartieUI();
                
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
