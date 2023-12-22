
import javax.swing.JComponent;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Font;

public class Scoreboard extends JComponent
{
	int score = 0;
	Font font;
	
	public Scoreboard(int x, int y)
	{
		this.setBounds(x, y, 80, 100);
		
		this.setFocusable(false);
	}
	
	public void paintComponent(Graphics g)
	{
		Font font = new Font("Serif", Font.BOLD, 60);
	    g.setFont(font);
	    g.drawString(""+ score,0,100);
	}
	
	public void reset()
	{
		this.score = 0;
	}
	
	public void addScore()
	{
		this.score++;
		this.paintComponent(getGraphics());
	}
	
	public int getScore()
	{
		return score;
	}

}
