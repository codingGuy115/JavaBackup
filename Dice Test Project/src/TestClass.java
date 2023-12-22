
public class TestClass 
{

	public static void main(String[] args) 
	{
		//first create two different Dice objects and store in variables
		Dice die1 = new Dice();
		Dice die2 = new Dice();
		
		//roll each dice several times, storing value in same variable for each and print 
		//first set of rolls (die1)
		int rollValue = die1.roll();
		System.out.println("Die1 value: " + rollValue);
		rollValue = die1.roll();
		System.out.println("Die1 value: " + rollValue);
		rollValue = die1.roll();
		System.out.println("Die1 value: " + rollValue);
		
		//second set of rolls (die2)
		rollValue = die2.roll();
		System.out.println("Die2 value: " + rollValue);
		rollValue = die2.roll();
		System.out.println("Die2 value: " + rollValue);
		rollValue = die2.roll();
		System.out.println("Die2 value: " + rollValue);
		
		//display number of times dice1 and dice2 were rolled
		System.out.println("Dice 1 was rolled " + die1.getNumRolls() + "times.");
		System.out.println("Dice 2 was rolled " + die2.getNumRolls() + "times.");
		
		//reset dice1 and display number of times each was rolled again
		die1.reset();
		System.out.println("Dice 1 was rolled " + die1.getNumRolls() + "times.");
		System.out.println("Dice 2 was rolled " + die2.getNumRolls() + "times.");
		


	}

}
