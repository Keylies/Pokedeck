package models;


public class Card {
	public static String[] cardTypes = 
		{
			"Energy", 
			"Pokemon", 
			"Trainer"
		};
	
	//protected String cardType;
	protected String cardName;
	protected String cardDesc;
	protected int cardNumber;
	
	public Card() {
		//cardType = "Blank card";
		cardName = "Blank card";
		cardDesc = "Blank card";
		cardNumber = 0;
	}

	public Card(String name, int number) {
		cardName = name;
		cardNumber = number;
		cardDesc = null;
	}
	
	public Card(String name, String desc, int number) {
		cardName = name;
		cardNumber = number;
		cardDesc = desc;
	}
	
	public void changeText(String newDesc) {
		cardDesc = newDesc;
	}
	
}
