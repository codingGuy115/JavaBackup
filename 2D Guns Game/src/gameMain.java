import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Game specific import statements 
import projectiles.Grenade;
import user_interface_components.GunDisplay;
import user_interface_components.SelectBar;
import environment.Ground;
import player.Player;

public class gameMain extends JFrame implements ActionListener
{
	
	private Timer timer;
	private double preserved_energy = 0.8;
	private int gravStrength = 1;
	private double maxDyValue;
	private boolean threshold;
	private int grenadeMaxRange = 20;
	//^^ above from the grenade OG code
	private Ground ground;
	private Player player;
	private ArrayList<Grenade> grenades;
	private GunDisplay gunDisplay;
	private SelectBar sb1;
	private SelectBar sb2;
	private String[] guns = {"Pistol", "Shotgun", "Grenade Launcher"};
	
	
	public gameMain()
	{
		grenades = new ArrayList<Grenade>();
		
		this.setBounds(100, 100, 1300, 600);
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setTitle("Grenade Launcher Game!");
		
		player = new Player(10, 10);
		this.add(player);
		player.setJumpHeld(false);
		player.setFireHeld(false);
		player.setGunHeld("Pistol");
		
		ground = new Ground(0, 512, 1300, 50, Color.BLACK);
		this.add(ground);
		
		gunDisplay = new GunDisplay(200, 20, 200, 60);
		this.add(gunDisplay);
		sb1 = new SelectBar(200, 8, 60, 10);
		this.add(sb1);
		sb2 = new SelectBar(200, 81, 60, 10);
		this.add(sb2);
		
		timer = new Timer(25, this);
		timer.start();
		
		/**
		 * NEED TO MULTITHREAD THESE MOUSE AND KEY EVENTS
		 */
		// -- ADDING MOUSE LISTENER (to the frame itself)
		this.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent e)
			{
//				int code = e.getID();
//				switch(code)
//				{
//				case MouseEvent.BUTTON1:
//					System.out.println("left click");
//					break;
//				case MouseEvent.BUTTON2:
//					System.out.println("Right click");
//				}
			}
			public void mouseReleased(MouseEvent e)
			{
				
			}
			public void mouseEntered(MouseEvent e)
			{
				
			}
			public void mouseExited(MouseEvent e)
			{
				
			}
			
			public void mouseClicked(MouseEvent e)
			{
				if (player.getGunHeld().equals("Grenade Launcher"))
				{
					int mouseX = e.getX();
					int mouseY = e.getY();
					double dx = 0;
					double dy = 0;
					double distX = (player.getX()+player.getWidth()) - mouseX;
					double distY = player.getY() - mouseY;
					
				// -- WILL HAVE TO LIMIT RANGE LATER 
					dx= -((player.getX()+player.getWidth()) - mouseX)/11;
					dy = -(player.getY() - mouseY)/11;	
					
					grenades.add(0, new Grenade(player.getX()+player.getWidth(), player.getY(), (int)dx, (int)dy));
					add(grenades.get(0));
				}
			}
		});
		//adding keyListener
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
				case KeyEvent.VK_A:
					player.setDx(-3);
					break;
				case KeyEvent.VK_D:
					player.setDx(3);
					break;
				case KeyEvent.VK_SPACE:
					if (!player.isJumpHeld() && player.getJumps() == 1)
					{
						player.setDy(-20);
						player.setGrounded(false);
						player.setJumpHeld(true);
						player.setJumps(0);
					}
					break;
			// -- EVENTUALLY SWITCHING TO MOUSE LISTENER
//				case KeyEvent.VK_K:
//					if (!player.isFireHeld())
//					{
//						player.setFireHeld(true);
//						grenades.add(0, new Grenade(player.getX()+player.getWidth(), player.getY()));
//						add(grenades.get(0));
//					}
//					break;
				case KeyEvent.VK_S:
				{
					//handling gun swaps
					if (sb1.getCurrentPos()==3)
					{
						sb1.setCurrentPos(1);
						sb1.setLocation(200, sb1.getY());
						sb2.setLocation(200, sb2.getY());
					}
					else
					{
						sb1.setCurrentPos(sb1.getCurrentPos()+1);
						sb1.setLocation(sb1.getX()+70, sb1.getY());
						sb2.setLocation(sb2.getX()+70, sb2.getY());
					}
					player.setGunHeld(guns[sb1.getCurrentPos()-1]);
					System.out.println("gun: " + player.getGunHeld());
					break;
				}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				int code = e.getKeyCode();
				switch(code)
				{
				case KeyEvent.VK_A:
					player.setDx(0);
					break;
				case KeyEvent.VK_D:
					player.setDx(0);
					break;
				case KeyEvent.VK_SPACE:
					player.setJumpHeld(false);
					break;
			// -- EVENTUALLY SWITCHING TO MOUSE LISTENER
//				case KeyEvent.VK_K:
//					player.setFireHeld(false);
//					break;
					
				}
			}
		
		});
				
		player.setGrounded(false);
		
		//-last 3 lines
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	

	/**
	 * EACH TIMER TICK
	 */
	public void actionPerformed(ActionEvent e) 
	{
		this.repaint();
		player.update();
		
		if (!player.isGrounded())
		{	// changing the rate of change
			player.setDy(player.getDy() + gravStrength);
			//easier way to see if it intersects
			if (player.getBounds().intersects(ground.getBounds()))
			{
				player.setDy(0);
				player.setJumps(1);
				System.out.println("Player touched ground.");
				//ensures player will land directly on ground
				player.setLocation(player.getX(), ground.getY() - player.getHeight());
				player.setGrounded(true);
			}
		}
		//updating grenades
		for (Grenade g: grenades)
		{
			g.update();
			g.setDy(g.getDy() + gravStrength);
			
		}
		
	}
	
	//MAIN
	public static void main(String[] args) 
	{
		new gameMain();

	}
}