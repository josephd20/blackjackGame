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

	@Override
	public void initialBet(double bet) {
		currentBet = bet;
		money -= bet;
		inPlay = true;
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
	}

	@Override
	public void surrender() {
		currentBet *= 0.5;
		money += currentBet;
	}

	@Override
	public void split() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearDeck() {
		deck = new PlayerDeck();
	}
	
}
