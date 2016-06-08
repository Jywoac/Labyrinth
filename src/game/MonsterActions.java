package game;

import java.util.ArrayList;
import java.util.Random;

public class MonsterActions {
	
	private String [][] monstersCoordinates;
	
	
	public String [][] addMonstersToBoard(String [][] boardWithoutMonsters){
		
		MonsterFileWork m = new MonsterFileWork();
		String [][] boardWithMonsters = boardWithoutMonsters;
		ArrayList<String> monsterSymbols = m.getMonsterSymbols();
				
		// add monsters here some random number.
		
		Random rand = new Random();
		int numOfMonsters = rand.nextInt(15 - 7 + 1) + 7;
		//random.nextInt(max - min + 1) + min
		
		monstersCoordinates = new String [numOfMonsters][numOfMonsters]; 
		

		int x = boardWithMonsters.length;
		int y = boardWithMonsters[0].length;
		
		// add monsters to board
		// if a spot is a floor add a monster to it.
		while(numOfMonsters > 0){
			
			int checkThisX = rand.nextInt(x);
			int chekcThisY = rand.nextInt(y);
			
			if(boardWithMonsters[checkThisX][chekcThisY].toLowerCase().contains("floor")){
				
				// add a random monster to board
				boardWithMonsters[checkThisX][chekcThisY] = monsterSymbols.get(rand.nextInt(monsterSymbols.size()));				
				numOfMonsters--;
			}else{
				// wall at this spot, do nothing.
				// NEXT CHANGE BOARD ACTIONS TO FIND WHAT SYMBOL IS THERE INSTEAD OF JUST PUTTING # wall symbol everywhere
			}
						
			
		}
		
		
		
		return boardWithMonsters;
	}

	
	
	// return specific monster data from file
	// identified with symbol
	// returns string array with all monster info
	public String [] getMonsterInfo(String Symbol){
		
		String [] mInfo = null;
		
		// TODO
		
		return mInfo;
	}
	
	// wanders around randomly in floor areas
	// if player coordinates are at some point around the monster
	// enter combat with that monster.
	// multiple monsters in same combat screen?
	// or just single combat?
	
	// check first if player has moved into combat range
	// if not move
	// check again if player is in combat range
	// if not wait for another move+
}
