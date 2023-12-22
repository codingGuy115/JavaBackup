
public class car implements Paintable
{
	private int numSeats;
	private String color;
	
	public car(int numSeats, String color)
	{
		this.numSeats = numSeats;
		this.color = color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}

	public void paint(String color) 
	{
		this.color = color;
		
	}

}
