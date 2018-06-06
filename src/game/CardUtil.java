package game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class with an assortment of useful static methods dealing with Cards
 * @author Joseph Daher
 */
public class CardUtil {
	
	/**
	 * Creates an ArrayList of the 52 cards in a typical playing deck; one for each value and suit.
	 * @return ArrayList of 52 playing Cards
	 */
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
	
	/**
	 * Shuffles an ArrayList of cards
	 * @param cards shuffled ArrayList of cards
	 */
	public static void shuffle(ArrayList<Card> cards)
	{
		Collections.shuffle(cards);
	}
	
	/**
	 * Calculates the blackjack value of an ArrayList of cards, with 2-10 being worth 2-10, Jack being 10, Queen being 10, King being 10, and Ace being 1 or 11.
	 * @param cards ArrayList of cards whose value is calculated
	 * @return numerical value of card hand according to blackjack rules
	 */
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
