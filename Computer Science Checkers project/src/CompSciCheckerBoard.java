	/*
	 * A CompSciCheckerBoard represents a playing board for a 
	 * CompSciChecker game.  In this game a board is 8x8 and starts 
	 * with black and white CompSciChecker pieces.  The fields
	 * numWhitePieces and numBlackPieces track the appropriate 
	 * number of pieces for either side.  There are 12 white 
	 * pieces starting at the top left square and fill every other space
	 * on the board for the first three rows.  No two white pieces 
	 * should be directly adjacent to start.  The same is true of the
	 * 12 black pieces but they start at the bottom right and fill the
	 * bottom three rows.  the pieces may move one space forwards, left, 
	 * right or diagonal, but may not move backwards until they first reach
	 * the opposite end of the board.  The pieces may "jump" an opposing 
	 * player in any direction as well, with the same limitation when it
	 * comes to moving backwards.
	 * 
	 * You must write the no arguments constructor to create a board,
	 * the isValidMove method, as well as the makeMove method.
	 * 
	 */
public class CompSciCheckerBoard 
{
	
	private CompSciChecker[][] board = new CompSciChecker[8][8];
	private int numWhitePieces;
	private int numBlackPieces;
	
	/*
	 * Create a Constructor for the CompSciCheckerBoard
	 * Use the String "W" to denote white pieces and
	 * "B" to denote black pieces when constructed.
	 * Once created the board should look like this:
	 * 
	 *  _ _ _ _ _ _ _ _
	 * |W   W   W   W  |
	 * |  W   W   W   W|
	 * |W   W   W   W  |
	 * |               |
	 * |               |
	 * |  B   B   B   B|
	 * |B   B   B   B  |
	 * |_ B _ B _ B _ B|
	 * 
	 * Empty Spaces must have a value of null
	 * 
	 * 
	 */
	
	public CompSciCheckerBoard()
	{
		//TODO PART A GitterDone!
		//using for loops to initialize white and black pieces
		
		//white pieces
		for (int rows = 0; rows < 3; rows +=2)
		{
			for (int c = 0; c<8; c++)
			{
				if (c%2 == 0)
				{
					board[rows][c] = new CompSciChecker("W");
				}
				else
				{
					board[rows][c] = null;
				}
				
			}
		}
		for (int c = 0; c<8; c++)
		{
			if (c%2 != 0)
			{
				board[1][c] = new CompSciChecker("W");
			}
			else
			{
				board[1][c] = null;
			}
		}
		//filling row 3-4 with null
		for (int rows = 3; rows<5; rows++)
		{
			for (int c = 0; c<8; c++)
			{
				board[rows][c] = null;
			}
		}
		
		//black pieces
		for (int rows = 5; rows < 8; rows +=2)
		{
			for (int c = 0; c<8; c++)
			{
				if (c%2 != 0)
				{
					board[rows][c] = new CompSciChecker("W");
				}
				else
				{
					board[rows][c] = null;
				}
				
			}
		}
		for (int c = 0; c<8; c++)
		{
			if (c%2 == 0)
			{
				board[6][c] = new CompSciChecker("W");
			}
			else
			{
				board[6][c] = null;
			}
		}
		
	}
	
	
	
	/**
	 * This constructor is complete and can be used to 
	 * test specific moves
	 * @param board
	 */
	public CompSciCheckerBoard(CompSciChecker[][]board)
	{
		this.board = board;
		numWhitePieces = 0;
		numBlackPieces = 0;
		for(int i = 0; i < this.board.length; i++)
		{
			for(int j = 0; j < this.board[i].length; j++)
			{
				if(this.board[i][j]!=null)
				{
					if(this.board[i][j].getColor().equals("W"))
						numWhitePieces++;
					else
						numBlackPieces++;
				}
			}
		}
		
	}
	
	
	
	/*
	 * Next you will write the method isValidMove which will
	 * take a row and column of an existing piece as well as
	 * a new row and column value and determine if the move 
	 * from the original space to the new space is legal.
	 * 
	 * A CompSciChecker piece can move one space in any forward
	 * or horizontal direction including diagonally, so long as 
	 * the space is not occupied.
	 * 
	 * A CompSciChecker piece can move backwards only if it has 
	 * first reached the opposite end of the board.
	 * 
	 * A CompSciChecker piece can move two spaces in any valid direction
	 * ONLY IF there is an opposing piece being "jumped" and the new
	 * space is not occupied.
	 * 
	 * write the method isValidMove.  return true if the desired move
	 * is valid and false if it is not.
	 */
	
