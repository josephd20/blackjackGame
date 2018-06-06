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
	
	/**
	 * 
	 * @param cards
	 * @return
	 */
	public static String displayCards(ArrayList<Card> cards)
	{
		String s = "";
		for(int i = 0; i < cards.size(); i++)
			s += "┌─────────┐" + "  ";
		s += "\n";
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < cards.size(); j++)
			{
				if(cards.get(j).getFaceDown())
					s += "│░░░░░░░░░│" + "  ";
				else
					if(i==0)
						s += "│" + cards.get(j).getStringValue(true) + "       │" + "  ";
					else if(i==3)
						s += "│    " + cards.get(j).getStringSuit() + "    │" + "  ";
					else if(i==6)
						s += "│       " + cards.get(j).getStringValue(false) + "│" + "  ";
					else
						s += "│         │" + "  ";
			}
			s += "\n";
		}
		for(int i = 0; i < cards.size(); i++)
			s += "└─────────┘" + "  ";
		return s;
	}
	
	public static void printCards(ArrayList<Card> cards)
	{
		for(int i = 0; i < cards.size(); i++)
			System.out.print("┌─────────┐" + "  ");
		System.out.print("\n");
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < cards.size(); j++)
			{
				if(cards.get(j).getFaceDown())
					System.out.print("│░░░░░░░░░│" + "  ");
				else
					if(i==0)
						System.out.print("│" + cards.get(j).getStringValue(true) + "       │" + "  ");
					else if(i==3)
						System.out.print("│    " + cards.get(j).getStringSuit() + "    │" + "  ");
					else if(i==6)
						System.out.print("│       " + cards.get(j).getStringValue(false) + "│" + "  ");
					else
						System.out.print("│         │" + "  ");
			}
			System.out.print("\n");
		}
		for(int i = 0; i < cards.size(); i++)
			System.out.print("└─────────┘" + "  ");
		System.out.print("\n");
	}
	
	public static void printCardsAlt(ArrayList<Card> cards)
	{
		for(int i = 0; i < cards.size(); i++)
			System.out.print("┌─────────┐" + "  ");
		System.out.print("\n");
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < cards.size(); j++)
			{
					System.out.print("│░░░░░░░░░│" + "  ");
			}
			System.out.print("\n");
		}
		for(int i = 0; i < cards.size(); i++)
			System.out.print("└─────────┘" + "  ");
		System.out.print("\n");
	}
	
}
