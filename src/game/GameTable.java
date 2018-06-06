package game;

import java.util.ArrayList;

/**
 * Class for a table of blackjack with players and a main deck
 * @author Joseph Daher
 */
public class GameTable {

	ArrayList<Player> players;
	Deck mainDeck; 
	
	/**
	 * Constructor
	 * @param cardDecks how many decks are used in main card deck
	 */
	public GameTable(int cardDecks) {
		players = new ArrayList<Player>();
		mainDeck = new Deck(cardDecks);
	}
	
	/**
	 * Default constructor
	 */
	public GameTable()
	{
		players = new ArrayList<Player>();
		mainDeck = new Deck(2);
	}
	
	/**
	 * Adds a player to the table
	 * @param newPlayer player added to the table
	 */
	public void addPlayer(Player newPlayer)
	{
		players.add(newPlayer);
	}
	
	/**
	 * returns a player from the table
	 * @param i index of the player
	 * @return designated player
	 */
	public Player getPlayer(int i)
	{
		return players.get(i);
	}
	
	/**
	 * returns whether a round of blackjack at the table is complete
	 * @return whether round is complete
	 */
	public boolean isTurnComplete()
	{
		for(Player p : players)
		{
			if(p.inPlay())
				return false;
		}
		return true;
	}
	
	/**
	 * returns main (dealer) deck
	 * @return main deck
	 */
	public Deck getMainDeck()
	{
		return mainDeck;
	}

}
