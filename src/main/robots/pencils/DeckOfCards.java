package main.robots.pencils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import main.robots.pencils.pojo.Deck;
import main.robots.pencils.pojo.Card;
import main.robots.pencils.exceptions.*;

/*
 * This DeckOfCards class will showcase the abilities of the Deck class.  
 * 
 * Please follow the prompts on the console and try various combinations.
 * 
 * Reading the word "Hearts" is not as efficient as seeing the symbol ❤
 */
public class DeckOfCards {
	
	static String ALERT_NEW_DECK_NEEDED = "\nALERT: Please use the n=new deck command first!!\n";
	static String BREAKER_LINE = "\n\n***************************************************************************************************************\n";

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		String nextCommand = null;
		Deck deck = null;
		List<Card> cardList = new ArrayList<Card>();
		while (true) {
			System.out.println("\nYour command options are: n=new deck, d=deal card, s=shuffle deck, p=print deck & card list details, r=reset, x=exit");
			System.out.print("Please enter single character for your next command (n, d, s, p, r, x): ");
			
			nextCommand = reader.next().toLowerCase();
			if (nextCommand == null || nextCommand.length() == 0) {
				System.out.print("\nPlease enter a valid command character");
			}
			else if (nextCommand.equalsIgnoreCase("n")) {
				deck = new Deck();
				cardList = new ArrayList<Card>();
				System.out.print("\n\nINFO: A new deck has been created\n\n");
				displayDeckCardDetails(deck, cardList);
				System.out.print(DeckOfCards.BREAKER_LINE);
			}
			else if (nextCommand.equalsIgnoreCase("s")) {
				if (deck == null) {
					System.out.println(DeckOfCards.ALERT_NEW_DECK_NEEDED); 
				}
				else {
					deck.shuffle();
					System.out.print("\n\nINFO: The deck has been shuffled\n\n");
					displayDeckCardDetails(deck, cardList);
					System.out.print(DeckOfCards.BREAKER_LINE);
				}
			}
			else if (nextCommand.equalsIgnoreCase("r")) {
				deck = null;
				cardList = new ArrayList<Card>();
				System.out.print("\n\nINFO: The deck and card list have both been cleared\n\n");
				displayDeckCardDetails(deck, cardList);
				System.out.print(DeckOfCards.BREAKER_LINE);
			}
			else if (nextCommand.equalsIgnoreCase("d")) {
				if (deck == null) {
					System.out.println(DeckOfCards.ALERT_NEW_DECK_NEEDED);
				}
				else
				{
					System.out.println("\n\tYour secondary command options are: t=deal from top (default), b=deal from bottom");
					System.out.print("\tPlease enter single character for your secondary command: ");
					nextCommand = reader.next().toLowerCase();
				
					try {
						if (nextCommand.equalsIgnoreCase("b")) {
							cardList.add(deck.dealFromBottom());
						}
						else {
							cardList.add(deck.dealFromTop());
						}
						System.out.print("\n\nINFO: A card has been dealt and added to the card list\n\n");
						displayDeckCardDetails(deck, cardList);
	
					}
					catch (EmptyDeckException ede) {
						System.out.println("\nALERT: There are no cards left in the deck\n"); 
					}
					System.out.print(DeckOfCards.BREAKER_LINE);
				}
					
			}
			else if (nextCommand.equalsIgnoreCase("p")) {
				displayDeckCardDetails(deck, cardList);
			}
			else if (nextCommand.equalsIgnoreCase("x")) {
				break;
			}
			else {
				System.out.print("\nALERT: Please enter a valid command character!!\n");
			}
			
		}
		
		System.out.println("\n\nThank you for your time.");
		
		reader.close();
		return;

	}
	
	private static void displayDeckCardDetails(Deck deck, List<Card> cardList) {
		if (deck == null) {
			System.out.println("\nThe deck is currently empty");
		}
		else {
			System.out.println("\nDeck details are as follows: number of cards left=" + deck.getNumberOfCards() + ", is deck shuffled=" + (deck.isShuffled() == true ? "Yes" : "No") + "\n");
			try {
				new PrintStream(System.out, true, "UTF-8").println(deck.toUnicodeString());
			}
			catch (UnsupportedEncodingException uee) {}
		}
		
		if (cardList == null || cardList.size() == 0) {
			System.out.println("\nThe card list is currently empty");
		}
		else {
			System.out.println("\nCard details are as follows: number of cards dealt=" + cardList.size() + "\n");
			
			StringBuffer cardString = new StringBuffer();
			for (Card card : cardList) {
				if (cardString.length() != 0) {
						cardString.append(", ");
				}
				cardString.append(card.toUnicodeString());
			}
			
			try {
				new PrintStream(System.out, true, "UTF-8").println(cardString);
			}
			catch (UnsupportedEncodingException uee) {}
			
		}
		
	}

}
