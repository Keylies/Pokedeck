package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;

import models.Deck;
import models.Energy;
import models.TableModel;
import controllers.AddEnergyCtrl;
import controllers.ContentCtrl;

/**
 * View to add Energy cards
 * 
 * @author Clément
 *
 */
public class AddEnergyView extends AddView {
	
	private Deck deck;
	
	private TableModel tableModel;

	public AddEnergyView(ContentCtrl ct, Deck d, TableModel tm) {
		
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
		
		titleLbl.setText("Add an Energy card");
	}
	
	protected void constructContentPanel() {
		
		super.constructContentPanel();
		GridBagConstraints c = new GridBagConstraints();

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(Energy.energyTypes);
		typeTxt.setModel(model);
		
		addBtn.addActionListener(new AddEnergyCtrl(this, deck, tableModel));
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5,10,5,10);
		c.weightx = 1;
		c.weighty = 1;
		
		c.gridx = 0;
		c.gridy = 9;
		contentPnl.add(addBtn, c);
	}
	
	/**
	 * Get the common fields values
	 * 
	 * @return a string HashMap
	 */
	public HashMap<String, String> getData() {

		setData();
		
		return data;
	}
}
