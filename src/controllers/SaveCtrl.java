package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Deck;
import views.FrameView;

/**
 * saveItem's controller, called when the save JMenuItem is pressed
 * 
 * @author Clément
 *
 */
public class SaveCtrl implements ActionListener {
	
	private FrameView frameView;
	private Deck deck;
	private JFileChooser fc;
	
	public SaveCtrl(FrameView fv, Deck d) {
		
		frameView = fv;
		deck = d;
		fc = new JFileChooser();
	}

	/*
	 * Open a dialog frame
	 * Save the current deck cards to JSON format in the file selected
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		int returnVal = fc.showSaveDialog(frameView);
		ObjectMapper mapper = new ObjectMapper();

        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	
            File file = fc.getSelectedFile();

            try {
            	
				mapper.writerWithDefaultPrettyPrinter().writeValue(file, deck);
			} catch (JsonGenerationException e) {

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
