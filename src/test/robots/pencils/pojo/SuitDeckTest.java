package test.robots.pencils.pojo;


import main.robots.pencils.pojo.Card;
import main.robots.pencils.pojo.SuitDeck;
import main.robots.pencils.enumerations.CardSuit;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import static org.junit.Assert.*;

/*
 * This test class verifies we can create the 4 suits that make up a deck
 * and that each suit has 13 unique playing cards
 */
public class SuitDeckTest {

	@Test
	public void testSuitDeckCreationSpades() throws UnsupportedEncodingException {	
		SuitDeck suitDeck = new SuitDeck(CardSuit.Spades);
		assertEquals(13, suitDeck.getSuiteCards().size());
		assertEquals("spades", suitDeck.getSuiteCards().get(0).getSuit().toString().toLowerCase());
		
		// Just for fun and visual inspection of a brand new suit
		System.out.println("\nSuit of cards (" + CardSuit.Spades.toString() + "):");
		new PrintStream(System.out, true, "UTF-8").print(suitDeck.toUnicodeString());
		System.out.println("\n");
	}
	
	@Test
	public void testSuitDeckCreationHearts() throws UnsupportedEncodingException {	
		SuitDeck suitDeck = new SuitDeck(CardSuit.Hearts);
		assertEquals(13, suitDeck.getSuiteCards().size());
		assertEquals("hearts", suitDeck.getSuiteCards().get(0).getSuit().toString().toLowerCase());
		
		// Just for fun and visual inspection of a brand new suit
		System.out.println("\nSuit of cards (" + CardSuit.Hearts.toString() + "):");
		new PrintStream(System.out, true, "UTF-8").print(suitDeck.toUnicodeString());
		System.out.println("\n");
	}
	
	@Test
	public void testSuitDeckCreationClubs() throws UnsupportedEncodingException {	
		SuitDeck suitDeck = new SuitDeck(CardSuit.Clubs);
		assertEquals(13, suitDeck.getSuiteCards().size());
		assertEquals("clubs", suitDeck.getSuiteCards().get(0).getSuit().toString().toLowerCase());
		
		// Just for fun and visual inspection of a brand new suit
		System.out.println("\nSuit of cards (" + CardSuit.Clubs.toString() + "):");
		new PrintStream(System.out, true, "UTF-8").print(suitDeck.toUnicodeString());
		System.out.println("\n");
	}
	
	@Test
	public void testSuitDeckCreationDiamonds() throws UnsupportedEncodingException {	
		SuitDeck suitDeck = new SuitDeck(CardSuit.Diamonds);
		assertEquals(13, suitDeck.getSuiteCards().size());
		assertEquals("diamonds", suitDeck.getSuiteCards().get(0).getSuit().toString().toLowerCase());
		
		// Just for fun and visual inspection of a brand new suit
		System.out.println("\nSuit of cards (" + CardSuit.Diamonds.toString() + "):");
		new PrintStream(System.out, true, "UTF-8").print(suitDeck.toUnicodeString());
		System.out.println("\n");
	}
	
	@Test
	public void testSuitDeckCreationRanksStringLong() {	
		SuitDeck suitDeck = new SuitDeck(CardSuit.Diamonds);
		assertEquals(13, suitDeck.getSuiteCards().size());
		
		// We'll use a String which we can turn into a list for checking that all 13 playing cards are created
		String cardRanksString = "ace,two,three,four,five,six,seven,eight,nine,ten,jack,queen,king";
		
		String[] rankList = cardRanksString.split(",");
		for (int x=0; x<rankList.length; x++) {
			boolean foundRank = false;
			for (Card card : suitDeck.getSuiteCards()) {
				if (rankList[x].equalsIgnoreCase(card.getRank().toString())) {
					foundRank = true;
					break;
				}
			}
			assertEquals("Could not find " + rankList[x] +" in the ranks" , true, foundRank);
		}
	}
	
	@Test
	public void testSuitDeckCreationRanksStringShort() {	
		SuitDeck suitDeck = new SuitDeck(CardSuit.Diamonds);
		assertEquals(13, suitDeck.getSuiteCards().size());
		
		// Test the short version for each rank
		String cardRanksString = "a,2,3,4,5,6,7,8,9,10,j,q,k";
		
		String[] rankList = cardRanksString.split(",");
		
		for (int x=0; x<rankList.length; x++) {
			boolean foundRank = false;
			for (Card card : suitDeck.getSuiteCards()) {
				if (rankList[x].equalsIgnoreCase(card.getRank().getStrRank())) {
					foundRank = true;
					break;
				}
			}
			assertEquals("Could not find " + rankList[x] +" in the ranks" , true, foundRank);
		}
	}

}
