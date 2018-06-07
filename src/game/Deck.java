package game;

import java.util.ArrayList;

/**
 * Subclass of CardHand to model the dealer deck in Blackjack, consisting of one or more complete deck of cards that are shuffled.
 * @author Joseph Daher and Ben Hanley
 */
public class Deck extends CardHand {

	/**
	 * Default constructor for Deck only uses 1 deck.
	 */
	public Deck()
	{
		cards = new ArrayList<Card>();
		cards.addAll(CardUtil.createDeck());
		CardUtil.shuffle(cards);
	}
	
	/**
	 * Constructor for deck that shuffles a predetermined number of decks together
	 * @param decks number of card decks used
	 */
	public Deck(int decks)
	{
		cards = new ArrayList<Card>();
		for(int i = 0; i < decks; i++)
		{
			cards.addAll(CardUtil.createDeck());
		}
		CardUtil.shuffle(cards);
	}
	
	/**
	 * Method implemented by parent class
	 * Adds card to a card hand/deck
	 * @param c Card added
	 */
	void addCard(Card c) {
		cards.add(c);
	}

	/**
	 * Method implemented by parent class
	 * Removes card from a card hand/deck
	 */
	Card removeCard() {
		return cards.remove(0);
	}
	
	/**
	 * Alternative method call for removeCard()
	 * @return top Card
	 */
	Card dealCard() {
		return this.removeCard();
	}
	
	/**
	 * Shuffles this deck
	 */
	void shuffle() {
		CardUtil.shuffle(cards);
	}
	
	/**
	 * Returns this deck as an ArrayList of Cards
	 * @return ArrayList of Cards in this deck
	 */
	ArrayList<Card> getCards()
	{
		return cards;
	}

}