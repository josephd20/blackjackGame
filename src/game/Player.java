package game;

/**
 * Class modeling a Player, which implements the Moves interface.
 * @authors Joseph Daher and Ben Hanley
 */
public class Player implements Moves {

	private String name;
	private double money;
	private double currentBet;
	private PlayerDeck deck;
	private boolean inPlay;
	
	/**
	 * Constructor for Player class
	 * @param name name of Player
	 * @param money amount of money Player has
	 */
	public Player(String name, double money)
	{
		this.name = name;
		this.money = money;
		deck = new PlayerDeck();
	}

	/**
	 * Inital move in round of blackjack where a bet is required
	 * @param bet amount of money wagered initially
	 * @return bet amount of money wagered initially
	 */
	public double initialBet(double bet) {
		currentBet = bet;
		money -= bet;
		inPlay = true;
		return currentBet;
	}
	
	/**
	 * Method called after round of blackjack is complete with VictoryType object which determines whether the player won or lost the round
	 * @param vt VictoryType object containing information about the previously played round
	 * @return amount of money payed out
	 */
	public double payout(VictoryType vt) {
		double payout = 0;
		switch (vt)
		{
			case TIE:
				payout = currentBet;
				break;
			case LOSS:
				break;
			case WIN:
				payout = currentBet * 2;
				break;
			case BLACKJACK:
				payout = currentBet * 2.5;
				break;
		//	case INSURANCE:
		//		payout = currentBet * 3;
		//		break;
		//	case SURRENDER:
		//		payout = currentBet * 0.5;
		//		break;
			default:
				break;
		}
		currentBet = 0;
		money += payout;
		return payout;
	}
	
	/**
	 * Basic blackjack move of 'hit', where an additional card is dealt to the player's hand.
	 */
	@Override
	public void hit(Card c) {
		deck.addCard(c);
		if(CardUtil.getValue(deck.cards)>21)
			inPlay = false;
	}

	/**
	 * Basic blackjack move of 'standing', where the player chooses to keep his current hand
	 */
	@Override
	public void stand() {
		inPlay = false;
	}

	/**
	 * Basic blackjack move of 'doubling down', where the player commits to one more card and doubles his bet
	 */
	@Override
	public void doubleDown(Card c) {
		deck.addCard(c);
		if(money>currentBet)
		{
			money -= currentBet;
			currentBet *= 2;
		}
		else
		{
			currentBet += money;
			money = 0;
		}
		inPlay = false;
	}

	/**
	 * Basic blackjack move of 'surrendering', where the player halves his bet but forfeits the round
	 */
	@Override
	public void surrender() {
		inPlay = false;
	}

	/**
	 * Unimplemented method of 'splitting', an advanced Blackjack move.
	 */
	public void split() {
		
	}

	/**
	 * Clears this players current hand with a new hand.
	 */
	public void clearDeck() {
		deck = new PlayerDeck();
	}
	
	/**
	 * returns whether the player is still in the round or not
	 * @return whether the player is still in the round or not
	 */
	public boolean inPlay()
	{
		return inPlay;
	}
	
	/**
	 * returns the player's name
	 * @return the player's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * returns the money the player has
	 * @return money player has
	 */
	public double getMoney()
	{
		return money;
	}
	
	/**
	 * returns the numerical blackjack value of the player's current hand
	 * @return the numerical blackjack value of the player's current hand
	 */
	public int getValueOfHand()
	{
		return deck.getValue();
	}
	
	/**
	 * returns reference to the player's deck
	 * @return reference to the player's deck object
	 */
	public PlayerDeck getDeck()
	{
		return deck;
	}
	
	/**
	 * returns a string that allows the deck to be displayed as a string
	 * @return a string that allows the deck to be displayed as a string
	 */
	public String displayDeck()
	{
		return deck.displayDeck();
	}
	/**
	 * Flips all of the cards to a face up position
	 */
	public void flipAllUp()
	{
		deck.flipAllUp();
	}
	/**
	 * Flips a single card
	 * @return the boolean value of the card (flipped or not)
	 */
	public boolean flip()
	{
		return deck.flip();
	}
}
