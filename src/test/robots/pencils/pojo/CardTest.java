package test.robots.pencils.pojo;

import main.robots.pencils.pojo.Card;
import main.robots.pencils.enumerations.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class CardTest {

	/*
	 * This test verifies that the creation of a card is successful
	 */
	@Test
	public void testCardCreation() {
		Card card = new Card(CardRank.Ace, CardSuit.Clubs);
		assertNotNull("Card should not be null", card);
		assertEquals("Ace of Clubs", card.toString());
		assertEquals("A-\u2663", card.toUnicodeString());
		assertEquals(CardRank.Ace.toString(), card.getRank().toString());
		assertEquals(CardSuit.Clubs.toString(), card.getSuit().toString());
	}
	
	
	/*
	 * This test verifies NPE when Rank is null
	 */
	@Test (expected = NullPointerException.class)
	public void testCardCreationNoRank() {
		new Card(null, CardSuit.Clubs);
	}
	
	
	/*
	 * This test verifies NPE when Suit is null
	 */
	@Test (expected = NullPointerException.class)
	public void testCardCreationNoSuit() {
		new Card(CardRank.Ace, null);
	}


	
}
