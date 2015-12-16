package models;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Trainer extends Card {
	public static String[] trainerTypes = 
		{
			"Item", 
			"Supporter", 
			"Statium"
		};
	
	private String trainerType;
	private String trainerRule;
	
	@JsonCreator
	public Trainer(@JsonProperty("name") String name, @JsonProperty("desc") String desc, @JsonProperty("number") int number, @JsonProperty("type") String type, @JsonProperty("rule") String rule) {
		super(name, type, desc, number);
		trainerType = type;
		trainerRule = rule; 
	}
	
	public String toString() {
		return "Trainer card : " + cardName + " (n°" + cardNumber + ")\n"
				+ "\t\t. Type : " + trainerType + "\n"
				+ "\t\t. Rule : " + trainerRule + "\n";
	}
	
//	public HashMap<String, Object> getData() {
//
//		setData();
//		
//		data.put("rule", trainerRule);
//		
//		return data;
//	}
	
	public String getRule() {
		return trainerRule;
	}
}
