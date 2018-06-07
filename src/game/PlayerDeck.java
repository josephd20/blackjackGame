package game;

import java.util.ArrayList;

/**
 * Subclass of CardHand for all Player card hands, containing an additional method to get the Blackjack value of the hand.
 * @author Joseph Daher and Ben Hanley
 *
 */
public class PlayerDeck extends CardHand {

	/**
	 * Default constructor for PlayerDeck; constructs an empty card hand.
	 */
	public PlayerDeck()
	{
		cards = new ArrayList<Card>();
	}
	
	/**
	 * Returns the numerical Blackjack value of this card hand, as according to typical rules of Blackjack. Aces are worth 11 unless the total is otherwise over 21, in which case Aces are worth 1.
	 * @return total value of this card hand
	 */
	int getValue()
	{
		return CardUtil.getValue(cards);
	}
	
	/**
	 * Returns the arrayList of cards as a String, used for debugging purposes.
	 */
	public String toString()
	{
		return cards.toString();
	}

	@Override
	Card removeCard() {
		return cards.remove(0);
	}

	@Override
	void addCard(Card c) {
		cards.add(c);
	}
	
	/**
	 * Returns this deck as an ArrayList of Cards
	 * @return ArrayList of Cards in this deck
	 */
	ArrayList<Card> getCards()
	{
		return cards;
	}

	/**
	 * Displays the cards in this deck by calling CardUtil.printCards()
	 * @return 
	 */
	public String displayDeck() {
		return CardUtil.displayCards(cards);
	}
	
	/**
	 * Flips all cards in this hand up
	 */
	public void flipAllUp()
	{
		for(Card c : cards)
			if(c.getFaceDown())
				c.flip();
	}
	
	/**
	 * flips the first card in the hand that is facedown
	 * @return true if there is a card to flip, false if not
	 */
	public boolean flip()
	{
		for(Card c : cards) {
			if(c.getFaceDown()) {
				c.flip();
				return true;
			}
		}
		return false;
	}

}