	public boolean isValidMove(int originalRow, int originalColumn , int newRow, int newColumn)
	{
		//getting some basic info on the selected piece 
		String currentColor = board[originalRow][originalColumn].getColor();
		String enemyColor;
		if (currentColor=="B")
		{ enemyColor = "W"; }
		else
		{ enemyColor = "B"; }
		
		//temporary 
		if(board[originalRow][originalColumn].reachedEnd())
		{ //System.out.println("or: " + originalRow+" oc: "+originalColumn+" nr: "+newRow+" nc: "+newColumn +" - Piece is a "+currentColor+" king."); 
			
		}
		else
		{ //System.out.println("or: " + originalRow+" oc: "+originalColumn+" nr: "+newRow+" nc: "+newColumn +" - Piece is a "+currentColor+" pawn."); 
			
		}
	
		
		//TODO Part B Gitterdone!!
		
		/**-needs to be completed in two sections: the black and white section 
		 * -sections are determined by condition which will see if compSciChecker.getColor() == "B" or "W"
		 * -Before each section, need to determine if the piece is a king. (reachedEnd == true) if this is the case,
		 * then black and white kings both have same movement capabilities, only difference being the eating mechanics
		 */
		
		boolean result = true;
		
		//----------- making sure there is actually a piece on the locations 
		if (board[originalRow][originalColumn] == null)
		{
			//result = false;
			return false;
		}
		//making sure the new location is not occupied
		if (board[newRow][newColumn] != null)
		{
			//result = false;
			return false;
		}
		
		//making sure if its a black pawn it only goes negative row direction 
		if (currentColor=="B" && board[originalRow][originalColumn].reachedEnd()==false && (newRow-originalRow>0))
		{
			return false;
			//result = false; 
		}
		//making sure if its a white pawn it only goes in positive row direction
		if (currentColor=="W" && board[originalRow][originalColumn].reachedEnd()==false && (newRow-originalRow<0))
		{ 
			return false; 
			//result = false; 
		}
		
		//This code block works. It will return false if the new location is not within a 5x5 radius of origin.
		if ((newRow-originalRow > 2) || (newRow-originalRow < -2))
		{
			//System.out.println("Should return false. New location not within 5x5 area.");
			//result = false;
			return false;
		}
		if ((newColumn-originalColumn > 2) || (newColumn-originalColumn < -2))
		{
			//System.out.println("Should return false. New location not within 5x5 area.");
			//result = false;
			return false;
		}
		
		//New code segment. This will set a boolean var=true if the new location is in the outer part.
		boolean withinOuterSegment = false;
		
		if ( ((newRow-originalRow == 2) || (newRow-originalRow == -2)) || ((newColumn-originalColumn == 2) || (newColumn-originalColumn == -2)) )
		{
			//System.out.println("New location is within the outer segment of 5x5 area. Set withinOuterSegment=true.");
			withinOuterSegment = true;
		}
		
		
		//New code segment. This will use the midpoint formula to make sure the move is valid within outer part of 5x5 block.
		//*note* - this ONLY CHECKS THE OUTER PART, does not work for inner part.
		double midRowCoord = 0;
		double midColCoord = 0;
		
		midRowCoord = (originalRow + newRow) / 2.0;
		midColCoord = (originalColumn + newColumn) / 2.0;
		
		int midRowCoordFinal = (int)midRowCoord;
		int midColCoordFinal = (int)midColCoord;
		
		if (withinOuterSegment)
		{
			if ( ((int)midRowCoord != midRowCoord) || ((int)midColCoord != midColCoord) )
			{
				//System.out.println("Should return false. New location does not have a midpoint that can be assigned to a space on the board.");
				//result = false;
				//System.out.println("HERE THIS RAN 1");
				return false;
			}
			else
			{
				//System.out.println("New location has a valid midpoint. need to check if midpoint has enemy piece. if no, return false.");
				//using the midpoint to determine whether or not the move was a jump ("eat")
				if (board[midRowCoordFinal][midColCoordFinal]==null)
				{
					//System.out.println("mipoint coordinate is empty. Should return false.");
					return false;
				}
				
				else
				{
					if (board[midRowCoordFinal][midColCoordFinal].getColor() != enemyColor)
					{
						return false;
						//result = false;
					}
					
				}
					
			}
		}
		else
		{
			//System.out.println("New location within inner part of 5x5 area.");
			
			
		}
		
		
		//System.out.println(result);
		if (currentColor == "B" && newRow == 0)
		{ board[originalRow][originalColumn].setReachedEnd(true); }
		if (currentColor == "W" && newRow == 7)
		{ board[originalRow][originalColumn].setReachedEnd(true); }
		
		return result;
		
		
		
	}
	
	
	/*
	 * Finally you will write the method makeMove.  This method will
	 * take a row and column where a piece lies and a new row and column
	 * as arguments.  move the desired piece ONLY IF the move is valid.  
	 * If an opposing piece is "jumped" remove it from the board and 
	 * update the appropriate field.  Be sure to call validMove from
	 * this method.  
	 * 
	 */
	
