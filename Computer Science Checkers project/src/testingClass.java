
public class testingClass 
{

	public static void main(String[] args) 
	{
		int originalRow = 2;
		int originalColumn = 2;
		
		int newRow = 0;
		int newColumn = 1;
		
		//This code block works. It will return false if the new location is not within a 5x5 radius of origin.
		if ((newRow-originalRow > 2) || (newRow-originalRow < -2))
		{
			System.out.println("Should return false. New location not within 5x5 area.");
		}
		if ((newColumn-originalColumn > 2) || (newColumn-originalColumn < -2))
		{
			System.out.println("Should return false. New location not within 5x5 area.");
		}
		
		//New code segment. This will set a boolean var=true if the new location is in the outer part.
		boolean withinOuterSegment = false;
		
		if ( ((newRow-originalRow == 2) || (newRow-originalRow == -2)) || ((newColumn-originalColumn == 2) || (newColumn-originalColumn == -2)) )
		{
			System.out.println("New location is within the outer segment of 5x5 area. Set withinOuterSegment=true.");
			withinOuterSegment = true;
		}
		
		//New code segment. This will use the midpoint formula to make sure the move is valid within outer part of 5x5 block.
		//*note* - this ONLY CHECKS THE OUTER PART, does not work for inner part.
		double midRowCoord = 0;
		double midColCoord = 0;
		
		midRowCoord = (originalRow + newRow) / 2.0;
		midColCoord = (originalColumn + newColumn) / 2.0;
		
		if (withinOuterSegment)
		{
			if ( ((int)midRowCoord != midRowCoord) || ((int)midColCoord != midColCoord) )
			{
				System.out.println("Should return false. New location does not have a midpoint that can be assigned to a space on the board.");
				
			}
		}
		else
		{
			System.out.println("New location within inner part of 5x5 area.");
		}
		

	}

}
