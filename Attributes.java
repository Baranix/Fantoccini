/* Attributes.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: September 4, 2012 */
 
import java.io.Serializable;
 
public class Attributes implements Serializable
{
	private String name;
	//private ImageFile; (In case I get around to putting a GUI)
	private int STR;
	private int AGI;
	private int MAG;
	
	private int HP;
	private int MP;
	private int EXP;
	private int LVL;
	
	public Attributes()
	{
		setSTR(5);
		setAGI(5);
		setMAG(5);
		setLVL(1);
	
	} // end Attributes( player )
	
	public Attributes ( String name, int lvl, int str, int agi, int mag )
	{
		//System.out.println( "// Monster Attributes called" ); // debugging
		setName( name );
		setLVL( lvl );
		setSTR( str );
		setAGI( agi );
		setMAG( mag );
	} // end Attributes( monster )
	
	public void setName( String n )
	{
		name = n;
	} // end setName
	
	public String getName()
	{
		return name;
	} // end getName
	
	public void setSTR( int i )
	{
		STR = i;
		setHP();
	} // end setSTR
	
	public int getSTR()
	{
		return STR;
	} // end getSTR
	
	public void setAGI( int i )
	{
		AGI = i;
	} // end setAGI
	
	public int getAGI()
	{
		return AGI;
	} // end getAGI
	
	public void setMAG( int i )
	{
		MAG = i;
		setMP();
	} // end setMAG
	
	public int getMAG()
	{
		return MAG;
	} // end getMAG
	
	public void setHP()
	{
		HP = STR*20;
	} // end setHP
	
	public void setHP( int HP )
	{
		this.HP = HP;
	} // end setHP(int)
	
	public int getHP()
	{
		return HP;
	} // end getHP
	
	public void setMP()
	{
		MP = MAG*20;
	} // end setMP
	
	public void setMP( int MP )
	{
		this.MP = MP;
	} // end setMP(int)
	
	public int getMP()
	{
		return MP;
	} // end getMP
	
	public void setEXP( int additionalEXP )
	{
		/* System.out.println( "// setEXP called" ); // debugging */
		EXP += additionalEXP;
		setLVL();
	} // end setEXP
	
	public int getEXP()
	{
		return EXP;
	} // end getEXP
	
	public void setLVL( int forced )
	{
		LVL = forced;
	} // end setLVL( forced )
	
	private void setLVL()
	{
		int EXPcap = ( 100 * LVL * ( LVL + 1 ) ); // the amount of EXP needed to get to the next LVL
		
		if ( EXP >= EXPcap )
			LVL++;
			
		/*System.out.println( "LVL = " + LVL ); // debugging
		System.out.println( "EXPcap = " + EXPcap ); // debugging*/
			
	} // end setLVL
	
	public int getLVL()
	{
		return LVL;
	} // end getLVL

} // end Attributes