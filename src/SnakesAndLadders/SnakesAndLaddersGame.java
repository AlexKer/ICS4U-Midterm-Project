package SnakesAndLadders;

import general.GameBoard;

public class SnakesAndLaddersGame implements GameBoard{
	//location pairs that are either: the head/tail of a snake, or top/bottom of a ladder
	static int ladders [][] = {{9, 34},{40, 64},{67, 86},{51,67},{71, 91}};
	static int snakes [][] = {{54, 19},{90, 48},{99, 77},{93, 73},{17,7}};
	//keep track of what square the players are on
	public int player1Position;
	public int player2Position;
	//keep track of the player's most recent roll
	public int player1Roll, player2Roll;
	//actual array representing the board
	int[][] map = new int[100][100];
	
	//constructor to initalize the board and variables
	public SnakesAndLaddersGame(){
		int counter = 100;
		player1Position = 0;
		player2Position = 0;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				map[i][j] = counter--;
			}
		}
	}
	
	//method to list all where all the snakes and ladders are
	public void displaySnakesAndLaddersLocation(){
		//
		System.out.print("LADDERS: ");
		for(int i=0;i<ladders.length;i++){
			System.out.print("{"+ladders[i][0]+", "+ladders[i][1]+"} ");
		}
		System.out.println();
		System.out.print("SNAKES: ");
		for(int i=0;i<snakes.length;i++){
			System.out.print("{"+snakes[i][0]+", "+snakes[i][1]+"} ");
		}
		System.out.println();
	}
		
	//displays board with approriate spacing and alignment
	@Override
	public void drawBoard() {
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(map[i][j] == player1Position){
					System.out.print("A");
				} 
				if(map[i][j] == player2Position){
					System.out.print("B");
				} 
				if(i==0 && j==0){
					System.out.print(map[i][j] + " ");
				}
				else if(i < 9){
					System.out.print(map[i][j] + "  ");
				}
				else{
					System.out.print(map[i][j] + "   ");
				}	
			}
			System.out.println();
		}
	}
 	
	//move the pieces of the player by the number on the dice
	public void move(int num, int player){
		if(player == 1){
			this.player1Position += num;
		}
		else{
			this.player2Position += num;
		}
	}
	
	//check if either players happen to hit a snake or ladder
	//if so change their position to the top of the ladder or bottom of the snake
	public void check(){
		for(int i=0;i<this.ladders.length;i++){
			if(this.ladders[i][0] == player1Position){
				player1Position = this.ladders[i][1];
				System.out.println("Player 1 hit a ladder. Now on square "+player1Position);
			}
			else if(this.ladders[i][0] == player2Position){
				player2Position = this.ladders[i][1];
				System.out.println("Player 2 hit a ladder. Now on square "+player2Position);
			}
		}
		for(int i=0;i<this.snakes.length;i++){
			if(this.snakes[i][0] == player1Position){
				player1Position = this.snakes[i][1];
				System.out.println("Player 1 hit a snake. Now on square "+player1Position);
			}
			else if(this.snakes[i][0] == player2Position){
				player2Position = this.snakes[i][1];
				System.out.println("Player 2 hit a snake. Now on square "+player2Position);
			}
		}
	}
	
 	//randomly generate a number between 1 and 6
 	public static int diceRoll(){
		return (int)(Math.random()* 6 + 1);
 	}
 	
 	//return true if the one player won the game
	@Override
	public boolean win() {
		return player1Position > 100 || player2Position > 100;
	}


	//return 1 if player1 wins, 2 otherwise
	public int getWinner() {
		if(player1Position > 100){
			return 1;
		}
		return 2;
	}


}
