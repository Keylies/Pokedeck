package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Energy extends Card {
	public static String[] energyTypes = 
		{
			"Grass", 
			"Fire", 
			"Water", 
			"Lightning", 
			"Psychic", 
			"Fighting", 
			"Darkness", 
			"Metal", 
			"Fairy", 
			"Dragon", 
			"Colorless"
		};
	
	private String energyType;
	
	@JsonCreator
	public Energy(@JsonProperty("name") String name, @JsonProperty("desc") String desc, @JsonProperty("number") int number, @JsonProperty("type") String type) {
		super(name, type, desc, number);
		energyType = type;
	}

	public String toString() {
		return "Energy card : " + energyType + "\n";
	}
	
}
