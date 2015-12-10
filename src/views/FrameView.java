package views;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controllers.ContentCtrl;
import controllers.MenuCtrl;

public class FrameView extends JFrame {
	
	JPanel content;
	
	JMenuBar menuBar;
	
	public FrameView () {
		super();
	}
	
	public void constructGUI() {
		
		constructMenu();
		constructContent();
		
		this.setTitle("Pokedeck, gotta catch 'em all");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setJMenuBar(menuBar);
		this.add(content);

		this.setVisible(true);
	}
	
	private void constructMenu() {
		
		menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenuItem importItem = new JMenuItem("Import");
		
		importItem.addActionListener(new MenuCtrl());
		
		menuFile.add(importItem);
		menuBar.add(menuFile);
	}
	
	private void constructContent() {
		
		content = new JPanel(new CardLayout());
		
		ContentCtrl contentCtrl = new ContentCtrl(content);
		
		DeckView deckView = new DeckView();
		deckView.constructPanel(contentCtrl);
		
		AddMenuView addView = new AddMenuView();
		addView.constructPanel(contentCtrl);
		
		AddPokemonView addPokemonView = new AddPokemonView(contentCtrl);
		addPokemonView.constructPanel();
		
		AddTrainerView addTrainerView = new AddTrainerView(contentCtrl);
		addTrainerView.constructPanel();
		
		AddEnergyView addEnergyView = new AddEnergyView(contentCtrl);
		addEnergyView.constructPanel();
		
		content.add(deckView, "Deck");
		content.add(addView, "Add cards menu");
		content.add(addPokemonView, "Add Pokemon card");
		content.add(addTrainerView, "Add Trainer card");
		content.add(addEnergyView, "Add Energy card");
	}
}
