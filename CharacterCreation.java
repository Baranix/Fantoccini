/* CharacterCreation.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 18, 2012 */

import java.util.Scanner; 

public class CharacterCreation
{		
	public static void main( /*String args[]*/ )
	{
		UserPlayer player = new UserPlayer();
		Attributes playerAtr = new Attributes();
		
		Scanner input = new Scanner( System.in );
		
		player = Save.chooseSave( player );
		
		// playerAtr.setImage( /* get what the character looks like from user */ );
		
		/* set Character's name */
		System.out.print( "Enter character name: " );
		playerAtr.setName( input.nextLine() );
		
		boolean exit = false;
		do
		{
			/* set attributes */
			Attributes attr = player.attributePoints( playerAtr );
			player.setAttr( attr );
		
			/* set default armor */
			Armor clothes = new Armor( ArmorType.NONE, "Clothes" );
			clothes.setIsEquip( true );
			player.setArmor( clothes );
		
			/* set default weapon */
			Weapon hands = new Weapon( WeaponType.NONE, "Hands" );
			hands.setIsEquip( true );
			player.setWeapon( hands );
			
			System.out.println( "\n\n" );
			
			player.displayStats();
			
			System.out.println( "Are you sure about these stats? Otherwise, stats will reset. [y/n]\nChoice: " );
			String temp = input.next();
			char choice = temp.charAt(0);
			if ( choice == 'y' || choice == 'Y' )
				exit = true;
			else
			{
				attr.setSTR(5);
				attr.setAGI(5);
				attr.setMAG(5);
			}
		}while( !exit );
		
		/* save game */
		Save.game( player, player.slot );
		
		StartBattle.main( player );
		
	} // end main
	
} // end CharacterCreation