package TicTacToe;

import general.GameBoard;

public class TicTacToeGame implements GameBoard{

	char[][] board = new char[3][3];
	int numMoves = 0;
	char winner = ' ';
	
	public TicTacToeGame() {
		clearBoard();
	}
	public void clearBoard() {
		for(int row=0;row<3;row++){
			for(int column=0;column<3;column++){
				board[row][column] = '_';
			}
		}
	}
	public void drawBoard() {
		System.out.println(" 1 2 3 ");
		for(int row=0;row<3;row++){
			System.out.print(row+1);
			for(int column=0;column<3;column++){
				System.out.print(board[row][column]+" ");
			}
			System.out.println();
		}
	}
	public int getPosition(int[] p) {
		return board[p[0]-1][p[1]-1];
	}
	//if the position is open, return true
	public boolean checkPosition(int[] p){
		return p[0] >= 1 && p[0] <= 3 && p[1] >= 1 && p[1] <= 3 && board[p[0]-1][p[1]-1] == '_';
	}
	public void setPosition(int[] p, char playerChar){
		if(playerChar == 'X'){
			board[p[0]-1][p[1]-1] = 'X';
		} else {
			board[p[0]-1][p[1]-1] = 'O';
		}
		numMoves++;
	}

	@Override
	public boolean win() {
		if (numMoves >= 5) {
			if (board[0][0] == 'X' && board[0][1] == 'X'
					&& board[0][2] == 'X' || board[1][0] == 'X'
					&& board[1][1] == 'X' && board[1][2] == 'X'
					|| board[2][0] == 'X' && board[2][1] == 'X'
					&& board[2][2] == 'X' || board[0][0] == 'X'
					&& board[1][0] == 'X' && board[2][0] == 'X'
					|| board[0][1] == 'X' && board[1][1] == 'X'
					&& board[2][1] == 'X' || board[0][2] == 'X'
					&& board[1][2] == 'X' && board[2][2] == 'X'
					|| board[0][0] == 'X' && board[1][1] == 'X'
					&& board[2][2] == 'X' || board[0][2] == 'X'
					&& board[1][1] == 'X' && board[2][0] == 'X') {
				winner = 'X';
				return true;
			} else if (board[0][0] == 'O' && board[0][1] == 'O'
					&& board[0][2] == 'O' || board[1][0] == 'O'
					&& board[1][1] == 'O' && board[1][2] == 'O'
					|| board[2][0] == 'O' && board[2][1] == 'O'
					&& board[2][2] == 'O' || board[0][0] == 'O'
					&& board[1][0] == 'O' && board[2][0] == 'O'
					|| board[0][1] == 'O' && board[1][1] == 'O'
					&& board[2][1] == 'O' || board[0][2] == 'O'
					&& board[1][2] == 'O' && board[2][2] == 'O'
					|| board[0][0] == 'O' && board[1][1] == 'O'
					&& board[2][2] == 'O' || board[0][2] == 'O'
					&& board[1][1] == 'O' && board[2][0] == 'O') {
				winner = 'O';
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean isFull() {
		return numMoves == 9;
	}


}
