package models;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	
	private Deck deck;
	
	private String[] columnNames = 
		{
			"Card",
			"Name",
            "Type",
            "Desc",
            "Rule / HP",
            "Number"
        };
	
	private HashMap<String, Object> data;
	
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
        return getValueAt(0, col).getClass();
    }
	
	public boolean isCellEditable(int row, int col) {

        return (col == 3) ? true : false;
    }

	@Override
	public Object getValueAt(int row, int col) {
		
		Card card = deck.getCards().get(row);
		
		String cardType = card.getClass().getName();
		cardType = cardType.substring(cardType.indexOf(".") + 1, cardType.length());
		
		//data = cardType.equals("Pokemon") ? ((Pokemon) card).getData() : cardType.equals("Trainer") ? ((Trainer) card).getData() : card.getData();
		
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
	            value = cardType.equals("Pokemon") ? ((Pokemon) card).getHp() : cardType.equals("Trainer") ? ((Trainer) card).getRule() : "";
	            break;
	        case 5:
	            value = card.getNumber();
	            break;
		}
			
		return value;
		
	}
	
	public void setValueAt(Object value, int row, int col) {
		
		Card card = deck.getCards().get(row);
		
		card.modifyDesc(value.toString());

        fireTableCellUpdated(row, col);
    }
}
