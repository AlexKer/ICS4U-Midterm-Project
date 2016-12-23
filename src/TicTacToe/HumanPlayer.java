package TicTacToe;

import java.util.Scanner;

import general.Player;

public class HumanPlayer extends Player{
	public Scanner sc = new Scanner(System.in);
	
	public HumanPlayer(char c) {
		this.playerChar = c;
	}

	//pass in game object, prompt for coordinates for the next move
	//loop until the user enters a valid point, then change that element in the array to the approriate gamepiece
	//draw board to reflect changes
	@Override
	public void play(TicTacToeGame game) {
		do{
			System.out.print("Row:");
			this.p[0] = sc.nextInt();
			System.out.print("Column:");
			this.p[1] = sc.nextInt();
			if(!game.checkPosition(this.p)){
				System.out.println("Invalid row or column, please enter a point that is not used between 1-3.");
			}
		}while(!game.checkPosition(this.p));
		game.setPosition(this.p, this.playerChar);
		game.drawBoard();
	}


}
