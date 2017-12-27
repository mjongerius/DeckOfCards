package main.robots.pencils.enumerations;

/*
 * I added a short string representation for each card rank that can be used
 * with the CardSuit unicode value to display card values in short form
 */
public enum CardRank {
	Ace("A"), 
	Two("2"), 
	Three("3"), 
	Four("4"), 
	Five("5"), 
	Six("6"), 
	Seven("7"), 
	Eight("8"), 
	Nine("9"), 
	Ten("10"), 
	Jack("J"), 
	Queen("Q"), 
	King("K");

	private final String strRank;

	CardRank(String strRank) {     // Constructor
		this.strRank = strRank;
	}

	public String getStrRank() {
		return this.strRank;
	}

}
