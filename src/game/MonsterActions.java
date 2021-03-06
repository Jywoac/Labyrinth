package game;

import java.util.ArrayList;
import java.util.Random;

public class MonsterActions {
	
	private String [] monstersCoordinates;
	
	// Needed for comabat, has monster health, attack defense, name and location (x,y coord)
	private String [][] allStatsOfMonstersInPlay;
	private int spot = 0;
	
	public String [][] addMonstersToBoard(String [][] boardWithoutMonsters){
		
		MonsterFileWork m = new MonsterFileWork();
		String [][] boardWithMonsters = boardWithoutMonsters;
		ArrayList<String> monsterSymbols = m.getMonsterSymbols();
				
		// add monsters here some random number.
		
		Random rand = new Random();
		int numOfMonsters = rand.nextInt(15 - 7 + 1) + 7;
		//random.nextInt(max - min + 1) + min
		
		monstersCoordinates = new String [numOfMonsters];		

		int x = boardWithMonsters.length;
		int y = boardWithMonsters[0].length;
		
		int monsterCoordNum = 0;
		
		// add monsters to board
		// if a spot is a floor add a monster to it.
		while(numOfMonsters > 0){
			
			int checkThisX = rand.nextInt(x);
			int checkThisY = rand.nextInt(y);
						
			if(boardWithMonsters[checkThisX][checkThisY].toLowerCase().contains("floor")){
				
				// add a random monster to board
				boardWithMonsters[checkThisX][checkThisY] = monsterSymbols.get(rand.nextInt(monsterSymbols.size()));
				monstersCoordinates[monsterCoordNum] = checkThisX +" "+checkThisY;
				
				monsterCoordNum++;
				numOfMonsters--;
			}else{				
				
				// wall at this spot, do nothing.
			}

		}

		return boardWithMonsters;
	}
	
	// moves monsters to a random empty square if possible
	// if not possible stay still (stuck behind other monsters or walls)
	public String [][] moveMonsters(String [][] moveInThisBoard){		
		String [][] monstersMovedInBoard = moveInThisBoard;
		
		int monstersToMove = monstersCoordinates.length;
		
		int spot = 0;

		while(monstersToMove > 0){

			String[] coordinates = monstersCoordinates[spot].split(" ");
			int x = Integer.parseInt(coordinates[0]);
			int y = Integer.parseInt(coordinates[1]);
			
			Random rand = new Random();
			
			boolean spotFound = false;
			int tries = 0;
			
			while(spotFound == false){
				// try to move to a random spot 10 times, if not possible stay still
				
								
				switch(rand.nextInt(4)){
				case 0:
					// try to move up					
					try {
						if(moveInThisBoard[x][y-1].toLowerCase().contains("floor")){
							// spot for monster found, move to it
							monstersCoordinates[spot] = x+" "+(y-1); // new coordinates for monster
							
							monstersMovedInBoard[x][y-1] = monstersMovedInBoard[x][y]; // move monster symbol to new spot						
													
							monstersMovedInBoard[x][y] = "floor"; // monster moved so change old spot to a floor
							
							spotFound = true;
						}
					}
					
					catch(ArrayIndexOutOfBoundsException exception) {
						// if monster tries to move out of the map (has found exit) do nothing.
					}
			
					break;
				case 1:
					
					try {
						// try to move right
						if(moveInThisBoard[x+1][y].toLowerCase().contains("floor")){
							// spot for monster found, move to it
							monstersCoordinates[spot] = (x+1)+" "+y; // new coordinates for monster
							monstersMovedInBoard[x+1][y] = monstersMovedInBoard[x][y]; // move monster symbol to new spot 
							monstersMovedInBoard[x][y] = "floor"; // monster moved so change old spot to a floor
							spotFound = true;
						}
					}
					
					catch(ArrayIndexOutOfBoundsException exception) {
						// if monster tries to move out of the map (has found exit) do nothing.
					}
					
					
					break;
				case 2:
					// try to move down					
					try {
						if(moveInThisBoard[x][y+1].toLowerCase().contains("floor")){
							// spot for monster found, move to it
							monstersCoordinates[spot] = x+" "+(y+1); // new coordinates for monster
							monstersMovedInBoard[x][y+1] = monstersMovedInBoard[x][y]; // move monster symbol to new spot 
							monstersMovedInBoard[x][y] = "floor"; // monster moved so change old spot to a floor
							spotFound = true;
						}
					}
					
					catch(ArrayIndexOutOfBoundsException exception) {
						// if monster tries to move out of the map (has found exit) do nothing.
					}
					
					break;
				case 3:
					// try to move left					
					try {
						if(moveInThisBoard[x-1][y].toLowerCase().contains("floor")){
							// spot for monster found, move to it
							monstersCoordinates[spot] = (x-1)+" "+y; // new coordinates for monster
							monstersMovedInBoard[x-1][y] = monstersMovedInBoard[x][y]; // move monster symbol to new spot 
							monstersMovedInBoard[x][y] = "floor"; // monster moved so change old spot to a floor
							spotFound = true;
						}
					}
					
					catch(ArrayIndexOutOfBoundsException exception) {
					    // if monster tries to move out of the map (has found exit) do nothing.
					}
			
					break;
				}				
				tries++;

				if(tries >= 10){
					spotFound = true;
				}
				
			}
		
			spot++;
			monstersToMove--;
		}
		
		return monstersMovedInBoard;
		
	}
		
	public String[] getMonstersCoordinates() {
		return monstersCoordinates;
	}

	public void setMonstersCoordinates(String[] monstersCoordinates) {
		this.monstersCoordinates = monstersCoordinates;
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
