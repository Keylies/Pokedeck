package views;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import models.Deck;
import models.Energy;
import controllers.AddEnergyCtrl;
import controllers.ContentCtrl;

public class AddEnergyView extends AddView {
	
	private Deck deck;

	public AddEnergyView(ContentCtrl ct, Deck d) {
		super(ct);
		deck = d;
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
		
		titleLbl.setText("Add an Energy card");
	}
	
	protected void constructContentPanel() {
		
		super.constructContentPanel();

		contentPnl.setLayout(new GridLayout(6, 2));
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(Energy.energyTypes);
		typeTxt.setModel(model);
		
		addBtn.addActionListener(new AddEnergyCtrl(this, deck));
		
		contentPnl.add(addBtn);
	}
	
	public HashMap<String, String> getData() {

		setData();
		
		return data;
	}
}
