package main.robots.pencils.pojo;

import main.robots.pencils.enumerations.*;

/*
 * Simple card object for our Deck class which does not concern itself with Jokers, 
 * just the main 13 playing cards per suit.
 */
public class Card {

	private CardRank rank;
	private CardSuit suit;

	public Card (CardRank rank, CardSuit suit) {
		if (rank == null) {
			throw new NullPointerException("Rank cannot be null");
		}
		if (suit == null) {
			throw new NullPointerException("Suit cannot be null");
		}
		this.rank = rank;
		this.suit = suit;
	}

	public CardRank getRank() {
		return rank;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public String toString() {
		return rank + " of " + suit;
	}

	public String toUnicodeString() {
		return rank.getStrRank() + "-" + suit.getUnicodeString();
	}

}
