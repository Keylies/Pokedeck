

public class Card {
	public static String[] cardTypes = 
		{
			"Energy", 
			"Pokemon", 
			"Trainer"
		};
	
	//protected String cardType;
	protected String cardName;
	protected String cardText;
	protected int cardNumber;
	
	public Card() {
		//cardType = "Blank card";
		cardName = "Blank card";
		cardText = "Blank card";
		cardNumber = 0;
	}

	public Card(String name, int number) {
		cardName = name;
		cardNumber = number;
		cardText = null;
	}
	
	public Card(String name, String text, int number) {
		cardName = name;
		cardNumber = number;
		cardText = text;
	}
	
	public void changeText(String newText) {
		cardText = newText;
	}
	
}
