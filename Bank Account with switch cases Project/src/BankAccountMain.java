import java.util.Scanner;

public class BankAccountMain 
{

	public static void main(String[] args) 
	{
		//Instantiating a bankAccount object to begin with
		BankAccount ba = new BankAccount(100, "Nick");
		
		//loop which will continuously ask user to choose from withdraw, deposit, get balance, or exit. (as long as response != exit), continue.
		String response = "";
		
		Scanner in = new Scanner(System.in);
		
		//boolean variable to control when the loop ends
		boolean running = true;
		
		while (running)
		{
			//asked each time
			System.out.println("Would u like to withdraw (w), deposit (d), get balance (g), or exit (e)?: ");
			response = in.next();
			in.nextLine();
			
			//performing task based on response USING SWITCH CASE
			switch (response)
			{
			case "w":
				//user wants to run withdraw method
				System.out.println("Enter amount to withdraw: ");
				ba.withdraw(in.nextDouble());
				in.nextLine();
				break;
			case "d":
				//user wants to run deposit method
				System.out.println("Enter amount to deposit: ");
				ba.deposit(in.nextDouble());
				in.nextLine();
				break;
			case "g":
				//user wants to run getBalance method
				System.out.println("Current balance for account under " + ba.getName() + ": \t" + ba.getBalance());
				break;
			case "e":
				//user entered "e", therefore they want to exit. set running to false
				running = false;
				break;
			default:
				//none of the keys entered, therefore user is a silly goose
				System.out.println("You should probably enter one of the valid keys if you want to accomplish anything...");
				break;
			}
			//hellottttt
			
		}

	}

}
