package game;

public class PlayerCharacter {
	private String name;
	private int health;
	private int attack;
	private int defense;
	private int magicAttack;
	private int magicDefense;
	private int pointsLeft; // points left to distribute
	private int pointsToUse; // amount of points the player gets to distribute between attributes
	private int minHealth; // minimum amount of health
	private int minAttack;
	private int minDefense;
	private int minMagicAttack;
	private int minMagicDefense;
	
	public int getMinHealth() {
		return minHealth;
	}
	public void setMinHealth(int minHealth) {
		this.minHealth = minHealth;
	}
	public int getMinAttack() {
		return minAttack;
	}
	public void setMinAttack(int minAttack) {
		this.minAttack = minAttack;
	}
	public int getMinDefense() {
		return minDefense;
	}
	public void setMinDefense(int minDefense) {
		this.minDefense = minDefense;
	}
	public int getMinMagicAttack() {
		return minMagicAttack;
	}
	public void setMinMagicAttack(int minMagicAttack) {
		this.minMagicAttack = minMagicAttack;
	}
	public int getMinMagicDefense() {
		return minMagicDefense;
	}
	public void setMinMagicDefense(int minMagicDefense) {
		this.minMagicDefense = minMagicDefense;
	}
	public int getPointsToUse() {
		return pointsToUse;
	}
	public void setPointsToUse(int pointsToUse) {
		this.pointsToUse = pointsToUse;
	}
	public int getPointsLeft() {
		return pointsLeft;
	}
	public void setPointsLeft(int pointsLeft) {
		this.pointsLeft = pointsLeft;
	}
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
	
	public void initializeCharacter(){
		name = "name here";
		health = 10;
		attack = 1;
		defense= 1;;
		magicAttack= 1;;
		magicDefense= 1;;
		pointsLeft = 10; // points left to distribute
		pointsToUse = 10; // amount of points the player gets to distribute between attributes
	}
	
}
