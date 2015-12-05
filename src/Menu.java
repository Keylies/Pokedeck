import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu extends JFrame {

	private JButton butSend;
	private JTextField txtName;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem importItem;
	
	
	public Menu() {
		super();
	}
	
	public void constructGUI() {

		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JPanel wrapper = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel lblName = new JLabel("Name"); 
		JLabel lblHp = new JLabel("HP");
		JLabel lblType = new JLabel("Type");
		txtName = new JTextField();
		JTextField txtHp = new JTextField();
		JTextField txtType = new JTextField();
		butSend = new JButton("Pokpok");
		menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		importItem = new JMenuItem("Import");
		
		importItem.addActionListener(new CtrlMenu());
		
		menuFile.add(importItem);
		menuBar.add(menuFile);
		
		this.setJMenuBar(menuBar);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		wrapper.add(lblName, c);
		
		c.gridx = 1;
		c.gridy = 0;
		wrapper.add(txtName, c);
		
		c.gridx = 0;
		c.gridy = 1;
		wrapper.add(lblHp, c);
		
		c.gridx = 1;
		c.gridy = 1;
		wrapper.add(txtHp, c);
		
		c.gridx = 0;
		c.gridy = 2;
		wrapper.add(lblType, c);
		
		c.gridx = 1;
		c.gridy = 2;
		wrapper.add(txtType, c);
		
		c.gridy = 3;
		c.gridwidth = 3;
		wrapper.add(butSend, c);

		
		this.add(wrapper);
		
		
		butSend.addActionListener(new Controller(this));
		
		
		
		this.setVisible(true);
	}
	
	public String getData() {
		return txtName.getText();
	}

}
