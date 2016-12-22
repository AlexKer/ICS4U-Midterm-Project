package TicTacToe;

public class TicTacToeGame{

	private char[][] board = new char[3][3];
	private int numMoves = 0;
	private char winner = ' ';

	public TicTacToeGame() {
		clearBoard();
	}
	public void clearBoard() {
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j] = '_';
			}
		}
	}
	public void drawBoard(char[][] a) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(a[j][i]);
			}
			System.out.println();
		}
	}
	public int getPosition(int[] p) {
		return board[p[0]][p[1]];
	}
	public void setPosition(int[] p, char player){
		if(player == 'X'){
			board[p[0]][p[1]] = 'X';
		} else {
			board[p[0]][p[1]] = 'O';
		}
	}

	public char[][] getBoard() {
		return this.board;
	}

	public char getWinner() {
		return this.winner;
	}

	



	public boolean isWinner() {
		if (this.numMoves >= 5) {
			if (this.board[0][0] == 'X' && this.board[0][1] == 'X'
					&& this.board[0][2] == 'X' || this.board[1][0] == 'X'
					&& this.board[1][1] == 'X' && this.board[1][2] == 'X'
					|| this.board[2][0] == 'X' && this.board[2][1] == 'X'
					&& this.board[2][2] == 'X' || this.board[0][0] == 'X'
					&& this.board[1][0] == 'X' && this.board[2][0] == 'X'
					|| this.board[0][1] == 'X' && this.board[1][1] == 'X'
					&& this.board[2][1] == 'X' || this.board[0][2] == 'X'
					&& this.board[1][2] == 'X' && this.board[2][2] == 'X'
					|| this.board[0][0] == 'X' && this.board[1][1] == 'X'
					&& this.board[2][2] == 'X' || this.board[0][2] == 'X'
					&& this.board[1][1] == 'X' && this.board[2][0] == 'X') {
				this.winner = 'X';
				return true;
			} else if (this.board[0][0] == 'O' && this.board[0][1] == 'O'
					&& this.board[0][2] == 'O' || this.board[1][0] == 'O'
					&& this.board[1][1] == 'O' && this.board[1][2] == 'O'
					|| this.board[2][0] == 'O' && this.board[2][1] == 'O'
					&& this.board[2][2] == 'O' || this.board[0][0] == 'O'
					&& this.board[1][0] == 'O' && this.board[2][0] == 'O'
					|| this.board[0][1] == 'O' && this.board[1][1] == 'O'
					&& this.board[2][1] == 'O' || this.board[0][2] == 'O'
					&& this.board[1][2] == 'O' && this.board[2][2] == 'O'
					|| this.board[0][0] == 'O' && this.board[1][1] == 'O'
					&& this.board[2][2] == 'O' || this.board[0][2] == 'O'
					&& this.board[1][1] == 'O' && this.board[2][0] == 'O') {
				this.winner = 'O';
				return true;
			}
		}
		return false;
	}

	// check if all the spots on the board is occupied
	public boolean isFull() {
		return this.numMoves == 9;
	}


}
