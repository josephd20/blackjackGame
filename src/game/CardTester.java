package game;

import java.util.ArrayList;

public class CardTester {

	public static void main(String[] args) {
		ArrayList<Card> test = CardUtil.createDeck();
		System.out.println(test);
		CardUtil.shuffle(test);
		System.out.println(test);
		
		Deck tester = new Deck();
		System.out.println(tester.getCards());
		
		System.out.println();
		System.out.println(CardUtil.getValue(tester.getCards()));

		PlayerDeck q = new PlayerDeck();
		q.addCard(tester.dealCard());
		q.addCard(tester.dealCard());
		System.out.println(CardUtil.getValue(q.getCards()));
		System.out.println(q.getCards());
		
	}

}
