package game;

import java.util.ArrayList;

public class CardTester {

	public static void main(String[] args) {
		
		System.out.println("Card Test");
		
		Player p = new Player("Jeff",123);
		Deck deck = new Deck();
		p.getDeck().addCard(deck.dealCard());
		p.displayDeck();
		p.getDeck().getCards().get(0).flip();
		p.displayDeck();
		
	}

}
