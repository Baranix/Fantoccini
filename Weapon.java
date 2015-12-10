/* Weapon.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 13, 2012 */

import java.io.Serializable;

public class Weapon implements Serializable
{
	private String name;
	private WeaponType type;
	private boolean equipped;
	
	public Weapon( WeaponType type, String name )
	{
		setType( type );
		setName( name );
		setIsEquip( false );
	} // end Armor
		
		
	public void setName( String name )
	{
		this.name = name + " " + type.getName();
	} // end setName
	
	public String getName()
	{
		return name;
	} // end getName
	
	public void setType( WeaponType type )
	{
		this.type = type;
	} // end setType
	
	public WeaponType getType()
	{
		return type;
	} // end getType
	
	public void setIsEquip( boolean equipped )
	{
		this.equipped = equipped;
	} // end setEquip
	
	public boolean getIsEquip()
	{
		return equipped;
	} // end getIsEquip

} // end Weapon