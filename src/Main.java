import javax.swing.JFrame;

import models.Deck;
import views.FrameView;


public class Main extends JFrame {

	public static void main(String[] args) {
		
		FrameView mainFrame = new FrameView();
		Deck deck = new Deck();
		
		mainFrame.constructGUI(deck);
	}

}
