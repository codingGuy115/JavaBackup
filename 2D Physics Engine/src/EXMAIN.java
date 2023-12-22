import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class EXMAIN extends JFrame implements ActionListener
{
	//fields
	private JButton button;
	private Timer timer;
	private EX ball;
	
	//constructor - REMEMBER, this class IS the jFrame
	public EXMAIN()
	{
		this.setBounds(100, 100, 1100, 700);
		this.setTitle("2D Physics Engine");
		this.setLayout(null);
		
		button = new JButton("Start");
		button.setBounds(20, 20, 100, 50);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				timer.start();
			}
		});
		this.add(button);
		
		ball = new EX(100, 100);
		this.add(ball);

		timer = new Timer(25, this);
		
		
		//-----------
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//methods 
	// what i want to happen on each timer tick (implemented method from ActionListener interface)
	public void actionPerformed(ActionEvent e) 
	{ 
		ball.incrementTime(1);
		ball.update();
		if (ball.getElapsedTime() % 10==0)
			System.out.println("X:"+ball.getX()+ " Y:"+ball.getY());
		
		//checking if ball went off the screen
		if (ball.getY() > 700)
			System.out.println("Ball OOB: X:"+ball.getX()+" Y:"+ball.getY());
	}
	
	//creating new engineMain
	public static void main(String[] args) 
	{
		new EXMAIN();
	}
}
