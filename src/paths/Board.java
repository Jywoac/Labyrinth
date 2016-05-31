package paths;

import java.util.Random;

public class Board {
	
	// board items holds the entire board
	// one item on the board could for example be a wall or an empty walkable tile
	private String[][] boardItems;
	private int startingXPosition = 0; // starting x position for path generation
	private int startingYPosition = 0; // starting y position for path generation
	private int boardXSize = 0;
	private int boardYSize = 0;
	private int playerYStartPos = 0;
	private int playerXStartPos = 0;

	public Board(int difficultyChosen){
		setDifficulty(difficultyChosen);
		boardItems = new String[boardXSize][boardYSize];	
		initializeBoard(boardItems);
	    makeMazes(difficultyChosen);	   	    
	
	}
	
	private void setDifficulty(int diff){
		
		// currently only uses case 1 to set the board size
		// might update this later to make smaller mazes		
		switch(diff){
			case 1:
				boardXSize = 69;
				boardYSize = 22;
				break;
			case 2:
				boardXSize = 50;
				boardYSize = 50;				
				break;
			case 3:
				boardXSize = 100;
				boardYSize = 100;
				break;
			default:
				break;			
		}	
		
	}

	
	private void makeMazes(int dif){		
	    
	    Random rand = new Random();

	    // making correct path through maze
		startingXPosition = rand.nextInt(boardXSize+1); // random number between boardXpos start and end
		if(startingXPosition == 0){
			startingXPosition = 1;
		}else{
			if(startingXPosition >= (boardXSize-1)){
				startingXPosition = (boardXSize-2);
			}
		}
		startingYPosition = 0; // always start at the edge of the board, in this case at the top row.
		
		playerYStartPos = startingYPosition;
		playerXStartPos = startingXPosition;
		
		boardItems = makeCorrectPathThroughMaze(boardItems,startingXPosition, startingYPosition);	    
	    
		switch(dif){
		
			case 1:
				// make multiple false y paths to generate maze
				int numOfYPaths = 5;
				
				while(numOfYPaths > 0){

					// make random y paths		
					startingXPosition = rand.nextInt(boardXSize+1); // random number between boardXpos start and end
					if(startingXPosition == 0){
						startingXPosition = 1;
					}else{
						if(startingXPosition >= (boardXSize-1)){
							startingXPosition = (boardXSize-2);
						}
					}
					startingYPosition = 1; // start at the almost edge of board					
					makeFalsePathYAxis(boardItems,startingXPosition, startingYPosition);
					
					// reset positions for next path generation
					startingXPosition = 0;
					startingYPosition = 0;

					numOfYPaths--;			
				}
				
				// make multiple false paths to generate maze
				int numOfXPaths = 5;
				
				while(numOfXPaths > 0){
					
					// make random x paths	
					startingYPosition = rand.nextInt(boardYSize+1); // random number between boardXpos start and end
					if(startingYPosition == 0){
						startingYPosition = 1;
					}else{
						if(startingYPosition >= (boardYSize-1)){
							startingYPosition = (boardYSize-2);
						}
					}
					
					startingXPosition = 1; // start at the almost edge of board	
								
					makeFalsePathXAxis(boardItems,startingXPosition, startingYPosition);
					numOfXPaths--;			
				}
				break;

			default:
				break;
		}
		
	}
	
