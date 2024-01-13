import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Here's how it works: Code runs every 25ms in the timer method. The dy is how much the ball changes from 
 * it's current location. I add 1 to this value every timer tick. this is essentially simulating gravity. 
 * (Being the rate at which the speed changes) From there we can use independence of motions to simulate
 * projectile motion. 
 * @author Nicholas 
 *
 */
public class GravityFrame extends JFrame implements ActionListener
{
	
	private JButton ground;
	private gravBall gball;
	private Timer timer;
	//when multiplying by Dy, gets 80 percent of the dy
	private double preserved_energy = 0.8;
	//keeping track of MIN dy value
	private double maxDyValue;
	private boolean threshold;
	
	public GravityFrame()
	{
		maxDyValue = -100;
		threshold = false;
		
		this.setBounds(100, 100, 1300, 600);
		this.setLayout(null);
		this.setTitle("Gravity demo");
		
		ground =new JButton("-------------------------");
		ground.setBounds(0,500,1300,50);
		this.add(ground);
		
		gball = new gravBall(193, 100);
		//gball = new gravBall(193,400);
		this.add(gball);
		//gball.setInStasis(true);
		//gball.setDy(-24);
		gball.setDx(3);
		
		timer = new Timer(25, this);
		timer.start();
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//checking if the threshold is reached
		if (maxDyValue > -17)
		{
			threshold = true;
			//System.out.println("Threshold reached.");
		}
		
		/**if this is true, basically it means the value for the ball to bounce up(negative bc of frame axis)
		 * is small enough to be considered zero. 
		 */
		if(maxDyValue > -0.3)
		{
			gball.setLocation(gball.getX(), ground.getY() - gball.getHeight());
			gball.setInStasis(true);
		}
		//updating the ball
		gball.update();
			
		if (!gball.isInStasis())
		{	// changing the rate of change
			gball.setDy(gball.getDy() + 1);
			System.out.println("Ball dy:"+gball.getDy());
			//easier way to see if it intersects
			if (gball.getBounds().intersects(ground.getBounds()))
			{
				//System.out.println(gball.getDy());
				//this line ensures ball will bounce directly from the ground
				gball.setLocation(gball.getX(), ground.getY() - gball.getHeight());
				
				if (!threshold)
					gball.setDy(gball.getDy() * -preserved_energy);
				else
				{
					preserved_energy -= 0.15;
					gball.setDy(gball.getDy() * -preserved_energy);
				}
				//directly at this moment, there is a dy MIN, bc ball moves fastest
				if (gball.getDy() > maxDyValue)
				{
					maxDyValue = gball.getDy();
				}
				System.out.println(maxDyValue);
			}
		}
	}
	
	//MAIN
	public static void main(String[] args) 
	{
		new GravityFrame();

	}
}