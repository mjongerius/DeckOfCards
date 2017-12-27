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
		new PrintStream(System.out, true, "UTF-8").println("\u2260");
		// Just for fun and visual inspection of a brand new deck
		System.out.println("\nBrand new deck of cards:");
		new PrintStream(System.out, true, "UTF-8").println(deck.toUnicodeString());
		System.out.println("\n");
		new PrintStream(System.out, true, "UTF-8").println("Test: \u2660");
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
			assertEquals(4, suits.size());
			System.out.println(suits);
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

		new PrintStream(System.out, true, "UTF-8").println(card.toUnicodeString());
		new PrintStream(System.out, true, "UTF-8").println(card.toString());

	}

}
