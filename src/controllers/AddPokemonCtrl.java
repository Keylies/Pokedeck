package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Card;
import models.Deck;
import models.Pokemon;
import views.AddPokemonView;

public class AddPokemonCtrl implements ActionListener {

	private AddPokemonView addView;
	private Deck deck;
	
	public AddPokemonCtrl(AddPokemonView apv, Deck d) {
		addView = apv;
		deck = d;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		String name = addView.getData().get("name");
		String desc = addView.getData().get("desc");
		int number = Integer.parseInt(addView.getData().get("number"));
		String type = addView.getData().get("type");
		int hp = Integer.parseInt(addView.getData().get("hp"));
		
		deck.addToDeck(new Pokemon(name, desc, number, type, hp));
		
		for ( Card card : deck.getCards() )
			System.out.println(card.toString());
	}

}
