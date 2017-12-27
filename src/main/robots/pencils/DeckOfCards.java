package main.robots.pencils;

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
	
	static String ALERT_NEW_DECK_NEEDED = "\nALERT: Please use the n=new deck command first\n";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		String nextCommand = null;
		Deck deck = null;
		Card card = null;
		while (true) {
			System.out.println("\nYour command options are: n=new deck, d=deal card, s=shuffle deck, p=print card & deck details, r=reset, x=exit");
			System.out.print("Please enter single character for your next command: ");
			
			nextCommand = reader.next().toLowerCase();
			if (nextCommand == null || nextCommand.length() == 0) {
				System.out.print("\nPlease enter a valid command character");
			}
			else if (nextCommand.equalsIgnoreCase("n")) {
				deck = new Deck();
				card = null;
			}
			else if (nextCommand.equalsIgnoreCase("s")) {
				if (deck == null) {
					System.out.println(DeckOfCards.ALERT_NEW_DECK_NEEDED); 
				}
				else {
					deck.shuffle();
				}
			}
			else if (nextCommand.equalsIgnoreCase("r")) {
				deck = null;
				card = null;
			}
			else if (nextCommand.equalsIgnoreCase("d")) {
				System.out.println("\nYour command options are: t=deal from top (default), b=deal from bottom");
				System.out.print("Please enter single character for your next command: ");
				nextCommand = reader.next().toLowerCase();
				
				if (deck == null) {
					System.out.println(DeckOfCards.ALERT_NEW_DECK_NEEDED);
				}
				else
				{
					try {
						if (nextCommand.equalsIgnoreCase("b")) {
							card = deck.dealFromBottom();
						}
						else {
							card = deck.dealFromTop();
						}
					}
					catch (EmptyDeckException ede) {
						System.out.println("\nThere are no cards left in the deck"); 
					}
				}
					
			}
			else if (nextCommand.equalsIgnoreCase("p")) {
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
				
			}
			else if (nextCommand.equalsIgnoreCase("x")) {
				break;
			}
			
			
		}
		
		System.out.println("\n\nThank you for your time!!");
		
		reader.close();
		return;

	}

}
