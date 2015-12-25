package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.Deck;
import models.Energy;
import models.TableModel;
import controllers.AddPokemonCtrl;
import controllers.ContentCtrl;

/**
 * View to add Pokemon cards
 * 
 * @author Clément
 *
 */
public class AddPokemonView extends AddView {
	
	private Deck deck;
	
	private JTextField hpTxt;
	
	private TableModel tableModel;

	public AddPokemonView(ContentCtrl ct, Deck d, TableModel tm) {
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
		
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 400;
		c.gridx = 0;
		c.gridy = 1;
		this.add(contentPnl, c);
	}
	
	protected void constructTitlePanel() {
		
		super.constructTitlePanel();
		
		titleLbl.setText("Add a Pokemon card");
	}
	
	protected void constructContentPanel() {
		
		super.constructContentPanel();
		GridBagConstraints c = new GridBagConstraints();
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(Energy.energyTypes);
		typeTxt.setModel(model);
		
		JLabel hpLbl = new JLabel("HP");
		hpTxt = new JTextField();
		
		addBtn.addActionListener(new AddPokemonCtrl(this, deck, tableModel));
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5,10,5,10);
		c.weightx = 1;
		c.weighty = 1;
		
		c.gridx = 0;
		c.gridy = 9;
		contentPnl.add(hpLbl, c);
		c.gridx = 0;
		c.gridy = 10;
		contentPnl.add(hpTxt, c);
		
		c.gridx = 0;
		c.gridy = 11;
		contentPnl.add(addBtn, c);
	}
	
	/**
	 * Get the common fields values + the Hp special field
	 * 
	 * @return a string HashMap
	 */
	public HashMap<String, String> getData() {

		setData();
		
		data.put("hp", hpTxt.getText());
		
		return data;
	}

	/**
	 * Set all fields to their default values
	 */
	public void reset() {
		
		super.reset();
		
		hpTxt.setText("");
	}
}
