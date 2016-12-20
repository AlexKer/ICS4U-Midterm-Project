package TicTacToe;

public class TicTacToeGame {
	// static variable to limit total instances
	private static int numInstance = 0;
	// private instance variables
	private char[][] board = new char[3][3];
	private int numMoves = 0;
	private char winner = ' ';
	private boolean validPoint;
	// flag created to see which player goes next
	private boolean turnOfX = true;

	// default constructor
	public TicTacToeGame() {
		// limit to only one total instance
		if (numInstance < 1) {
			// default constructor initializing a 2D-array with ‘_‘ characters
			// as placeholders
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					this.board[i][j] = '_';
				}
			}
		}
		// static variable incremented to keep track of how many objects have
		// been instantiated
		numInstance++;
	}

	// accessor methods for: the number of moves elapsed
	// the board, the winner, whether a point is valid, and whose turn it is
	public int getMoves() {
		return this.numMoves;
	}

	public char[][] getBoard() {
		return this.board;
	}

	public char getWinner() {
		return this.winner;
	}

	public boolean getValidPoint() {
		return this.validPoint;
	}

	public boolean getTurnOfX() {
		return this.turnOfX;
	}

	// mutator methods
	// check if coordinates is within restriction: between 1-3 and not used by
	// other pieces
	// take coordinates and stores it into approriate spot by substracting 1
	// because the indices of an array start from 0, then increment the number
	// of moves by 1
	public void setPointX(int x, int y) {
		if (x >= 1 && x <= 3 && y >= 1 && y <= 3
				&& this.board[x - 1][y - 1] == '_') {
			this.board[x - 1][y - 1] = 'X';
			this.numMoves++;
			this.validPoint = true;
		} else {
			this.validPoint = false;
		}
	}

	public void setPointO(int x, int y) {
		if (x >= 1 && x <= 3 && y >= 1 && y <= 3
				&& this.board[x - 1][y - 1] == '_') {
			this.board[x - 1][y - 1] = 'O';
			this.numMoves++;
			this.validPoint = true;
		} else {
			this.validPoint = false;
		}
	}

	// sets turnOfX equal to its opposite, indicating it is the next turn
	public void nextTurn() {
		this.turnOfX = !this.turnOfX;
	}

	// check the 8 winning conditions, if there are more than a total of 5 moves
	// if one player form three pieces in a line, winner is set to X if X wins
	// and O if O wins
	// else isWinner returns false the games continues
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

	
	public void drawBoard(char[][] a) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(a[j][i]);
			}
			System.out.println();
		}
	}

}
