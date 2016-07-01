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
	
	// items in inventory
	private String [][] mainHand;
	private String [][] offHand;
	private String [][] chest;
	private String [][] pants;
	private String [][] feet;
	private String [][] head;
	private String [][] hands;
	private String [][] misc;	
	
	public String[][] getMainHand() {
		return mainHand;
	}
	public void setMainHand(String[][] mainHand) {
		this.mainHand = mainHand;
	}
	public String[][] getOffHand() {
		return offHand;
	}
	public void setOffHand(String[][] offHand) {
		this.offHand = offHand;
	}
	public String[][] getChest() {
		return chest;
	}
	public void setChest(String[][] chest) {
		this.chest = chest;
	}
	public String[][] getPants() {
		return pants;
	}
	public void setPants(String[][] pants) {
		this.pants = pants;
	}
	public String[][] getFeet() {
		return feet;
	}
	public void setFeet(String[][] feet) {
		this.feet = feet;
	}
	public String[][] getHead() {
		return head;
	}
	public void setHead(String[][] head) {
		this.head = head;
	}
	public String[][] getHands() {
		return hands;
	}
	public void setHands(String[][] hands) {
		this.hands = hands;
	}
	public String[][] getMisc() {
		return misc;
	}
	public void setMisc(String[][] misc) {
		this.misc = misc;
	}
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
		
		// player starting items
		
		// Mainhand
		mainHand[0][0] = "Short Sword"; // name of the weapon
		mainHand[0][1] = "2"; // attack value of the weapon
		mainHand[0][2] = "100"; // value of the weapon
		
		// Offhand
		// Helm
		// Chest
		// Feet
		// Pants
		// Hands
		
		// add these items to the inventory screen
	}
	
}