	public void makeMove(int originalRow, int originalColumn , int newRow, int newColumn)
	{
		System.out.println(isValidMove(originalRow, originalColumn, newRow, newColumn));
		
		String currentColor = board[originalRow][originalColumn].getColor();
		System.out.println("piece selected color: " + board[originalRow][originalColumn].getColor());
		
		if(isValidMove(originalRow, originalColumn, newRow, newColumn))
		{
			//putting piece in new location, and removing piece from old location 
			board[newRow][newColumn] = board[originalRow][originalColumn];
			board[originalRow][originalColumn] = null;
			
			//seeing if it jumped a piece, then using the midpoint to remove the piece at that location 
			//New code segment. This will set a boolean var=true if the new location is in the outer part.
			boolean withinOuterSegment = false;
			
			if ( ((newRow-originalRow == 2) || (newRow-originalRow == -2)) || ((newColumn-originalColumn == 2) || (newColumn-originalColumn == -2)) )
			{
				//System.out.println("New location is within the outer segment of 5x5 area. Set withinOuterSegment=true.");
				withinOuterSegment = true;
			}
			
			//New code segment. This will use the midpoint formula to make sure the move is valid within outer part of 5x5 block.
			//*note* - this ONLY CHECKS THE OUTER PART, does not work for inner part.
			double midRowCoord = 0;
			double midColCoord = 0;
			
			midRowCoord = (originalRow + newRow) / 2.0;
			midColCoord = (originalColumn + newColumn) / 2.0;
			
			int midRowCoordFinal = (int)midRowCoord;
			int midColCoordFinal = (int)midColCoord;
			
			
			if(withinOuterSegment)
			{
				board[midRowCoordFinal][midColCoordFinal] = null;
				if (currentColor == "W")
				{ numBlackPieces--; }
				else
				{ numWhitePieces--; }
			}

		}
		else
		{
			System.out.println("Move is invalid, therefore no move will be made.");
		}
	}
	
	
	


	
	/**
	 * 
	 * @param x x coordinate of board
	 * @param y y coordinate of board
	 * @return the piece at the given row and col or null if no piece
	 *         is located at that location
	 */
	public CompSciChecker getPiece(int row, int col)
	{
		return board[row][col];
	}
	
	/**
	 * 
	 * @return the field board
	 */
	public CompSciChecker[][] getBoard()
	{
		return board;
	}
	
	/**
	 * 
	 * @return number of white pieces on board
	 */
	public int getNumWhitePieces()
	{
		return numWhitePieces;
	}
	
	
	/**
	 * 
	 * @return number of black pieces on board
	 */
	public int getNumBlackPieces()
	{
		return numBlackPieces;
	}
	
	/**
	 * returns a string representation of the board
	 */
	public String toString()
	{
		String str = "  _ _ _ _ _ _ _ _\n";
		for(int i = 0; i<board.length; i++)
		{
			str+= i + "|";
			for(int j = 0; j<board[i].length; j++)
			{
				if(board[i][j] != null)
					str+=board[i][j].getColor();
				else
				{
					if(i<board.length-1) str+=" ";
					else str+= "_";
				}
				if(j<board[i].length-1) str+= " ";
			}
			str+="|\n";
		}
		str+= "  0 1 2 3 4 5 6 7\n";
		return str;
	}
	
	
	
	
	

}
