package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.ContentCtrl;

/**
 * Parent view for add views, create the common elements between cards
 * 
 * @author Clément
 *
 */
abstract public class AddView extends JPanel {
	
	protected ContentCtrl content;
	
	protected JPanel titlePnl;
	protected JPanel contentPnl;
	
	protected JLabel titleLbl;
	
	protected JTextField nameTxt;
	protected JTextArea descTxt;
	protected JTextField numberTxt;
	protected JComboBox<String> typeTxt;
	
	protected JButton addBtn;
	
	protected HashMap<String, String> data;
	
	protected AddView(ContentCtrl ct) {
		super();
		content = ct;
	}

	protected void constructTitlePanel() {

		titlePnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		titleLbl = new JLabel();
		
		JButton homeBtn = new JButton("Deck");
		homeBtn.addActionListener(content);
		
		JButton addViewBtn = new JButton("Add cards menu");
		addViewBtn.addActionListener(content);
		
		c.insets = new Insets(10,10,0,10);

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		titlePnl.add(titleLbl, c);
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		titlePnl.add(homeBtn, c);
		
		c.gridx = 1;
		c.gridy = 1;
		titlePnl.add(addViewBtn, c);
	}
	
	protected void constructContentPanel() {

		contentPnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel nameLbl = new JLabel("Name");
		nameTxt = new JTextField();
		
		JLabel typeLbl = new JLabel("Type");
		typeTxt = new JComboBox<String>();
		
		JLabel descLbl = new JLabel("Description");
		descTxt = new JTextArea();
		
		JLabel numberLbl = new JLabel("Number");
		numberTxt = new JTextField();
		
		addBtn = new JButton("Add");
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5,10,5,10);
		c.weightx = 1;
		c.weighty = 1;

		c.gridx = 0;
		c.gridy = 0;
		contentPnl.add(nameLbl, c);
		c.gridx = 0;
		c.gridy = 1;
		contentPnl.add(nameTxt, c);
		
		c.gridx = 0;
		c.gridy = 3;
		contentPnl.add(typeLbl, c);
		c.gridx = 0;
		c.gridy = 4;
		contentPnl.add(typeTxt, c);
		
		c.gridx = 0;
		c.gridy = 5;
		contentPnl.add(descLbl, c);
		
		c.ipady = 40;
		c.gridx = 0;
		c.gridy = 6;
		contentPnl.add(descTxt, c);
		
		c.ipady = 1;
		c.gridx = 0;
		c.gridy = 7;
		contentPnl.add(numberLbl, c);
		c.gridx = 0;
		c.gridy = 8;
		contentPnl.add(numberTxt, c);
		
	}
	
	/**
	 * Put common fields values into a String Hashmap
	 */
	protected void setData() {
		
		data = new HashMap<String, String>();
		
		data.put("name", nameTxt.getText());
		data.put("type", (String) typeTxt.getSelectedItem());
		data.put("desc", descTxt.getText());
		data.put("number", numberTxt.getText());
	}
	
	/**
	 * Set common fields to their default values
	 */
	public void reset() {
		
		nameTxt.setText("");
		typeTxt.setSelectedIndex(0);
		descTxt.setText("");
		numberTxt.setText("");
	}

}
