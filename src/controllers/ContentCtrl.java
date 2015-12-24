package controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

/**
 * FrameView's controller, called when a navigation button is pressed
 * 
 * @author Clément
 * 
 */
public class ContentCtrl implements ActionListener {
	
	JPanel content;
	CardLayout cl;
	
	public ContentCtrl(JPanel ct) {
		
		content = ct;
	}
	
	/*
	 * Get destination from the pressed button
	 * Show the linked panel/card
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {

		cl = (CardLayout)(content.getLayout());
	    cl.show(content, ((AbstractButton) evt.getSource()).getText());
	}

}
