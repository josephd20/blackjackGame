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
<<<<<<< HEAD
	abstract void addCard(Card c);
	abstract int score();
=======
>>>>>>> fd50d9cd24a826a34f9d5dc6d7d2b8a9313998d8
	
	/**
	 * Adds card to a card hand/deck
	 * @param c Card added
	 */
	abstract void addCard(Card c);
	
}
