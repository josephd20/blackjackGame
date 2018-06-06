package game;

import java.util.ArrayList;

public class GameTable {

	ArrayList<Player> players;
	Deck mainDeck; 
	
	public GameTable(int cardDecks) {
		players = new ArrayList<Player>();
		mainDeck = new Deck(cardDecks);
	}
	
	public GameTable()
	{
		players = new ArrayList<Player>();
		mainDeck = new Deck(2);
	}
	
	public void addPlayer(Player newPlayer)
	{
		players.add(newPlayer);
	}
	
	public Player getPlayer(int i)
	{
		return players.get(i);
	}
	
	public boolean isTurnComplete()
	{
		for(Player p : players)
		{
			if(p.inPlay())
				return false;
		}
		return true;
	}
	
	public Deck getMainDeck()
	{
		return mainDeck;
	}

}
