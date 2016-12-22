package SnakeAndLadders;

import java.util.Scanner;

public class SnakesAndLaddersMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SnakesAndLaddersGame game = new SnakesAndLaddersGame();
		game.drawBoard();
		while(game.player1Position < 100 && game.player2Position < 100){
			
			do{
				System.out.println("Type \"R\" To roll");
			}while(!sc.nextLine().equals("R"));
			
			game.player1Roll = game.diceRoll();
			System.out.println("Player 1 rolled " + game.player1Roll);
			game.player1Position += game.player1Roll;
			System.out.println("Player 1 position "+ game.player1Position);
			
			do{
				System.out.println("Type \"R\" To roll");
			}while(!sc.nextLine().equals("R"));
			
			game.player2Roll = game.diceRoll();
			System.out.println("Player 2 rolled " + game.player2Roll);
			game.player2Position += game.player2Roll;
			System.out.println("Player 2 position "+ game.player2Position);
			
			game.check();
			game.drawBoard();
		
		}

	}

}
