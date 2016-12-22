package TicTacToe;

import general.Player;

public class ComputerPlayer extends Player{
	
	public ComputerPlayer(char c){
		this.playerChar = c;
	}

	//blocks all possible wins
	@Override
	public void play(TicTacToeGame game) {
		boolean play = false;
		do{
			this.p[0] = (int) (Math.random()*3+1);
			this.p[1] = (int) (Math.random()*3+1);
			System.out.println(p[0] + " " + p[1]);
			if(game.checkPosition(this.p)){
				game.setPosition(this.p, this.playerChar);
				play = true;
			}
		}while(!game.checkPosition(this.p) & !play);
		System.out.println("The Computer Entered Row "+this.p[0]+" and Column "+this.p[1]);
		game.drawBoard();
	}
	
	
	
	
	
	



	
	
}
