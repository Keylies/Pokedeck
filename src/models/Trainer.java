package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Trainer card, has a special field "Rule"
 * 
 * @author Clément
 *
 */
public class Trainer extends Card {
	
	public static String[] trainerTypes = 
		{
			"Item", 
			"Supporter", 
			"Statium"
		};
	
	private String trainerRule;
	
	@JsonCreator
	public Trainer(@JsonProperty("name") String name, @JsonProperty("desc") String desc, @JsonProperty("number") int number, @JsonProperty("type") String type, @JsonProperty("rule") String rule) {
		
		super(name, type, desc, number);
		trainerRule = rule; 
	}
	
	public String getRule() {
		return trainerRule;
	}
}
