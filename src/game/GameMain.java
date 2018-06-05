package game;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMain {

	static GameTable table;
	static Scanner in;
	
	public static void main(String[] args) {

		System.out.println("welcome");
		in = new Scanner(System.in);
		
		table = new GameTable();
		double casinoBank = 5E7;
		
		System.out.println("how many playaz");
		int number = in.nextInt();
		
		System.out.println("what you name");
		String name = in.next();
		
		System.out.println("how much cash you strappin");
		double humanMoney = in.nextDouble();
		double bet;
		
		Player dealer = new Player("dealer",casinoBank);
		Player human = new Player(name,humanMoney);

		table.addPlayer(dealer);
		table.addPlayer(human);
		
		boolean gameContinue = true;
		
		do
		{
			System.out.println("You have " + human.getMoney() + " dollars.");
            do {
            	System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");
            	bet = in.nextInt();
            	if (bet < 0 || bet > human.getMoney())
            		System.out.println("Your answer must be between 0 and " + human.getMoney() + '.');
            } while (bet < 0 || bet > human.getMoney());
            if (bet == 0)
               break;
            human.initialBet(bet);
            boolean roundWin = playBlackjackHand();
            if (roundWin)
               money = money + bet;
            else
               money = money - bet;
            if (money == 0) {
               TextIO.putln("Looks like you've are out of money!");
               gameContinue = false;
            }
		}
		while (gameContinue);

	}
	
	static boolean playBlackjack()
	{
		Player dealer = table.getPlayer(0);
     	Player human = table.getPlayer(1);
     	Deck mainDeck = table.getMainDeck();
 
     	mainDeck.shuffle();
     	dealer.hit(mainDeck.dealCard());
     	dealer.hit(mainDeck.dealCard());
     	human.hit(mainDeck.dealCard());
     	human.hit(mainDeck.dealCard());
     
        displayCards();
     	
		if (dealer.getValueOfHand() == 21) {
			return false;
		}
		 
		if (human.getValueOfHand() == 21) {
			return true;
		}
		 
		boolean gameContinue = true;
		 
		while (gameContinue) {
			char userAction;
			while(userAction=)
		} // end while loop
     
     /* If we get to this point, the user has Stood with 21 or less.  Now, it's
        the dealer's chance to draw.  Dealer draws cards until the dealer's
        total is > 16.  If dealer goes over 21, the dealer loses.
     */

     TextIO.putln();
     TextIO.putln("User stands.");
     TextIO.putln("Dealer's cards are");
     TextIO.putln("    " + dealerHand.getCard(0));
     TextIO.putln("    " + dealerHand.getCard(1));
     while (dealerHand.getBlackjackValue() <= 16) {
        Card newCard = deck.dealCard();
        TextIO.putln("Dealer hits and gets the " + newCard);
        dealerHand.addCard(newCard);
        if (dealerHand.getBlackjackValue() > 21) {
           TextIO.putln();
           TextIO.putln("Dealer busted by going over 21.  You win.");
           return true;
        }
     }
     TextIO.putln("Dealer's total is " + dealerHand.getBlackjackValue());
     
     /* If we get to this point, both players have 21 or less.  We
        can determine the winner by comparing the values of their hands. */
     
     TextIO.putln();
     if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
        TextIO.putln("Dealer wins on a tie.  You lose.");
        return false;
     }
     else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
        TextIO.putln("Dealer wins, " + dealerHand.getBlackjackValue() 
                         + " points to " + userHand.getBlackjackValue() + ".");
        return false;
     }
     else {
        TextIO.putln("You win, " + userHand.getBlackjackValue() 
                         + " points to " + dealerHand.getBlackjackValue() + ".");
        return true;
     }

  }  // end playBlackjack()
	
	public static void displayCards()
	{
		System.out.println();
	}
}