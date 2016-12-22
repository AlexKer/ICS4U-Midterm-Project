package SnakeAndLadders;

import general.GameBoard;

public class SnakesAndLaddersGame implements GameBoard{
	static int ladders [][] = {{9, 34},{40, 64},{67, 86},{51,67},{71, 91}};
	static int snakes [][] = {{54, 19},{90, 48},{99, 77},{93, 73},{17,7}};
	public int player1Position;
	public int player2Position;
	public int player1Roll, player2Roll;
	int[][] map = new int[100][100];
	int turn = 1;
	
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
	
	public void displaySnakesAndLaddersLocation(){
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
 	
	public void move(int num, int player){
		if(player == 1){
			this.player1Position += num;
		}
		else{
			this.player2Position += num;
		}
	}
	
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
	
 	
 	public static int diceRoll(){
		return (int)(Math.random()* 6 + 1);
 	}
 	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean win() {
		return player1Position > 100 || player2Position > 100;
	}

	@Override
	public int flag() {
		return turn++;
	}

	@Override
	public int getWinner() {
		if(player1Position > 100){
			return 1;
		}
		return 2;
	}


}
