package game;

public class Player implements Moves {

	private String name;
	private double money;
	private double currentBet;
	private PlayerDeck deck;
	private boolean inPlay;
	
	public Player(String name, double money)
	{
		this.name = name;
		this.money = money;
		deck = new PlayerDeck();
	}

	public double initialBet(double bet) {
		currentBet = bet;
		money -= bet;
		inPlay = true;
		return currentBet;
	}
	
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
			case INSURANCE:
				payout = currentBet * 3;
				break;
			case SURRENDER:
				payout = currentBet * 0.5;
				break;
			default:
				break;
		}
		currentBet = 0;
		money += payout;
		return payout;
	}
	
	@Override
	public void hit(Card c) {
		deck.addCard(c);
		if(CardUtil.getValue(deck.cards)>21)
			inPlay = false;
	}

	@Override
	public void stand() {
		inPlay = false;
	}

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

	@Override
	public void surrender() {
		inPlay = false;
	}

	@Override
	public void split() {
		
	}

	@Override
	public void clearDeck() {
		deck = new PlayerDeck();
	}
	
	public boolean inPlay()
	{
		return inPlay;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public double getValueOfHand()
	{
		return deck.getValue();
	}
	
	public PlayerDeck getDeck()
	{
		return deck;
	}
}
