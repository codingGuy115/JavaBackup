
public class bankAccount 
{
	//fields 
	private String name;
	private double balance;
	private int accountNumber;
	
	//constructors (allows for object to be created with different parameters 
	public bankAccount(String n, int aNum)
	{
		name = n;
		accountNumber = aNum;
		balance = 0.0;
		
	}
	
	public bankAccount(String n, int aNum, double bal)
	{
		name = n;
		accountNumber = aNum;
		balance = bal;
		
	}
	
	//methods 
	public void deposit(double depositAmount)
	{
		balance = balance + depositAmount;
		
	}
	
	public void withdraw(double withdrawAmount)
	{
		balance = balance - withdrawAmount;
		
	}
	
	public double getBalance()
	{
		return balance;
		
	}
	
	public String toString()
	{
		return "Name: " + name + " Balance: " + balance + " Account Number: " + accountNumber;
		
	}

}
