/* Monster.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 15, 2012 */

import java.util.Random;

public class Monster extends Character
{
/* set the kind of monster as well as call the Attributes class to set its attributes */

	public Monster( int m )
	{
		System.out.println( "m = " + m ); // debugging
		
		Random i = new Random();
		System.out.println( "// Random successfully created." ); // debugging
		
		switch( m )
		{
			case 1: super.setAttr( new Attributes( "Moth Larvae", 1, ( 3 + i.nextInt( 2 ) + 1 ), ( 5 + i.nextInt( 3 ) + 1 ), 3 ) );
					super.setArmor( new Armor( ArmorType.NONE, "Fat Hide" ) );
					super.setWeapon( new Weapon( WeaponType.NONE, "Mandibles" ) );
					break;
			case 2: System.out.println( "// case 2 called" ); // debugging
					super.setAttr( new Attributes( "Thieving Magpie", 2, ( 5 + i.nextInt( 2 ) + 2 ), ( 7 + i.nextInt( 3 ) + 2 ), 4 ) );
					super.setArmor( new Armor( ArmorType.NONE, "Feathers" ) );
					super.setWeapon( new Weapon( WeaponType.NONE, "Sharp Beak" ) );
					System.out.println( "// Thieving Magpie monster created." ); // debugging
					break;
			default: System.out.println( "ERROR: Monster not found!" );
		};
		
	} // end Monster
	
/*	public Attributes getAttr()
	{
		return super.getAttr();
	} // end getAttr
	
	public Armor getArmor()
	{
		return super.getArmor();
	} // getArmor
	
	public Weapon getWeapon()
	{
		return super.getWeapon();
	} // end getWeapons
	
	
	public void displayStats()
	{
		super.displayStats();
	} // end displayStats*/

} //end Monster