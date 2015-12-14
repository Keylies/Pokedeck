package controllers;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableCtrl implements TableModelListener {

	@Override
	public void tableChanged(TableModelEvent evt) {
		System.out.println(((TableModel) evt.getSource()));
		
	}

}
