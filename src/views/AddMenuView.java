package views;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controllers.ContentCtrl;

/**
 * View to choose which type of card we want to create
 * 
 * @author Clément
 *
 */
public class AddMenuView extends JPanel {
	
	private ContentCtrl contentCtrl;
	
	private JPanel titlePnl;
	private JPanel tabPnl;
	private JPanel pokemonPnl;
	private JPanel trainerPnl;
	private JPanel energyPnl;
	
	JTabbedPane tabbedPane;
	
	public AddMenuView(ContentCtrl contentCtrl) {
		
		super();
		this.contentCtrl = contentCtrl;
	}
	
	public void constructPanel() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		constructTitlePanel();
		constructPokemonPanel();
		constructTrainerPanel();
		constructEnergyPanel();
		constructTabPanel();
		
		c.insets = new Insets(10,0,0,0);
		c.fill = GridBagConstraints.BOTH;

		c.gridx = 0;
		c.gridy = 0;
		this.add(titlePnl, c);
		
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 1;
		this.add(tabPnl, c);
	}
	
	private void constructTitlePanel() {
		
		titlePnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel titleLbl = new JLabel("Add cards menu");
		
		JButton homeBtn = new JButton("Deck");
		homeBtn.addActionListener(contentCtrl);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,0,0,0);

		c.gridx = 0;
		c.gridy = 0;
		titlePnl.add(titleLbl, c);
		
		c.gridx = 0;
		c.gridy = 1;
		titlePnl.add(homeBtn, c);
	}
	
	private void constructTabPanel() {
		
		tabPnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Pokemon", pokemonPnl);
		tabbedPane.addTab("Trainer", trainerPnl);
		tabbedPane.addTab("Energy", energyPnl);
		
		c.fill = GridBagConstraints.BOTH;

		c.weightx = 1.0;
		c.weighty = 1.0;
		c.ipady = 1;
		c.gridx = 0;
		c.gridy = 0;
		tabPnl.add(tabbedPane, c);
	}
	
	private void constructPokemonPanel() {
		
		pokemonPnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JButton pokemonViewBtn = new JButton("Add Pokemon card");
		pokemonViewBtn.addActionListener(contentCtrl);
		
		JLabel descLbl = new JLabel("Of course the most important cards are Pokémon!");
		
		JLabel img = new JLabel(getImg("img/pokemonImg.bmp"));
		
		c.insets = new Insets(10,10,10,10);
		
		c.gridx = 0;
		c.gridy = 0;
		pokemonPnl.add(descLbl, c);
		
		c.gridx = 0;
		c.gridy = 1;
		pokemonPnl.add(img, c);
		
		c.gridx = 0;
		c.gridy = 2;
		pokemonPnl.add(pokemonViewBtn, c);
	}
	
	private void constructTrainerPanel() {
		
		trainerPnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JButton trainerViewBtn = new JButton("Add Trainer card");
		trainerViewBtn.addActionListener(contentCtrl);
		
		JLabel descLbl = new JLabel("Trainer cards represent the Items, Supporters, and Stadiums a Trainer can use in battle.");
		
		JLabel img = new JLabel(getImg("img/trainerImg.bmp"));
		
		c.insets = new Insets(10,10,10,10);
		
		c.gridx = 0;
		c.gridy = 0;
		trainerPnl.add(descLbl, c);
		
		c.gridx = 0;
		c.gridy = 1;
		trainerPnl.add(img, c);
		
		c.gridx = 0;
		c.gridy = 2;
		trainerPnl.add(trainerViewBtn, c);
	}
	
	private void constructEnergyPanel() {
		
		energyPnl = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JButton energyViewBtn = new JButton("Add Energy card");
		energyViewBtn.addActionListener(contentCtrl);
		
		JLabel descLbl = new JLabel("Most of the time, Pokémon can’t attack without Energy cards!");
		
		JLabel img = new JLabel(getImg("img/energyImg.bmp"));
		
		c.insets = new Insets(10,10,10,10);
		
		c.gridx = 0;
		c.gridy = 0;
		energyPnl.add(descLbl, c);
		
		c.gridx = 0;
		c.gridy = 1;
		energyPnl.add(img, c);
		
		c.gridx = 0;
		c.gridy = 2;
		energyPnl.add(energyViewBtn, c);
	}
	
	
	/**
	 * Read an image file and returns it as an ImageIcon for JLabel
	 * 
	 * @param path (String), path of image file
	 * @return an ImageIcon
	 */
	private ImageIcon getImg(String path) {
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return new ImageIcon(img);
	}
}
