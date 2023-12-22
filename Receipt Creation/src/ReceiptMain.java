import java.util.Scanner;

public class ReceiptMain 
{
	//creating constant for sales tax rate
	final static double TAX_RATE = 0.06;

	public static void main(String[] args) 
	{
		//creating scanner object
		Scanner in = new Scanner(System.in);
		
		//getting input values for name of and price of (appetizer, entree, drink, dessert)
		//appetizer
		System.out.print("Appetizer: ");
		String appName = in.nextLine();
		
		System.out.print("Appetizer price: $ ");
		double appPrice = in.nextDouble();
		in.nextLine();
		
		//entree
		System.out.print("Entree: ");
		String entName = in.nextLine();
		
		System.out.print("Entree price: $ ");
		double entPrice = in.nextDouble();
		in.nextLine();
		
		//drink
		System.out.print("Drink: ");
		String drinkName = in.nextLine();
		
		System.out.print("Drink price: $ ");
		double drinkPrice = in.nextDouble();
		in.nextLine();
		
		//dessert
		System.out.print("Dessert: ");
		String desName = in.nextLine();
		
		System.out.print("Dessert price: $ ");
		double desPrice = in.nextDouble();
		in.nextLine();
		
		//calling the method to get the subtotal
		double subTotal = ReceiptCalculator.calcSubtotal(appPrice, entPrice, drinkPrice, desPrice);
		
		//calling method to get the tax
		double tax = ReceiptCalculator.calcTax(subTotal, TAX_RATE);
		
		double completeTotal = subTotal + tax;
		
		//'printing' the receipt - TO CONSOLE (39 *s)
		System.out.printf(appName + "%20.2f", appPrice);
		System.out.println();
		System.out.printf(entName + "%20.2f", entPrice);
		System.out.println();
		System.out.printf(drinkName + "%20.2f", drinkPrice);
		System.out.println();
		System.out.printf(desName + "%20.2f", desPrice);
		System.out.println();
		System.out.print("Subtotal");
		System.out.printf("%20.2f", subTotal);
		System.out.println();
		System.out.print("Tax(6%)");
		System.out.printf("%20.2f", tax);
		System.out.println();
		System.out.println("***************************************");
		System.out.println();
		System.out.print("Total");
		System.out.printf("%20.2f", completeTotal);

	}

}
