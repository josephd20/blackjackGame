package game;

import java.util.ArrayList;

public class PlayerDeck extends CardHand {

	public PlayerDeck()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
	}

	@Override
	Card removeCard() {
		return cards.remove(0);
	}

	@Override
	void addCard(Card c) {
		cards.add(c);
	}
	
	double getValue()
	{
		return CardUtil.getValue(cards);
	}

}
