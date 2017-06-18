package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.ResultSetMetaData;

import controller.ChoixPartieController;
import controller.JoueAbaloneController;
import domaine.ResultSetTableModel;

public class Classement extends JFrame implements ActionListener{
	
	
	 public Classement(ResultSetTableModel model){
	       
	       
		 	setSize(850,650);
	        setVisible(true);
	        setLocationRelativeTo(null);
	        draw( model);
	        this.revalidate();


	    }

	private void draw(ResultSetTableModel model) {
		// TODO Auto-generated method stub
		  this.setLayout(new GridLayout(2, 1));
		 JTable table = new JTable(model);
		

		    JScrollPane Jscroll = new JScrollPane(table); 
	        this.add( Jscroll, BorderLayout.CENTER );
	        Jscroll.getVerticalScrollBar().setVisible(true);
	        //bas de page
	        JPanel footer = new JPanel();

	        JButton menu = new JButton(new AbstractAction("Menu") {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                ChoixPartieController control = new ChoixPartieController();
	                dispose();
	                ChoixPartieUI menu = new ChoixPartieUI();
	            }
	        });
	        footer.add(menu, BorderLayout.WEST);
	        this.add(footer, BorderLayout.WEST);
	        
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	      
	        this.setVisible( true );
	        
				
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
