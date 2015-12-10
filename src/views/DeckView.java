package views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ContentCtrl;

public class DeckView extends JPanel {
	
	ContentCtrl contentCtrl;
	
	JPanel searchPnl;
	JPanel tablePnl;
	
	JLabel titleLbl;
	
	JButton addViewBtn;
	JButton deckViewBtn;
	
	public DeckView() {
		super();
	}
	
	public void constructPanel(ContentCtrl contentCtrl) {
		
		this.contentCtrl = contentCtrl;
		
		this.setLayout(new GridLayout(4, 1, 10, 10));
		
		titleLbl = new JLabel("Pokedeck");
		
		addViewBtn = new JButton("Add cards menu");
		addViewBtn.addActionListener(contentCtrl);
		
		constructSearchPanel();
		constructTablePanel();
		
		this.add(titleLbl);
		this.add(addViewBtn);
		this.add(searchPnl);
		this.add(tablePnl);
	}
	
	private void constructSearchPanel() {
		searchPnl = new JPanel(new GridLayout(2, 3));
	}
	
	private void constructTablePanel() {
		tablePnl = new JPanel(new GridLayout(1, 1));
	}
}
