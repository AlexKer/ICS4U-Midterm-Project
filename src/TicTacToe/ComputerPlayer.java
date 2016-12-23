package TicTacToe;

import general.Player;

public class ComputerPlayer extends Player{
	
	public ComputerPlayer(char c){
		this.playerChar = c;
	}

	//pass in game object, generate two random numbers between 1 and 3 for row and column
	//loop until a valid point is generated, then change that element in the array to the approriate gamepiece
	//output the point so the user is aware of the move the computer made, and board is drawn to reflect changes
	@Override
	public void play(TicTacToeGame game) {
		do{
			this.p[0] = (int) (Math.random()*3+1);
			this.p[1] = (int) (Math.random()*3+1);
		}while(!game.checkPosition(this.p));
		game.setPosition(this.p, this.playerChar);
		System.out.println("The Computer Entered Row "+this.p[0]+" and Column "+this.p[1]);
		game.drawBoard();
	}
	
	
	
	
	
	



	
	
}
