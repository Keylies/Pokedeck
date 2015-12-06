import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;


public class AddCardCtrl implements ActionListener {
	
	private AddCardView addCardView;
	
	public AddCardCtrl(AddCardView adv) {
		addCardView = adv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((AbstractButton) e.getSource()).getText()) {
	        case "Pokemon":  
	        	addCardView.setPokemonPanel();

	            break;
	        case "Trainer":  
	        	addCardView.setTrainerPanel();
	            break;
	        case "Energy":  

	            break;
	        case "Add":  

	            break;
		}
	}
}
