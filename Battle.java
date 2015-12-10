/* Battle.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 18, 2012 */

import java.util.Random;
import java.util.Scanner;
 
public class Battle
{
	/* adds the Character object and an array of Monsters
	 * number of monsters to be randomly generated
	 * monsters' attributes will be randomly generated (based on player's level)
	 * attacks and defenses will be compared, etc.
	 */
	
	private boolean win;
	private boolean run;
	private final UserPlayer player;
	private Monster monster;
	
	public Battle( UserPlayer player, Monster monster )
	{
		this.player = player;
		this.monster = monster;
		win = false;
		run = false;
		
	} // end Battle constructor
	
	public void Sequence()
	{
		Random d = new Random();
		Scanner i = new Scanner( System.in );
		
		do
		{
			System.out.println();
			System.out.println();
			monster.displayStats(); // display Monster stats
			System.out.println();
			player.displayStats(); // display Player stats
			System.out.println();
			
			/* prompt user what to do */
			System.out.println( "What would you like to do?" );
			System.out.println( "1. Swing " + player.getWeapon().getName() );
			System.out.println( "2. Cast spell" );
			System.out.println( "3. Run away" );
			System.out.print( "\nChoice: " );
			
			switch( i.nextInt() )
			{
				case 1: UseWeapon( player.getAttr(), player.getWeapon(), monster.getAttr(), monster.getArmor(), d );
						break;
				case 2: CastSpell( player.getAttr(), player.getWeapon(), monster.getAttr(), monster.getArmor(), 0 );
						break;
				case 3: runAway( player.getAttr(), monster.getAttr(), d );
						if ( run )
							System.out.println( "You ran away." );
						else
							System.out.println( "Couldn't get away!" );
						break;
			};
			
			System.out.println( " >>" ); // Pause effect
			Fantoccini.pause();
			
			win = monster.getAttr().getHP() <=0 ? true : false;
			
			/* Monster's turn ( will always use weapons ) */
			if ( !win && !run )
			{
				System.out.println( "\n\n" + monster.getAttr().getName() + "'s turn." );
				Fantoccini.pause();
			
				UseWeapon( monster.getAttr(), monster.getWeapon(), player.getAttr(), player.getArmor(), d );
			
				System.out.println( " >>" ); // Pause effect
				Fantoccini.pause();
			}
			
		}while( monster.getAttr().getHP() > 0 && player.getAttr().getHP() > 0 && !run );

	} // end Sequence
	
	private void UseWeapon( Attributes first, Weapon w, Attributes second, Armor a, Random d )
	{
		/*  if ( PlayerAGI + Random( from 0 to PlayerAGI ) is greater than or equal to MonsterAGI + Random( from 0 to MonsterAGI ) )
				hit
			else
				miss */
		if ( ( first.getAGI() + d.nextInt( first.getAGI() ) ) >= ( second.getAGI() + d.nextInt( second.getAGI() ) ) )
		{
			int dmg = ( ( d.nextInt( first.getAGI() )
						+ ( first.getSTR() ) )
						+ w.getType().getATK() ) 
						- a.getType().getDEF();
						
			/* Damage = Random( from 0 to PlayerAGI ) + PlayerSTR + WeaponAttack - MonsterArmor */
			if ( dmg < 0 )
			 dmg = 0;
			 
			// Set HP - dmg 
			second.setHP( second.getHP() - dmg );
			System.out.println( "\n\n" + second.getName() + " gets " + dmg + " damage from " + w.getName() );
		}
		else
		{
			System.out.println( "Missed!" );
		}
	} // end UseWeapon
	
	private void CastSpell( Attributes first, Weapon w, Attributes second, Armor a, int who )
	{
		Random d = new Random();
		int mana = 5, choice = 0;
		int bonusDamage = d.nextInt( first.getMAG() ) + 1;
		String spellname = "Mana Bolt";
		
		do
		{
			System.out.println( "Choose a spell:" );
			System.out.println( "1. Mana Bolt\n2. Fire Ball\n\nChoice: " );
			Scanner i = new Scanner( System.in );
			choice = i.nextInt();
		}while( choice<1 && choice>2 );
		
		switch( choice )
		{
			case 2: spellname = "Fire Ball";
					bonusDamage = d.nextInt( first.getMAG() ) + 2; // has more dmg than the default Mana Bolt
					mana = 10; // cost of spell
					break;
		};
		
		/* using spells cost mana or MP */
		first.setMP( first.getMP() - mana );
		
		/* dmg = MAG + WeaponMagicAttack + BonusDamage - OpponentDefense */
		int dmg = (int) ( first.getMAG() + w.getType().getMATK() + bonusDamage ) - a.getType().getDEF();
		if ( dmg < 0 )
			dmg = 0;
		second.setHP( second.getHP() - dmg );
			
		System.out.println( "\n\n" + second.getName() + " gets " + dmg + " damage from " + first.getName() + "'s " + spellname + "." );	
	} // end CastSpell
	
	private void runAway( Attributes p, Attributes m, Random d )
	{
		/* if Player's AGI is greater than or equal to the Monster's AGI, then Player can run away */
		if ( ( p.getLVL() + d.nextInt( p.getAGI() ) ) >= ( m.getLVL() + d.nextInt( m.getAGI() ) ) )
		{
			run = true;
		}

	} // end runAway
	
	public boolean HasRun()
	{
		return run;
	} // end HasRun
	
	public boolean HasWon()
	{
		return win;
	} // end HasWon
	
	public UserPlayer getPlayer()
	{
		return player;
	} // end getPlayer
	
	public Monster getMonster()
	{
		return monster;
	} // end getMonster
	
} // end Battle

/* The algorithm used in this battle system is
 * based on the RPG Dragon Age by Bioware
 * http://dragonage.wikia.com/wiki/Combat_mechanics
 */