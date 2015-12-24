package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import models.CustomTableCellEditor;
import models.Deck;
import models.TableModel;
import controllers.ContentCtrl;

/**
 * View for the deck, show cards details in a table
 * 
 * @author Cl�ment
 *
 */
public class DeckView extends JPanel {
	
	private Deck deck;
	
	ContentCtrl contentCtrl;
	
	JPanel searchPnl;
	JPanel tablePnl;
	
	JLabel titleLbl;
	
	JButton addViewBtn;
	JButton deckViewBtn;
	
	JTextField filterTxt;
	TableRowSorter<TableModel> sorter;
	
	public DeckView(ContentCtrl contentCtrl, Deck d) {
		super();
		this.contentCtrl = contentCtrl;
		deck = d;
	}
	
	public void constructPanel() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		titleLbl = new JLabel("Pokedeck");
		
		addViewBtn = new JButton("Add cards menu");
		addViewBtn.addActionListener(contentCtrl);
		
		constructSearchPanel();
		constructTablePanel();
		
		c.insets = new Insets(10,0,0,0);
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(titleLbl, c);

		c.gridx = 0;
		c.gridy = 1;
		this.add(addViewBtn, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(searchPnl, c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(tablePnl, c);
	}
	
	private void constructSearchPanel() {

		searchPnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel filterLbl = new JLabel("Search :");
		
		filterTxt = new JTextField(10);

		filterTxt.getDocument().addDocumentListener(
			new DocumentListener() {
	           public void changedUpdate(DocumentEvent e) {
	               newFilter();
	           }
	           public void insertUpdate(DocumentEvent e) {
	               newFilter();
	           }
	           public void removeUpdate(DocumentEvent e) {
	               newFilter();
	           }
			});
		
		c.insets = new Insets(0,5,0,5);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		searchPnl.add(filterLbl, c);

		c.gridx = 1;
		c.gridy = 0;
		searchPnl.add(filterTxt, c);
	}
	
	private void constructTablePanel() {

		tablePnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		TableModel tableModel = new TableModel(deck);
		sorter = new TableRowSorter<TableModel>(tableModel);
		JTable table = new JTable(tableModel);
		
		TableColumn typeColumn = table.getColumnModel().getColumn(2);
		typeColumn.setCellEditor(new CustomTableCellEditor(deck));
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);
		
		c.gridx = 0;
		c.gridy = 0;
		tablePnl.add(scrollPane, c);
	}
	
	/**
	 * Get the value of the filter TextField and sort the table rows with this value
	 */
    private void newFilter() {
    	
        RowFilter<TableModel, Object> rf = null;

        try {
            rf = RowFilter.regexFilter(filterTxt.getText());
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        sorter.setRowFilter(rf);
    }
}
