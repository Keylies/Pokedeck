package models;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 * Custom model for the deck view table
 * 
 * @author Cl�ment
 *
 */
public class TableModel extends AbstractTableModel {
	
	private Deck deck;
	
	private String[] columnNames = 
		{
			"Card",
			"Name",
            "Type",
            "Desc",
            "HP",
            "Rule",
            "N�"
        };
	
	public TableModel(Deck d) {

		super();
		deck = d;
	}

	@Override
	public int getColumnCount() {
		
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		
		return deck.getCards().size();
	}
	
	public String getColumnName(int col) {
		
        return columnNames[col];
    }
	
	public Class getColumnClass(int col) {
		
		if (deck.getCards().isEmpty())
	        return Object.class;
		
        return getValueAt(0, col).getClass();
    }
	
	public boolean isCellEditable(int row, int col) {

        return col > 0 ;
    }

	@Override
	public Object getValueAt(int row, int col) {
		
		Card card = deck.getCards().get(row);
		
		String cardType = card.getClass().getName();
		cardType = cardType.substring(cardType.indexOf(".") + 1, cardType.length());
		
		Object value = null;
		
		switch (col) {
	        case 0:
	            value = cardType;
	            break;
	        case 1:
	            value = card.getName();
	            break;
	        case 2:
	            value = card.getType();
	            break;
	        case 3:
	            value = card.getDesc();
	            break;
	        case 4:
	            value = cardType.equals("Pokemon") ? ((Pokemon) card).getHp() : "None";
	            break;
	        case 5:
	            value = cardType.equals("Trainer") ? ((Trainer) card).getRule() : "None";
	            break;
	        case 6:
	            value = card.getNumber();
	            break;
		}
			
		return value;
	}
	
	public void setValueAt(Object value, int row, int col) {
		
		Card card = deck.getCards().get(row);
		
		String cardType = card.getClass().getName();
		cardType = cardType.substring(cardType.indexOf(".") + 1, cardType.length());
		
		switch (col) {
	        case 1:
	        	card.setName(value.toString());
	            break;
	        case 2:
	        	card.setType(value.toString());
	            break;
	        case 3:
	        	card.setDesc(value.toString());
	            break;
	        case 4:
	        	if ( cardType.equals("Pokemon") )
	        		((Pokemon) card).setHp((int) value);
	            break;
	        case 5:
	        	if ( cardType.equals("Trainer") )
	        		((Trainer) card).setRule(value.toString());
	            break;
	        case 6:
	        	card.setNumber((int) value);
	            break;
		}
		
		fireTableCellUpdated(row,col);
    }
}
