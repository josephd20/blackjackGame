package game;

public interface Moves {

	void initialBet(double bet);
	
	void hit(Card c);
	void stand();
	void doubleDown(Card c);
	void surrender();
	void split();
	
	void clearDeck();
	
}
