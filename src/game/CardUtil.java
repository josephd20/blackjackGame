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
	
	public static int getValue(ArrayList<Card> cards)
	{
		int count = 0;
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i).getValue()!=CardValue.ACE)
			{
				count += cards.get(i).getNumericalValue();
			}
		}
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i).getValue()==CardValue.ACE)
			{
				if(count<=10)
					count += 11;
				else
					count += 1;
			}
		}
		return count;
	}
	
}
