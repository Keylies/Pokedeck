package models;

import java.util.HashMap;


public class Card {
	
	public static String[] cardTypes = 
		{
			"Energy", 
			"Pokemon", 
			"Trainer"
		};
	
	protected String cardName;
	protected String cardType;
	protected String cardDesc;
	protected int cardNumber;
	
	protected HashMap<String, Object> data;
	
	public Card() {};
	
	public Card(String name, String type, String desc, int number) {
		cardName = name;
		cardType = type;
		cardDesc = desc;
		cardNumber = number;
	}
	
	protected void setData() {
		
		data = new HashMap<String, Object>();
		
		data.put("name", cardName);
		data.put("type", cardType);
		data.put("desc", cardDesc);
		data.put("number", cardNumber);
	}
	
	public HashMap<String, Object> getData() {
		
		setData();
		return data;
	}
	
	public void modifyDesc(String desc) {
		cardDesc = desc;
	}
	
}
