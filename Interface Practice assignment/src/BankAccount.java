
public class BankAccount implements Measurable
{
	private int balance;
	
	public BankAccount(int balance)
	{
		this.balance = balance;
	}

	@Override
	public int getMeasure() 
	{
		return balance;
	}
	

}
