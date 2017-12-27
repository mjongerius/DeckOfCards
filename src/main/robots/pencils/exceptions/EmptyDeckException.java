package main.robots.pencils.exceptions;

public class EmptyDeckException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyDeckException() {
		super("There are no more cards in the deck");
	}
	
	public EmptyDeckException (String message) {
		super (message);
	}
}
