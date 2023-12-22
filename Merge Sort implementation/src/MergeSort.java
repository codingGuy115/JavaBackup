import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args)
	{
		int[] start = new int[100];
		for(int i = 0; i < start.length; i++)
		{
			start[i] = (int)(Math.random()*20 + 1);
		}
		int[] sorted = Arrays.copyOf(start,start.length);
		//check
		System.out.println("Original at start: " + Arrays.toString(start));
		
		Arrays.sort(sorted);
		mergesort(start);
		
		//check
		System.out.println("Original at end: " + Arrays.toString(start));
		
		if(Arrays.equals(start, sorted))
			System.out.print("correctly sorted");
		else
			System.out.print("not properly sorted");
	}
	
	/*
	 * implement the mergesort method.  It should be a recursive
	 * implementation of the mergesort algorithm we spoke about
	 * in class.  If you run this main method it will tell you 
	 * if your algorithm properly sorted the array.  You do not 
	 * need to add any code to the main method.
	 */
	
	public static void mergesort(int[] arr)
	{
		//will continue as long as the arr argument is greater than 1, bc cannot split array of size 1
		if (arr.length > 1)
		{
			// CODE HERE
			//creating two int arrays that will be placeholders for the array to broken down
			int[] temparr1 = new int[arr.length / 2]; //for the merge sort, perhaps tackle one at a time??
			int[] temparr2 = new int[arr.length - arr.length / 2];
			
			//filling arrays
			for (int i = 0; i<(arr.length/2); i++)
			{
				temparr1[i] = arr[i];
			}
			
			int index = 0;
			for (int i = (arr.length/2); i<arr.length; i++)
			{
				temparr2[index] = arr[i];
				index ++;
			}
			
			mergesort(temparr1);
			mergesort(temparr2);
			
			int ti1 = 0;
			int ti2 = 0;
			//int fI = 0;
			
			for (int i = 0; i<arr.length; i++)
			{
				//System.out.println("this ran here");
				if (ti1 == temparr1.length)
				{
					arr[i] = temparr2[ti2];
					ti2++;
					//return;
				}
				else if (ti2 == temparr2.length)
				{
					arr[i] = temparr1[ti1];
					ti1++;
					//return;
				}
				else
				{
					if (temparr1[ti1] > temparr2[ti2])
					{
						arr[i] = temparr2[ti2];
						ti2++;
					}
					else
					{
						arr[i] = temparr1[ti1];
						ti1++;
					}
				}
			}
		}
		
		}
		
	
	
	

}
