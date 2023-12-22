
public class Dice 
{
	//fields 
	
	
	//constructors
	public Dice()
	{
		
	}
	
	//methods
	public int roll()
	{
		int num = (int)(Math.random() * 6 + 1);
		return num;
	}

}
