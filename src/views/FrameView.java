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
	
	private JPanel content;
	
	private DeckView deckView;
	private AddView addView;
	
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem importItem;
	
	private ContentCtrl contentCtrl;

	public FrameView () {
		super();
	}
	
	public void constructGUI() {
		
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
		menuFile = new JMenu("File");
		importItem = new JMenuItem("Import");
		
		importItem.addActionListener(new MenuCtrl());
		
		menuFile.add(importItem);
		menuBar.add(menuFile);
	}
	
	private void constructContent() {
		
		content = new JPanel(new CardLayout());
		
		contentCtrl = new ContentCtrl(content);
		
		deckView = new DeckView();
		deckView.constructPanel(contentCtrl);
		
		addView = new AddView();
		addView.constructPanel(contentCtrl);
		
		content.add(deckView, "Deck");
		content.add(addView, "Add cards");
	}
}
