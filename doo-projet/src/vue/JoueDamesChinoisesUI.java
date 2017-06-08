package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.JoueDamesChinoisesController;
import domaine.Case;
import domaine.PlateauDamesChinoises;

public class JoueDamesChinoisesUI extends JFrame implements ActionListener  {
	private JoueDamesChinoisesController control;
	RoundButton cases[] = new RoundButton[122];
	//JPanel plat = new JPanel();
	RoundButton selected = new RoundButton(new Case(0));
	
	public JoueDamesChinoisesUI(JoueDamesChinoisesController c){
		super("Dammes Chinoises");
		control=c;
		setSize(1000, 700);
		setVisible(true);
		setLocationRelativeTo(null);	
		draw();
		//this.add(plat);
		this.revalidate();
	}
	
	public void draw(){
		
		PlateauDamesChinoises plateau = (PlateauDamesChinoises) control.getPartie().getPlateau();
		for(int i=1; i<=121; i++){
			cases[i]= new RoundButton(plateau.getPlateau()[i]);
            
		}

		this.setLayout(new GridLayout(17, 1));
		
		JPanel one = new JPanel();
		cases[1].addActionListener(this);
		one.add(cases[1]);
		this.add(one);
		
		one = new JPanel();
		cases[2].addActionListener(this);
		one.add(cases[2]);
		cases[3].addActionListener(this);
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
		this.add(one);
		
        this.setVisible(true);
    }

	public void addBetween(int min, int max){
		JPanel one = new JPanel();
		for (int i = min; i <= max ; i++) {
			cases[i].addActionListener(this);
			one.add(cases[i]);
		}
		this.add(one);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(((RoundButton)e.getSource()).getCases().getId());
		
		//decolore les mouvements passés 
		if (((RoundButton)e.getSource()).getCases().getPion()!=null){
			ArrayList<Case> res = control.mouvements_possibles(selected.getCases());		
		for (int i = 0; i < res.size(); i++) {
			cases[res.get(i).getId()].setForeground(Color.GRAY);
			}
		}
		
		
		
		if(((RoundButton)e.getSource()).getForeground()==Color.PINK){
			if(control.getPartie().getPlateau().estVoisin(((RoundButton)e.getSource()).getCases(),selected.getCases())){
				control.deplacementSimple(selected.getCases(), ((RoundButton)e.getSource()).getCases());
			}
			else {
				control.sautePion(selected.getCases(), ((RoundButton)e.getSource()).getCases());
			}
			
			//decolore les mouvements passés 
			if (((RoundButton)e.getSource()).getCases().getPion()!=null){
				ArrayList<Case> res = control.mouvements_possibles(selected.getCases());		
			for (int i = 0; i < res.size(); i++) {
				cases[res.get(i).getId()].setForeground(Color.GRAY);
				}
			}
			
			
		}
		
		
	
		//collore mouvements possibles
		if (((RoundButton)e.getSource()).getCases().getPion()!=null){
			ArrayList<Case> res = control.mouvements_possibles(((RoundButton)e.getSource()).getCases());
			for (int i = 0; i < res.size(); i++) {
				cases[res.get(i).getId()].setForeground(Color.PINK);
			}
		}
		
		
		selected=((RoundButton)e.getSource());
		
		if(control.partie_finie()){
			JOptionPane.showMessageDialog(this, "PARTIE FINIE!!");
			dispose();
		}
		
	}
}
