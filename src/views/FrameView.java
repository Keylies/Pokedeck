package views;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import models.Card;
import models.Deck;
import models.TableModel;
import controllers.ContentCtrl;
import controllers.ImportCtrl;
import controllers.SaveCtrl;

/**
 * Pokedeck frame
 * 
 * @author Clément
 *
 */
public class FrameView extends JFrame {
	
	private Deck deck;
	
	private TableModel tableModel;
	
	private JPanel content;
	
	private JMenuBar menuBar;
	
	public FrameView () {
		super();
	}
	
	public void constructGUI(Deck d) {
		
		deck = d;
		tableModel = new TableModel(deck);
		
		constructMenu();
		constructContent();
		
		this.setTitle("Pokedeck, gotta catch 'em all");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setJMenuBar(menuBar);
		this.add(content);

	
		this.setVisible(true);
	}
	
	private void constructMenu() {
		
		menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		
		JMenuItem importItem = new JMenuItem("Import");
		importItem.addActionListener(new ImportCtrl(this, deck));
		
		JMenuItem saveItem = new JMenuItem("Save Deck");
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
		
		AddPokemonView addPokemonView = new AddPokemonView(contentCtrl, deck, tableModel);
		addPokemonView.constructPanel();
		
		AddTrainerView addTrainerView = new AddTrainerView(contentCtrl, deck, tableModel);
		addTrainerView.constructPanel();
		
		AddEnergyView addEnergyView = new AddEnergyView(contentCtrl, deck, tableModel);
		addEnergyView.constructPanel();
		
		content.add(deckView, "Deck");
		content.add(addView, "Add cards menu");
		content.add(addPokemonView, "Add Pokemon card");
		content.add(addTrainerView, "Add Trainer card");
		content.add(addEnergyView, "Add Energy card");
	}
	
	/**
	 * Replace the current deck with a new deck and recreate the Pokedeck with the last
	 * 
	 * @param d, the new deck
	 */
	public void update(Deck d) {
		
		deck = d;

		this.setJMenuBar(null);
		this.remove(content);
		
		constructMenu();
		constructContent();
		
		this.setJMenuBar(menuBar);
		this.add(content);
		this.validate();
	}
}
