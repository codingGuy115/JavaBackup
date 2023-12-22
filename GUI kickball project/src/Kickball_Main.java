import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Kickball_Main 
{

	public static void main(String[] args) 
	{
		//creating the frame
		JFrame frame = new JFrame("Ball test");
		frame.setBounds(100,100,700,500);
		frame.setLayout(null);
		
		//creating the objects
		Man man = new Man(10, 10);
		frame.add(man);
		
		Ball ball = new Ball(100, 100);
		frame.add(ball);
		
		//creating the logic for the program
		
		//first need to make action listener
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			//THIS is the one we want to use
			public void keyPressed(KeyEvent e) 
			{
				//if this happens, a key has been pressed.
				// Want to ONLY control movements of man. The ball will move in accordance with this.
				
				int code = e.getKeyCode();
				
				//creating variables to make identifying sides of components easier
				//man sides
				int manTop = man.getY();
				int manBottom = man.getY() + man.getHeight();
				int manLeft = man.getX();
				int manRight = man.getX() + man.getWidth();
				
				//ball sides
				int ballTop = ball.getY();
				int ballBottom = ball.getY() + ball.getHeight();
				int ballLeft = ball.getX();
				int ballRight = ball.getX() + ball.getWidth();
				
				boolean collisionOccured = false;
				
				
				
				//making sure not out of bounds
				boolean OOB = false;
				if ((manLeft <= 1) || (manRight >= frame.getWidth()-20) || (manTop <= 1) || (manBottom >= frame.getHeight()-40))
				{
					OOB = true;
				}
				
				
				
				switch(code)
				{
				// LEFT
				case KeyEvent.VK_A:			
//					//move the man
					if (!OOB)
						man.setLocation(man.getX()-1, man.getY());
					else
						man.setLocation(man.getX()+1, man.getY());
					
					//if there was a collision put it next to the man without changing y
					//checking if there is collision
					if ((ballRight > manLeft) && (ballLeft < manRight) && (ballBottom > manTop) && (ballTop < manBottom))
					{
						//if this runs then a collision happened somewhere
						System.out.println("Collision detected"); //was there a collision
						collisionOccured = true;
					} 							//Experimenting with condition, trying to fix dragging effect
					if (collisionOccured && !(manRight>ballLeft))
					{
						System.out.println("hit on LEFT");
						//ball.setLocation(ball.getX()-5, ball.getY());
						ball.setLocation(manLeft - ball.getWidth()-2, ball.getY());
					}
					break;
					
				// RIGHT
				case KeyEvent.VK_D:
					if (!OOB)
						man.setLocation(man.getX()+1, man.getY());
					else
						man.setLocation(man.getX()-1, man.getY());
					
					if ((ballRight > manLeft) && (ballLeft < manRight) && (ballBottom > manTop) && (ballTop < manBottom))
					{
						//if this runs then a collision happened somewhere
						System.out.println("Collision detected"); //was there a collision
						collisionOccured = true;
					}
					if (collisionOccured)
					{
						System.out.println("hit on RIGHT");
						//ball.setLocation(ball.getX()+5, ball.getY());
						ball.setLocation(manRight+2, ball.getY());
					}
					break;
					
				// UP
				case KeyEvent.VK_W:		
					if (!OOB)
						man.setLocation(man.getX(), man.getY()-1);
					else
						man.setLocation(man.getX(), man.getY()+1);
					
					if ((ballRight > manLeft) && (ballLeft < manRight) && (ballBottom > manTop) && (ballTop < manBottom))
					{
						//if this runs then a collision happened somewhere
						System.out.println("Collision detected"); //was there a collision
						collisionOccured = true;
					}
					if (collisionOccured)
					{
						System.out.println("hit on TOP");
						//ball.setLocation(ball.getX(), ball.getY()-5);
						ball.setLocation(ball.getX(), manTop-ball.getHeight()-2);
					}
					break;
					
				// DOWN
				case KeyEvent.VK_S:		
					if (!OOB)
						man.setLocation(man.getX(), man.getY()+1);
					else
						man.setLocation(man.getX(), man.getY()-1);
					
					if ((ballRight > manLeft) && (ballLeft < manRight) && (ballBottom > manTop) && (ballTop < manBottom))
					{
						//if this runs then a collision happened somewhere
						System.out.println("Collision detected"); //was there a collision
						collisionOccured = true;
					}
					if (collisionOccured)
					{
						System.out.println("hit on BOTTOM");
						//ball.setLocation(ball.getX(), ball.getY()+5);
						ball.setLocation(ball.getX(), manBottom+2);
					}
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//last 2 lines
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
