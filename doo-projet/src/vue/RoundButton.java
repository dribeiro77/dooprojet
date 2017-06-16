package vue;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import domaine.Case;

public class RoundButton extends JButton {
	private Case cases;
  public RoundButton(Case c) {
    super("");
    this.cases=c;

// These statements enlarge the button so that it 
// becomes a circle rather than an oval.
    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, 
      size.height);
    setPreferredSize(size);

// This call causes the JButton not to paint 
   // the background.
// This allows us to paint a round background.
    setContentAreaFilled(false);
  }

  public RoundButton(String str){
	  super(str);
	  cases=null;
	  
	// These statements enlarge the button so that it 
	// becomes a circle rather than an oval.
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width, 
	      size.height);
	    setPreferredSize(size);

	// This call causes the JButton not to paint 
	   // the background.
	// This allows us to paint a round background.
	    setContentAreaFilled(false);
	  
  }


public Case getCases() {
	return cases;
}



public void setCases(Case cases) {
	this.cases = cases;
}



// Paint the round background and label.
  protected void paintComponent(Graphics g) {
    if (cases!=null) {
    	if(cases.getPion()!=null){
// You might want to make the highlight color 
   // a property of the RoundButton class.
      g.setColor(cases.getPion().getCouleur());
    } else {
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width-1, 
      getSize().height-1);

// This call will paint the label and the 
   // focus rectangle.
    super.paintComponent(g);
  }
    else{
    	
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width-1, 
      getSize().height-1);

// This call will paint the label and the 
   // focus rectangle.
    super.paintComponent(g);
    }
  
  

// Paint the border of the button using a simple stroke.
  protected void paintBorder(Graphics g) {
    g.setColor(getForeground());
    g.drawOval(0, 0, getSize().width-1, 
      getSize().height-1);
  }

// Hit detection.
  Shape shape;
  public boolean contains(int x, int y) {
// If the button has changed size, 
   // make a new shape object.
    if (shape == null || 
      !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, 
        getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }
  
  public String getStringColor(){
	  if (cases.getPion()!=null){
		  if (this.getCases().getPion().getCouleur()==Color.BLUE){
			  return "BLUE";
		  }
		  else if (this.getCases().getPion().getCouleur()==Color.RED){
			  return "RED";
		  }
		  else if (this.getCases().getPion().getCouleur()==Color.MAGENTA){
			  return "MAGENTA";
		  }
		  else if (this.getCases().getPion().getCouleur()==Color.YELLOW){
			  return "YELLOW";
		  }
		  else if (this.getCases().getPion().getCouleur()==Color.GREEN){
			  return "GREEN";
		  }
		  else {
			  return "BLACK";
		  }
	  }
	  else return "";
  }

}