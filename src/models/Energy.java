package models;

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

	public Energy(String name, String desc, int number, String type) {
		super(name, type, desc, number);
		energyType = type;
	}

	public String toString() {
		return "Energy card : " + energyType + "\n";
	}
	
}
