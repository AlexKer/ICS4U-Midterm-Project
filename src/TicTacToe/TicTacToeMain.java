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
		
		do{
			System.out.println("Select Mode: Enter HH for Human vs. Human or HC for Human vs. Computer");
			option = sc.nextLine();
			if(!option.equals("HH") && !option.equals("HC")){
				System.out.println("Invalid Option! Try again");
			}
		}while(!option.equals("HH") && !option.equals("HC"));
		
		if(option.equals("HH")){
			player1 = new HumanPlayer('X');
			player2 = new HumanPlayer('O');
		}
		else{
			player1 = new HumanPlayer('X');
			player2 = new ComputerPlayer('O');
		}
		
		game.drawBoard();
		while(!game.isFull() && !game.win()){
			if(flag){
				player1.play(game);
			} 
			else{
				player2.play(game);
			}
			game.numMoves++;
			flag = !flag;
		}
		
		if(game.win()){
			System.out.println(game.winner+" Is the winner!");
		}
		else{
			System.out.println("Full Board. Tie!");
		}
		

	}

}
