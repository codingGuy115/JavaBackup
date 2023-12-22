import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class Ball extends JComponent
{
	private Ellipse2D.Double ball;
	private Color color;
	
	private int dx = 6;
	private int dy = 6;
	
	public Ball(int x, int y)
	{
		this.color = Color.RED;
		this.setBounds(x, y, 20, 20);
		ball = new Ellipse2D.Double(0, 0, 19, 19);
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
	public void updateDx()
	{
		this.setLocation(getX() + dx, getY());
	}
	public void updateDy()
	{
		this.setLocation(getX(), getY() + dy);
	}
	
	public int getDx()
	{
		return dx;
	}
	
	public int getDy()
	{
		return dy;
	}
	
	//method which will randomize the direction the ball travels in.
	public void randomizeDirection()
	{
		int num = (int)(Math.random()*4 + 1);
		switch(num)
		{
		
		case(1):
		{
			//up right
			this.setDy(dy * -1);
		}
		case(2):
		{
			//down right
			
		}
		case(3):
		{
			//down left
			this.setDx(dx * -1);
		}
		case(4):
		{
			//up left
			this.setDx(dx * -1);
			this.setDy(dy * -1);
		}
		
		}
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
