import javax.swing.JComponent;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Font;

public class WinMessage extends JComponent
{
	String message = "";
	Font font;
	
	public WinMessage()
	{
		this.setBounds(200, 200, 200, 100);
		
		this.setFocusable(false);
	}
	
	public void paintComponent(Graphics g)
	{
		Font font = new Font("Serif", Font.BOLD, 40);
	    g.setFont(font);
	    g.setColor(Color.YELLOW);
	    g.drawString(message, 20, 20);
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}

}
