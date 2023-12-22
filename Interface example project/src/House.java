
public class House implements Paintable
{
	private int numBedrooms;
	private int numBathrooms;
	private String color;
	
	//constructors
	public House(int numBedrooms, int numBathrooms, String color)
	{
		this.numBedrooms = numBedrooms;
		this.numBathrooms = numBathrooms;
		this.color = color;
	}
	
	//methods
	public void setColor(String color)
	{
		this.color = color;
	}

	public void paint(String color) 
	{
		this.color = color;
		
	}

}
