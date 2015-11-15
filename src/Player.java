import java.util.ArrayList;


public class Player {
	private String playerName;
	private ArrayList<Card> playerDeck;
	private ArrayList<Card> playerHand;
	
	public Player() {
		playerName = "Anonymous";
		playerDeck = new ArrayList<Card>();
		playerHand = new ArrayList<Card>();
	}
	
	public Player(String name) {
		playerName = name;
		playerDeck = new ArrayList<Card>();
		playerHand = new ArrayList<Card>();
	}
	
	public void drawCard() {
		Card topOfDeck = playerDeck.get(playerDeck.size() - 1);
		playerHand.add(topOfDeck);
		playerDeck.remove(topOfDeck);
	}
	
	public void addToDeck(Card newCard) {
		playerDeck.add(newCard);
	}
	
	public String toString() {
		String deckDisplay = playerName + " cards\n";
		
		for ( Card card : playerDeck )	
			deckDisplay += "\t- " + card.toString() + "\n";

		return deckDisplay;
	}
}
