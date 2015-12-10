package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AddPokemonView;
import views.AddMenuView;

public class AddPokemonCtrl implements ActionListener {

	private AddPokemonView addView;
	
	public AddPokemonCtrl(AddPokemonView apv) {
		addView = apv;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
	
	}

}
