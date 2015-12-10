/* Armor.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 13, 2012 */
 
import java.io.Serializable;
 
public class Armor implements Serializable
{
	private String name;
	private ArmorType type;
	private boolean equipped;
	
	public Armor( ArmorType type, String name )
	{
		setType( type );
		setName( name );
		setIsEquip( false );
	} // end Armor
		
		
	public void setName( String name )
	{
		this.name = type.getName() + " " + name;
	} // end setName
	
	public String getName()
	{
		return name;
	} // end getName
	
	public void setType( ArmorType type )
	{
		this.type = type;
	} // end setType
	
	public ArmorType getType()
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

} // end Armor