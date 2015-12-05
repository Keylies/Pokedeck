import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {
	
	private Menu menu;
	
	public Controller(Menu m) {
		menu = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(menu.getData());
	}
}
