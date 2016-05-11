package movement;

import java.util.Scanner;

public class PlayerActions {
	
	int playerActionTaken = 0;
	
	public String playerButtonPress(){
		
		boolean answer = false;
		Scanner in = new Scanner(System.in);
		String actionTaken = null;
		
		while(answer == false){

			String s = in.nextLine();						
						
			switch(s){
				case "w":
					answer = true;
					actionTaken = s;
					break;
				case "d":
					answer = true;
					actionTaken = s;
					break;
				case "s":
					answer = true;
					actionTaken = s;
					break;
				case "a":
					answer = true;
					actionTaken = s;
					break;
				case "l":
					answer = true;
					actionTaken = s;
					break;						
				default:
					answer = false;
					//System.out.println("Please choose 1,2,3,4 or 5.");
					
			}	
			
		}
		
		return actionTaken;		
	}
	
}
