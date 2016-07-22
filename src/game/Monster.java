package game;

// once player has initiated combat with a monster this class is needed
public class Monster {
	
	private String name;
	private String desc;
	private int AP;
	private int DP;
	private int lootTable;
	private int monsterDiff;
	private int alwaysDrop;
	private String symbol;
	private int health;
	private int xCoord;
	private int yCoord;
	
	public void initializeMonster(String nam, String des, int att, int def, int loot, int drop, String sym, int heal, int x, int y){
		
		name = nam;
		desc = des;
		AP = att;
		DP = def;
		lootTable = loot;
		alwaysDrop = drop;
		symbol = sym;
		health = heal;
		xCoord = x;
		yCoord = y;		
		
	}

	public void monsterDiedEraseFromBoard(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getAP() {
		return AP;
	}

	public void setAP(int aP) {
		AP = aP;
	}

	public int getDP() {
		return DP;
	}

	public void setDP(int dP) {
		DP = dP;
	}

	public int getLootTable() {
		return lootTable;
	}

	public void setLootTable(int lootTable) {
		this.lootTable = lootTable;
	}

	public int getMonsterDiff() {
		return monsterDiff;
	}

	public void setMonsterDiff(int monsterDiff) {
		this.monsterDiff = monsterDiff;
	}

	public int getAlwaysDrop() {
		return alwaysDrop;
	}

	public void setAlwaysDrop(int alwaysDrop) {
		this.alwaysDrop = alwaysDrop;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
}
