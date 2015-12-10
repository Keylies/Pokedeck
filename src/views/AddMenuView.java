package views;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import controllers.ContentCtrl;


public class AddMenuView extends JPanel {
	
	private ContentCtrl contentCtrl;
	
	private JPanel titlePnl;
	private JPanel tabPnl;
	private JPanel pokemonPnl;
	private JPanel trainerPnl;
	private JPanel energyPnl;
	
	JTabbedPane tabbedPane;
	
	public AddMenuView() {
		super();
	}
	
	public void constructPanel(ContentCtrl contentCtrl) {

		this.contentCtrl = contentCtrl;
		
		this.setLayout(new GridLayout(1, 1));

		constructTitlePanel();
		//constructTabPanel();
		
		this.add(titlePnl);
		//this.add(tabPnl);
	}
	
	private void constructTitlePanel() {
		
		titlePnl = new JPanel(new GridLayout(5, 1, 10, 10));
		
		JLabel titleLbl = new JLabel("Add cards menu");
		
		JButton homeBtn = new JButton("Deck");
		homeBtn.addActionListener(contentCtrl);
		
		JButton pokemonViewBtn = new JButton("Add Pokemon card");
		pokemonViewBtn.addActionListener(contentCtrl);
		
		JButton trainerViewBtn = new JButton("Add Trainer card");
		trainerViewBtn.addActionListener(contentCtrl);
		
		JButton energyViewBtn = new JButton("Add Energy card");
		energyViewBtn.addActionListener(contentCtrl);
		
		titlePnl.add(titleLbl);
		titlePnl.add(homeBtn);
		titlePnl.add(pokemonViewBtn);
		titlePnl.add(trainerViewBtn);
		titlePnl.add(energyViewBtn);
	}
	
	private void constructTabPanel() {
		
		tabPnl = new JPanel(new GridLayout(1, 1, 10, 10));
		
		tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Pokemon", pokemonPnl);
		tabbedPane.addTab("Trainer", trainerPnl);
		tabbedPane.addTab("Energy", energyPnl);
		
		tabPnl.add(tabbedPane);
	}
}
