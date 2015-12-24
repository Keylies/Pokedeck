package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Deck;
import views.FrameView;

/**
 * importItem's controller, called when the import JMenuItem is pressed
 * 
 * @author Clément
 *
 */
public class ImportCtrl implements ActionListener {
	
	private FrameView frameView;
	private Deck deck;
	private JFileChooser fc;
	
	public ImportCtrl(FrameView fv, Deck d) {
		frameView = fv;
		deck = d;
		fc = new JFileChooser();
	}

	/*
	 * Open a dialog frame
	 * Replace the current deck with JSON values from the file selected
	 * Update the frame
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		int returnVal = fc.showOpenDialog(frameView);
		ObjectMapper mapper = new ObjectMapper();
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
            File file = fc.getSelectedFile();

            try {
            	
				deck = mapper.readValue(file, Deck.class);
				frameView.update(deck);
			} catch (JsonParseException e) {
				
				e.printStackTrace();
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
        } else {
        	System.out.println("File error");
        }
   
	}

}
