import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// -- EXAMPLE OF MULTITHREADING TO USE IN GAME

public class MultiThreadEx extends JFrame implements ActionListener {
    // Existing code...

    private boolean leftKeyPressed = false;
    private boolean rightKeyPressed = false;
    private boolean spaceKeyPressed = false;

    public MultiThreadEx() {
        // Existing code...

        // Adding key listener
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO: Handle keyTyped event if needed
            }

            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyReleased(e.getKeyCode());
            }
        });

        // Adding mouse listener
        this.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePressed(e);
            }

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });

        // Start a separate thread for handling input events
        Thread inputThread = new Thread(() -> {
            while (true) {
                processInput();
                try {
                    Thread.sleep(10); // Adjust the sleep time as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        inputThread.start();

        // Existing code...
    }

    // Methods to handle key and mouse events
    private void handleKeyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_A:
                leftKeyPressed = true;
                break;
            case KeyEvent.VK_D:
                rightKeyPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                spaceKeyPressed = true;
                break;
            // Handle other key events...
        }
    }

    private void handleKeyReleased(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_A:
                leftKeyPressed = false;
                break;
            case KeyEvent.VK_D:
                rightKeyPressed = false;
                break;
            case KeyEvent.VK_SPACE:
                spaceKeyPressed = false;
                break;
            // Handle other key events...
        }
    }

    private void handleMousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        // Handle mouse press event...
    }

    private void processInput() {
        // Process input events on this thread
        if (leftKeyPressed) {
            // Handle left key pressed
        }
        if (rightKeyPressed) {
            // Handle right key pressed
        }
        if (spaceKeyPressed) {
            // Handle space key pressed
        }
        // Process other input events...
    }

    // Existing code...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultiThreadEx());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}