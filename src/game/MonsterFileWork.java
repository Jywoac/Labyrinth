package game;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MonsterFileWork {
	
	private String name = null;
	private String description = null;
	private int health = 0;
	private int attackPower = 0;
	private int defensivePower = 0;
	private int lootTable = 0; // ex. 1 would mean loot table one
	private int monsterDifficulty = 0; // ex. 1 would mean easiest monster, use 1st gold reward.
	private int alwaysDrop = 0; // an item that a specific monster always drops, can be random of several items. for example a skeleton might drop a bone or skull.
	private String monsterSymbol = null; // how the monster appears ingame, a zombie might have Z symbol for example on game board.
	
	// save a new monster to the file, NOT FOR PLAYER USE
	public void addMonster(){
		File monsters = new File("monsters.data");
		
		// if monsters file does not exist, create one
		if(monsters.exists() != true){			
			try {
				monsters.createNewFile();
			} catch (IOException e) {
				// Could not create file
				System.out.println("Could not create file.");
				
			}
		}
		
		FileWriter fileWritter = null;;
		try {
			fileWritter = new FileWriter(monsters.getName(),true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                        
        try {
			bufferWritter.write(name+"\n"); // 0
			bufferWritter.write(description+"\n"); // 1
			bufferWritter.write(attackPower+"\n"); // 2
			bufferWritter.write(defensivePower+"\n"); // 3
			bufferWritter.write(lootTable+"\n"); // 4
			bufferWritter.write(monsterDifficulty+"\n"); //5
			bufferWritter.write(alwaysDrop+"\n"); // 6
			bufferWritter.write(monsterSymbol+"\n"); // 7
			bufferWritter.write(health+"\n"); // 8
			bufferWritter.write("-----\n");// separator 5 times -----
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        try {
			bufferWritter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// get a monster with specific name
	// returns monster and all its attributes
	public String getMonster(String name){
		return null;
	}
	
	public ArrayList<String> getMonsterNames(){
		ArrayList<String> monsterName = new ArrayList<String>();	
		BufferedReader reader = null;
		
		int currentLine = 1;

		try {
		    File file = new File("monsters.data");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {    
		        // check if line is on top of the symbol
		        // if it is add it to return array
		    	
		    	if(currentLine == 1){
		    		monsterName.add(line);
		    	}else{		    	
			        if(currentLine == 9){
			        	currentLine = 0;
			        }		        
		    	}
		    	
		    	System.out.println(line);
		    	
		        currentLine++;
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		return monsterName;
	}
	
	public ArrayList<String> getMonsterSymbols(){
		ArrayList<String> monsterSymbol = new ArrayList<String>();	
		BufferedReader reader = null;
		
		int currentLine = 1;

		try {
		    File file = new File("monsters.data");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {    
		        // check if line is on top of the symbol
		        // if it is add it to return array
		    	
		    	if(currentLine == 1){
		    		// skip first line
		    	}else{
		    	    if(currentLine == 8){
			        	monsterSymbol.add(line);
				        System.out.println(line);
			        }else{
			        	if(currentLine == 9){
			        		currentLine = 0;
			        	}
			        }
		        
		    	}
		        currentLine++;
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		return monsterSymbol;
	}
	
	// get all monsters
	// returns table of monsters from file
	public String [][] getAllMonsters() {
		
		String [][] allMonsters = new String [50][20];
		BufferedReader reader = null;
		
		int currentLine = 1;
		int monsterNameLine = 0;
		int lineInMonsterTableStats = 0;
		
		try {
		    File file = new File("monsters.data");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {    
		    	
		    	if(currentLine == 1){
		    		allMonsters[monsterNameLine][lineInMonsterTableStats] = line; // add the first name		    		
		    		lineInMonsterTableStats++;
		    		
		    	}else{
		    		
		    		// all stats from previous monster have been added, move to new monster.
	    	        if(currentLine == 10){
	    	        	
	    	        	currentLine = 1;
	    	        	
	    	        	lineInMonsterTableStats = 0;
			    		monsterNameLine++;
			    		allMonsters[monsterNameLine][lineInMonsterTableStats] = line;
			    		lineInMonsterTableStats++;
	    	        }else{
			    		allMonsters[monsterNameLine][lineInMonsterTableStats] = line;		    		
			    		lineInMonsterTableStats++;
	    	        }
		    	}
		    	
		        currentLine++;
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		return allMonsters;
	}

	
	// set monster name
	public void setName(String n){
		name = n;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setAlwaysDrop(int alwaysDrop) {
		this.alwaysDrop = alwaysDrop;
	}

	// set monster description
	public void setDescription(String d){
		description = d;
	}
	
	// set monster attack power
	public void setAttackPower(int a){
		attackPower = a;
	}
	
	// set monster defensive power
	public void setDefensivePower(int def){
		defensivePower = def;
	}
	
	// set monster loot table
	public void setLootTable(int l){
		lootTable = l;
	}
	
	// set monster difficulty	
	public void setMonsterDifficulty(int diff){
		monsterDifficulty = diff;
	}
	
	// set monster item that monster always drops
	public void setMonsterAlwaysDrop(int alw){
		alwaysDrop = alw;
	}
	
	// set monster item that monster always drops
	public void setMonsterSymbol(String s){
		monsterSymbol = s;
	}
	
}