	// Correct and False path need more x movement since they are too linear
	// Maybe stop the y from moving like every 2 movement stay on the level for 5 x movements?
	private String[][] makeFalsePathYAxis(String[][] BI,int x,int y){
		
		String [][] boardWithPath = BI;
		Random rand = new Random();
		
		int leftOrRight = 0; // has 2 possible values, 0 move left, 1 move right.
		int downUpOrStay = 0; // has 3 possible values, 0 stay on current level, 1 move back up, 2 move down.
		
		boardWithPath[x][y] = "floor";
		
		// generate a path from top to bottom
		// stop just before exiting the maze so we that we wont have multiple
		// paths out of the maze
		while(y < boardYSize-1){
			
			downUpOrStay = rand.nextInt(4); // randomizing the y value path
			
			// possibly need to make it more likely to move down a level
			// Currently moving down with 2x possibility, adding more cases increases
			// chance of moving down if y increases in the case			
			switch(downUpOrStay){
				case 0:
					// do nothing, stay on same level
					break;
				case 1:
					y--; // move back a level
					break;
				case 2:
					y++; // move down a level
					break;
				case 3:
					y++; // move down a level
					break;
			}			
			
			if(y <= 0){ // prevent breaking of outside wall
				y = 1;
			}
			
			// only move x if y stayed on the same level
			if(downUpOrStay == 0){				
				
				leftOrRight = rand.nextInt(2);
				
				switch(leftOrRight){
					case 0:
						x--; // move left
						break;
					case 1:
						x++; // move right
						break;
	
				}
	
				// we don't want multiple paths out of the maze so we must discard edge numbers (boardXsize-1 and 0) since they are 
				// the board edge walls that we dont want to break
				if(x <= 0){
					x = 1;
				}
				
				if(x >= boardXSize-1){ // 19
					x = boardXSize-3; // 18
				}
			}
			
			// y will reach a size over the board here so 
			// needs to have this catch
			if(y >= boardYSize-1){
				
			}else{				
				boardWithPath[x][y] = "floor";
			}
		}
		return boardWithPath;
	}
	
	private String[][] makeFalsePathXAxis(String[][] BI,int x,int y){
		
		String [][] boardWithPath = BI;
		Random rand = new Random();
		
		int leftOrRight = 0; // has 2 possible values, 0 move left, 1 move right.
		int downUpOrStay = 0; // has 3 possible values, 0 stay on current level, 1 move back up, 2 move down.
		
		boardWithPath[x][y] = "floor"; // use "floor" text after testing
		
		// generate a path from left to right
		// stop just before exiting the maze so we that we wont have multiple
		// paths out of the maze
		while(x < boardXSize-1){
			
			downUpOrStay = rand.nextInt(4); // randomizing the y value path
			
			//generate moving on x axis			
			switch(downUpOrStay){
				case 0:
					// do nothing, stay on same level
					break;
				case 1:
					x--; // move left
					break;
				case 2:
					x++; // move right
					break;
				case 3:
					x++; // move right
					break;
			}			
			
			if(x <= 0){ // prevent breaking of outside wall
				x = 1;
			}
			
			// only move x if y stayed on the same level
			if(downUpOrStay == 0){				
				
				leftOrRight = rand.nextInt(2);
				
				switch(leftOrRight){
					case 0:
						y--; // move up (moves up because a lower y number is higher when drawn)
						break;
					case 1:
						y++; // move down
						break;
	
				}
	
				// we don't want multiple paths out of the maze so we must discard edge numbers (boardXsize-1 and 0) since they are 
				// the board edge walls that we dont want to break
				if(y <= 0){
					y = 1;
				}else{
					if(y >= boardYSize-1){
						y = boardYSize-3;
					}
				}
			}
			
			// x will reach a size over the board here so 
			// needs to have this catch
			if(x >= boardXSize-1){
				
			}else{				
				boardWithPath[x][y] = "floor"; // use "floor" text after testing
				//boardWithPath[x][y] = "X"; // path testing 
			}
		}
		return boardWithPath;
	}
	
