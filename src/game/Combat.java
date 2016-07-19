package game;

public class Combat {
	
	// calculates the damage that the target took from the attack
	// reduced by target defense
	public int attack(int attackDamage, int targetHealth, int targetDefense){
		
		// 250 is the max value of attributes
		// example:  		100				50				50				25
		//					100				50				50				0.1 (25 / 250)
		//					100				50				5 (50 * 0.1)
		//					100				45 (50 - 5)
		//					55 (100 - 45)
		// newhealth = 55
		double newHealth = targetHealth - (attackDamage - (attackDamage * (targetDefense / 250)));
		
		targetHealth = (int) newHealth;
		
		return targetHealth;
	}
	
}
