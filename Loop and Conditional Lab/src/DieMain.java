import java.util.Scanner;

/**
 * 
 * @author 	YOUR NAME HERE
 * 
 * MULTI SIDED DIE MAIN
 *
 */
public class DieMain 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		/*
		 * TASK ONE
		 * 
		 * create two twelve sided dice and
		 * roll the dice until you roll doubles
		 * (print each roll to the screen).
		 * Once you have rolled doubles, print
		 * to the screen the number of times
		 * you had to roll the dice to get doubles
		 * 
		 */
		System.out.println("***TASK ONE***\n**************");
		
		MultiSidedDie die1 = new MultiSidedDie(12);
		MultiSidedDie die2 = new MultiSidedDie(12);
		
		boolean doublesAchieved = false;
		int rollCount = 0;
		int firstRoll = 0;
		int secondRoll = 0;
		
		while (! doublesAchieved)
		{
			rollCount ++;
			firstRoll = die1.roll();
			secondRoll = die2.roll();
			System.out.println("Die1 roll: " + firstRoll + " Die2 roll: " + secondRoll);
			
			if (firstRoll == secondRoll)
			{
				doublesAchieved = true;
			}
			
		}
		System.out.println("It took " + rollCount + " rolls to get doubles.");
		
		/*
		 * TASK TWO
		 * 
		 * ask the user to enter the number of sides
		 * they would like to have on their dice and
		 * construct the appropriate Die object (only one).
		 * 
		 * ask the user to identify a target roll 
		 * value(ensure that it is between 1 and numSides).
		 * Roll the Die 20 times, printing
		 * each roll.  Print the number of times the
		 * target was rolled
		 *
		 */
		System.out.println("***TASK TWO***\n**************");
		
		System.out.print("Enter the number of sides you want on your dice: ");
		int desiredSides = in.nextInt();
		in.nextLine();
		MultiSidedDie die3 = new MultiSidedDie(desiredSides);
		
		System.out.print("Enter a target roll value (1 - " + die3.getNumSides() + "): ");
		int targetRoll = in.nextInt();
		in.nextLine();
		while (targetRoll < 1 || targetRoll > die3.getNumSides())
		{
			System.out.print("Wrong. Please enter a target roll value (1 - " + die3.getNumSides() + "): ");
			targetRoll = in.nextInt();
			in.nextLine();
		}
		System.out.println("Valid target value entered. Proceed.");
		
		int rollsLeft = 20;
		int timesTargetRolled = 0;
		int thirdRoll = 0;
		
		while (rollsLeft != 0)
		{
			thirdRoll = die3.roll();
			System.out.println(thirdRoll);
			rollsLeft --;
			if (thirdRoll == targetRoll)
			{
				timesTargetRolled ++;
			}
		}
		System.out.println("Number of times target rolled: " + timesTargetRolled);
		

		/*
		 * TASK THREE
		 * 
		 * As in task two, ask the user to identify the number
		 * of sides for the Die object and construct the 
		 * appropriate Die.  Ask the user to identify a target
		 * roll value(ensure that it is a valid entry).  
		 * Roll the die until you the target is rolled.  Print
		 * each roll.   Print the number of rolls required to 
		 * roll the target value.
		 */
		System.out.println("***TASK THREE***\n**************");
		
		System.out.print("Enter the number of sides you want on your dice: ");
		desiredSides = in.nextInt();
		in.nextLine();
		MultiSidedDie die4 = new MultiSidedDie(desiredSides);
		
		System.out.print("Enter a target roll value (1 - " + die4.getNumSides() + "): ");
		targetRoll = in.nextInt();
		in.nextLine();
		while (targetRoll < 1 || targetRoll > die4.getNumSides())
		{
			System.out.print("Wrong. Please enter a target roll value (1 - " + die4.getNumSides() + "): ");
			targetRoll = in.nextInt();
			in.nextLine();
		}
		System.out.println("Valid target value entered. Proceed.");
		
		int counter = 0;
		int fourthRoll = 0;
		
		while (fourthRoll != targetRoll)
		{
			fourthRoll = die4.roll();
			System.out.println(fourthRoll);
			counter ++;
		}
		System.out.println("It took " + counter + " rolls to get the target roll of " + targetRoll + ".");
		
	}

}
