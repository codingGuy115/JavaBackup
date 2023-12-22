import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

import java.awt.Color;

public class Ball extends JComponent
{
	private Ellipse2D.Double ball;
	private Color color;
	
	private int dx = 3;
	private int dy = 3;
	
	public Ball(int x, int y)
	{
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
	
	public void setDy(int dy)
	{
		this.dy = dy;
	}
	
	public void update()
	{
		this.setLocation(getX() + dx, getY() + dy);
	}
	
	public int getDx()
	{
		return dx;
	}
	
	public int getDy()
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
	

}
