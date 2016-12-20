package TicTacToe;

import general.Player;

public class ComputerPlayer extends TicTacToeGame{
	private int x, y;
	public ComputerPlayer(){
		x = 0;
		y = 0;
	}
	
	//return best possible move under these circumstances
	//using recursive algorithm
	public int[] selectMove() {
		int max = -1;
		int[] location = new int[2];
		char[][] game = this.getBoard();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				//if position
				if(game[i][j] != '_' && value() > max){
					max = value();
					location[0] = i; //y value
					location[1] = j; //x value
				}
			}
		}
		return location;
	}
	
	public int value(){
		int x = 0;
		return x;
	}


	
	
}
