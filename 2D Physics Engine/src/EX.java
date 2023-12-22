import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

public class EX extends JComponent
{
	//fields 
	private int yI;
	private int xI;
	private int dx=7;
	private int dy=-1;
	private double downwardsAccel = -1;
	private int elapsedTime = 0;
	
	//math related
	private int a = 2;
	private int h = 50;
	private int k = 50;
	
	private Color color;
	private Ellipse2D.Double ball;
	private Rectangle2D outline;
	
	public EX(int x, int y)
	{
		yI = y;
		xI = x;
		this.color = Color.BLUE;
		this.setBounds(x, y, 16, 16);
		ball = new Ellipse2D.Double(0, 0, 15, 15);
		outline = new Rectangle2D.Double(0,0,15,15);
		this.setFocusable(false);
	}
	
	public void incrementTime(int time)
	{
		elapsedTime += time;
	}
	public int getElapsedTime()
	{
		return elapsedTime;
	}
	
	public void setColor(Color c){
		color = c;}
	
	public void setDx(int dx){
		this.dx = dx;}
	
	public void setDy(int dy){
		this.dy = dy;}
	//parabola motion should be implemented here 
	public void update()
	{
		//int newY = (int)(0.5*downwardsAccel)*getX()^2 + dy*getX();
		//int newY = (a*((elapsedTime-h)*(elapsedTime-h)) + k) / 5;
		int newY = 500-((a*((elapsedTime-h)*(elapsedTime-h)) + k) / 5);
		this.setLocation(getX() + dx, 700-newY);
		//????????
	}
	
	public int getDx(){
		return dx;}
	
	public int getDy(){
		return dy;}
	
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
