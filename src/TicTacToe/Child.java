package TicTacToe;

public class Child extends HumanPlayer{
	//a class to demonstrate downcasting
	public Child(char c) {
		super(c);
	}
	public String crawl(){
		return "Downcast!";
	}
}
