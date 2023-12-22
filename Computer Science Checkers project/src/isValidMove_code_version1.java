
public class isValidMove_code_version1 
{

	public static void main(String[] args) 
	{
		//old code 
		//BEFORE ANYTHING ELSE: CHECK TO MAKE SURE ALL PARAMETERS ARE BETWEEN 0 and 7
		
				//for loop that is compact and gets everything done in shorter amount of code
//				int counter = 0;
//				for (int i = 0; i<8; i++)
//				{
//					if (i==originalRow || i==originalColumn || i==newRow || i==newColumn)
//					{
//						counter ++;
//					}
//				}
//				if (counter != 4)
//				{
//					//temp print statement
//					System.out.println("parameters given are not valid.");
//					return false;
//				}
				
				//-------------
				
				//----------- making sure there is actually a piece on the locations 
				if (board[originalRow][originalColumn] == null)
				{
					return false;
				}
				//making sure the new location is not occupied
				if (board[newRow][newColumn] != null)
				{
					return false;
				}
				//now we know that all parameters are valid, need to make a temp var to hold the reference to the current piece
				CompSciChecker pieceHeld = new CompSciChecker(board[originalRow][originalColumn].getColor());
				if (board[originalRow][originalColumn].reachedEnd() == true)
				{
					pieceHeld.setReachedEnd(true);
				}
				else
				{
					pieceHeld.setReachedEnd(false);
				}
				//pieceHeld should now have all the properties of the selected one
				
				String enemyColor;
				
				//boolean variables to see whether the move is meant to be a jump, or a regular move
				boolean jumpMove = false;
				boolean normalMove = false;
				
				//arrays to hold differences in columns and rows 
				int[] normalMoveDiff = {-1, 1};
				int[] jumpMoveDiff = {-2, 2};
				
				if (pieceHeld.getColor() == "B")
				{
					enemyColor = "W";
					//black piece, now have to determine whether .hasReachedEnd() is true
					if (pieceHeld.reachedEnd())
					{
						//piece is king, so able to make special moves (backwards as well as forwards)
						//first checking to see if the move can be a jump and eat of an enemy piece
						//jumpMove 
						for (int i = 0; i<2; i++)
						{
							if (jumpMoveDiff[i] == originalRow - newRow)
							{
								for(int j = 0; j<2; j++)
								{
									if(jumpMoveDiff[j] == originalColumn - newColumn)
									{
										jumpMove = true;
									}
								}
							}
						}
						if (jumpMove)
						{
							
							//up, down, right, left
							if (originalColumn == newColumn && newRow +2 == originalRow && originalRow > 1)
							{	if(board[originalRow-1][originalColumn].getColor() != enemyColor) {return false;}}
							if (originalColumn == newColumn && originalRow +2 == newRow && originalRow < 6)
							{	if(board[originalRow+1][originalColumn].getColor() != enemyColor) {return false;}}
							if (originalRow == newRow && originalColumn +2 == newColumn && originalColumn < 6)
							{	if(board[originalRow][originalColumn + 1].getColor() != enemyColor) {return false;}}
							if (originalRow == newRow && newColumn +2 == originalColumn && originalColumn > 1)
							{	if(board[originalRow][originalColumn-1].getColor() != enemyColor) {return false;}}
							
							//up right, up left, down right, down left
							if (newRow+2 == originalColumn && originalColumn +2 == newColumn && originalRow>1&&originalColumn<6)
							{	if(board[originalRow-1][originalColumn+1].getColor() != enemyColor) {return false;}}
							if (newRow+2 == originalRow && newColumn +2 == originalColumn && originalRow>1&&originalColumn<1)
							{	if(board[originalRow-1][originalColumn-1].getColor() != enemyColor) {return false;}}
							if (originalRow+2 == newRow && originalColumn +2 == newColumn && originalRow<6&&originalColumn<6)
							{	if(board[originalRow+1][originalColumn+1].getColor() != enemyColor) {return false;}}
							if (originalRow+2 == newRow && newColumn+2 == originalColumn && originalRow<6&&originalColumn<1)
							{	if(board[originalRow+1][originalColumn-1].getColor() != enemyColor) {return false;}}
							
							return true;
						}
						
						
						//normalMove
						for (int i = 0; i<2; i++)
						{
							if (normalMoveDiff[i] == originalRow - newRow)
							{
								for(int j = 0; j<2; j++)
								{
									if(normalMoveDiff[j] == originalColumn - newColumn)
									{
										normalMove = true;
									}
								}
							}
						}
						
						if (normalMove)
						{
							//everything should work fine, since its already been determined that the new location is unoccupied
							System.out.println("This is a normal move for a black king.");
							return true;
							
						}
						else
						{
							return false;
						}
						
						
						
					}
					else
					{
						//piece is a pawn
						//first checking to see if the move can be a jump and eat of an enemy piece
						if (newRow > originalRow)
						{
							return false;
						}
						
						//jumpMove 
						for (int i = 0; i<2; i++)
						{
							if (jumpMoveDiff[i] == originalRow - newRow)
							{
								for(int j = 0; j<2; j++)
								{
									if(jumpMoveDiff[j] == originalColumn - newColumn)
									{
										jumpMove = true;
									}
								}
							}
						}
						if (jumpMove)
						{
							
							//up, down, right, left
							if (originalColumn == newColumn && newRow +2 == originalRow && originalRow > 1)
							{	if(board[originalRow-1][originalColumn].getColor() != enemyColor) {return false;}}
							
							if (originalRow == newRow && originalColumn +2 == newColumn && originalColumn < 6)
							{	if(board[originalRow][originalColumn + 1].getColor() != enemyColor) {return false;}}
							if (originalRow == newRow && newColumn +2 == originalColumn && originalColumn > 1)
							{	if(board[originalRow][originalColumn-1].getColor() != enemyColor) {return false;}}
							
							//up right, up left, down right, down left
							if (newRow+2 == originalColumn && originalColumn +2 == newColumn && originalRow>1&&originalColumn<6)
							{	if(board[originalRow-1][originalColumn+1].getColor() != enemyColor) {return false;}}
							if (newRow+2 == originalRow && newColumn +2 == originalColumn && originalRow>1&&originalColumn<1)
							{	if(board[originalRow-1][originalColumn-1].getColor() != enemyColor) {return false;}}
							
							return true;
						}
						
						
						//normalMove
						for (int i = 0; i<2; i++)
						{
							if (normalMoveDiff[i] == originalRow - newRow)
							{
								for(int j = 0; j<2; j++)
								{
									if(normalMoveDiff[j] == originalColumn - newColumn)
									{
										normalMove = true;
									}
								}
							}
						}
						
						if (normalMove)
						{
							//everything should work fine, since its already been determined that the new location is unoccupied
							System.out.println("This is a normal move for a black pawn.");
							return true;
						}
						else
						{
							return false;
						}
						
						
						//next determining location relevance and validity
						
						
						
					}
					
					
					
				}
				else
				{
					enemyColor = "B";
					//white piece, now have to determine whether .hasReachedEnd() is true
					if (pieceHeld.reachedEnd())
					{
						//piece is king, so able to make special moves (backwards as well as forwards)
						//first checking to see if the move can be a jump and eat of an enemy piece
						//jumpMove 
						for (int i = 0; i<2; i++)
						{
							if (jumpMoveDiff[i] == originalRow - newRow)
							{
								for(int j = 0; j<2; j++)
								{
									if(jumpMoveDiff[j] == originalColumn - newColumn)
									{
										jumpMove = true;
									}
								}
							}
						}
						if (jumpMove)
						{
							
							//up, down, right, left
							if (originalColumn == newColumn && newRow +2 == originalRow && originalRow > 1)
							{	if(board[originalRow-1][originalColumn].getColor() != enemyColor) {return false;}}
							if (originalColumn == newColumn && originalRow +2 == newRow && originalRow < 6)
							{	if(board[originalRow+1][originalColumn].getColor() != enemyColor) {return false;}}
							if (originalRow == newRow && originalColumn +2 == newColumn && originalColumn < 6)
							{	if(board[originalRow][originalColumn + 1].getColor() != enemyColor) {return false;}}
							if (originalRow == newRow && newColumn +2 == originalColumn && originalColumn > 1)
							{	if(board[originalRow][originalColumn-1].getColor() != enemyColor) {return false;}}
							
							//up right, up left, down right, down left
							if (newRow+2 == originalColumn && originalColumn +2 == newColumn && originalRow>1&&originalColumn<6)
							{	if(board[originalRow-1][originalColumn+1].getColor() != enemyColor) {return false;}}
							if (newRow+2 == originalRow && newColumn +2 == originalColumn && originalRow>1&&originalColumn<1)
							{	if(board[originalRow-1][originalColumn-1].getColor() != enemyColor) {return false;}}
							if (originalRow+2 == newRow && originalColumn +2 == newColumn && originalRow<6&&originalColumn<6)
							{	if(board[originalRow+1][originalColumn+1].getColor() != enemyColor) {return false;}}
							if (originalRow+2 == newRow && newColumn+2 == originalColumn && originalRow<6&&originalColumn<1)
							{	if(board[originalRow+1][originalColumn-1].getColor() != enemyColor) {return false;}}
							
							return true;
						}
						
						
						//normalMove
						for (int i = 0; i<2; i++)
						{
							if (normalMoveDiff[i] == originalRow - newRow)
							{
								for(int j = 0; j<2; j++)
								{
									if(normalMoveDiff[j] == originalColumn - newColumn)
									{
										normalMove = true;
									}
								}
							}
						}
						
						if (normalMove)
						{
							//everything should work fine, since its already been determined that the new location is unoccupied
							System.out.println("This is a normal move for a white king.");
							return true;
							
						}
						else
						{
							return false;
						}

						
						
						//next determining location relevance and validity


						
					}
					else
					{
						//piece is a pawn
						//first checking to see if the move can be a jump and eat of an enemy piece
						if (newRow < originalRow)
						{
							return false;
						}
						
						//jumpMove 
						for (int i = 0; i<2; i++)
						{
							if (jumpMoveDiff[i] == originalRow - newRow)
							{
								for(int j = 0; j<2; j++)
								{
									if(jumpMoveDiff[j] == originalColumn - newColumn)
									{
										jumpMove = true;
									}
								}
							}
						}
						if (jumpMove)
						{
							
							//up, down, right, left
							
							if (originalColumn == newColumn && originalRow +2 == newRow && originalRow < 6)
							{	if(board[originalRow+1][originalColumn].getColor() != enemyColor) {return false;}}
							if (originalRow == newRow && originalColumn +2 == newColumn && originalColumn < 6)
							{	if(board[originalRow][originalColumn + 1].getColor() != enemyColor) {return false;}}
							if (originalRow == newRow && newColumn +2 == originalColumn && originalColumn > 1)
							{	if(board[originalRow][originalColumn-1].getColor() != enemyColor) {return false;}}
							
							//up right, up left, down right, down left
							
							if (originalRow+2 == newRow && originalColumn +2 == newColumn && originalRow<6&&originalColumn<6)
							{	if(board[originalRow+1][originalColumn+1].getColor() != enemyColor) {return false;}}
							if (originalRow+2 == newRow && newColumn+2 == originalColumn && originalRow<6&&originalColumn<1)
							{	if(board[originalRow+1][originalColumn-1].getColor() != enemyColor) {return false;}}
							
							return true;
						}
						
						
						//normalMove
						for (int i = 0; i<2; i++)
						{
							if (normalMoveDiff[i] == originalRow - newRow)
							{
								for(int j = 0; j<2; j++)
								{
									if(normalMoveDiff[j] == originalColumn - newColumn)
									{
										normalMove = true;
									}
								}
							}
						}
						
						if (normalMove)
						{
							//everything should work fine, since its already been determined that the new location is unoccupied
							System.out.println("This is a normal move for a white pawn.");
							return true;
							
						}
						else
						{
							return false;
						}
						
						//next determining location relevance and validity
						
						
						
					}
					
				}
	

	}

}
