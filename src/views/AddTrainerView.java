package views;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.Deck;
import models.Trainer;
import controllers.AddTrainerCtrl;
import controllers.ContentCtrl;

public class AddTrainerView extends AddView {
	
	private Deck deck;
	
	private JTextField ruleTxt;

	public AddTrainerView(ContentCtrl ct, Deck d) {
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
		
		titleLbl.setText("Add a Trainer card");
	}
	
	protected void constructContentPanel() {
		
		super.constructContentPanel();

		contentPnl.setLayout(new GridLayout(6, 2));
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(Trainer.trainerTypes);
		typeTxt.setModel(model);
		
		JLabel ruleLbl = new JLabel("Rule");
		ruleTxt = new JTextField();
		
		addBtn.addActionListener(new AddTrainerCtrl(this, deck));
		
		contentPnl.add(ruleLbl);
		contentPnl.add(ruleTxt);
		
		contentPnl.add(addBtn);
	}
	
	public HashMap<String, String> getData() {

		setData();
		
		data.put("rule", ruleTxt.getText());
		
		return data;
	}
}
