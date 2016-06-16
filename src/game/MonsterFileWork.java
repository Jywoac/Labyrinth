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
			bufferWritter.write(name+"\n");
			bufferWritter.write(description+"\n");
			bufferWritter.write(attackPower+"\n");
			bufferWritter.write(defensivePower+"\n");
			bufferWritter.write(lootTable+"\n");
			bufferWritter.write(monsterDifficulty+"\n");
			bufferWritter.write(alwaysDrop+"\n");
			bufferWritter.write(monsterSymbol+"\n");
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
		
		int currentLine = 0;

		try {
		    File file = new File("monsters.data");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {    
		        // check if line is on top of the symbol
		        // if it is add it to return array
		    	
		    	if(currentLine == 0){
		    		monsterName.add(line);
		    	}else{		    	
			        if(currentLine % 8 == 0){
			        	monsterName.add(line);
			        	// CHECK HERE IF NAME IS EMPTY
			        	// TODO
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
		
		int currentLine = 0;

		try {
		    File file = new File("monsters.data");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {    
		        // check if line is on top of the symbol
		        // if it is add it to return array
		    	
		    	if(currentLine == 0){
		    		// skip first line
		    	}else{
		    	        if(currentLine % 7 == 0){
			        	monsterSymbol.add(line);
				        System.out.println(line);
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
		return null;
	}
	
	// set monster name
	public void setName(String n){
		name = n;
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
