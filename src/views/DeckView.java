package views;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import models.Deck;
import models.TableModel;
import controllers.ContentCtrl;
import controllers.TableCtrl;

public class DeckView extends JPanel {
	
	private Deck deck;
	
	ContentCtrl contentCtrl;
	
	JPanel searchPnl;
	JPanel tablePnl;
	
	JLabel titleLbl;
	
	JButton addViewBtn;
	JButton deckViewBtn;
	
	public DeckView(ContentCtrl contentCtrl, Deck d) {
		super();
		this.contentCtrl = contentCtrl;
		deck = d;
	}
	
	public void constructPanel() {
		
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
		
		TableModel tableModel = new TableModel(deck);
		JTable table = new JTable(tableModel);

		tableModel.addTableModelListener(new TableCtrl());
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		tablePnl.add(scrollPane);
		
	}
}
