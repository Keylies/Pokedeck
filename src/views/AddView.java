package views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controllers.ContentCtrl;

abstract public class AddView extends JPanel {
	
	protected ContentCtrl content;
	
	protected JPanel titlePnl;
	protected JPanel contentPnl;
	
	protected JLabel titleLbl;
	
	protected JComboBox<String> typeTxt;
	
	protected JButton addBtn;
	
	protected AddView(ContentCtrl ct) {
		super();
		content = ct;
	}

	protected void constructTitlePanel() {
		titlePnl = new JPanel(new GridLayout(1, 3, 10, 10));
		
		titleLbl = new JLabel();
		
		JButton homeBtn = new JButton("Deck");
		homeBtn.addActionListener(content);
		
		JButton addViewBtn = new JButton("Add cards menu");
		addViewBtn.addActionListener(content);
		
		titlePnl.add(titleLbl);
		titlePnl.add(homeBtn);
		titlePnl.add(addViewBtn);
	}
	
	protected void constructContentPanel() {
		
		contentPnl = new JPanel();
		
		JLabel nameLbl = new JLabel("Name");
		JTextField nameTxt = new JTextField();
		
		JLabel typeLbl = new JLabel("Type");
		typeTxt = new JComboBox<String>();
		
		JLabel descLbl = new JLabel("Description");
		JTextArea descTxt = new JTextArea();
		
		JLabel numberLbl = new JLabel("Number");
		JTextField numberTxt = new JTextField();
		
		addBtn = new JButton("Add");
		
		contentPnl.add(nameLbl);
		contentPnl.add(nameTxt);
		
		contentPnl.add(typeLbl);
		contentPnl.add(typeTxt);
		
		contentPnl.add(descLbl);
		contentPnl.add(descTxt);
		
		contentPnl.add(numberLbl);
		contentPnl.add(numberTxt);
	}

}
