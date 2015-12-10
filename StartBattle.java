/* StartBattle.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 17, 2012 */

import java.util.Scanner;

public class StartBattle
{
	public static void main( UserPlayer player )
	{
		boolean replay;
		Monster monster;
		Scanner i = new Scanner( System.in );
		do{
			// create monster based on player's level
			monster = createMonster( player.getAttr().getLVL() );
			
			// Create and start battle sequence
			Battle battle = new Battle( player, monster );
			battle.Sequence();
		
			// Return the results of the battle on both sides
			player = battle.getPlayer();
			monster = battle.getMonster();
			
			// Reset HP and MP
			player.getAttr().setHP();
			player.getAttr().setMP();
			
			// Autosave game
			Save.game( player, player.slot );
		
			if ( battle.HasWon() )
			{
				System.out.println( monster.getAttr().getName() + " has been defeated!" );
				
				int prevLVL = player.getAttr().getLVL();
				
				// Calculate the EXP gained by dividing the monster's LVL by the player's LVL times 100
				double EXP = ( (double) monster.getAttr().getLVL() / (double) prevLVL ) * 100;
				// set the new EXP
				player.getAttr().setEXP( (int) EXP );
				
				System.out.println( "You earn " + (int) EXP + " experience!" );
				System.out.println( "Total EXP: " + player.getAttr().getEXP() );
				System.out.println( "Level: " + player.getAttr().getLVL() );
				
				// Check if enough EXP for a level up
				int newLVL = player.getAttr().getLVL();
				if ( newLVL > prevLVL )
					player.levelUp();
			}
			else // if player died or ran away
			{
				System.out.println( "You have been defeated." );
			}
			
			// Prompt to go to next battle or exit
			System.out.print( "Continue? [y/n] " );
			String temp = i.next();
			char c = temp.charAt(0);
			
			if ( c == 'y' || c == 'Y' )
				replay = true;
			else
				replay = false;
		
		}while( replay );
	} // end main
	
	private static Monster createMonster( int plvl )
	{
		/* System.out.println( "// Create Monster called." ); // debugging */
		
		int mlvl = plvl < 3 ? plvl : 2;
		/* System.out.println( "plvl = " + plvl ); // debugging
		System.out.println( "mlvl = " + mlvl ); // debugging */
		
		Monster monster = new Monster( mlvl );
		
		return monster;
	} // end setMonster
	
} // end StartBattle