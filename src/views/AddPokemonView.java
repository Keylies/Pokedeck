package views;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.Energy;
import controllers.AddPokemonCtrl;
import controllers.ContentCtrl;

public class AddPokemonView extends AddView {
	
	private JTextField hpTxt;

	public AddPokemonView(ContentCtrl ct) {
		super(ct);
	}
	
	public void constructPanel() {
		
		this.setLayout(new GridLayout(2, 1));
		
		constructTitlePanel();
		constructContentPanel();
		
		this.add(titlePnl);
		this.add(contentPnl);
	}
	
	protected void constructTitlePanel() {
		
		super.constructTitlePanel();
		
		titleLbl.setText("Add a Pokemon card");
	}
	
	protected void constructContentPanel() {
		
		super.constructContentPanel();

		contentPnl.setLayout(new GridLayout(6, 2));
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(Energy.energyTypes);
		typeTxt.setModel(model);
		
		JLabel hpLbl = new JLabel("HP");
		hpTxt = new JTextField();
		
		addBtn.addActionListener(new AddPokemonCtrl(this));
		
		contentPnl.add(hpLbl);
		contentPnl.add(hpTxt);
		
		contentPnl.add(addBtn);
	}
}
