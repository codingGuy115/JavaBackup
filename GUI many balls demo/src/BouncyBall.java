import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Insets;


public class BouncyBall extends JFrame implements ActionListener 
{
	
	private int dx;
	private int dy;
	private Timer timer;
	private ArrayList<Ball> balls;
	private Color[] colors;
	
	public BouncyBall()
	{
		this.setBounds(100, 100, 600, 500);
		this.setTitle("Bouncing ball");
		this.setLayout(null);
		
		dx = 3;
		dy = 3;
		timer = new Timer(25, this);
		
		balls = new ArrayList<Ball>();
		//adding ball at random location
		balls.add(new Ball((int)(Math.random()*100), (int)(Math.random()*100)));
		this.add(balls.get(0));
		Color[] c = {Color.red, Color.blue, Color.gray, Color.yellow};
		colors = c;
		
		timer.start();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Insets insets = this.getInsets();
		//checking to see if each ball has hit edge of screen
		for (int i = 0; i < balls.size(); i++)
		{
			Ball b = balls.get(i);
			b.update();
		
		
			//collision stuff
			
			if (b.getX() < 0)
				{
					b.setDx(b.getDx() * -1);
					b.setColor(this.colors[(int)(Math.random() * 4)]);
					Ball b2 = new Ball((int)(Math.random()*100), (int)(Math.random()*100));
					balls.add(b2);
					this.add(b2);
				}
			else if(b.getX() + b.getWidth() > this.getWidth() - insets.left - insets.right)
				{
					b.setDx(b.getDx() * -1);
					b.setColor(this.colors[(int)(Math.random() * 4)]);
				}
			
			if (b.getY() < 0)
				{
					b.setDy(b.getDy() * -1);
					balls.get(0).setColor(this.colors[(int)(Math.random() * 4)]);
				}
			else if (b.getY() + b.getHeight() > this.getHeight() - insets.top - insets.bottom)
				{
					b.setDy(b.getDy() * -1);
					b.setColor(this.colors[(int)(Math.random() * 4)]);
				}
		}
		
	}
	
	//MAIN
	public static void main(String[] args)
	{
		new BouncyBall();
	}

}
