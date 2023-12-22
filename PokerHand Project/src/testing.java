
public class testing 
{

	public static void main(String[] args) 
	{
		int[] hand = {2, 2, 1, 1, 1};
		int valueCheck;
		
		valueCheck = hand[0];
		int sameVal1 = 0;
		int sameVal2 = 0;
		int sameVal3 = 0;
		boolean allSame = true;
		
		for (int i = 0; i<5; i++)
		{
			if (hand[i] != valueCheck)
			{
				allSame = false;
			}
		}
		
		if (allSame)
		{
			System.out.println("all the same");
		}
		else
		{
			//index 0-2
			for (int i = 0; i<5; i++)
			{
				if (hand[i] == valueCheck)
				{
					sameVal1 ++;
				}
				
			}
			
			//index 1-3
			valueCheck = hand[1];
			for (int i = 1; i<5; i++)
			{
				if (hand[i] == valueCheck)
				{
					sameVal2 ++;
				}
		
			}
			
			//index 2-4
			valueCheck = hand[2];
			for (int i = 2; i<5; i++)
			{
				if (hand[i] == valueCheck)
				{
					sameVal3 ++;
				}
		
			}
			
			System.out.println("Sameval1: " + sameVal1 + "\n Sameval2: " + sameVal2 + " \n Sameval3: " + sameVal3);
			int total = sameVal1 + sameVal2 + sameVal3;
			if (total == 5 || total == 6 || total == 7)
			{
				System.out.println("Three of a kind");
			}
		}

	}

}
