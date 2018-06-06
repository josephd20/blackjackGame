package game;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMain {
	static GameTable table;
	static Player human;
	static Player dealer;
	static Scanner in;
	static Deck mainDeck;
	
	public static void main(String[] args) {

		System.out.println("Welcome to the Bronxville Casino!");
		System.out.println("");
		in = new Scanner(System.in);
		
		table = new GameTable(2);
		double casinoBank = 5E7;
		
		System.out.print("Please enter your player name: ");
		String name = in.next().trim();
		System.out.println("");
		
		double humanMoney = 50000;
		double bet;
		double initialMoney = humanMoney;
		
		System.out.println("You have been given $" + humanMoney +" to start. Good luck!");
		System.out.println("");
		
		dealer = new Player("Dealer",casinoBank);
		human = new Player(name,humanMoney);

		table.addPlayer(dealer);
		table.addPlayer(human);
		mainDeck = table.getMainDeck();
		
		boolean gameContinue = true;
		int roundCount = 1;
		int buyIn = 50;
		
		// Main game loop
		do
		{
			System.out.println("[Round " + roundCount +"]");
			System.out.println("You have $" + human.getMoney());
			System.out.println("");
			double initialRoundMoney = human.getMoney();
			
			// Bet input loop
            do {
            	// checks if player has sufficient money to play
            	if(human.getMoney() < buyIn)
            	{
            		bet = 0;
            		System.out.println("You do not have any more money to play. Game over!");
            		break;
            	}            		
            	
            	System.out.println("How many dollars do you want to bet? The buy-in is at $"+ buyIn + ".");
            	System.out.println("To leave the table, bet $0");
            	
            	if(in.hasNextDouble())
            		bet = (double) (int) in.nextDouble();
            	else
            		bet = buyIn;
            	
            	if ((bet < buyIn && bet != 0) || bet > human.getMoney())
            		System.out.println("Your answer must be between $" + buyIn + " and $" + human.getMoney());
            	
            } while ((bet < buyIn && bet != 0) || bet > human.getMoney());
            
            System.out.println("");
            
            if (bet == 0)
               break;
            
            dealer.initialBet(human.initialBet(bet));
           	VictoryType vt = playBlackjack();
           	human.payout(vt);
           	
           	if(initialRoundMoney < human.getMoney())
           	{
           		System.out.println(human.getName() + " wins $" + (human.getMoney() - initialRoundMoney));
           	}
           	else if(initialRoundMoney == human.getMoney())
           	{
           		System.out.println(human.getName() + " stayed even with $" + (human.getMoney() - initialRoundMoney));
           	}
           	else
           	{
           		System.out.println(human.getName() + " lost $" + (initialRoundMoney - human.getMoney()));
           	}
           	System.out.println(human.getName() + " now has $" + human.getMoney());
           	System.out.println("");
           	
            human.clearDeck();
            dealer.clearDeck();
            roundCount++;
            
            // Shuffles the main card deck every five rounds
            if(roundCount%5==0)
            	mainDeck.shuffle();
		}
		while (gameContinue);
		
		System.out.println("Thanks for playing!");
		in.close();

	}
	static VictoryType playBlackjack()
	{
 
     	mainDeck.shuffle();
     	dealer.hit(mainDeck.dealCard());
     	dealer.hit(mainDeck.dealCard());
     	human.hit(mainDeck.dealCard());
     	human.hit(mainDeck.dealCard());
     	
     	human.flipAllUp();
     	dealer.flip();
        
        if (dealer.getValueOfHand() == 21 && human.getValueOfHand() == 21) {
        	dealer.flipAllUp();
        	displayCardText();
        	System.out.println("Tie. Both " + human.getName() + " and " + dealer.getName() + " got blackjack.");
			return VictoryType.TIE;
		}
        else if (dealer.getValueOfHand() == 21) {
        	dealer.flipAllUp();
        	displayCardText();
        	System.out.println( human.getName() + " loses. " + dealer.getName() + " got blackjack.");
        	return VictoryType.LOSS;
		}
		else if (human.getValueOfHand() == 21) {
			dealer.flipAllUp();
			displayCardText();
			System.out.println( human.getName() + " wins with blackjack.");
			return VictoryType.BLACKJACK;
		}
		
		while(human.inPlay())
		{
			displayCardText();
			
			System.out.println("\tH - Hit");
			System.out.println("\tD - Double Down");
			System.out.println("\tS - Stand");
			System.out.print("Enter move: ");
			
			String userAction = in.next();
			switch(userAction)
			{
				case "H":
				case "h":
					System.out.println(human.getName() + " hits.");
					human.hit(mainDeck.dealCard());
					break;
				case "D":
				case "d":
					System.out.println(human.getName() + " doubles down.");
					human.doubleDown(mainDeck.dealCard());
					break;
				case "S":
				case "s":
				default:
					System.out.println(human.getName() + " stands.");
					human.stand();
					break;
			}
			System.out.println("");
			human.flipAllUp();
		}
		while(dealer.inPlay())
		{
			if(dealer.getValueOfHand()<17)
			{
				dealer.doubleDown(mainDeck.dealCard());
			}
			else if(dealer.getValueOfHand()<17)
			{
				dealer.hit(mainDeck.dealCard());
			}
			else
			{
				dealer.stand();
			}
			dealer.flipAllUp();
			displayCardText();
		}
        
		System.out.println(human.getName() + ": " + human.getValueOfHand() + " to " + dealer.getName() + ": " + dealer.getValueOfHand());
        if (dealer.getValueOfHand() == 21 && human.getValueOfHand() == 21) {
        	System.out.println("Tie. Both " + human.getName() + " and " + dealer.getName() + " got blackjack.");
			return VictoryType.TIE;
		}
        else if (dealer.getValueOfHand() == 21) {
        	System.out.println( human.getName() + " loses. " + dealer.getName() + " got blackjack.");
        	return VictoryType.LOSS;
		}
		else if (human.getValueOfHand() == 21) {
			System.out.println( human.getName() + " wins with blackjack.");
			return VictoryType.BLACKJACK;
		}
		else if (human.getValueOfHand() < 21 && dealer.getValueOfHand() < human.getValueOfHand()) {
			System.out.println( human.getName() + " wins with a better hand.");
        	return VictoryType.WIN;
		}
		else if (human.getValueOfHand() < 21 && dealer.getValueOfHand() > 21) {
			System.out.println( human.getName() + " wins because " + dealer.getName() + " busted.");
        	return VictoryType.WIN;
		}
		else if (dealer.getValueOfHand() < 21 && human.getValueOfHand() > 21) {
			System.out.println( human.getName() + " busts.");
			return VictoryType.LOSS;
		}
		else if (dealer.getValueOfHand() < 21 && human.getValueOfHand() < dealer.getValueOfHand()) {
			System.out.println( human.getName() + " loses because " + dealer.getName() + " has a better hand.");
			return VictoryType.LOSS;
		}
		else if(dealer.getValueOfHand()==human.getValueOfHand()) {
			System.out.println("Tie. Both " + human.getName() + " and " + dealer.getName() + " have equal value hands.");
			return VictoryType.TIE;
		}
        else {
			System.out.println("Tie. Both " + human.getName() + " and " + dealer.getName() + " busted.");
			return VictoryType.TIE;
		}

	}
	
	public static void displayCardText()
	{
		System.out.println(human.getName() + ":");
		System.out.println(human.displayDeck());
		System.out.println(dealer.getName() + ":");
		System.out.println(dealer.displayDeck());
	}
	
}


