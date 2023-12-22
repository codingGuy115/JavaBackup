
public class CheckerTest 
{

	public static void main(String[] args)
	{
		CompSciCheckerBoard gameboard = new CompSciCheckerBoard();
		
		CompSciChecker[][] board = null;
		try
		{
			board = gameboard.getBoard();
		}
		catch(Exception e)
		{
			System.out.print("getBoard() ERROR");
			System.exit(1);
		}
		
		System.out.println("CONSTRUCTED BOARD:");
		System.out.print(gameboard);
		boolean boardSetup = true;
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(i%2 == j%2 && board[i][j] == null)
				{
					boardSetup = false;	
				}
				else if(i%2 != j%2 && board[i][j] != null)
				{
					boardSetup = false;	
				}
				else if(i%2 == j%2 && i<3 && !board[i][j].getColor().equals("W"))
				{
					boardSetup = false;
				}
				else if(i%2 == j%2 && i>4 && !board[i][j].getColor().equals("B"))
				{
					boardSetup = false;
				}

			}
		}
		
		if(!boardSetup)
		{
			System.err.println("CONSTRUCTOR FAIL - no other tests will run");
			System.exit(1);
		}
		else
			System.out.println("********CONSTRUCTOR PASS********");
		
		
				
		boolean validMove = true;
		
		if(!gameboard.isValidMove(2, 2, 2, 1))
			{validMove = false; System.out.println('a');}
		if(gameboard.isValidMove(2, 2, 2, 2))
			{validMove = false; System.out.println('b');}
		if(gameboard.isValidMove(2, 2, 2, 0))
			{validMove = false; System.out.println('c');}
		if(gameboard.isValidMove(2, 2, 4, 2))
			{validMove = false; System.out.println('d');}
		if(gameboard.isValidMove(2, 2, 0, 1))
			{validMove = false; System.out.println('e');}
		if(gameboard.isValidMove(2, 2, 1, 1))
			{validMove = false; System.out.println('f');}
		if(!gameboard.isValidMove(2, 2, 3, 1))
			{validMove = false; System.out.println('g');}
		if(!gameboard.isValidMove(2, 2, 3, 2))
			{validMove = false; System.out.println('h');}
		if(gameboard.isValidMove(2, 2, 4, 0))
			{validMove = false; System.out.println('i');}
		if(gameboard.isValidMove(2, 2, 1, 2))
			{validMove = false; System.out.println('j');}
		

		CompSciChecker[][] testBoard = new CompSciChecker[8][8];
		testBoard[4][3] = new CompSciChecker("W");
		testBoard[4][4] = new CompSciChecker("W",true);
		testBoard[5][3] = new CompSciChecker("B");
		testBoard[3][4] = new CompSciChecker("B");
		testBoard[5][2] = new CompSciChecker("B");
		CompSciCheckerBoard test = new CompSciCheckerBoard(testBoard);
		System.out.println("VALID MOVE TEST BOARD");
		System.out.println(test);
		
		if(!test.isValidMove(4, 3, 6, 3))
			{validMove = false; System.out.println(1);}
		if(test.isValidMove(4, 3, 6, 2))
			{validMove = false; System.out.println(2);}
		if(test.isValidMove(4, 3, 2, 5))
			{validMove = false; System.out.println(3);}
		if(!test.isValidMove(4, 3, 6, 1))
			{validMove = false; System.out.println(4);}
		if(test.isValidMove(4, 3, 7, 3))
			{validMove = false; System.out.println(5);}
		if(test.isValidMove(4, 3, 4, 5))
			{validMove = false; System.out.println(6);}
		if(!test.isValidMove(4, 4, 2, 4))
			{validMove = false; System.out.println(7);}
		
		
		if(!validMove)
		{
			System.err.println("VALIDMOVE FAIL -- no further tests will run");
			System.exit(1);
		}
		else
		{
			System.out.println("********VALIDMOVE PASS********");
		}
		
		

		
		boolean move = true;
		
		test.makeMove(5, 2, 6, 2);
		if(test.getBoard()[5][2] == null || test.getBoard()[6][2] != null)
			{move = false;System.out.println(10);}
		
		test.makeMove(5, 3, 3, 3);
		if(test.getBoard()[5][3] != null || test.getBoard()[3][3] == null || test.getBoard()[4][3] !=null)
			{move = false;System.out.println(20);}
		if(test.getBoard()[4][3]!=null && !test.getBoard()[3][3].getColor().equals("B"))
			{move = false;System.out.println(30);}
		if(test.getNumWhitePieces() != 1)
			{move = false;System.out.println(40);}
		
		test.makeMove(4, 4, 2, 4);
		if(test.getBoard()[4][4] != null || test.getBoard()[2][4] == null || test.getBoard()[3][4] != null)
			{move = false;System.out.println(50);			}
		if(test.getBoard()[2][4]!=null && !test.getBoard()[2][4].getColor().equals("W"))
			{move = false;System.out.println(60);}
		if(test.getNumBlackPieces() != 2)
			{move = false;System.out.println(70);}
		test.makeMove(3, 3, 2, 3);
		test.makeMove(2, 3, 1, 3);
		test.makeMove(1, 3, 0, 3);
		if(test.getBoard()[0][3] == null || !test.getBoard()[0][3].reachedEnd())
			{move = false;System.out.println(80);}
		
		if(!move)
			System.err.println("xxxxxxxxMAKEMOVE FAILxxxxxxxx");
			
		else
			System.out.println("********MAKEMOVE PASS********");
		
	
	}

}
