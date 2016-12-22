package general;

import TicTacToe.TicTacToeGame;

public abstract class Player extends TicTacToeGame{
	public int[] p = new int[2];
	public char playerChar;
	public abstract void play(TicTacToeGame board);
	


}
