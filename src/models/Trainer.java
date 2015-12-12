package models;

import java.util.HashMap;

public class Trainer extends Card {
	public static String[] trainerTypes = 
		{
			"Item", 
			"Supporter", 
			"Statium"
		};
	
	private String trainerType;
	private String trainerRule;
	
	public Trainer() {
		super();
	}
	
	public Trainer(String name, String desc, int number, String type, String rule) {
		super(name, type, desc, number);
		trainerType = type;
		trainerRule = rule; 
	}
	
	public String toString() {
		return "Trainer card : " + cardName + " (n°" + cardNumber + ")\n"
				+ "\t\t. Type : " + trainerType + "\n"
				+ "\t\t. Rule : " + trainerRule + "\n";
	}
	
	public HashMap<String, Object> getData() {

		setData();
		
		data.put("rule", trainerRule);
		
		return data;
	}
}
