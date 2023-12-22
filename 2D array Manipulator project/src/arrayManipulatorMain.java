
public class arrayManipulatorMain 
{
	
	public static void main(String[] args)
	{
		ArrayManipulator am = new ArrayManipulator();
		int[] testArray = {1, 2, 3, 4, 5, 6, 7};
		
		System.out.print("Before reverse: ");
		for (int i=0; i<testArray.length; i++)
		{
			System.out.print(testArray[i] + " ");
		}
		
		//testing the reverseValues method
		am.reverseHor(testArray);
		System.out.print("\nAfter reverse: ");
		for (int i=0; i<testArray.length; i++)
		{
			System.out.print(testArray[i] + " ");
		}
		
//		int[][] ddtest = new int[6][6];
//		//filling ddtest
//		for (int r=0; r<ddtest.length; r++)
//		{
//			if(r%2!=0) {
//				for (int c=1; c<ddtest[0].length; c+=2) {
//					ddtest[r][c] = 1; }}
//			else {
//				for (int c=0; c<ddtest[0].length; c+=2) {
//					ddtest[r][c] = 1; }}
//		}
		int[][] ddtest = {
				{0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 1},
				{0, 0, 1, 1, 1, 1, 0},
				{0, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 1, 0, 1, 0},
				{0, 0, 1, 0, 0, 0, 1},
		};
		
		//printing ddtest
		System.out.print("\n\n2D array before:\n");
		for (int r=0; r<ddtest.length; r++)
		{
			for (int c=0; c<ddtest[0].length; c++)
				System.out.print(ddtest[r][c] + "  ");
			System.out.println("");
		}
		
		//reversing each array in ddtest
		for (int r=0; r<ddtest.length; r++)
			am.reverseHor(ddtest[r]);
		
		//printing ddtest
		System.out.print("2D array after HOR reverse:\n");
		for (int r=0; r<ddtest.length; r++)
		{
			for (int c=0; c<ddtest[0].length; c++)
				System.out.print(ddtest[r][c] + "  ");
			System.out.println("");
		}
		
		//now going to reverse values VERICALLY
		am.reverseVert(ddtest);
		
		//printing ddtest
		System.out.print("\n\n2D array after VERT reverse:\n");
		for (int r=0; r<ddtest.length; r++)
		{
			for (int c=0; c<ddtest[0].length; c++)
				System.out.print(ddtest[r][c] + "  ");
			System.out.println("");
		}
	}

}
