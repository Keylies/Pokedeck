package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Card;
import models.Deck;
import models.Trainer;
import views.AddTrainerView;

public class AddTrainerCtrl implements ActionListener {

	private AddTrainerView addView;
	private Deck deck;
	
	public AddTrainerCtrl(AddTrainerView atv, Deck d) {
		addView = atv;
		deck = d;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		String name = addView.getData().get("name");
		String desc = addView.getData().get("desc");
		int number = Integer.parseInt(addView.getData().get("number"));
		String type = addView.getData().get("type");
		String rule = addView.getData().get("rule");
		
		deck.addToDeck(new Trainer(name, desc, number, type, rule));
		
		for ( Card card : deck.getCards() )
			System.out.println(card.toString());
	}

}
