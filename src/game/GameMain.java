package game;

import java.util.Scanner;

public class GameMain {

<<<<<<< HEAD
public class GameMain extends JFrame implements ActionListener {
	private CardHand deck;

	JFrame f = new JFrame();
	
	private static JButton hit   = new JButton("Hit Me");
	private static JButton stand = new JButton("Stand");
	private static JButton doubleDown  = new JButton("Double Down");
	private static JButton deal = new JButton("Deal");
	
	private JLabel status = new JLabel(" ", JLabel.CENTER);
	
	CardHand player;
	
	public GameMain() {
			f.setSize(1500,1500);
			f.setTitle("Blackjack");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel buttons = new JPanel();
       
	    	buttons.add(hit);
        	buttons.add(stand);
        	buttons.add(doubleDown);
        	buttons.add(deal);
        	hit.addActionListener(this);
        	stand.addActionListener(this);
        	doubleDown.addActionListener(this);
        	deal.addActionListener(this);
        	//hit.setEnabled(false);
        	//stand.setEnabled(false);
        	//doubleDown.setEnabled(false);
        	//deal.setEnabled(true);
        	
        		    
	    	
			getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	        //getContentPane().add(main);
	        getContentPane().add(buttons);
	        getContentPane().add(status);
	        
			pack();
			f.add(buttons);	
        	f.setVisible(true);
	}
=======
	static GameTable table;
	static Player human;
	static Player dealer;
	static Scanner in;
	static Deck mainDeck;
	
	public static void main(String[] args) {

		System.out.println("welcome");
		in = new Scanner(System.in);
		
		table = new GameTable(2);
		double casinoBank = 5E7;
		
		System.out.println("what you name");
		String name = in.next();
		
		System.out.println("how much cash you strappin");
		double humanMoney = in.nextDouble();
		double bet;
		
		dealer = new Player("dealer",casinoBank);
		human = new Player(name,humanMoney);
>>>>>>> fd50d9cd24a826a34f9d5dc6d7d2b8a9313998d8

		table.addPlayer(dealer);
		table.addPlayer(human);
		mainDeck = table.getMainDeck();
		
		boolean gameContinue = true;
		
		do
		{
			System.out.println("You have $" + human.getMoney());
			double initialMoney = human.getMoney();
			
            do {
            	System.out.println("How many dollars do you want to bet?  (Enter $0 to end)");
            	bet = in.nextInt();
            	if (bet < 0 || bet > human.getMoney())
            		System.out.println("Your answer must be between $0 and $" + human.getMoney());
            } while (bet < 0 || bet > human.getMoney());
            if (bet == 0)
               break;
            
            dealer.initialBet(human.initialBet(bet));
           	VictoryType vt = playBlackjack();
           	human.payout(vt);
           	
           	if(initialMoney < human.getMoney())
           	{
           		System.out.println(human.getName() + " wins $" + (human.getMoney() - initialMoney));
           	}
           	else if(initialMoney == human.getMoney())
           	{
           		System.out.println(human.getName() + " stayed even with $" + (human.getMoney() - initialMoney));
           	}
           	else
           	{
           		System.out.println(human.getName() + " lost $" + (initialMoney - human.getMoney()));
           	}
           	System.out.println("");
           	
            human.clearDeck();
            dealer.clearDeck();
		}
		while (gameContinue);
		
		System.out.println("Thanks for playing!");

	}
<<<<<<< HEAD
	public static void main(String[] args) {
		new GameMain();
	}
}
=======
	
	static VictoryType playBlackjack()
	{
 
     	mainDeck.shuffle();
     	dealer.hit(mainDeck.dealCard());
     	dealer.hit(mainDeck.dealCard());
     	human.hit(mainDeck.dealCard());
     	human.hit(mainDeck.dealCard());
        
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
		
		while(human.inPlay())
		{
			displayCards();
			System.out.println("choose move (h-hit/d-doubledown/s-stand)");
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
		}
        displayCards();
		
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
		else if (human.getValueOfHand() < 21 && (dealer.getValueOfHand() > 21 || dealer.getValueOfHand() < human.getValueOfHand())) {
			System.out.println( human.getName() + " wins.");
        	return VictoryType.WIN;
		}
		else if (dealer.getValueOfHand() < 21 && (human.getValueOfHand() > 21 || human.getValueOfHand() < dealer.getValueOfHand())) {
			System.out.println( human.getName() + " loses.");
			return VictoryType.LOSS;
		}
		else {
			System.out.println("Tie. Both " + human.getName() + " and " + dealer.getName() + " busted.");
			return VictoryType.TIE;
		}

  }
	
	public static void displayCards()
	{
		System.out.println("");
		System.out.println(human.getName() + ":" + (int) human.getValueOfHand());
		System.out.println(dealer.getName() + ":" + (int) dealer.getValueOfHand());
		System.out.println("");
	}
}
>>>>>>> fd50d9cd24a826a34f9d5dc6d7d2b8a9313998d8
