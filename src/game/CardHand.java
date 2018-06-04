package game;

import java.util.ArrayList;

public abstract class CardHand {
	
	ArrayList<Card> cards;
	
	abstract Card removeCard();
	abstract void addCard(Card c);
	abstract int score();
	
	// TEST
	
}
