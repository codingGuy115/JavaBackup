
public class incrementing_i_and_j 
{

	public static void main(String[] args) 
	{
		//int[] arr = {4, 5, 5, 5, 10};
		int[] arr = {3, 1, 3, 3, 3};
		int uPairs = 0;
		int[] value = {-99, -99};
		
		for (int i = 0; i<4; i++)
		{
			for (int j = i+1; j < 5; j++)
			{
				System.out.println("Arr[i]: " + arr[i] + "  Arr[j]: " + arr[j] + "   i: " + i + ",  j: " + j);
				if (arr[i] == arr[j])
				{
					value[0] = i;
					uPairs ++;
					if (i +2 <= 4)
					{
						i += 2;
						j += 1;
						//System.out.println("i: " + i + ",  j: " + j);
					}
					
				}
			}
			System.out.println("New i value");
		}
		
		System.out.println("Pairs: " + uPairs);

	}

}
