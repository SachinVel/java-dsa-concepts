package backtracking;

public class sudoku {
	public static boolean isSafe(int board[][], int row, int col,int num ) {
		int rowStart = (row/3)*3;
		int colStart = (col/3)*3;
		for( int i=0 ; i<9 ; ++i ) {
			if( board[i][col]==num ) {
				return false;
			}
			if( board[row][i]==num ) {
				return false;
			}
		}
		
		for( int i=rowStart ; i<(rowStart+3) ; ++i ) {
			for( int j=colStart ; j<(colStart+3) ; ++j ) {
				if( board[i][j]==num ) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static boolean backtrack( int board[][] ) {
		boolean isEmpty = true;
		int row,col=0;
		for( row=0 ; row<9 ; row++ ) {
			for( col=0 ; col<9 ; ++col ) {
				if( board[row][col]==0 ) {
					isEmpty = false;
					break;
				}
			}
			if( !isEmpty ) {
				break;
			}
		}
		if( isEmpty ) {
			return true;
		}
		for( int i=1 ; i<=9 ; ++i ) {
			if( isSafe(board,row,col,i) ) {
				board[row][col] = i;
				if( backtrack(board) ) {
					return true;
				}else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] board = new int[][] 
		    { 
		            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
		    };
		    
		    if( backtrack(board) ) {
		    	for( int i=0 ; i<9 ; ++i ) {
		    		for( int j=0 ; j<9 ;++j ) {
		    			System.out.print(board[i][j]+" ");
		    		}
		    		System.out.println();
		    	}
		    }
		    
		

	}
}
