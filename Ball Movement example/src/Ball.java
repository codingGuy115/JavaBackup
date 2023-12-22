import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball extends JComponent
{
	private Ellipse2D.Double ball;
	//private Ellipse2D.Double ball1;
	
	public Ball(int x, int y)
	{
		this.setBounds(x, y, 11, 11);
		ball = new Ellipse2D.Double(0, 0, 10, 10);
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//Graphics2D g3 = (Graphics2D) ga;
		
		g2.draw(ball);
		//g3.draw(ball1);
		
		
	}
	
	

}
