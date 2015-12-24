package models;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pokemon card, has a special field "Hp"
 * 
 * @author Clément
 *
 */
public class Pokemon extends Card {
	
	private int pokemonHp;

	@JsonCreator
	public Pokemon(@JsonProperty("name") String name, @JsonProperty("desc") String desc, @JsonProperty("number") int number, @JsonProperty("type") String type, @JsonProperty("hp") int hp) {
		
		super(name, type, desc, number);
		pokemonHp = hp; 
	}
	
	public int getHp() {
		return pokemonHp;
	}
	
	public void setHp(int hp) {
		pokemonHp = hp;
	}
}
