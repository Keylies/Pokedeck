package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Deck;
import models.Pokemon;
import models.TableModel;
import views.AddPokemonView;

/**
 * AddPokemonView's controller, called when the Add button is pressed
 * 
 * @author Clément
 *
 */
public class AddPokemonCtrl implements ActionListener {

	private AddPokemonView addView;
	private Deck deck;
	private TableModel tableModel;
	
	public AddPokemonCtrl(AddPokemonView apv, Deck d, TableModel tm) {
		
		addView = apv;
		deck = d;
		tableModel = tm;
	}

	/*
	 * Get textfields' values from AddPokemonView in order to create a new Energy card 
	 * Add it to the current Deck
	 * Call to the view's reset function
	 * Update the table model
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {

		String name = addView.getData().get("name");
		String desc = addView.getData().get("desc");
		int number = Integer.parseInt(addView.getData().get("number"));
		String type = addView.getData().get("type");
		int hp = Integer.parseInt(addView.getData().get("hp"));
		
		deck.addToDeck(new Pokemon(name, desc, number, type, hp));
		
		addView.reset();
		
		tableModel = new TableModel(deck);
	}

}
