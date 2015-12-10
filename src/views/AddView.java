import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AddCardView extends JFrame {
	
	private JPanel content;
	private JPanel pokemonPanel;
	private JPanel trainerPanel;
	private JPanel energyPanel;
	
	private GridBagConstraints c;

	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem importItem;
	
	private JLabel lblName;
	private JLabel lblType;
	private JLabel lblHp;
	private JLabel lblDesc;
	
	private ButtonGroup group;
	private JRadioButton pokemonButton;
	private JRadioButton trainerButton;
	private JRadioButton energyButton;
	
	private JTextField txtName;
	private JComboBox txtType;
	private JTextField txtHp;
	private JTextArea txtDesc;
	
	private JButton butSend;
	
	public AddCardView() {
		super();
	}
	
	public void constructGUI() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());

		menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		importItem = new JMenuItem("Import");
		
		importItem.addActionListener(new CtrlMenu());
		
		menuFile.add(importItem);
		menuBar.add(menuFile);
		
		this.setJMenuBar(menuBar);
		
		content = new JPanel(new GridBagLayout());
		content.setBorder(BorderFactory.createLineBorder(Color.black));
		
		pokemonButton = new JRadioButton("Pokemon");
		trainerButton = new JRadioButton("Trainer");
		energyButton = new JRadioButton("Energy");
		
		pokemonButton.addActionListener(new AddCardCtrl(this));
		trainerButton.addActionListener(new AddCardCtrl(this));
		energyButton.addActionListener(new AddCardCtrl(this));
		
		group = new ButtonGroup();
		group.add(pokemonButton);
		group.add(trainerButton);
		group.add(energyButton);
		
		constructPokemonPanel();
		constructTrainerPanel();
		constructEnergyPanel();
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(pokemonButton, c);
		
		c.gridx = 1;
		c.gridy = 0;
		this.add(trainerButton, c);
		
		c.gridx = 2;
		c.gridy = 0;
		this.add(energyButton, c);
		
		c.gridx = 0;
		c.gridy = 0;
		content.add(pokemonPanel, c);
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(30, 30, 30, 30);
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		this.add(content, c);

		this.pack();
		this.setVisible(true);
	}
	
	private void constructPokemonPanel() {
		pokemonPanel = new JPanel(new GridBagLayout());
		
		lblName = new JLabel("Name");
		lblType = new JLabel("Type");
		lblHp = new JLabel("HP");
		lblDesc = new JLabel("Description");
		
		txtName = new JTextField();
		txtType = new JComboBox(Energy.energyTypes);
		txtHp = new JTextField();
		txtDesc = new JTextArea();
		
		butSend = new JButton("Add");
		butSend.addActionListener(new AddCardCtrl(this));
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 50;
		c.ipadx = 300;
		
		c.insets = new Insets(15, 30, 15, 30);
		c.gridx = 0;
		c.gridy = 0;
		pokemonPanel.add(lblName, c);
		
		c.gridx = 1;
		c.gridy = 0;
		pokemonPanel.add(txtName, c);
		
		c.gridx = 0;
		c.gridy = 1;
		pokemonPanel.add(lblType, c);
		
		c.gridx = 1;
		c.gridy = 1;
		pokemonPanel.add(txtType, c);
		
		c.gridx = 0;
		c.gridy = 2;
		pokemonPanel.add(lblHp, c);
		
		c.gridx = 1;
		c.gridy = 2;
		pokemonPanel.add(txtHp, c);
		
		c.gridx = 0;
		c.gridy = 3;
		pokemonPanel.add(lblDesc, c);
		
		c.gridx = 1;
		c.gridy = 3;
		pokemonPanel.add(txtDesc, c);
		
		c.gridx = 0;
		c.gridy = 4;
		pokemonPanel.add(butSend, c);
	}
	
	private void constructTrainerPanel() {
		trainerPanel = new JPanel(new GridBagLayout());
		
		lblName = new JLabel("test");
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 50;
		c.ipadx = 300;
		
		c.insets = new Insets(15, 30, 15, 30);
		c.gridx = 0;
		c.gridy = 0;
		trainerPanel.add(lblName, c);
	}
	
	private void constructEnergyPanel() {
		energyPanel = new JPanel(new GridBagLayout());
		
		lblName = new JLabel("test");
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 50;
		c.ipadx = 300;
		
		c.insets = new Insets(15, 30, 15, 30);
		c.gridx = 0;
		c.gridy = 0;
		trainerPanel.add(lblName, c);
	}
	
	private void refreshContent() {
		content.validate();
		content.repaint();
	}
	
	public void setPokemonPanel() {
		content.removeAll();
		content.add(pokemonPanel);
		refreshContent();
	}
	
	public void setTrainerPanel() {
		content.removeAll();
		content.add(trainerPanel);
		refreshContent();
	}
	
	public void setEnergyPanel() {
		content.removeAll();
		content.add(energyPanel);
		refreshContent();
	}

	public String getData() {
		return txtName.getText();
	}

}
