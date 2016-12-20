package SnakeAndLadders;

import general.GameBoard;

public class SnakeAndLaddersGame implements GameBoard{
	static int ladders [][] = {{9, 34},{40, 64},{67, 86}};
	static int snakes [][] = {{54, 19},{90, 48},{99, 77}};
	private int player1Position;
	private int player2Position;
 	public static void main(String[] args) {

	int[][] map = new int[100][100];
	
	
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
 	}
 	
 	public static int diceRoll(){
		return (int)(Math.random()* 6 + 1);
	}

 	int count = 0;
	@Override
	public int turnTracker() {
		
		return 0;
	}

}
