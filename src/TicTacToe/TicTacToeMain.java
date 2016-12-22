package TicTacToe;

import general.GameBoard;
import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TicTacToeGame game = new TicTacToeGame();
		
		boolean computer;
		System.out.println("Do you wish to play with computer with another human player?");
		if(sc.next().equals("yes")){
			
		}
			ComputerPlayer CP = new ComputerPlayer();
		
		//CP.move(x, y);
		// instructions
		System.out.println("Welcome to TicTacToe!");
		System.out.println("Top left corner is 1, 1; bottom right corner is 3, 3.");
		System.out.println("X goes 1st and O goes 2nd. Do not enter points already in use.");

		// Print out of the initial state of the board before it begins
		game.drawBoard(game.getBoard());

		// keep on running the game if the board is not full and there is no
		// winner
		while (!game.isFull() && !game.isWinner()) {
			if (game.getTurnOfX()) {
				System.out.println("Please enter x and y points between 1-3 for player X separated by a space: ");
				game.setPointX(sc.nextInt(), sc.nextInt());
			} else {
				System.out
						.println("Please enter x and y points between 1-3 for player O separated by a space: ");
				game.setPointO(sc.nextInt(), sc.nextInt());
			}
			// display board after each turn
			game.drawBoard(game.getBoard());
			// if the point is not between and including 1-3, and not already
			// used, move on to the next turn
			// else keep on prompting for a valid input
			if (game.getValidPoint() == true) {
				game.nextTurn();
			} else {
				System.out.println("Not valid input, try again.");
			}
		}

		// if at the end of the game there is a winner, print it out
		// else there is no winner i.e. a tie
		if (game.isWinner()) {
			System.out.println("The Winner is " + game.getWinner());
		} else {
			System.out.println("There is a tie.");
		}
	}

}

