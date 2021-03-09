import java.util.*;
/*
 * NQueen
 * @author - neha patidar
 * 
 */
public class NQueen {
	int board[][];
	/*
	 * @param sizeOfBoard
	 */
	NQueen(int sizeOfBoard) {
		this.board = new int[sizeOfBoard][sizeOfBoard];
	}
	/*
	 * @param board, row, column
	 * @return true if queen is safe else return false
	 */
	public boolean isQueenSafe(int[][] board, int row, int column) {
		for (int index = 0; index < column; index++) {
			if (board[row][index] == 1) {
				return false;
			}
		}

		for (int rowIndex = row, colIndex = column; rowIndex >= 0
				&& colIndex >= 0; rowIndex--, colIndex--) {
			if (board[rowIndex][colIndex] == 1) {
				return false;
			}
		}

		for (int rowIndex = row, colIndex = column; colIndex >= 0
				&& rowIndex < board.length; rowIndex++, colIndex--) {
			if (board[rowIndex][colIndex] == 1) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * @param board, column
	 * @return true if solution found else return false
	 */
	public boolean solution(int[][] board, int column) {
		  
		if (column >= board.length) {
			return true;
		}

		for (int index = 0; index < board.length; index++) {
			if (isQueenSafe(board, index, column)) {
				board[index][column] = 1;
				if (solution(board, column + 1) == true) {
					return true;
				}
				board[index][column] = 0;
			}
		}
		return false;
	}
	/*
	 * Print the board
	 */
	public void showBoard() {
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
	}
	

}
