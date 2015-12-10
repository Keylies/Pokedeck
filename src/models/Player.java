import java.util.ArrayList;


public class Player {
	private String playerName;
	private Deck playerDeck;
	private ArrayList<Card> playerHand;
	
	public Player() {
		playerName = "Anonymous";
		playerDeck = new Deck();
		playerHand = new ArrayList<Card>();
	}
	
	public Player(String name) {
		playerName = name;
		playerDeck = new Deck();
		playerHand = new ArrayList<Card>();
	}
	
	public void drawCard() {
		Card topOfDeck = playerDeck.getCards().get(playerDeck.getCards().size() - 1);
		playerHand.add(topOfDeck);
		playerDeck.getCards().remove(topOfDeck);
	}
	
	public void addToDeck(Card newCard) {
		playerDeck.getCards().add(newCard);
	}
	
	public String toString() {
		String deckDisplay = playerName + " cards\n";
		
		for ( Card card : playerDeck.getCards() )	
			deckDisplay += "\t- " + card.toString() + "\n";

		return deckDisplay;
	}
}
