package game;

/**
 * Class modeling a playing card, with a suit (heart/spades/diamonds/clubs) and value (1-10/jack/queen/king/ace)
 * @author Joseph Daher
 */
public class Card {

	private CardSuit suit;
	private CardValue value;
	
	/**
	 * Constructor for Card requires a designated suit and value.
	 * @param suit suit of playing card (i.e. diamonds)
	 * @param value value of playing card (i.e. ace)
	 */
	public Card(CardSuit suit, CardValue value)
	{
		this.suit = suit;
		this.value = value;
	}
	
	/**
	 * Accessor method for suit of a Card object
	 * @return suit of Card
	 */
	public CardSuit getSuit()
	{
		return suit;
	}
	
	/**
	 * Accessor method for value of a Card object
	 * @return value of Card
	 */
	public CardValue getValue()
	{
		return value;
	}
	
	/**
	 * Returns the numerical value corresponding to this card, with Jack, King and Queen being worth 10 and Ace being worth 11
	 * @return integer corresponding to numerical value of card
	 */
	public int getNumericalValue()
	{
		int[] values = {2,3,4,5,6,7,8,9,10,10,10,11};
		return values[this.getValue().ordinal()];
	}
}
