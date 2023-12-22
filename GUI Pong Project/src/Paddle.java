import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

public class Paddle extends JComponent
{
	private Rectangle2D paddle;
	private int dx = 0;
	//should be the only one changing
	private int dy = 0;
	private boolean idle;
	
	public Paddle(int x, int y)
	{
		this.setBounds(x, y, 15, 80);
		paddle = new Rectangle2D.Double(0,0,14,79);
		this.setFocusable(false);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.draw(paddle);	
		g2.fill(paddle);
	}
	
	//getter and setter for dx
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	//getter and setter for dy
	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	//update method
	public void update()
	{
		this.setLocation(getX() + dx, getY() + dy);
	}

	public boolean isIdle() {
		return idle;
	}

	public void setIdle(boolean idle) {
		this.idle = idle;
	}

}
