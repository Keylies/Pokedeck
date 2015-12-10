package views;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import models.Energy;
import models.Trainer;
import controllers.AddEnergyCtrl;
import controllers.AddTrainerCtrl;
import controllers.ContentCtrl;

public class AddEnergyView extends AddView {

	public AddEnergyView(ContentCtrl ct) {
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
		
		titleLbl.setText("Add an Energy card");
	}
	
	protected void constructContentPanel() {
		
		super.constructContentPanel();

		contentPnl.setLayout(new GridLayout(6, 2));
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(Energy.energyTypes);
		typeTxt.setModel(model);
		
		addBtn.addActionListener(new AddEnergyCtrl(this));
		
		contentPnl.add(addBtn);
	}
}
