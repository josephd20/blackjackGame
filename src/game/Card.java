package game;

/**
 * Class modeling a playing card, with a suit (heart/spades/diamonds/clubs) and value (1-10/jack/queen/king/ace)
 * @author Joseph Daher and Ben Hanley
 */
public class Card {

	private CardSuit suit;
	private CardValue value;
	private boolean faceDown;
	
	/**
	 * Constructor for Card requires a designated suit and value.
	 * @param suit suit of playing card (i.e. diamonds)
	 * @param value value of playing card (i.e. ace)
	 */
	public Card(CardSuit suit, CardValue value)
	{
		this.suit = suit;
		this.value = value;
		faceDown = true;
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
		switch(getValue())
		{
			case TWO:
				return 2;
			case THREE:
				return 3;
			case FOUR:
				return 4;
			case FIVE:
				return 5;
			case SIX:
				return 6;
			case SEVEN:
				return 7;
			case EIGHT:
				return 8;
			case NINE:
				return 9;
			case TEN:
				return 10;
			case JACK:
				return 10;
			case QUEEN:
				return 10;
			case KING:
				return 10;
			case ACE:
			default:
				return 1;
		}
	}
	
	public boolean getFaceDown()
	{
		return faceDown;
	}
	
	public void flip()
	{
		faceDown = !faceDown;
	}
	
	public String getStringValue(boolean top)
	{
		if(top)
			switch(getValue())
			{
				case TWO:
					return "2 ";
				case THREE:
					return "3 ";
				case FOUR:
					return "4 ";
				case FIVE:
					return "5 ";
				case SIX:
					return "6 ";
				case SEVEN:
					return "7 ";
				case EIGHT:
					return "8 ";
				case NINE:
					return "9 ";
				case TEN:
					return "10";
				case JACK:
					return "J ";
				case QUEEN:
					return "Q ";
				case KING:
					return "K ";
				case ACE:
				default:
					return "A ";
			}
		else
			switch(getValue())
			{
				case TWO:
					return " 2";
				case THREE:
					return " 3";
				case FOUR:
					return " 4";
				case FIVE:
					return " 5";
				case SIX:
					return " 6";
				case SEVEN:
					return " 7";
				case EIGHT:
					return " 8";
				case NINE:
					return " 9";
				case TEN:
					return "10";
				case JACK:
					return " J";
				case QUEEN:
					return " Q";
				case KING:
					return " K";
				case ACE:
				default:
					return " A";
			}
	}
	
	public String getStringSuit()
	{
		switch(getSuit())
		{
			case HEARTS:
				return "♥";
				// ♥
			case SPADES:
				return "♠";
				// ♠
			case DIAMONDS:
				return "♦";
				// ♦
			case CLUBS:
			default:
				return "♣";
				// ♣
		}
	}
}
