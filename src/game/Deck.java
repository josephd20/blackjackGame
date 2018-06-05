package game;

import java.util.ArrayList;

public class Deck extends CardHand {

	public Deck()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.addAll(CardUtil.createDeck());
		CardUtil.shuffle(cards);
	}
	
	public Deck(int decks)
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
	
	Card dealCard() {
		return this.removeCard();
	}
	
	void shuffle() {
		CardUtil.shuffle(cards);
	}
	
}