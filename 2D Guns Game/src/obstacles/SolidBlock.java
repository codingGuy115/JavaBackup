package obstacles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

//I want this to be a Parent class for most obstacles.
public abstract class SolidBlock extends JComponent
{
	//fields
	private int dx;
	private int dy;
	private int blockWidth = 50;
	private int blockHeight = 50;
	private double startingHp;
	private double hitpoints; //>when updating healthBar, need to take PERCENTAGE of this
	private double hbarWidthVal = blockWidth-6;
	private Color color; //> might change this field to store an image for graphics instead
	private Rectangle2D.Double blockDrawing;
	private Rectangle2D.Double healthBarOutline;
	private Rectangle2D.Double healthBar;
	
	//constructors
	public SolidBlock(int x, int y)
	{
		this.setBounds(x, y, blockWidth+1, blockHeight+1);
		blockDrawing = new Rectangle2D.Double(0,0,blockWidth,blockHeight);
		healthBarOutline = new Rectangle2D.Double(2,2,blockWidth-4, 10);
		healthBar = new Rectangle2D.Double(3,3,(int)hbarWidthVal, 8);
	}

	//methods
	public double getHbarWidthVal()
	{
		return hbarWidthVal;
	}	
	
	//WHEN BLOCK GETS HIT
	public void takeDamage(double amount)
	{
		hitpoints -= amount;
		//updating value for actual width of visible Healthbar
		double HpPerPixel = startingHp / 44;
		hbarWidthVal = hitpoints / HpPerPixel;
		healthBar.setFrame(3, 3, hbarWidthVal, 8);
	}
	
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void update()
	{
		this.setLocation(getX() + dx, getY() + dy);
	}
	
	public void paintComponent(Graphics g)
	{
		//type casting to a Graphics2D object in the method
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		//using inherited method
		g2.draw(blockDrawing);
		g2.fill(blockDrawing);
		
		g2.setColor(Color.black);
		g2.draw(healthBarOutline);
		g2.setColor(Color.green);
		g2.draw(healthBar);
		g2.fill(healthBar);
	}

	public double getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(double hitpoints) {
		this.hitpoints = hitpoints;
	}

	public double getStartingHp() {
		return startingHp;
	}

	public void setStartingHp(double startingHp) {
		this.startingHp = startingHp;
	}
	
	

}
