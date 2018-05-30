package game;

import java.util.ArrayList;
import java.util.Collections;

public class CardUtil {
	
	public static ArrayList<Card> createDeck()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		for(CardValue value:CardValue.values())
		{
			for(CardSuit suit:CardSuit.values())
			{
				cards.add(new Card(suit, value));
			}
		}	
		return cards;
	}
	
	public static void shuffle(ArrayList<Card> cards)
	{
		Collections.shuffle(cards);
	}
	
}
