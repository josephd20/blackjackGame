package game;

<<<<<<< HEAD
import java.util.ArrayList;

public class GameMain {
=======
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
>>>>>>> 118a37b464e924365b99e72141f8210f0122f273


public class GameMain extends JFrame implements ActionListener {
	
	private static JButton hit   = new JButton("Hit Me");
	private static JButton stand = new JButton("Stand");
	private static JButton doubleDown  = new JButton("Double Down");
	private static JButton deal = new JButton("Deal");
	
	public static void main(String[] args) {
<<<<<<< HEAD

		System.out.println("welcome");
		
		int playerCount = 5;
		double initialMoney = 10000;
		int cardDecks = 2;
		
		Deck mainDeck = new Deck(2);
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 0; i < playerCount; i++)
		{
			players.add(new PlayerDeck());
		}
		
		while(playContinue)
		{
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < playerCount; j++)
				{
					players.get(j).hit(mainDeck.removeCard());
				}
			}
			while(turnContinue)
			{
				for(int i = 0; i < playerCount; i++)
				{
					if()
						players.get(i).hit();
					else if()
						players.get(i).stand();
					else if()
						players.get(i).doubleDown();
				}
			}
			
		}
=======
		
		JFrame f = new JFrame();
		f.setSize(1500,1500);
		f.setTitle("Blackjack");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    
	    JPanel buttons = new JPanel();
       
	    buttons.add(hit);
        buttons.add(stand);
        buttons.add(doubleDown);
        buttons.add(deal);
        
        f.add(buttons);
        
        f.setVisible(true);
	}
>>>>>>> 118a37b464e924365b99e72141f8210f0122f273

	public void actionPerformed(ActionEvent b) {
		if(b.getSource() == hit) {
			
		}
		
	}

}
