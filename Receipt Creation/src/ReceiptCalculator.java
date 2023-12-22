
public class ReceiptCalculator 
{
	//only using static methods for this, so they can be accessed without making an object in main class
	public static double calcSubtotal(double appetizerPrice, double entreePrice, double drinkPrice, double dessertPrice)
	{
		double subtotal = appetizerPrice + entreePrice + drinkPrice + dessertPrice;
		return subtotal;
	}
	
	public static double calcTax(double subtotal, double taxRate)
	{
		double calculatedTax = subtotal * taxRate;
		return calculatedTax;
		
	}

}
