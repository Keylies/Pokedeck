package models;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 * Custom cell editor to populate the card type column with the appropriate ComboBox
 * 
 * @author Clément
 *
 */
public class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor {

	private TableCellEditor editor;
	private Deck deck;
	
	public CustomTableCellEditor(Deck d) {
		
		super();
		deck = d;
	}
	
	@Override
	public Object getCellEditorValue() {
		
		 if (editor != null) {
             return editor.getCellEditorValue();
         }

         return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		
		Card card = deck.getCards().get(row);
		
		String cardType = card.getClass().getName();
		cardType = cardType.substring(cardType.indexOf(".") + 1, cardType.length());
		
		 if ( cardType.equals("Trainer") )
             editor = new DefaultCellEditor(new JComboBox<String>(Trainer.trainerTypes));
		 else
			 editor = new DefaultCellEditor(new JComboBox<String>(Energy.energyTypes));

         return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
	}

}
