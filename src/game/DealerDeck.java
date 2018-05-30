package game;

import java.util.ArrayList;

public class DealerDeck extends CardHand {

	public DealerDeck()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.addAll(CardUtil.createDeck());
		CardUtil.shuffle(cards);
	}
	
	public DealerDeck(int decks)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int i = 0; i < decks; i++)
		{
			cards.addAll(CardUtil.createDeck());
		}
		CardUtil.shuffle(cards);
	}
	
	@Override
	void addCard(Card c) {
		cards.add(c);
	}

	@Override
	Card removeCard() {
		return cards.remove(0);
	}
	
}