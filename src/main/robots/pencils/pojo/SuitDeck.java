package main.robots.pencils.pojo;

import java.util.List;
import java.util.ArrayList;

import main.robots.pencils.pojo.Card;
import main.robots.pencils.enumerations.*;

/*
 * A suit in cards consists of 13 playing cards, all of the same suit
 */
public class SuitDeck {

	private List<Card> suitDeck;

	public SuitDeck (CardSuit suit) {
		this.suitDeck = new ArrayList<Card>();
		for (CardRank rank : CardRank.values()) {
			suitDeck.add(new Card(rank, suit));
		}
	}
	
	public List<Card> getSuiteCards() {
		return this.suitDeck;
	}
	
	public String toUnicodeString() {
		StringBuffer suitDeckString = new StringBuffer();
		for (Card card : this.getSuiteCards()) {
			if (suitDeckString.length() != 0) {
				suitDeckString.append(", ");
			}
			suitDeckString.append(card.toUnicodeString());
		}
		return suitDeckString.toString();
	}
	
}
