package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

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
		//left.add(flow);

		//JSeparator separate = new JSeparator(SwingConstants.VERTICAL);

		// LEFT : Dames Chinoises
		flow.setLayout(new FlowLayout());
		left.setLayout(new GridLayout(3, 1));
		left.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		right.setBorder(BorderFactory.createLineBorder(Color.white,10));

		// CASE N°1 :
		flow = new JPanel();
		flow.setLayout(new FlowLayout());

		JLabel dames = new JLabel("DAMES CHINOISES");
		dames.setFont(new Font("Batang",20,40));
		// Test
		//dames.setVerticalAlignment(SwingConstants.CENTER);
		flow.add(dames);
		//
		flow.setBackground(Color.lightGray);
		left.add(flow);

		// CASE N°2 :
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		ImageIcon icone = new ImageIcon("DamesChinoises.png");
		JLabel image = new JLabel(icone);
        left.add(image);
		left.setBackground(Color.lightGray);

		// CASE N°3 :
		flow = new JPanel();
		flow.setLayout(new FlowLayout());

		JButton play = new JButton( new AbstractAction("Reglage Dames Chinoises") {
			@Override
			public void actionPerformed( ActionEvent e ) {
				control.choixJeu("Dames Chinoise");
				if(control.lancePartie()){
					dispose();
					ReglageDamesChinoiseUI reglage = new ReglageDamesChinoiseUI();
				}
				else {
					JOptionPane.showMessageDialog(null, "Ne peut pas lancer la partie", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		flow.add(play);
		flow.setBackground(Color.lightGray);
		left.add(flow);
		this.add(left);


		/*__________________________________________________________________________________________________________
		__________________________________________________________________________________________________________*/


		// RIGHT : Abalone

		// CASE N°1 : Nom
		flow = new JPanel();
		flow.setLayout(new FlowLayout());
		right.setLayout(new GridLayout(3, 1));

		JLabel abalone = new JLabel("ABALONE",JLabel.CENTER);
		abalone.setFont(new Font("Batang",20,40));
		flow.add(abalone,BorderLayout.CENTER);
		flow.setBackground(Color.lightGray);
		right.add(flow);

		// CASE N°2 : Image
        flow = new JPanel();
        flow.setLayout(new FlowLayout());
        ImageIcon icone2 = new ImageIcon("Abalone.png");
        JLabel image2 = new JLabel(icone2);
        right.add(image2);
        right.setBackground(Color.lightGray);

		// CASE N°3 : Bouttons
		flow = new JPanel();
		flow.setLayout(new FlowLayout());

		JButton playAba = new JButton( new AbstractAction("Réglage Abalone") {
			@Override
			public void actionPerformed( ActionEvent e ) {
				control.choixJeu("Abalone");
				if(control.lancePartie()){
					dispose();
					ReglageAbaloneUI reg2 = new ReglageAbaloneUI();
				}
				else {
					JOptionPane.showMessageDialog(null, "Ne peut pas lancer la partie", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		flow.add(playAba);
		flow.setBackground(Color.lightGray);
		right.add(flow);

		this.add(right);

	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
