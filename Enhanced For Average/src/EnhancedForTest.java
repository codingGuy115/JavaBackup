
public class EnhancedForTest 
{
	//static method called findAverage (use forEach loop)
	public static double findAverage(int[] arr)
	{
		int total = 0;
		for(int a: arr)
		{
			total += a;
		}
		double average = total*1.0 / arr.length;
		return average;
	}
	
	
	//static method called findMinVal (use for Each loop)
	public static int findMinVal(int[] arr)
	{
		int min = arr[0];
		for(int a: arr)
		{
			if (a < min)
			{
				min = a;
			}
		}
		return min;
	}
	

	//main method to create int array of length 20, initialize each index of array to random integer 1-100, 
	//then call findMinVal and findAverage and display the results
	public static void main(String[] args)
	{
		int[] arr1 = new int[20];
		for (int i = 0; i<20; i++)
		{
			arr1[i] = (int)(Math.random()*100+1);
			
		}
		
		System.out.println("findMinVal: " + EnhancedForTest.findMinVal(arr1));
		System.out.println("findAverage: " + EnhancedForTest.findAverage(arr1));
	}
	

}
