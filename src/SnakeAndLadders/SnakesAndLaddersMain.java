package SnakeAndLadders;

import java.util.Scanner;

public class SnakesAndLaddersMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SnakesAndLaddersGame game = new SnakesAndLaddersGame();
		game.drawBoard();
		game.displaySnakesAndLaddersLocation();
		while(!game.win()){
			
			do{
				System.out.println("Type \"R\" To roll");
			}while(!sc.nextLine().equals("R"));
			
			game.player1Roll = game.diceRoll();
			game.player1Position += game.player1Roll;
			System.out.println("Player 1 rolled "+game.player1Roll+". Now on square "+ game.player1Position);

			do{
				System.out.println("Type \"R\" To roll");
			}while(!sc.nextLine().equals("R"));
			
			game.player2Roll = game.diceRoll();
			game.player2Position += game.player2Roll;
			System.out.println("Player 2 rolled "+game.player2Roll+". Now on square "+ game.player2Position);
			
			game.check();
			game.drawBoard();
		
		}
		System.out.println("----GAME-OVER----");
		System.out.println("Wooooooooooooh!!! PLAYER-"+game.getWinner()+"Wins!");

	}

}
