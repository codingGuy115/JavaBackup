import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

//this class is our OWN component. Components hold things.
public class Background extends JComponent
{
	private Rectangle2D backgroundColor;
	
	public Background()
	{
		this.setBounds(0, 0, 750, 500);
		backgroundColor = new Rectangle2D.Double(0, 0, 750, 500);
		this.setFocusable(false);
	}
	
	//this method is invoked when it is time to draw a component
	public void paintComponent(Graphics g)
	{
		//type casting to a Graphics2D object in the method
		Graphics2D g2 = (Graphics2D) g;
		//using method from g2 object to draw all fields on component
		g2.setColor(Color.BLACK);
		g2.draw(backgroundColor);
		g2.fill(backgroundColor);
	}
	
	//just in case i want to change the color of the background later on
	public void setBackgroundColor(Color c)
	{
		
	}

}
