
public class Dice 
{
	//fields
	private int numRolls;
	
	//constructors
	public Dice()
	{
		numRolls = 0;
	}
	
	//methods
	public int roll()
	{
		numRolls = numRolls + 1;
		return (int)(Math.random()*6 + 1);
		
	}
	
	public int getNumRolls()
	{
		return numRolls;
	}
	
	public void reset()
	{
		numRolls = 0;
	}

}
