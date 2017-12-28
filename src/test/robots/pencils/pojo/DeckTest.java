package test.robots.pencils.pojo;

import main.robots.pencils.pojo.Card;
import main.robots.pencils.pojo.Deck;
import main.robots.pencils.exceptions.*;
import main.robots.pencils.enumerations.*;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

import org.junit.Assert;


public class DeckTest {

	/*
	 * This test verifies that the creation of a new deck results in an
	 * unshuffled deck of 52 playing cards.
	 */
	@Test
	public void testDeckCreationNumberCards() throws UnsupportedEncodingException {
		Deck deck = new Deck();
		assertEquals(52, deck.getNumberOfCards());
		assertEquals(false, deck.isShuffled());
		
		// Just for fun and visual inspection of a brand new deck
		System.out.println("\nBrand new deck of cards:");
		new PrintStream(System.out, true, "UTF-8").println(deck.toUnicodeString());
		System.out.println("\n");
	}

	/*
	 * This test verifies that a new deck of cards has 4 distinct suits
	 */
	@Test
	public void testDeckCreationSuits() {
		Deck deck = new Deck();
		Card card = null;
		HashMap<String, CardSuit> suits = new HashMap<String, CardSuit>();
		try {
			// Keep track of the suits via a HashMap, while dealing the entire deck
			while (true) {
				card = deck.dealFromTop();
				suits.put(card.getSuit().toString(), card.getSuit());
			}
		}
		catch (EmptyDeckException ede) {
			assertEquals(0, deck.getNumberOfCards());
		}
		// We'll use a String which we can turn into a list for checking that all 4 suits are created
		String cardSuitsString = "Spades,Hearts,Clubs,Diamonds";

		String[] suitList = cardSuitsString.split(",");
		for (int x=0; x < suitList.length; x++) {
			boolean foundSuit = suits.containsKey(suitList[x]);
			assertEquals("Could not find " + suitList[x] +" in the ranks" , true, foundSuit);
		}
	}

	@Test
	public void testDeckDealFromTop() throws UnsupportedEncodingException {
		Deck deck = new Deck();
		Card card = null;
		try {
			card = deck.dealFromTop();
		}
		catch (EmptyDeckException ede) {
			Assert.fail("Exception is not expected");
		}
		Assert.assertNotNull("Card is not to be null", card);
		assertEquals(51, deck.getNumberOfCards());

		System.out.println("\nDetails of the dealt card:");
		new PrintStream(System.out, true, "UTF-8").println(card.toUnicodeString());
		new PrintStream(System.out, true, "UTF-8").println(card.toString());
		System.out.println("\n");
	}
	
	@Test
	public void testDeckDealFromBottom() throws UnsupportedEncodingException {
		Deck deck = new Deck();
		Card card = null;
		try {
			card = deck.dealFromBottom();
		}
		catch (EmptyDeckException ede) {
			Assert.fail("Exception is not expected");
		}
		Assert.assertNotNull("Card is not to be null", card);
		assertEquals(51, deck.getNumberOfCards());

		System.out.println("\nDetails of the dealt card:");
		new PrintStream(System.out, true, "UTF-8").println(card.toUnicodeString());
		new PrintStream(System.out, true, "UTF-8").println(card.toString());
		System.out.println("\n");
	}
	
	@Test
	public void testDeckShuffle() throws UnsupportedEncodingException {
		Deck deck = new Deck();
		String unshuffled = deck.toString();
		
		deck.shuffle();
		assertEquals(52, deck.getNumberOfCards());
		assertEquals(true, deck.isShuffled());
		assertNotEquals(unshuffled, deck.toString());
		
		System.out.println("\nShuffled deck:");
		new PrintStream(System.out, true, "UTF-8").println(deck.toUnicodeString());
		System.out.println("\n");
	}

}
