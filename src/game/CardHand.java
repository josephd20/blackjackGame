package game;

import java.util.ArrayList;

/**
 * Abstract superclass for classes that are collections of cards (PlayerDeck & Deck)
 * @author Joseph Daher
 */
public abstract class CardHand {
	
	ArrayList<Card> cards;
	
	/**
	 * Removes first (top) card from a card hand/deck.
	 * @return Card removed
	 */
	abstract Card removeCard();
	
	/**
	 * Adds card to a card hand/deck
	 * @param c Card added
	 */
	abstract void addCard(Card c);
	
}
