import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Timer;

//this class is the same as a JFrame(has inherited methods), therefore we can say'this.method()'or just call them straight
public class TimerDemo extends JFrame implements ActionListener
{
	private int dx;
	private int dy;
	private JButton button;
	
	private boolean running;
	private Timer t;
	
	
	public TimerDemo()
	{
		this.setTitle("Motion Demo");
		this.setBounds(100, 100, 750, 500);
		this.setLayout(null);
		
		dx = 3;
		dy = 3;
		
		button  = new JButton("CLICK ME");
		button.setBounds(20, 20, 120, 40);
		button.setBackground(Color.GREEN);
		
		//making a black background color component
//		Background b = new Background();
//		this.add(b);
		
		t = new Timer(25, this);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//what i want to happen when the button is clicked
				if (!running)
				{
					t.start();
					running = true;
				}
				else
				{
					t.stop();
					running = false;
				}
				
			}
			
		});
		
		this.add(button);
		
		
		
		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//what I want to do every 25 milliseconds
		
		//set the insets (size of the borders)
		Insets insets = this.getInsets();
		//move the button 
		button.setLocation(button.getX()+dx, button.getY()+dy);
		
		//bounce off the right side
		if (button.getX() + button.getWidth() > this.getWidth() - insets.left - insets.right)
			dx *= -1;
		//bounce off the bottom
		if (button.getY() + button.getHeight() > this.getHeight() - insets.top - insets.bottom)
			dy *= -1;
		//bounce off the left side
		if (button.getX() <= 0)
			dx *= -1;
		//bounce off the top
		if (button.getY() <= 0)
			dy *= -1;
	}
	
	public static void main(String[] args)
	{
		new TimerDemo();
	}
	

}
