package game;

public class PlayerCharacter {
	private String name;
	private int health;
	private int attack;
	private int defense;
	private int magicAttack;
	private int magicDefense;
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getMagicAttack() {
		return magicAttack;
	}
	public void setMagicAttack(int magicAttack) {
		this.magicAttack = magicAttack;
	}
	public int getMagicDefense() {
		return magicDefense;
	}
	public void setMagicDefense(int magicDefense) {
		this.magicDefense = magicDefense;
	}
	

}
