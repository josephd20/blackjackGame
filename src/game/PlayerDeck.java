package game;

import java.util.ArrayList;

public class PlayerDeck extends CardHand {

	public PlayerDeck()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
	}

	@Override
	public Card removeCard() {
		
		return null;
	}

	@Override
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public int score() {
		int s = 0;
		for(Card c:cards) {
			s+=c.getNumericalValue();
		}
		return s;
	}

}
