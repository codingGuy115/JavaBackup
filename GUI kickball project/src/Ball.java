import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

import java.awt.Color;

public class Ball extends JComponent
{
	private Ellipse2D.Double ball;
	
	public Ball(int x, int y)
	{
		this.setBounds(x, y, 11, 11);
		ball = new Ellipse2D.Double(0, 0, 10, 10);
		this.setFocusable(false);
	}
	
	
	public void paintComponent(Graphics g)
	{
		//type casting to a Graphics2D object in the method
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		//using inherited method
		g2.draw(ball);
		g2.fill(ball);
	}
	

}
