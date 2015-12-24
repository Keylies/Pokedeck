package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Deck;
import models.TableModel;
import models.Trainer;
import views.AddTrainerView;

/**
 * AddTrainerView's controller, called when the Add button is pressed
 * 
 * @author Clément
 *
 */
public class AddTrainerCtrl implements ActionListener {

	private AddTrainerView addView;
	private Deck deck;
	private TableModel tableModel;
	
	public AddTrainerCtrl(AddTrainerView atv, Deck d, TableModel tm) {
		
		addView = atv;
		deck = d;
		tableModel = tm;
	}

	/*
	 * Get textfields' values from AddTrainerView in order to create a new Energy card
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
		String rule = addView.getData().get("rule");
		
		deck.addToDeck(new Trainer(name, desc, number, type, rule));
		
		addView.reset();
		
		tableModel = new TableModel(deck);
	}

}
