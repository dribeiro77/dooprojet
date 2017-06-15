package domaine;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domaine.CRUD;
import domaine.Joueur;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	CRUD a = new CRUD();
		Joueur J = new Joueur("Karim");
		try {
			a.connection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a.ajouter_Joueur(J);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			a.scoreAbalone(J, 2);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		ResultSet res = null;
		
		try {
			res = a.lister_joueur();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			a.afficher(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		ResultSet rs = null;
		
		try {
			rs = a.lister_joueur_abalone();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ResultSetTableModel model = new ResultSetTableModel( rs );
	    JTable table = new JTable(model);
	    JScrollPane Jscroll = new JScrollPane(table);
        
        JFrame mainFrame = new JFrame( "Affiche table " );
        mainFrame.add( Jscroll, BorderLayout.CENTER );
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        mainFrame.setSize( 640, 480 );
        mainFrame.setVisible( true );
		
	}
		
		*/
		PlateauAbalone board = new PlateauAbalone(5);
		//board.print();
		
		for (int i = 0 ; i< board.getNbCases();i++)
		{
		board.afficher_voisins_console(board.getPlateau()[i]);
		System.out.println("");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}}