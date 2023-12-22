import java.util.Scanner;

public class CrackMeMain {

	public static void main(String[] args) 
	{
		//instantiating scanner and CrackMe object
		Scanner in = new Scanner(System.in);
		CrackMe crack1 = new CrackMe();
		
		//creating boolean variable which controls when game ends (true if guessed numbers combine to theCode)
		boolean codeGuessed = false;
		//variable to keep track of # of guesses left
		int guessesRemaining = 10;
		//variables to display guessed digits progress throughout game
		String digitProgress1 = "_";
		String digitProgress2 = "_";
		String digitProgress3 = "_";
		String allDigitProgress;
		//variable to store current guess and check against crackMe methods
		String guess;
		//variable to store guess as an int before its converted to string
		int numberGuess;
		
		/**
		 * asking user for guess, making sure its an int, checking each digit, displaying digits guessed ex.(1_9),
		 * displaying guessesRemaining, adding digit to digitProgress1-3 if guess in theCode, 
		 * ending game early if user guesses the code before all guesses used-- 10 times total
		 */
		
		while (codeGuessed == false && guessesRemaining != 0)
		{
			System.out.print("Guess a 3-digit number (greater than 100, less than 1000): ");
			if (in.hasNextInt())
			{
				numberGuess = in.nextInt();
				if (numberGuess >= 100 && numberGuess <= 999)
				{
					System.out.println("int included, and valid 3 digit number entered.");
					guess = "" + numberGuess;
					//checking begins
					if (crack1.checkFirstDigit(guess))
					{
						digitProgress1 = guess.substring(0, 1);
					}
					
					if (crack1.checkSecondDigit(guess))
					{
						digitProgress2 = guess.substring(1, 2);
					}
					
					if (crack1.checkThirdDigit(guess))
					{
						digitProgress3 = guess.substring(2);
					}
				}
				else
				{
					System.out.println("int included, 3 digit number not valid though.");
				}
			}
			else
			{
				System.out.println("Int not included, turn wasted.");
			}
			in.nextLine();
			guessesRemaining --;
			System.out.println("Guesses remaining: " + guessesRemaining);
			System.out.println(digitProgress1 + digitProgress2 + digitProgress3);
			allDigitProgress = digitProgress1 + digitProgress2 + digitProgress3;
			if (allDigitProgress.contains("_"))
			{
				codeGuessed = false;
			}
			else
			{
				codeGuessed = true;
			
			}
		}
		
		//END OF LOOP
		
		if (codeGuessed)
		{
			System.out.println("the code has been guessed. You win!");
		}
		else
		{
			System.out.println("You lose. The code was " + crack1.toString());
		}
		

	}

}
