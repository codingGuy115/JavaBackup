
public class BankAccount 
{
	//fields
	private double balance;
	private String name; 
	
	//constructors
	public BankAccount(double balance, String name)
	{
		this.name = name;
		this.balance = balance;
	}
	
	//methods - first 2 are setters
	
	//deposit method
	public void deposit(double amount) throws IllegalArgumentException
	{
		if(amount <= 0)
		{
			throw new IllegalArgumentException("Invalid argument: You cannot deposit 0 or less than 0.");
		}
		else 
		{
			balance += amount;
		}
	}
	
	//withdraw method
	public void withdraw(double amount) throws InsufficientBalanceException
	{
		if (amount <= 0)
		{
			throw new IllegalArgumentException("Invalid argument: You cannot withdraw 0 or less than 0.");
		}
		else if(amount > balance)
		{
			throw new InsufficientBalanceException("InsufficientBalanceException: Amount is more than the balance.");
		}
		else
		{
			balance -= amount;
		}
	}
	
	//getBalance() getter method
	public double getBalance()
	{
		return balance;
	}
	
	public String getName()
	{
		return name;
	}

}
