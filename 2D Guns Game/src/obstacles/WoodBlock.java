package obstacles;

import java.awt.Color;

/**
 * Think about making a JPanel to keep all the obstacles moving together
 * @author Nicholas
 *
 */
public class WoodBlock extends SolidBlock
{
	public WoodBlock(int x, int y, Color color)
	{
		super(x, y);
		this.setColor(color);   /**>because the size of all blocks will be uniform, there is no need for an 
		 						override of anything EXCEPT the color (which will eventually be the graphics picture)*/
		this.setStartingHp(50);
		this.setHitpoints(50);
		this.setFocusable(false);
		
	}

}
