/**9-23-23 - This project will help me get back into coding. It is supposed to be a class that can be used in many projects,
 * so that I can manipulate arrays and run certain methods on them.
 * @author Nick 
 *
 */

public class ArrayManipulator 
{
	//fields
	
	//constructors
	public ArrayManipulator()
	{
		System.out.println("New manipulator made.");
	}
	//methods
	public void reverseHor(int[] arr)
	{
		int temp;
		for (int i=0; i<arr.length/2; i++)
		{
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
	public void reverseVert(int[][] arr)
	{
		int temp;
		for (int c=0; c<arr[0].length; c++)
		{
			for (int r=0; r<arr.length/2; r++)
			{
				temp = arr[r][c];
				arr[r][c] = arr[arr.length-1-r][c];
				arr[arr.length-1-r][c] = temp;
			}
		}
	}

}
