package Visual_Testing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * going to try and make a frame with a jLabel that i can put an image in and turn certain parts transparent
 *
 */
public class VTMain extends JFrame implements ActionListener
{
	//fields
	private Timer timer;
	private JLabel label;
	private ImageIcon imageIcon;
	private Image firstImage;
	
	
	//constructor
	// remember: we ARE the frame
	public VTMain()
	{
		this.setBounds(100, 100, 500, 500);
		this.setTitle("Image Transparency test");
		this.setLayout(null);

		label = new JLabel();
        ImageIcon imageIcon = new ImageIcon("/2D Physics Engine/Photos/dots.PNG");  // Replace with your image path
        Image image = imageIcon.getImage();
        //Image newImage = makeTransparent(image, Color.BLACK);  // Function to make parts transparent
        label.setIcon(imageIcon);
        label.setLocation(10, 10);
        
        this.add(label);
        System.out.println(label.getIcon().getIconHeight());
		
		timer = new Timer(25, this);
		timer.start();
		
		//-----------
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	//each timer tick
	public void actionPerformed(ActionEvent e) 
	{
		
		
	}

	public static void main(String[] args) 
	{
		new VTMain();
	}
	
	// method to cycle thru the pixels and change a target color to transparent
	public static Image makeTransparent(Image image, Color targetColor)
	{
		BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

	    for (int i = 0; i < bufferedImage.getHeight(); i++) 
	    {
	        for (int j = 0; j < bufferedImage.getWidth(); j++) 
	        {
	            int pixel = bufferedImage.getRGB(j, i);
	            Color color = new Color(pixel, true);  // Get the color of the pixel

	            // Check if the pixel color matches the target color (e.g., white)
	            if (color.equals(targetColor)) {
	                bufferedImage.setRGB(j, i, 0x00FFFFFF);  // Set the pixel to fully transparent
	            }
	        }
	    }
	    //returning modified image
	    return bufferedImage;
	}
}
