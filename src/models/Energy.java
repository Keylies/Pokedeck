package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Energy card, no special field
 * 
 * @author Clément
 *
 */
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
	
	@JsonCreator
	public Energy(@JsonProperty("name") String name, @JsonProperty("desc") String desc, @JsonProperty("number") int number, @JsonProperty("type") String type) {
		
		super(name, type, desc, number);
	}
}
