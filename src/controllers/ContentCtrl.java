package controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

public class ContentCtrl implements ActionListener {
	
	JPanel content;
	CardLayout cl;
	
	public ContentCtrl(JPanel ct) {
		
		content = ct;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {

		cl = (CardLayout)(content.getLayout());
	    cl.show(content, ((AbstractButton) evt.getSource()).getText());
	}

}
