package main.robots.pencils.pojo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import main.robots.pencils.pojo.Card;
import main.robots.pencils.exceptions.*;
import main.robots.pencils.enumerations.*;

/*
 * This class represents a very basic deck of playing cards without Jokers.
 * The deck is made up of the 13 playing cards (Ace through King) for the four standard suits (Spades, Diamonds, Clubs and Hearts)  
 */
public class Deck {

	private List<Card> deck;
	private boolean isShuffled;

	public Deck () {
		this.deck = new ArrayList<Card>();
		for (CardSuit suit : CardSuit.values()) {
			deck.addAll((new SuitDeck(suit)).getSuiteCards());
		}
		isShuffled = false;
	}

	public int getNumberOfCards() {
		return this.deck.size();
	}

	public boolean isShuffled() {
		return this.isShuffled;
	}
	
	public void shuffle() {
		Collections.shuffle(deck);  // use java.util.Collections' static method to shuffle the List
		isShuffled = true;
	}

	public Card dealFromTop() throws EmptyDeckException {
		if (deck.size() == 0) {
			throw new EmptyDeckException();
		}
		return deck.remove(deck.size() - 1);
	}

	public Card dealFromBottom() throws EmptyDeckException {
		if (deck.size() == 0) {
			throw new EmptyDeckException();
		}
		return deck.remove(0);
	}

	
	public void display() {
		for (Card card : deck) {
			System.out.println(card); // print all cards
		}
	}

	public String toString() {
		StringBuffer deckString = new StringBuffer();
		for (Card card : deck) {
			if (deckString.length() != 0) {
				deckString.append(", ");
			}
			deckString.append(card.toString());
		}
		return deckString.toString();
	}

	
	public String toString(String separator) {
		StringBuffer deckString = new StringBuffer();
		for (Card card : deck) {
			if (deckString.length() != 0) {
				deckString.append(separator);
			}
			deckString.append(card.toString());
		}
		return deckString.toString();
	}
	
	public String toUnicodeString() {
		StringBuffer deckString = new StringBuffer();
		int cardCounter = 1;
		for (Card card : deck) {
			if (deckString.length() != 0) {
				if (!isShuffled && cardCounter > 13) {
					deckString.append("\n");
					cardCounter = 1;
				}
				else {
					deckString.append(", ");
				}
			}
			deckString.append(card.toUnicodeString());
			cardCounter++;
		}
		return deckString.toString();
	}

}
