package game;

import paths.Board;

public class BoardActions {
	
	private Board b;
	private Board mapBoard;
	private int playerXCoord;
	private int playerYCoord;
	private int entryPointYCoord;
	private int entryPointXCoord;
	private String [][] map;
	private int mazeSize = 0;
	private int firstMovement = 0; // if first movement is 0 then player is making their first move of the game
	//private String [][] board = null;

	// set the size of the maze, 1 = small, 2 = medium, 3 = large
	public void setMazeSize(int size){
		mazeSize = size;
	}
	// make new board, make new map
	public void initializeBoard(){
		b = new Board(mazeSize);
		mapBoard = new Board(mazeSize);
		map = mapBoard.getBoard();			
	}

	// main game loop
	public String gameLoop(String movementDirectionKeystroke){
		
		String textToReturn = null;
		
		if(firstMovement == 0){
			
			playerXCoord = b.getPlayerXStartPos();
			playerYCoord = b.getPlayerYStartPos()+1; // +1 needed to move away from edge of wall
			
			entryPointYCoord = playerYCoord; // save entry point data for text description
			entryPointXCoord = playerXCoord;
			
			// stay in maze while player y position is not at the edge of the maze
			// when y position is at the edge, player has found an exit so end the game.
			
			// player map that is initially empty but fills in as player explores different areas.
			map = mapBoard.getBoard();		
			mapBoard.initializeMap(map);
			firstMovement++;
			
			if(playerYCoord >= b.getBoardYSize()-1){
				//exit found do nothing
			}else{
				exploringBoard();
				b.setBoard(b.getMonsterActions().moveMonsters(b.getBoard()));
				
				// player is always on empty space but future proofing with this catch.
				// else fork means player is somehow standing either on wall or something else than floor.
				if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
					map[playerXCoord][playerYCoord] = "."; // player is always on empty space so make it empty again. 
				}else{
					map[playerXCoord][playerYCoord] = "#";
				}
			
			}
			
			map[playerXCoord][playerYCoord] = "X";
			
			textToReturn = b.printBoard(map);
		}else{
			if(playerYCoord < b.getBoardYSize()-1){
				
				actionResult(movementDirectionKeystroke);			
				
				textToReturn = b.printBoard(map);
				
			}else{
				textToReturn = ("You found the exit!");
			}
		}
		
