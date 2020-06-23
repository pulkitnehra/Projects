
public class Sudoku {
	
	static void sudokuSolved(int [][] bo)
	{
		boolean flag = sudokuSolve(bo);
		if (flag)
		{
			printBoard(bo);
		}
		
		else
		{
			System.out.println("no soluition");
		}
	}
	
	
	
	
	
	static boolean sudokuSolve(int bo[][])
	{
		for(int row = 0; row<9; row++) //or bo.length-1
		{
			for(int col = 0; col < 9; col++)
			{
//				check for empty space
				
				if(bo[row][col] == 0)
				{
				for(int num = 1; num<=9; num++)
				{
//					for checking and inserting one number at one position
					if(isValid(bo, row,col, num))
					{
						bo[row][col] = num;
					
//				to check and insert at all the valid positions we use recursion
					if(sudokuSolve(bo))
					{
						return true;
					}
//					backtrack
					else
						bo[row][col] = 0;
				}
				}
				return false;
					
				}
				
				
				
			}
		}
		return true;
		
		
		
	}
	
	
//	check for row, col, grid clash
	static boolean isValid(int[][] bo, int row, int col, int num)
	{
//		check row clash row is variable
		for(int i = 0; i<bo.length; i++)
		{
			if(bo[i][col] == num)
			{
				return false;
			}
			
		}
		
//		check for column clash column will be variable
		for(int i = 0; i<bo.length; i++)
		{
			if(bo[row][i] == num)
			{
				return false;
			}
			
		}
		
		
//	check for 3x3 grid for same number
		int boxRow = row - row%3;
		int boxCol = col - col%3;
		
		for(int i = boxRow; i<boxRow+3; i++)
		{
		for(int j = boxCol; j<boxCol+3; j++)
		{
			if(bo[i][j] == num)
				return false;
			
		}
		}
	
	return true;
	
	}
	
	
	
	
//	prints all the lines in rows and | in cols
	static void  printBoard(int bo[][]) 
	{
//		row
		for(int i = 0; i<=bo.length; i++)
		{
			if(i % 3 == 0)
			{
				System.out.println("-------------------------------");
			}
			if(i==9)
			{
				continue;
			}
		
//		col
		for(int j = 0; j<=bo.length; j++)
		{
			if(j % 3 == 0)
			{
				System.out.print("|");
			}
			if(j==9)
			{
				continue;
			}
		
		System.out.print(" "+bo[i][j]+" ");
		}
		System.out.println();
		}
	
	}

	
	
	
	
	

	public static void main(String[] args) {
		int[][] sudokuGrid = { 
				{7, 8, 0, 4, 0, 0, 1, 2, 0},
			    {6, 0, 0, 0, 7, 5, 0, 0, 9},
			    {0, 0, 0, 6, 0, 1, 0, 7, 8},
			    {0, 0, 7, 0, 4, 0, 2, 6, 0},
			    {0, 0, 1, 0, 5, 0, 9, 3, 0},
			    {9, 0, 4, 0, 6, 0, 0, 0, 5},
			    {0, 7, 0, 3, 0, 0, 0, 1, 2},
			    {1, 2, 0, 0, 0, 7, 4, 0, 0},
			    {0, 4, 9, 2, 0, 6, 0, 0, 7}
				
				
				
			};
		sudokuSolved(sudokuGrid);
		
	}
}

/*    OUTPUT                                  */



