package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Card;
import models.Deck;
import models.Energy;
import views.AddEnergyView;

public class AddEnergyCtrl implements ActionListener {

	private AddEnergyView addView;
	private Deck deck;
	
	public AddEnergyCtrl(AddEnergyView aev, Deck d) {
		addView = aev;
		deck = d;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		String name = addView.getData().get("name");
		String desc = addView.getData().get("desc");
		int number = Integer.parseInt(addView.getData().get("number"));
		String type = addView.getData().get("type");
		
		deck.addToDeck(new Energy(name, desc, number, type));
		
		for ( Card card : deck.getCards() )
			System.out.println(card.toString());
	}

}
