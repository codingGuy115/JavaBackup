

public class CrackMeClassTest {

	public static void main(String[] args) 
	{
		CrackMe crackMe= null;
		try {
		 crackMe = new CrackMe();
		}
		catch(Exception e)
		{
			System.out.println("constructor incorrect");
			System.exit(0);
		}
		 
		String pin = null;
		try {
			pin = crackMe.toString();
			if(pin.length() != 3)
			{
				System.out.print("toString not returning appropriate value.  Return only the pin");
				System.exit(0);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("toString not working appropriately.");
			System.exit(0);
		}
		
		String first = pin.substring(0,1);
		String second = pin.substring(1,2);
		String third = pin.substring(2,3);
		String incorrectFirst = ((Integer.parseInt(first) + 1)%10) + "";
		String incorrectSecond = ((Integer.parseInt(second) + 1)%10) + "";
		String incorrectThird = ((Integer.parseInt(third) + 1)%10) + "";
		
		String guess = first+second+third;
		String guessInc = incorrectFirst+incorrectSecond+incorrectThird;
		
		if(crackMe.checkFirstDigit(guess))
			System.out.println("correct guess checkFirstDigit: pass");
		else
			System.out.println("correct guess checkFirstDigit: fail");
		
		if(!crackMe.checkFirstDigit(guessInc))
			System.out.println("incorrect guess checkFirstDigit: pass");
		else
			System.out.println("incorrect guess checkFirstDigit: fail");
		
		
		if(crackMe.checkSecondDigit(guess))
			System.out.println("correct guess checkSecondDigit: pass");
		else
			System.out.println("correct guess checkSecondDigit: fail");
		
		if(!crackMe.checkSecondDigit(guessInc))
			System.out.println("incorrect guess checkSecondDigit: pass");
		else
			System.out.println("incorrect guess checkSecondDigit: fail");
		
		
		if(crackMe.checkThirdDigit(guess))
			System.out.println("correct guess checkThirdDigit: pass");
		else
			System.out.println("correct guess checkThirdDigit: fail");
		
		if(!crackMe.checkThirdDigit(guessInc))
			System.out.println("incorrect guess checkThirdDigit: pass");
		else
			System.out.println("incorrect guess checkThirdDigit: fail");
		
	}

}
