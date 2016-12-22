package TicTacToe;

import java.util.Scanner;

import general.Player;

public class HumanPlayer extends Player{
	public Scanner sc = new Scanner(System.in);
	
	public HumanPlayer(char c) {
		this.playerChar = c;
	}

	//passing by reference
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
