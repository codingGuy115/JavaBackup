import java.util.Scanner;

public class phoneNumberAssignment 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter your first and last name: ");
		String name = in.nextLine();
		
		System.out.print("Enter your phone number in the format xxxxxxxxxx: ");
		String phoneNumber = in.next();
		
		//have to manipulate the data now in order to format name as new string
		//finding length of name string
		int length = name.length();
		//finding the first space
		int spaceIndex = name.indexOf(" ");
		//taking the first name from the name string 
		String firstName = name.substring(0, spaceIndex);
		//taking the last name from the name string
		String lastName = name.substring(spaceIndex + 1, length);
		
		//manipulating the phone number
		String first3dig = phoneNumber.substring(0, 3);
		String sec3dig = phoneNumber.substring(3, 6);
		String last3dig = phoneNumber.substring(6);
		
		//console output
		
		System.out.print(lastName + ", " + firstName + "        (" + first3dig + ") " + sec3dig + "- " + last3dig);
		

	}

}
