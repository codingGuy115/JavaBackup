
public class MergeSort_testing 
{

	public static void main(String[] args) 
	{
		//Should be able to work for array of any length
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		//doing it with a while loop first
		
		int[] a = new int[arr.length];
		int counter = 1;
	
		while (arr.length > 1)
		{
			arr = splitDaArray(arr);
			System.out.println("Split number " + counter);
			counter++;
		}
		
		//testing merging the arrays
		System.out.print("\n\n-----------------------\n TESTING MERGEARRAYS METHOD\n-----------------------");
		
		int[] testArr1 = {2, 3, 6};
		int[] testArr2 = {1, 5, 7};
		
		
		MergeSort_testing.mergeArrays(testArr1, testArr2);
		
//		int[] temparr1 = new int[arr.length / 2]; //for the merge sort, perhaps tackle one at a time??
//		int[] temparr2 = new int[arr.length - arr.length / 2];
//		
//		for (int i = 0; i<(arr.length/2); i++)
//		{
//			temparr1[i] = arr[i];
//		}
//		
//		int index = 0;
//		for (int i = (arr.length/2); i<arr.length; i++)
//		{
//			temparr2[index] = arr[i];
//			index ++;
//		}
//		
//		//----------------------------------
//		
//		//printing temparr1
//		System.out.println("Temparr1: ");
//		for (int a : temparr1)
//		{
//			System.out.print(a + ", ");
//		}
//		
//		//printing temparr2
//		System.out.println("\n\nTemparr2: ");
//		for (int a : temparr2)
//		{
//			System.out.print(a + ", ");
//		}
		

	}
	
	public static int[] splitDaArray(int[] arr) //-----> this is a GETTER method
	{
		int[] temparr1 = new int[arr.length / 2]; //for the merge sort, perhaps tackle one at a time??
		int[] temparr2 = new int[arr.length - arr.length / 2];
		
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
		
		//printing temparr1
		System.out.println("\n\nTemparr1: ");
		for (int a : temparr1)
		{
			System.out.print(a + ", ");
		}
		
		//printing temparr2
		System.out.print("\t\tTemparr2: \n\t\t\t");
		for (int a : temparr2)
		{
			System.out.print(a + ", ");
		}
		
		return temparr1;
	}
	
	//Merge arrays method
	
	public static int[] mergeArrays(int[] arr1, int[] arr2 )
	{
		//int[] var to hold new array that will be arr1 and arr2 combined, THEN sorted
		int[] newArr = new int[arr1.length + arr2.length];
		//filling newArr with values from arr1
		for (int i = 0; i<arr1.length; i++)
		{
			newArr[i] = arr1[i];
		}
		
		//filling newArr with values from arr2
		int index = 0;
		for (int i = (newArr.length - arr2.length); i<newArr.length; i++)
		{
			newArr[i] = arr2[index];
			index ++;
		}
		//WORKS
		
		System.out.println("\nnewArr: ");
		for(int a : newArr)
		{
			System.out.print(a + ", ");
		}
		
		//now that they are in one array, need to sort them in order
		//using selection sort
		int min = newArr[0];
		int minIndex = 0;
		int temp = 0;
		
		for (int i = 0; i<newArr.length; i++)
		{
			
			//must find minimum value each time
			
			for (int j = 0; j<newArr.length; j++)
			{
				if (newArr[j]<min)
				{ min = newArr[j]; minIndex = j; System.out.println("this ran");}
			}
			
			//now need to swap minimum value with element in newArr at index i
			temp = newArr[minIndex];
			newArr[minIndex] = newArr[i];
			newArr[i] = temp;
			
			
		}
		
		
		return newArr;
		
	}

}
