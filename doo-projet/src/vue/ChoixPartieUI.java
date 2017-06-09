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

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controller.ChoixPartieController;
import controller.JoueDamesChinoisesController;
import domaine.Joueur;

public class ChoixPartieUI extends JFrame implements ActionListener{
	private ChoixPartieController control;
	
	
	public ChoixPartieUI(){
		super("Choix Partie");
		control = new ChoixPartieController();
		setSize(850,650);
		setVisible(true);
		setLocationRelativeTo(null);
		//add(new JLabel(new ImageIcon("fondchoix.jpeg")));
		draw();
		revalidate();
		
	}
	
	public void draw(){
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel flow = new JPanel();
		
		
		
		
		this.setLayout(new GridLayout(1, 2));
		
		JSeparator separate = new JSeparator(SwingConstants.VERTICAL);
		
		//======================================LEFT PANEL================================
		flow.setLayout(new FlowLayout());
		left.setLayout(new GridLayout(6, 1));
		
		JLabel dames = new JLabel("DAMES CHINOISES");
		dames.setFont(new Font("Batang",20,20));
		flow.add(dames,BorderLayout.SOUTH);
		flow.setBackground(Color.cyan);
		left.add(flow);
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		
		Object liste[] = control.getPartie().getJoueurs().toArray();
		JList listeJoueurs = new JList(liste);
		flow.add(listeJoueurs);
		flow.setBackground(Color.cyan);
		left.add(flow);
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		
		JButton ajout = new JButton( new AbstractAction("Ajoute joueur") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	            String pseudo=JOptionPane.showInputDialog(null, "Pseudo à ajouter");
	            if(control.ajouteJoueurDames(pseudo)){
	            	Object listee[]=control.getPartie().getJoueurs().toArray();
	            	String j[] = new String[listee.length];
	            	for (int i = 0; i < listee.length; i++) {
						j[i]=((Joueur)listee[i]).getPseudo();
					}
	            	listeJoueurs.setListData(j);
	            	revalidate();
	            	
	            }
	            else{
	            	JOptionPane.showMessageDialog(null, "Impossible d'ajouter le joueur", "Erreur", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });
		flow.add(ajout);
		flow.setBackground(Color.cyan);
		left.add(flow);
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		
		String labels[] = {"0", "1", "2", "3", "4"};
		JComboBox comboBox = new JComboBox(labels);
		comboBox.setSize(20, 30);
		flow.add(comboBox);
		flow.setBackground(Color.cyan);
		left.add(flow);
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		
		String mod[] = {"Classique", "Avec prise", "Rapide"};
		JComboBox comboBoxModes = new JComboBox(mod);
		flow.add(comboBoxModes);
		flow.setBackground(Color.cyan);
		left.add(flow);
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		
		JButton play = new JButton( new AbstractAction("Jouer") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	            control.getPartie().setCouleurParJoueur(comboBox.getSelectedIndex());
	            control.choixJeu("Dames Chinoises");
	            if(control.lancePartie()){
	            	dispose();
	            	JoueDamesChinoisesController joue = new JoueDamesChinoisesController(control.getPartie());
	            	JoueDamesChinoisesUI ui = new JoueDamesChinoisesUI(joue);
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "Ne peut pas lancer la partie", "Erreur", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });
		flow.add(play);
		flow.setBackground(Color.cyan);
		left.add(flow);
		this.add(left);
		
		//====================================RIGHT PANEL==================================
		
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		right.setLayout(new GridLayout(5, 1));
		
		JLabel abalone = new JLabel("ABALONE");
		abalone.setFont(new Font("Batang",20,20));
		flow.add(abalone,BorderLayout.SOUTH);
		flow.setBackground(Color.MAGENTA);
		right.add(flow);
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		
		Object listeJ[] = control.getPartie().getJoueurs().toArray();
		JList listeJoueursAb = new JList(listeJ);
		flow.add(listeJoueursAb);
		flow.setBackground(Color.MAGENTA);
		right.add(flow);
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		
		JButton ajoutAba = new JButton( new AbstractAction("Ajoute joueur") {
	        @Override
	        public void actionPerformed( ActionEvent e ) {
	            String pseudo=JOptionPane.showInputDialog(null, "Pseudo à ajouter");
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
		flow.setBackground(Color.MAGENTA);
		right.add(flow);
		
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		
		String modes[] = {"Classique", "Version2"};
		JComboBox comboBoxModesAba = new JComboBox(modes);
		comboBoxModesAba.setSize(20, 30);
		flow.add(comboBoxModesAba);
		flow.setBackground(Color.MAGENTA);
		right.add(flow);
		
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
		flow.setBackground(Color.MAGENTA);
		right.add(flow);
		
		this.add(right);
		
	}

	@Override
	public void actionPerformed(ActionEvent but) {
		// TODO Auto-generated method stub
			System.out.println(((JButton)but.getSource()).getName());
		
	}

}