		return textToReturn;
	}
	
	// generates the player sightradius, eg. removes ? marks and replaces them with appropriate items like floor or wall.
	public void exploringBoard(){
		
		// generate player sight radius around current position, 1 tile radius.
		
		// show to player what he sees north
		if(b.getPositionInfo(playerXCoord, playerYCoord-1).toLowerCase().contains("floor")){

			// check for first movement, show door instead of floor text				
			if(playerXCoord == entryPointXCoord && playerYCoord == entryPointYCoord){
				map[playerXCoord][playerYCoord-1] = "E"; // E marks the entrance to the maze
			}else{
				map[playerXCoord][playerYCoord-1] = "."; // if text is floor mark it as a .
			}
			
		}else{
			
			// check if the spot is a wall, if it is not then it must be a monster or an item.			
			if(b.getPositionInfo(playerXCoord, playerYCoord-1).toLowerCase().contains("wall")){
				map[playerXCoord][playerYCoord-1] = "#"; // wall space shown as # symbol
			}else{
				map[playerXCoord][playerYCoord-1] = b.getPositionInfo(playerXCoord, playerYCoord-1);
			}

		}
		
		// show to player what he sees north east
		if(b.getPositionInfo(playerXCoord+1, playerYCoord-1).toLowerCase().contains("floor")){

			map[playerXCoord+1][playerYCoord-1] = "."; // if text is floor mark it as a .
						
		}else{
			
			// check if the spot is a wall, if it is not then it must be a monster or an item.			
			if(b.getPositionInfo(playerXCoord+1, playerYCoord-1).toLowerCase().contains("wall")){
				map[playerXCoord+1][playerYCoord-1] = "#"; // wall space shown as # symbol
			}else{
				map[playerXCoord+1][playerYCoord-1] = b.getPositionInfo(playerXCoord+1, playerYCoord-1);
			}

		}
		
		// show to player what he sees east
		if(b.getPositionInfo(playerXCoord+1, playerYCoord).toLowerCase().contains("floor")){

			map[playerXCoord+1][playerYCoord] = "."; // if text is floor mark it as a .
			
		}else{

			// check if the spot is a wall, if it is not then it must be a monster or an item.			
			if(b.getPositionInfo(playerXCoord+1, playerYCoord).toLowerCase().contains("wall")){
				map[playerXCoord+1][playerYCoord] = "#"; // wall space shown as # symbol
			}else{
				map[playerXCoord+1][playerYCoord] = b.getPositionInfo(playerXCoord+1, playerYCoord);
			}
			
		}
		
		// show to player what he sees south east
		if(b.getPositionInfo(playerXCoord+1, playerYCoord+1).toLowerCase().contains("floor")){

			map[playerXCoord+1][playerYCoord+1] = "."; // if text is floor mark it as a .
			
		}else{

			// check if the spot is a wall, if it is not then it must be a monster or an item.			
			if(b.getPositionInfo(playerXCoord+1, playerYCoord+1).toLowerCase().contains("wall")){
				map[playerXCoord+1][playerYCoord+1] = "#"; // wall space shown as # symbol
			}else{
				map[playerXCoord+1][playerYCoord+1] = b.getPositionInfo(playerXCoord+1, playerYCoord+1);
			}
			
		}
		
		// show to player what he sees south
		if(b.getPositionInfo(playerXCoord, playerYCoord+1).toLowerCase().contains("floor")){

			map[playerXCoord][playerYCoord+1] = "."; // if text is floor mark it as a .
			
		}else{
			
			// check if the spot is a wall, if it is not then it must be a monster or an item.			
			if(b.getPositionInfo(playerXCoord, playerYCoord+1).toLowerCase().contains("wall")){
				map[playerXCoord][playerYCoord+1] = "#"; // wall space shown as # symbol
			}else{
				map[playerXCoord][playerYCoord+1] = b.getPositionInfo(playerXCoord, playerYCoord+1);
			}
			
		}
		
		// show to player what he sees south west
		if(b.getPositionInfo(playerXCoord-1, playerYCoord+1).toLowerCase().contains("floor")){

			map[playerXCoord-1][playerYCoord+1] = "."; // if text is floor mark it as a .
			
		}else{
			
			// check if the spot is a wall, if it is not then it must be a monster or an item.			
			if(b.getPositionInfo(playerXCoord-1, playerYCoord+1).toLowerCase().contains("wall")){
				map[playerXCoord-1][playerYCoord+1] = "#"; // wall space shown as # symbol
			}else{
				map[playerXCoord-1][playerYCoord+1] = b.getPositionInfo(playerXCoord-1, playerYCoord+1);
			}
			
		}
		
		// show to player what he sees west
		if(b.getPositionInfo(playerXCoord-1, playerYCoord).toLowerCase().contains("floor")){			
			
			map[playerXCoord-1][playerYCoord] = "."; // if text is floor mark it as a .
							
		}else{
			
			// check if the spot is a wall, if it is not then it must be a monster or an item.			
			if(b.getPositionInfo(playerXCoord-1, playerYCoord).toLowerCase().contains("wall")){
				map[playerXCoord-1][playerYCoord] = "#"; // wall space shown as # symbol
			}else{
				map[playerXCoord-1][playerYCoord] = b.getPositionInfo(playerXCoord-1, playerYCoord);
			}
			
		}
		
		// show to player what he sees north west
		if(b.getPositionInfo(playerXCoord-1, playerYCoord-1).toLowerCase().contains("floor")){			
			
			map[playerXCoord-1][playerYCoord-1] = "."; // if text is floor mark it as a .
							
		}else{
			
			// check if the spot is a wall, if it is not then it must be a monster or an item.			
			if(b.getPositionInfo(playerXCoord-1, playerYCoord-1).toLowerCase().contains("wall")){
				map[playerXCoord-1][playerYCoord-1] = "#"; // wall space shown as # symbol
			}else{
				map[playerXCoord-1][playerYCoord-1] = b.getPositionInfo(playerXCoord-1, playerYCoord-1);
			}
			
		}

	}
	
	
	// gets called when player moves with arrowkeys. Moves the player to a spot if possible.
	public void actionResult(String action){		
		
		switch(action){
			case "up":
				playerYCoord--; // player moving up
									
				// check for first movement, show door instead of floor text
				if(playerXCoord == entryPointXCoord && playerYCoord+1 == entryPointYCoord){
					playerYCoord++;						
				}else{
					// check if the position that we are moving to has a floor tile
					// if it has movement is allowed
					// else hit head on wall and reverse movement
					if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
						// player moves up successfully, do nothing since coordinate has been updated already
					}else{
						// player hit a wall or other blockage, reverse their movement.						
						playerYCoord++; // reverse movement, wall found in new position.
					}
				
				}
				break;
			case "right":
				
				playerXCoord++; // player moving right
				
				if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
					// player moves right successfully, do nothing since coordinate has been updated already
				}else{

					playerXCoord--; // reverse movement, wall found in new position.
				}
									
				break;
			case "down":
				
				playerYCoord++; // player moving down
				
				if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
					// player moves down successfully, do nothing since coordinate has been updated already
				}else{

					playerYCoord--; // reverse movement, wall found in new position.
				}
				
				break;
			case "left":
				
				playerXCoord--; // player moving left
				
				if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
					// player moves left successfully, do nothing since coordinate has been updated already
				}else{

					playerXCoord++; // reverse movement, wall found in new position.
				}
				
				break;
			case "l":
				// show what player sees around them as text
				// not implemented yet.
				exploringBoard();
				break;
			
		}
		
		if(playerYCoord >= b.getBoardYSize()-1){
			//exit found, do nothing
		}else{
			exploringBoard();
			b.setBoard(b.getMonsterActions().moveMonsters(b.getBoard()));
			
			// MOVE TO COMBAT SCREEN IF PLAYER COORDINATE AND MONSTER COORDINATES ARE NEXT TO EACH OTHER OR THE SAME.
			
			// player is always on empty space but future proofing with this catch.
			// else fork means player is somehow standing either on wall or something else than floor.
			if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
				map[playerXCoord][playerYCoord] = "."; // player is always on empty space so make it empty again. 
			}else{
				map[playerXCoord][playerYCoord] = "#";
			}
		
		}
		
		map[playerXCoord][playerYCoord] = "X";
	}
	
	public int getXSizeFromBoard(){
		return b.getBoardXSize();
	}
	
	public int getYSizeFromBoard(){
		return b.getBoardYSize();
	}
		
}
