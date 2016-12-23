package SnakesAndLadders;

import java.util.Scanner;

public class SnakesAndLaddersMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//create a new game instance and show how the board looks at the start
		SnakesAndLaddersGame game = new SnakesAndLaddersGame();
		System.out.println("Welcome to Snakes and Ladders!");
		System.out.println("Player1's position is represented by 'A' and Player2's by 'B' beside the number");
		game.drawBoard();
		game.displaySnakesAndLaddersLocation();
		

		//keep looping until someone wins
		while(!game.win()){
			
			//prompt player1 to roll and subsequently player2 roll
			//output their new location
			do{
				System.out.println("Type \"R\" To roll for Player 1");
			}while(!sc.nextLine().equals("R"));
			
			game.player1Roll = game.diceRoll();
			game.player1Position += game.player1Roll;
			System.out.println("Player 1 rolled "+game.player1Roll+". Now on square "+ game.player1Position);

			do{
				System.out.println("Type \"R\" To roll for Player 2");
			}while(!sc.nextLine().equals("R"));
			
			game.player2Roll = game.diceRoll();
			game.player2Position += game.player2Roll;
			System.out.println("Player 2 rolled "+game.player2Roll+". Now on square "+ game.player2Position);
			
			//check whether they hit a snake or ladder
			game.check();
			System.out.println();
			System.out.println();
			//redraw the board
			game.drawBoard();
			//display the locations of the snakes and ladders
			game.displaySnakesAndLaddersLocation();
		
		}
		
		//if we break out of while loop, the game is over. Output winner.
		System.out.println("----GAME-OVER----");
		System.out.println("Wooooooooooooh!!! PLAYER-"+game.getWinner()+"Wins!");

	}

}
