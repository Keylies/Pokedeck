package models;
import java.util.ArrayList;


public class Pokemon extends Card {
	private String pokemonType;
	private int pokemonHp;
//	private int evolutionStage;
//	private Pokemon evolvesFrom;
//	private ArrayList<Attack> attacks;
	
	public Pokemon() {
		super();
	}
	
	public Pokemon(String name, String desc, int number, String type, int hp) {
		super(name, desc, number);
		pokemonType = type;
		pokemonHp = hp; 
	}
	
	public String toString() {
		return "Pokemon card : " + cardName + " (n�" + cardNumber + ")\n"
				+ "\t\t. Type : " + pokemonType + "\n"
				+ "\t\t. HP : " + pokemonHp + "\n"
				+ "\t\t. Text : " + cardDesc + "\n";
	}
}
