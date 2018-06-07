package game;

/**
 * Interface of possible moves in Blackjack implemented by the Player class
 * @author Joseph Daher and Ben Hanley
 */

public interface Moves {
	
	void hit(Card c);
	void stand();
	void doubleDown(Card c);
	void surrender();
	void split();
	void clearDeck();
	
}
