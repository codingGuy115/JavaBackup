
public class CrackMe 
{
	//fields 
	private String theCode;
	
	//constructors
	public CrackMe()
	{
		theCode = "" + (int)(Math.random()*900 + 100);
		
	}
	
	//methods
	public boolean checkFirstDigit(String guess)
	{
		if ((guess.charAt(0)) == theCode.charAt(0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkSecondDigit(String guess)
	{
		if ((guess.charAt(1)) == theCode.charAt(1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkThirdDigit(String guess)
	{
		if ((guess.charAt(2)) == theCode.charAt(2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return theCode;
	}

}
