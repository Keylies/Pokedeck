package models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/*
 * Jackson params for JSON import
 */
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "classType")
@JsonSubTypes({
		@Type(value = Pokemon.class),
		@Type(value = Trainer.class),
		@Type(value = Energy.class),
})

/**
 * Contains the common properties between all cards types
 * Description modification is allowed
 * 
 * @author Clément
 *
 */
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
	
	public Card(String name, String type, String desc, int number) {
		
		cardName = name;
		cardType = type;
		cardDesc = desc;
		cardNumber = number;
	}
	
	public void setName(String name) {
		cardName = name;
	}
	
	public void setDesc(String desc) {
		cardDesc = desc;
	}
	
	public void setType(String type) {
		cardType = type;
	}
	
	public void setNumber(int number) {
		cardNumber = number;
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
