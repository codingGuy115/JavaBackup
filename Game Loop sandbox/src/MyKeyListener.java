import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

	private static MyKeyListener instance = null;
	
	private MyKeyListener() {
		
	}
	
	public static MyKeyListener get() {
		if (MyKeyListener.instance == null) {
			MyKeyListener.instance = new MyKeyListener();
		}
		return MyKeyListener.instance;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		switch(code) 
		{
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
