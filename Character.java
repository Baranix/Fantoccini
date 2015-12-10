/* Character.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: September 5, 2012 */

import java.io.Serializable;

public class Character implements Serializable
{
	/* all attributes created in CharacterCreation, Armor, Weapons, Helmet will be called here */
	
	private Attributes attr;
	private Armor armor;
	private Weapon weapon;
	// private Spell[] spell;
	
	public void setAttr( Attributes a )
	{
		attr = a;
	} // end setAttr
	
	public Attributes getAttr()
	{
		return attr;
	} // end getAttr
	
	public void setArmor( Armor armor )
	{
		this.armor = armor;
	} // end setArmor
	
	public Armor getArmor()
	{
		return armor;
	} // end getArmor
	
	public void setWeapon( Weapon weapon )
	{
		this.weapon = weapon;
	} // end getWeapon
	
	public Weapon getWeapon()
	{
		return weapon;
	} // end getWeapon
	
	/*public void setSpell( Spell[] spell )
	{
		this.spell = spell;
	} // end setSpell
	
	public Spell getSpell()
	{
	
	}*/ // I wanted more complicated spells, but it was taking too much time
	
	public void displayStats()
	{
		System.out.println( getAttr().getName() );
		System.out.println();
		System.out.println( "LVL: " + getAttr().getLVL() );
		System.out.println( "STR: " + getAttr().getSTR() );
		System.out.println( "AGI: " + getAttr().getAGI() );
		System.out.println( "MAG: " + getAttr().getMAG() );
		System.out.println( "HP: " + getAttr().getHP() );
		System.out.println( "MP: " + getAttr().getMP() );
		System.out.println();
		System.out.println( "Armor: " + getArmor().getName() );
		System.out.println( "Weapon: " + getWeapon().getName() );
		
	} // end displayStats
} // end Character