package models;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "classType")
@JsonSubTypes({
		@Type(value = Pokemon.class),
		@Type(value = Trainer.class),
		@Type(value = Energy.class),
})

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
	
	//protected HashMap<String, Object> data;
	
	public Card(String name, String type, String desc, int number) {
		cardName = name;
		cardType = type;
		cardDesc = desc;
		cardNumber = number;
	}
	
//	protected void setData() {
//		
//		data = new HashMap<String, Object>();
//		
//		data.put("name", cardName);
//		data.put("type", cardType);
//		data.put("desc", cardDesc);
//		data.put("number", cardNumber);
//	}
//	
//	public HashMap<String, Object> getData() {
//		
//		setData();
//		return data;
//	}
	
	public void modifyDesc(String desc) {
		cardDesc = desc;
	}
	
	public String getName() {
		return cardName;
	}
	
	public String getType() {
		return cardType;
	}
	
	public String getDesc() {
		return cardDesc;
	}
	
	public int getNumber() {
		return cardNumber;
	}
	
}
