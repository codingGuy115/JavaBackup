
public class ArrayClasswork 
{

	public static void main(String[] args) 
	{
		/**
		 * 1) Create an array (1-dimension) with a random number of indexes between 50 and 100 inclusive.
2) Fill the array with random values from 1-100 inclusive.
3)create a 2-dimensional array with 7 columns and as few rows as possible to be able to put each value from the one dimensional array 
into the new 2D array.  Fill the 2D array with the values from the original array.  
Each index that does not receive a value in the 2D array should be equal to zero.  There should be no extra rows.
     Ex:   original array {1,2,3,4,5,6,7,8,9,10}
                2D   { {1,2,3,4,5,6,7},
                            {8,9,10,0,0,0,0}}
4)  print the original array and the 2D array in a readable format using loops
5) input an int value from the user and print the row and column index of where the first occurance (difined as being lowest row number,
 then lowest column number) of the value can be found in the 2D array.  Print "value not found" if it is not in the array.
		 */
		
		int[] arr = new int[(int)(Math.random()*100+50)];
		for(int i = 0; i<arr.length; i++)
		{
			arr[i] = (int)(Math.random()*100+1);
			System.out.println(arr[i]);
		}
		
		int rowsNeeded = arr.length / 7;
		if (arr.length  % 7  != 0)
		{
			rowsNeeded = (arr.length / 7) +1;
		}
		
		int[][] arr2d = new int[rowsNeeded][7];
		
		//putting the original array into the new 2d one
		
		int indexCounter = 0;
		for (int i =0; i<arr2d.length; i++)
		{
			for (int j = 0; j<arr2d[0].length; j++)
			{
				arr2d[i][j] = arr[indexCounter];
				indexCounter ++;
				
			}
			System.out.println();
		}
	}

}
