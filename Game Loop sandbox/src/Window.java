import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.SwingConstants;

public class Window extends JFrame
{
	//fields
	private static JFrame jframe;
	private static int width;
	private static int height;
	private static String title;
	private Timer timer;
	private static Window window = null; //singleton
	private static boolean running;
	
	
	public Window()
	{
		this.width = 1100;
		this.height = 700;
		this.title = "Game Loop Sandbox";
	}
	
	public static Window get() {
		if (Window.window == null) {
			Window.window = new Window();
		}
		return Window.window;
	}
	
	public void run() {
		init();
		loop();
		System.out.println("Gameloop over.");
	}
	
	public static void init() {
		jframe = new JFrame();
		jframe.setBounds(100, 100, width, height);
		jframe.setTitle(title);
		jframe.setLayout(null);
		
		jframe.addKeyListener(new KeyListener() 
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
				case KeyEvent.VK_0:
				{	System.out.println("0 was typed.");
					running = false;
					break; }
				}
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				
			}
		
		});
		
		
		//-----------
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	
	public static void loop() {
		running = true;
		float beginTime = Time.
		
		while (running) {
		
		}
		
	}
	
	
	
	

}