	// create a path that goes through the maze aka the correct path.
	private String[][] makeCorrectPathThroughMaze(String[][] BI,int x,int y){
		
		String [][] boardWithPath = BI;
		Random rand = new Random();
		
		int leftOrRight = 0; // has 2 possible values, 0 move left, 1 move right.
		int downUpOrStay = 0; // has 3 possible values, 0 stay on current level, 1 move back up, 2 move down.
		
		boardWithPath[x][y] = "floor"; // use "floor" text after testing
		
		// generate a path from top to bottom		
		while(y < boardYSize){
			
			downUpOrStay = rand.nextInt(4); // randomizing the y value path
			
			// possibly need to make it more likely to move down a level
			// Currently moving down with 2x possibility, adding more cases increases
			// chance of moving down if y increases in the case
			
			switch(downUpOrStay){
				case 0:
					// do nothing, stay on same level
					break;
				case 1:
					y--; // move back a level
					break;
				case 2:
					y++; // move down a level
					break;
				case 3:
					y++; // move down a level
					break;
			}			
			
			if(y <= 0){ // prevent breaking of outside wall
				y = 1;
			}
			
			// only move x if y stayed on the same level
			if(downUpOrStay == 0){				
				
				leftOrRight = rand.nextInt(2);
				
				switch(leftOrRight){
					case 0:
						x--; // move left
						break;
					case 1:
						x++; // move right
						break;
	
				}
	
				// we don't want multiple paths out of the maze so we must discard edge numbers (boardXsize-1 and 0) since they are 
				// the board edge walls that we dont want to break
				if(x <= 0){
					x = 1;
				}else{
					if(x >= boardXSize-1){ // 19
						x = boardXSize-3; // 18
					}
				}
			}
			
			// y will reach a size over the board here so 
			// needs to have this catch
			if(y >= boardYSize){
				
			}else{				
				boardWithPath[x][y] = "floor"; // use when not path testing
				//boardWithPath[x][y] = "C"; // path testing 
			}			
		}

		return boardWithPath;
	}
	
	// initialize the board with wall items
	public String[][] initializeBoard(String[][] BI){
		
		int x = 0;
		int y = 0;
		String [][] boardI = BI;
		
		// populate board with walls
		while (y < boardYSize){
			x = 0;
			while(x < boardXSize){
				boardI[x][y] = "wall"; // use when not path testing
				//boardI[x][y] = "|"; // path testing
				x++;
			}			
			y++;
		}
		return boardI;
	}
	
	// initial population of the map with wall items
	// this map is shown to the player. So all spaces are marked as "unknown" with ? symbol
	public String[][] initializeMap(String[][] BI){
		
		int x = 0;
		int y = 0;
		String [][] boardI = BI;
		
		// populate board with unknowns
		while (y < boardYSize){
			x = 0;
			while(x < boardXSize){
				boardI[x][y] = "?";
				x++;
			}			
			y++;
		}
		return boardI;
	}

	// print board items
	public String printBoard(String[][] board){
		
		int x = 0;
		int y = 0;
		
		// print board items		
		String boardToPrint = null;
				
		while (y < boardYSize){

			x = 0;
			while(x < boardXSize){				
				if(boardToPrint == null){
					boardToPrint = board[x][y];
				}else{					
					boardToPrint = boardToPrint + board[x][y];
				}
				x++;
			}
			// JEditorPane uses HTML, so need <br> for line breaks.
			if(x == boardXSize){
				boardToPrint = boardToPrint + "<br>";
			}
			
			y++;
		}

		return boardToPrint;
	}
	
	// print board items with char amount
	public int printBoardWithReturnCharAmount(String[][] board){
		
		int x = 0;
		int y = 0;
		
		// print board items		
		String boardToPrint = null;
				
		while (y < boardYSize){
						
			x = 0;
			while(x < boardXSize){				
				if(boardToPrint == null){
					boardToPrint = board[x][y];
				}else{					
					boardToPrint = boardToPrint + board[x][y];
				}
				x++;
			}
			
			if(x == boardXSize){
				boardToPrint = boardToPrint + "<br>";
			}
			
			y++;
		}

		return (boardToPrint.length());
	}

	
	// return whole board
	public String [][] getBoard(){
		return boardItems;
	}
	
	// return player x starting position
	public int getPlayerXStartPos(){
		return playerXStartPos;
	}
	
	// return player y starting position
	public int getPlayerYStartPos(){
		return playerYStartPos;
	}
	
	// return board y size
	public int getBoardXSize(){

		return boardXSize;
	}
	
	// return board x size
	public int getBoardYSize(){

		return boardYSize;
	}
	
	// return the text at this specific location
	public String getPositionInfo(int x, int y){
		return boardItems[x][y];
	}
}
