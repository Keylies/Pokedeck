
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

	public Energy(String type) {
		super(type, 0);
		energyType = type;
	}

	public String toString() {
		return "Energy card : " + energyType + "\n";
	}
	
}
