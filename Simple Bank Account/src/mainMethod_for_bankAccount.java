
public class mainMethod_for_bankAccount 
{

	public static void main(String[] args) 
	{
		//created to test the bankAccount class
		//creating 2 bankAccount objects 
		bankAccount acc1 = new bankAccount("Nick", 10);
		bankAccount acc2 = new bankAccount("John", 20, 0.0);
		
		//testing the methods
		//the deposit of 20.0 on both acc1 and acc2 should have the same effect
		acc1.deposit(20.0);
		System.out.println(acc1.getBalance());
		
		acc2.deposit(20.0);
		System.out.println(acc2.getBalance());
		
		//the withdraw of 20.0 on both acc1 and acc2 should have the same effect
		acc1.withdraw(10.0);
		System.out.println(acc1.getBalance());
		
		acc2.withdraw(15.0);
		System.out.println(acc2.getBalance());
		
		//checking to make sure the toString method works- should return string with all the fields
		System.out.println("acc1 field values: " + acc1.toString());
		System.out.println("acc2 field values: " + acc2.toString());
		

	}

}
