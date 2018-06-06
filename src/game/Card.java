package game;

public class Card {

	private CardSuit suit;
	private CardValue value;
	
	public Card(CardSuit suit, CardValue value)
	{
		this.suit = suit;
		this.value = value;
	}
	
	public CardSuit getSuit()
	{
		return suit;
	}
	
	public CardValue getValue()
	{
		return value;
	}
	
	public int getNumericalValue()
	{
		int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,11};
		return values[this.getValue().ordinal()];
	}
}
