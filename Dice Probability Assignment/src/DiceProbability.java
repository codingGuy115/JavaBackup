import java.util.Scanner;

public class DiceProbability 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		Dice die1 = new Dice();
		Dice die2 = new Dice();
		
		System.out.print("Input the number of times to roll the two dice: ");
		int numTimes = in.nextInt();
		in.nextLine();
		
		//array to keep track of number of times the sum (2-12) rolled
		int[] arr1 = new int[11];
		
		//variable to keep track of sum
		int val1;
		int val2;
		int sum = 0;
		
		for (int i = 0; i < numTimes; i ++)
		{
			val1 = die1.roll();
			val2 = die2.roll();
			sum = val1 + val2;
			
			if (sum == 2)
			{
				arr1[0] ++;
			}
			if (sum == 3)
			{
				arr1[1] ++;
			}
			if (sum == 4)
			{
				arr1[2] ++;
			}
			if (sum == 5)
			{
				arr1[3] ++;
			}
			if (sum == 6)
			{
				arr1[4] ++;
			}
			if (sum == 7)
			{
				arr1[5] ++;
			}
			if (sum == 8)
			{
				arr1[6] ++;
			}
			if (sum == 9)
			{
				arr1[7] ++;
			}
			if (sum == 10)
			{
				arr1[8] ++;
			}
			if (sum == 11)
			{
				arr1[9] ++;
			}
			if (sum == 12)
			{
				arr1[10] ++;
			}
		}
		
		//testing
		int index = 0;
		for (int i = 0; i < arr1.length; i++)
		{
			System.out.println("value at index " + index + " is: " + arr1[index]);
			index ++;
			
		}
		
		
		// for loop over
		int displayNum = 2;
		double probability = 0;
		int counter = 0;
		int currentNumber = 0;
		
		while (displayNum != 13)
		{
			currentNumber = arr1[counter];
			System.out.println("current number: " + currentNumber);
			probability = currentNumber / numTimes;

			System.out.print(displayNum + ":   " + arr1[counter] + "   " + "Experimental probability: ");
			System.out.printf("%6.4f", probability);
			System.out.println();
			displayNum ++;
			counter ++;
		}

	}

}
