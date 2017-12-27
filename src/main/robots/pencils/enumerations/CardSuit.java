package main.robots.pencils.enumerations;

/*
 * I decided to add unicode symbols for each suit in order to display the suit
 * in such a way that the human brain can determine the suit as quickly as possible.
 * 
 * Reading the word "Hearts" is not as efficient as seeing the symbol ❤
 */
public enum CardSuit {
	Spades("\u2660"), 
	Diamonds("\u2666"), 
	Clubs("\u2663"), 
	Hearts("\u2665");

	// The Unicode value that will display a single symbol representing the suit
	private final String unicode;

	CardSuit(String unicode) {
		this.unicode = unicode;
	}

	public String getUnicodeString() {
		return this.unicode;
	}

}
