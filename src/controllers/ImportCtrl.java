package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Card;
import models.Deck;
import views.FrameView;


public class ImportCtrl implements ActionListener {
	
	private FrameView frameView;
	private Deck deck;
	private JFileChooser fc;
	
	public ImportCtrl(FrameView fv, Deck d) {
		frameView = fv;
		deck = d;
		fc = new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		int returnVal = fc.showOpenDialog(fc);
		ObjectMapper mapper = new ObjectMapper();
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.

            try {
            	
				deck = mapper.readValue(file, Deck.class);
				for ( Card card : deck.getCards() )
					System.out.println(card.toString());
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } else {
        	System.out.println("fail");
        }
   
	}

}
