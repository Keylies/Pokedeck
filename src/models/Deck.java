package models;
import java.util.ArrayList;

/**
 * Contains all the cards
 * 
 * @author Clément
 *
 */
public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void addToDeck(Card newCard) {
		cards.add(newCard);
	}

	public void removeFromDeck(Card oldCard) {
		cards.remove(oldCard);
	}
}
