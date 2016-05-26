package game;

import paths.Board;

import java.util.Scanner;

import movement.PlayerActions;

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
	private String [][] board = null;
	private PlayerActions pl = null;

	// set the size of the maze, 1 = small, 2 = medium, 3 = large
	public void setMazeSize(int size){
		mazeSize = size;
	}
	
	public void initializeBoard(){
		b = new Board(mazeSize);
		mapBoard = new Board(mazeSize);
		map = mapBoard.getBoard();			
	}

	// main game loop which ends once player has reached the end of the maze
	public String gameLoop(String movementDirectionKeystroke){
		
		String textToReturn = null;
		
		if(firstMovement == 0){
		
			board = b.getBoard();
		
			playerXCoord = b.getPlayerXStartPos();
			playerYCoord= b.getPlayerYStartPos()+1; // +1 needed to move away from edge of wall
			Scanner in = new Scanner(System.in);
			
			entryPointYCoord = playerYCoord; // save entry point data for text description
			entryPointXCoord = playerXCoord;
			
			// stay in maze while player y position is not at the edge of the maze
			// when y position is at the edge, player has found an exit so end the game.
			
			pl = new PlayerActions();
			
			// player map that is initially empty but fills in as player explores different areas.
			map = mapBoard.getBoard();				
			mapBoard.initializeMap(map);
			firstMovement++;
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

	public void exploringBoard(){		

		
		// generate player sight radius around current position, 1 tile radius.
		
		// show to player what he sees north
		if(b.getPositionInfo(playerXCoord, playerYCoord-1).toLowerCase().contains("floor")){

			// check for first movement, show door instead of floor text				
			if(playerXCoord == entryPointXCoord && playerYCoord == entryPointYCoord){
				//System.out.println("You see the maze entrance door NORTH of your position. ");
				map[playerXCoord][playerYCoord-1] = "E"; // empty space so use space to show as empty, maybe some other symbol better?
			}else{
				//System.out.println("You see an empty floor NORTH of your position. ");
				map[playerXCoord][playerYCoord-1] = "."; // empty space so use space to show as empty, maybe some other symbol better?
			}
			
		}else{
			//System.out.println("You see a wall NORTH of your position.");
			map[playerXCoord][playerYCoord-1] = "#"; // wall space shown as # symbol
		}
		
		// show to player what he sees east
		if(b.getPositionInfo(playerXCoord+1, playerYCoord).toLowerCase().contains("floor")){
			
			//System.out.println("You see an empty floor EAST of your position. ");
			map[playerXCoord+1][playerYCoord] = "."; // empty space so use space to show as empty, maybe some other symbol better?
			
		}else{
			//System.out.println("You see a wall EAST of your position.");
			map[playerXCoord+1][playerYCoord] = "#"; // wall space shown as # symbol
		}
		
		// show to player what he sees south
		if(b.getPositionInfo(playerXCoord, playerYCoord+1).toLowerCase().contains("floor")){
			
			//System.out.println("You see an empty floor SOUTH of your position. ");
			map[playerXCoord][playerYCoord+1] = "."; // empty space so use space to show as empty, maybe some other symbol better?
			
		}else{
			//System.out.println("You see a wall SOUTH of your position.");
			map[playerXCoord][playerYCoord+1] = "#"; // wall space shown as # symbol
		}
		
		// show to player what he sees west
		if(b.getPositionInfo(playerXCoord-1, playerYCoord).toLowerCase().contains("floor")){
			
			//System.out.println("You see an empty floor WEST of your position. ");
			map[playerXCoord-1][playerYCoord] = "."; // empty space so use space to show as empty, maybe some other symbol better?
							
		}else{
			//System.out.println("You see a wall WEST of your position.");
			map[playerXCoord-1][playerYCoord] = "#"; // wall space shown as # symbol
		}

	}

	public void actionResult(String action){
		
		
		switch(action){
			case "up":
				playerYCoord--; // player moving north
									
				// check for first movement, show door instead of floor text
				if(playerXCoord == entryPointXCoord && playerYCoord+1 == entryPointYCoord){
//					System.out.println("The door is locked, it seems you need to find another way out of the maze.");
//					System.out.println("Press ENTER.");
//					in.nextLine();
					playerYCoord++;						
				}else{
					// check if the position that we are moving to has a floor tile
					// if it has movement is allowed
					// else hit head on wall and reverse movement
					if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
//						System.out.println("You walk NORTH.");
//						System.out.println("Press ENTER.");
//						in.nextLine();
					}else{
//
//						System.out.println("Ouch, you hit your head on the wall!");		
//						System.out.println("Press ENTER.");
//						in.nextLine();
						
						playerYCoord++; // reverse movement, wall found in new position.
					}
				
				}
				break;
			case "right":
				
				playerXCoord++; // player moving east
				
				if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
//					System.out.println("You walk EAST.");
//					System.out.println("Press ENTER.");
//					in.nextLine();
				}else{
//					System.out.println("Ouch, you hit your head on the wall!");
//					System.out.println("Press ENTER.");
//					in.nextLine();
					playerXCoord--; // reverse movement, wall found in new position.
				}
									
				break;
			case "down":
				
				playerYCoord++; // player moving south
				
				if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
//					System.out.println("You walk SOUTH.");
//					System.out.println("Press ENTER.");
//					in.nextLine();
				}else{
//					System.out.println("Ouch, you hit your head on the wall!");
//					System.out.println("Press ENTER.");
//					in.nextLine();
					playerYCoord--; // reverse movement, wall found in new position.
				}
				
				break;
			case "left":
				
				playerXCoord--; // player moving west
				
				if(b.getPositionInfo(playerXCoord, playerYCoord).toLowerCase().contains("floor")){
//					System.out.println("You walk WEST.");
//					System.out.println("Press ENTER.");
//					in.nextLine();
				}else{
//					System.out.println("Ouch, you hit your head on the wall!");
//					System.out.println("Press ENTER.");
//					in.nextLine();
					playerXCoord++; // reverse movement, wall found in new position.
				}
				
				break;
			case "l":
				// show what player sees around them as text
				exploringBoard();
				break;
			
		}
		
		if(playerYCoord >= b.getBoardYSize()-1){
			//exit found do nothing
		}else{
			exploringBoard();
		
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
}
