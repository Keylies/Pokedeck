package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.DeckView;
import models.Card;
import models.Deck;
import models.TableModel;


/**
 * Controller for the rmvButton in Deck View. Remove the selected card from the Deck.
 * 
 * @author Clément
 *
 */
public class RemoveCardCtrl implements ActionListener {

	private Deck deck;
	private DeckView deckView;
	private TableModel tableModel;
	
	public RemoveCardCtrl(DeckView dv, Deck d, TableModel tm) {
		
		deck = d;
		deckView = dv;
		tableModel = tm;
	}
	
	/*
	 * Remove the selected card in JTable from the Deck
	 * Update the table model
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( deckView.getRow() > -1 ) {
			
			Card selectedCard = deck.getCards().get(deckView.getRow());
			deck.removeFromDeck(selectedCard);
			
			tableModel = new TableModel(deck);
		}
	}

}
