
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

public class Line extends JComponent
{
	private Rectangle2D line;
	
	public Line(int x, int y)
	{
		this.setBounds(x, y, 5, 40);
		line = new Rectangle2D.Double(0,0,14,79);
		this.setFocusable(false);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GRAY);
		g2.draw(line);	
		g2.fill(line);
	}
	

}
