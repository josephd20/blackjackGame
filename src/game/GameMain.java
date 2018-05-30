package game;

import java.util.ArrayList;

public class GameMain {

	public static void main(String[] args) {

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

	}

}
