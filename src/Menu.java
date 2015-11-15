
public class Menu {

	public static void main(String[] args) {
		Card grassCard = new Energy("Grass");
		Card bulbizarre = new Pokemon("Bulbizarre", "Bulbe bizarre", 1, "Grass", 100);
		Card sacha = new Trainer("Sacha", "Le meilleur dresseur", 200, "Supporter", "Gogogogo");
		
		Player p1 = new Player("Clém");
		
		p1.addToDeck(grassCard);
		p1.addToDeck(bulbizarre);
		p1.addToDeck(sacha);
		
		bulbizarre.changeText("BUUUULBI");
		
		System.out.println(p1.toString());
	}

}
