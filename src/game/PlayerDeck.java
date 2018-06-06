package game;

import java.util.ArrayList;

/**
 * Subclass of CardHand for all Player card hands, containing an additional method to get the Blackjack value of the hand.
 * @author Joseph Daher
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

	@Override
	Card removeCard() {
		return cards.remove(0);
	}

	@Override
	void addCard(Card c) {
		cards.add(c);
	}
	
	/**
	 * Returns the numerical Blackjack value of this card hand, as according to typical rules of Blackjack. Aces are worth 11 unless the total is otherwise over 21, in which case Aces are worth 1.
	 * @return total value of this card hand
	 */
	int getValue()
	{
		return CardUtil.getValue(cards);
	}
	
	public String toString()
	{
		return cards.toString();
	}

}
