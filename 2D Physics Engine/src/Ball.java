import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.lang.Math;

public class Ball extends JComponent
{
	//fields 
	private Color color;
	private Ellipse2D.Double ball;
	private Rectangle2D outline;
	
	//logic related
	private int xI;
	private int yI;
	private double vO;
	private double angle;
	private double g = -9.8;
	
	private double elapsedTime = 0;
	private int dx = 2;
	
	
	
	public Ball(int x, int y, double initVel, double a)
	{
		xI = x;
		yI = y;
		vO = initVel;
		angle = Math.toRadians(a);
		//ETC-----------------------
		this.setBounds(x, y, 16, 16);
		this.color = Color.BLUE;
		ball = new Ellipse2D.Double(0, 0, 15, 15);
		outline = new Rectangle2D.Double(0,0,15,15);
		this.setFocusable(false);
	}
	
	public void incrementTime(double amount)
	{
		elapsedTime += amount;
	}
	//calculate new angle value
	public void calcNewAngle()
	{
		//angle = Math.abs(angle-0.1);
		angle = Math.abs(Math.acos( (getX()-xI)/(elapsedTime*vO) ));
	}
	//calculate newX
	public int calcNewX()
	{
		return getX() + dx;
		//return (int) (xI + (vO*Math.cos(angle)*elapsedTime));
	}
	//calculate newY
	public int calcNewY()
	{
		return (int) (yI + (vO*Math.sin(angle)));
		//return (int) (yI + (vO*Math.sin(angle)) - (0.5*g*Math.pow(elapsedTime, 2)) );
	}
	
	public void update()
	{
		this.setLocation(calcNewX(), calcNewY());
	}
	
	public void paintComponent(Graphics g)
	{
		//type casting to a Graphics2D object in the method
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		//using inherited method
		g2.draw(ball);
		g2.fill(ball);
		g2.draw(outline);
	}
}
