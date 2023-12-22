/**
 * This works and gives intended y-values (rounded as integers)
 * @author Nick
 *
 */
public class Testing 
{

	public static void main(String[] args) 
	{
		//testing a function of X. f(x)=a(x-h)^2+k - (vertex form of a parabola)
		int[] xValues = new int[50];
		int[] yValues = new int[50];
		
		int a = 1;
		int h = 2;
		int k = 3;
		
		int count = 0;
		while (count < 50)
		{
			xValues[count] = count;
			count++;
		}
		
		for (int x=0; x<xValues.length; x++)
		{
			int xVal = xValues[x];
			yValues[x] = a * ((xVal-h)*(xVal-h)) + k;
		}
		
		//printing all the results
		for (int i=0; i<50; i++)
		{
			System.out.println("X: "+xValues[i] + " Y: "+yValues[i]);
		}
		
	}

}

