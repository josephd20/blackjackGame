package game;

public interface Moves {
	
	void hit(Card c);
	void stand();
	void doubleDown(Card c);
	void surrender();
	void split();
	
	void clearDeck();
	
}
