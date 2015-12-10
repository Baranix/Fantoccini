/* WeaponType.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 13, 2012 */

public enum WeaponType{
	SWORD( 5, 1 ),
	BOW( 3, 1 ),
	STAFF( 1, 5 ),
	NONE( 0, 0 );
	
	private int ATK;
	private int MATK;
	private String typeName;
	
	public String getName()
	{
		switch (this)
		{
			case SWORD:
				typeName = "Sword";
				break;
			case BOW:
				typeName = "Bow";
				break;
			case STAFF:
				typeName = "Staff";
				break;
			case NONE:
				typeName = "";
        };
		
		return typeName;
	} // Read more: http://javarevisited.blogspot.com/2011/08/enum-in-java-example-tutorial.html#ixzz23JVWI9je
	
	private WeaponType( int ATK, int MATK )
	{
		this.ATK = ATK;
		this.MATK = MATK;
	}
	
	public int getATK()
	{
		return ATK;
	} // end getATK
	
	public int getMATK()
	{
		return MATK;
	} // end get MATK
};