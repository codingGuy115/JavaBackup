import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

public class PongMain extends JFrame implements ActionListener
{
	//fields
	private Timer timer;
	private Ball ball; // -> this needs to be a field. Need to access it outside of constructor.
	private Paddle paddle1;
	private Paddle paddle2;
	private Scoreboard score1;
	private Scoreboard score2;
	
	//private WinMessage wmess;
	
	//constructor
	public PongMain()
	{
		this.setBounds(100, 100, 600, 500);
		this.setTitle("Pong Game Frame");
		this.setLayout(null);

		timer = new Timer(25, this);
		//starting timer. might want to change this if adding a 'game over' screen
		timer.start();
		
		//adding the ball to the center of frame
		ball = new Ball(280, 200);
		this.add(ball);
		ball.randomizeDirection();
		
		//adding paddles to screen
		paddle1 = new Paddle(18, 185);
		paddle2 = new Paddle(548, 185);
		this.add(paddle1);
		this.add(paddle2);
		
		//adding scoreboards
		score1 = new Scoreboard(130, -30);
		this.add(score1);
		score2 = new Scoreboard(410, -30);
		this.add(score2);
		
		//adding win message (universal)
		//wmess = new WinMessage();
		//this.add(wmess);
		
		//adding lines to screen
		Line line1 = new Line(280, 0);
		this.add(line1);
		Line line2 = new Line(280, 80);
		this.add(line2);
		Line line3 = new Line(280, 160);
		this.add(line3);
		Line line4 = new Line(280, 240);
		this.add(line4);
		Line line5 = new Line(280, 320);
		this.add(line5);
		Line line6 = new Line(280, 400);
		this.add(line6);
		Line line7 = new Line(280, 480);
		this.add(line7);
		
		//need key listener for w/s and up/down keys. allows for 2 players
		this.addKeyListener(new KeyListener() 
		{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) 
			{	
				int code = e.getKeyCode();
				switch(code)
				{
				//player 1
				case KeyEvent.VK_W:
					paddle1.setDy(-10);
					break;
				case KeyEvent.VK_S:
					paddle1.setDy(10);
					break;
				//player 2
				case KeyEvent.VK_UP:
					paddle2.setDy(-10);
					break;
				case KeyEvent.VK_DOWN:
					paddle2.setDy(10);
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				//set paddle velocity to 0
				int code = e.getKeyCode();
				switch(code)
				{
				//player 1
				case KeyEvent.VK_W:
					paddle1.setDy(0);
					break;
				case KeyEvent.VK_S:
					paddle1.setDy(0);
					break;
				//player 2
				case KeyEvent.VK_UP:
					paddle2.setDy(0);
					break;
				case KeyEvent.VK_DOWN:
					paddle2.setDy(0);
					break;
				}
			}
		
		});
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	// what i want to happen on each timer tick
	public void actionPerformed(ActionEvent e) 
	{
		Insets insets = this.getInsets();
		
		if (paddle1.getY() < 0)
		{
			paddle1.setLocation(18, 0);
			paddle1.update();
		}
		if (paddle1.getY() + paddle1.getHeight() >= getHeight() - insets.top - insets.bottom)
		{
			paddle1.setLocation(18, getHeight()-insets.top-insets.bottom - paddle1.getHeight());
			paddle1.update();
		}
		if (paddle2.getY() <= 0)
		{
			paddle2.setLocation(548, 0);
			paddle2.update();
		}
		if (paddle2.getY() + paddle2.getHeight() >= getHeight() - insets.top - insets.bottom)
		{
			paddle2.setLocation(548, getHeight()-insets.top-insets.bottom - paddle2.getHeight());
			paddle2.update();
		}
		
		//might need to replace with separate x and y movements
		ball.updateDx();
		//checking to see if ball hit paddles
		if (paddle1.getBounds().intersects(ball.getBounds()))
		{
			
			//System.out.println("paddle1 hit ball");
			ball.setDx((ball.getDx() * -1) );
			ball.update();
		}
		
		if (paddle2.getBounds().intersects(ball.getBounds()))
		{
			//System.out.println("paddle2 hit ball");
			ball.setDx((ball.getDx() * -1) );
			ball.update();
		}
		ball.updateDy();
		//checking to see if ball hit paddles
		if (paddle1.getBounds().intersects(ball.getBounds()))
		{
			
			//System.out.println("paddle1 should pass through ball.");
			ball.setDy((ball.getDy() * -1) );
			ball.update();
		}
		
		if (paddle2.getBounds().intersects(ball.getBounds()))
		{
			//System.out.println("paddle2 should pass through ball.");
			ball.setDy((ball.getDy() * -1) );
			ball.update();
		}
		
		
		//have to update both paddles as well
		paddle1.update();
		paddle2.update();
		
		//checking to see if either player won
		if (score1.getScore() == 10)
		{
			// PLAYER 1 WINS
			//System.out.println("here");
			//wmess.setMessage("PLAYER 1 WINS!!!");
			//wmess.repaint();
			
			score1.reset();
			score2.reset();
			score1.repaint();
			score2.repaint();
			timer.stop();
			ball.setLocation(280, 200);
			try {
				TimeUnit.SECONDS.sleep(3);
				System.out.println("this part");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			timer.start();
		}
		if (score2.getScore() == 10)
		{
			// PLAYER 2 WINS
			//wmess.setMessage("PLAYER 2 WINS!!!");
			//wmess.repaint();
			
			score1.reset();
			score2.reset();
			score1.repaint();
			score2.repaint();
			timer.stop();
			ball.setLocation(280, 200);
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			timer.start();
		}
			
		//now checking to see if ball hit wall
		//bounce off the right side
		if (ball.getX() + ball.getWidth() > this.getWidth() - insets.left - insets.right)
		{	
			//paddle1 should get a point. pause and reset ball back to (280, 200).
			ball.setLocation(280, 200);
			ball.randomizeDirection();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ball.setDx(ball.getDx() * -1);
			score1.addScore();
			score1.repaint();
		
		}
		//bounce off the left side
		if (ball.getX() <= 0)
		{
			//paddle2 should get a point. pause and reset ball back to (280, 200).
			ball.setLocation(280, 200);
			ball.randomizeDirection();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ball.setDx(ball.getDx() * -1);
			score2.addScore();
			score2.repaint();
		
		}
		
		//bounce off the bottom
		if (ball.getY() + ball.getHeight() > this.getHeight() - insets.top - insets.bottom)
			ball.setDy(ball.getDy() * -1);
		//bounce off the top
		if (ball.getY() <= 0)
			ball.setDy(ball.getDy() * -1);
		
		
		//checking to see if ball hit paddles
		if (paddle1.getBounds().intersects(ball.getBounds()))
		{
			
			//System.out.println("paddle1 hit ball");
			ball.setDx((ball.getDx() * -1) );
		}
		
		if (paddle2.getBounds().intersects(ball.getBounds()))
		{
			//System.out.println("paddle2 hit ball");
			ball.setDx((ball.getDx() * -1) );
		}
		
		
	}
	
	//creating new PongMain
	public static void main(String[] args) 
	{
		new PongMain();

	}

}
