package views;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import models.Deck;
import controllers.ContentCtrl;
import controllers.ImportCtrl;
import controllers.SaveCtrl;

public class FrameView extends JFrame {
	
	private Deck deck;
	
	private JPanel content;
	private DeckView deckView;
	
	private JMenuBar menuBar;
	
	public FrameView () {
		super();
	}
	
	public void constructGUI(Deck d) {
		
		deck = d;
		
		constructMenu();
		constructContent();
		
		this.setTitle("Pokedeck, gotta catch 'em all");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setJMenuBar(menuBar);
		this.add(content);

		this.setVisible(true);
	}
	
	private void constructMenu() {
		
		menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		
		JMenuItem importItem = new JMenuItem("Import");
		importItem.addActionListener(new ImportCtrl(this, deck));
		
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new SaveCtrl(this, deck));
		
		menuFile.add(importItem);
		menuFile.add(saveItem);
		menuBar.add(menuFile);
	}
	
	private void constructContent() {
		
		content = new JPanel(new CardLayout());
		
		ContentCtrl contentCtrl = new ContentCtrl(content);
		
		DeckView deckView = new DeckView(contentCtrl, deck);
		deckView.constructPanel();
		
		AddMenuView addView = new AddMenuView(contentCtrl);
		addView.constructPanel();
		
		AddPokemonView addPokemonView = new AddPokemonView(contentCtrl, deck);
		addPokemonView.constructPanel();
		
		AddTrainerView addTrainerView = new AddTrainerView(contentCtrl, deck);
		addTrainerView.constructPanel();
		
		AddEnergyView addEnergyView = new AddEnergyView(contentCtrl, deck);
		addEnergyView.constructPanel();
		
		content.add(deckView, "Deck");
		content.add(addView, "Add cards menu");
		content.add(addPokemonView, "Add Pokemon card");
		content.add(addTrainerView, "Add Trainer card");
		content.add(addEnergyView, "Add Energy card");
	}
}
