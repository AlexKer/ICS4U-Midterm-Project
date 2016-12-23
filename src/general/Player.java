package general;

import TicTacToe.TicTacToeGame;

public abstract class Player extends TicTacToeGame{
	//array to store input x and y coordinates the player enters
	public int[] p = new int[2];
	//ascii character representing the player, either 'X' or 'O'
	public char playerChar;
	//abstract method, implemented differently depending on player(human or computer)
	public abstract void play(TicTacToeGame board);
}
