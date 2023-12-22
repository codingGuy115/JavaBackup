import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class BallMain 
{

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Ball test");
		frame.setBounds(100,100,700,500);
		frame.setLayout(null);
		
		Ball ball = new Ball(200, 150);
		frame.add(ball);
		
		frame.addKeyListener(new KeyListener()  {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				
				switch(code)
				{
				// if i pressed the letter A
				case KeyEvent.VK_A:
					ball.setLocation(ball.getX()-5, ball.getY());
					break;
				case KeyEvent.VK_D:
					ball.setLocation(ball.getX()+5, ball.getY());
					break;
				case KeyEvent.VK_W:
					ball.setLocation(ball.getX(), ball.getY()-5);
					break;
				case KeyEvent.VK_S:
					ball.setLocation(ball.getX(), ball.getY()+5);
					break;
				
				}
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
