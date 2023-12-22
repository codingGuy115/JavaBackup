import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import java.awt.Color;

import java.awt.geom.Rectangle2D;

public class Man extends JComponent
{
	//need fields to represent each of the body parts
	private Ellipse2D.Double head;
	private Rectangle2D body;
	private Rectangle2D leftArm;
	private Rectangle2D rightArm;
	private Rectangle2D leftLeg;
	private Rectangle2D rightLeg;
	
	//constructor that will put all fields in correct place in component
	public Man(int x, int y)
	{
		//saying the component bounds are to be set to these parameters
		this.setBounds(x, y, 31, 70);
		//setting each field to an object so they can be put on the component
		
		// (x, y, width, height)
		
		head = new Ellipse2D.Double(10, 0, 11, 11);
		body = new Rectangle2D.Double(10, 12, 11, 30);
		leftArm = new Rectangle2D.Double(0, 12, 20, 10);
		rightArm = new Rectangle2D.Double(11, 12, 19, 10);
		leftLeg = new Rectangle2D.Double(0, 32, 10, 37);
		rightLeg = new Rectangle2D.Double(21, 32, 9, 37);
		
		this.setFocusable(false);
		
		
	}
	
	//method that will use the inherited method draw
	public void paintComponent(Graphics g)
	{
		//type casting to a Graphics2D object in the method
		Graphics2D g2 = (Graphics2D) g;
		//using method from g2 object to draw all fields on component
		g2.setColor(Color.BLUE);
		
		g2.draw(head);
		g2.fill(head);
		g2.draw(body);
		g2.fill(body);
		g2.draw(leftArm);
		g2.fill(leftArm);
		g2.draw(rightArm);
		g2.fill(rightArm);
		g2.draw(leftLeg);
		g2.fill(leftLeg);
		g2.draw(rightLeg);
		g2.fill(rightLeg);
		
	}
	

}
