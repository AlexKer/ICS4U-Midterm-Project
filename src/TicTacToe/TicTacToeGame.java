package TicTacToe;

import general.GameBoard;

public class TicTacToeGame implements GameBoard{

	char[][] board = new char[3][3];
	int numMoves = 0;
	char winner = ' ';
	
	public TicTacToeGame() {
		clearBoard();
	}
	
	//reset board to original empty state
	public void clearBoard() {
		for(int row=0;row<3;row++){
			for(int column=0;column<3;column++){
				board[row][column] = '_';
			}
		}
	}
	
	//display board with labelled rows and columns
	@Override
	public void drawBoard() {
		System.out.println(" 1 2 3 ");
		for(int row=0;row<3;row++){
			System.out.print(row+1+" ");
			for(int column=0;column<3;column++){
				System.out.print(board[row][column]+" ");
			}
			System.out.println();
		}
	}
	
	//check whether position entered is valid and not occupied by other pieces
	public boolean checkPosition(int[] p){
		return p[0] >= 1 && p[0] <= 3 && p[1] >= 1 && p[1] <= 3 && board[p[0]-1][p[1]-1] == '_';
	}
	
	//Set the element in the board array to desired piece
	public void setPosition(int[] p, char playerChar){
		if(playerChar == 'X'){
			board[p[0]-1][p[1]-1] = 'X';
		} else {
			board[p[0]-1][p[1]-1] = 'O';
		}
		numMoves++;
	}

	//check all winning conditions for both players
	//mark the winner if there is one and return true, otherwise false
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
			} 
			else if (board[0][0] == 'O' && board[0][1] == 'O'
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

	//return true if board is full, otherwise false
	public boolean isFull() {
		return numMoves == 9;
	}


}
