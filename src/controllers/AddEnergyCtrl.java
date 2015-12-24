package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Deck;
import models.Energy;
import models.TableModel;
import views.AddEnergyView;

/**
 * AddEnergyView's controller, called when the Add button is pressed
 * 
 * @author Clément
 *
 */
public class AddEnergyCtrl implements ActionListener {

	private AddEnergyView addView;
	private Deck deck;
	private TableModel tableModel;
	
	public AddEnergyCtrl(AddEnergyView aev, Deck d, TableModel tm) {
		
		addView = aev;
		deck = d;
		tableModel = tm;
	}

	/*
	 * Get textfields' values from AddEnergyView in order to create a new Energy card 
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
		
		deck.addToDeck(new Energy(name, desc, number, type));
		
		addView.reset();
		
		tableModel = new TableModel(deck);
	}

}
