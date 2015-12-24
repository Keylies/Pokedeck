package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.Deck;
import models.TableModel;
import models.Trainer;
import controllers.AddTrainerCtrl;
import controllers.ContentCtrl;

/**
 * View to add Trainer cards
 * 
 * @author Clément
 *
 */
public class AddTrainerView extends AddView {
	
	private Deck deck;
	
	private JTextField ruleTxt;
	
	private TableModel tableModel;

	public AddTrainerView(ContentCtrl ct, Deck d, TableModel tm) {
		
		super(ct);
		deck = d;
		tableModel = tm;
	}
	
	public void constructPanel() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		constructTitlePanel();
		constructContentPanel();
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(titlePnl, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(contentPnl, c);
	}
	
	protected void constructTitlePanel() {
		
		super.constructTitlePanel();
		
		titleLbl.setText("Add a Trainer card");
	}
	
	protected void constructContentPanel() {
		
		super.constructContentPanel();
		GridBagConstraints c = new GridBagConstraints();
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(Trainer.trainerTypes);
		typeTxt.setModel(model);
		
		JLabel ruleLbl = new JLabel("Rule");
		ruleTxt = new JTextField();
		
		addBtn.addActionListener(new AddTrainerCtrl(this, deck, tableModel));
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5,10,5,10);
		c.weightx = 1;
		c.weighty = 1;
		
		c.gridx = 0;
		c.gridy = 9;
		contentPnl.add(ruleLbl, c);
		c.gridx = 0;
		c.gridy = 10;
		contentPnl.add(ruleTxt, c);
		
		c.gridx = 0;
		c.gridy = 11;
		contentPnl.add(addBtn, c);
	}
	
	/**
	 * Get the common fields values + the Rule special field
	 * 
	 * @return a string HashMap
	 */
	public HashMap<String, String> getData() {

		setData();
		
		data.put("rule", ruleTxt.getText());
		
		return data;
	}
	
	/**
	 * Set all fields to their default values
	 */
	public void reset() {
		
		super.reset();
		
		ruleTxt.setText("");
	}
}
