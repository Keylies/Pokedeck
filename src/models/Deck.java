package models;
import java.util.ArrayList;


public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	};
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void addToDeck(Card newCard) {
		cards.add(newCard);
	}
}
