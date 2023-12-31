package projectiles;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

import java.awt.Color;

public class Grenade extends JComponent 
{
	private Ellipse2D.Double ball;
	private Color color;
	//sweetspot> dx:3, dy:-20
	private int dx;
	private double dy;
	
	private boolean inStasis;
	
	public Grenade(int x, int y, int dx, int dy)
	{
		this.dx = dx;
		this.dy = dy;
		inStasis = false;
		this.color = Color.BLUE;
		this.setBounds(x, y, 16, 16);
		ball = new Ellipse2D.Double(0, 0, 15, 15);
		this.setFocusable(false);
	}
	
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	public void setDx(int dx)
	{
		this.dx = dx;
	}
	
	public void setDy(double dy)
	{
		this.dy = dy;
	}
	
	public void update()
	{
		this.setLocation(getX() + dx, (int)(this.getY() + dy));
	}
	
	public int getDx()
	{
		return dx;
	}
	
	public double getDy()
	{
		return dy;
	}
	
	public void paintComponent(Graphics g)
	{
		//type casting to a Graphics2D object in the method
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		//using inherited method
		g2.draw(ball);
		g2.fill(ball);
	}


	public boolean isInStasis() {
		return inStasis;
	}


	public void setInStasis(boolean inStasis) {
		this.inStasis = inStasis;
		this.dy = 0;
		this.dx = 0;
	}
	

}