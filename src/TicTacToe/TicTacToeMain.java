package TicTacToe;

import general.Player;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player player1, player2;
		String option;
		boolean flag = true;
		
		System.out.println("Welcome to TicTacToe!");
		TicTacToeGame game = new TicTacToeGame();
		
		//ask for input until player selects one out of the two modes
		do{
			System.out.println("Select Mode: Enter HH for Human vs. Human or HC for Human vs. Computer");
			option = sc.nextLine();
			if(!option.equals("HH") && !option.equals("HC")){
				System.out.println("Invalid Option! Try again");
			}
		}while(!option.equals("HH") && !option.equals("HC"));
		
		//create objects with approriate instance type according to game mode
		if(option.equals("HH")){
			player1 = new HumanPlayer('X');
			player2 = new HumanPlayer('O');
		}
		else{
			player1 = new HumanPlayer('X');
			player2 = new ComputerPlayer('O');
		}
		
		//draw initial state of the board
		game.drawBoard();
		//loop until board is full or someone wins
		while(!game.isFull() && !game.win()){
			//execute each player's play methods
			if(flag){
				player1.play(game);
			} 
			else{
				player2.play(game);
			}
			game.numMoves++;
			//boolean variable allow for alternating turns
			flag = !flag;
		}
		
		//print out the winner if there is one, otherwise tie
		if(game.win()){
			System.out.println(game.winner+" Is the winner!");
		}
		else{
			System.out.println("Full Board. Tie!");
		}
		
		//object created with HumanPlayer reference type of Child instance type
		//to demonstrate downcast using a method inside the Child class
		HumanPlayer Alex = new Child('X');
		System.out.println(((Child) Alex).crawl());

	}

}
