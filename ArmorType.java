/* ArmorType.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 13, 2012 */

public enum ArmorType{
	METAL( 5 ),
	LEATHER( 3 ),
	CLOTH( 1 ),
	NONE( 0 );
	
	private int DEF;
	private String typeName;
	
	public String getName()
	{
		switch (this)
		{
			case METAL:
				typeName = "Metal";
				break;
			case LEATHER:
				typeName = "Leather";
				break;
			case CLOTH:
				typeName = "Cloth";
				break;
			case NONE:
				typeName = "Normal";
        };
		
		return typeName;
	} // Read more: http://javarevisited.blogspot.com/2011/08/enum-in-java-example-tutorial.html#ixzz23JVWI9je
	
	private ArmorType( int DEF )
	{
		this.DEF = DEF;
	}
	
	public int getDEF()
	{
		return DEF;
	} // end getDEF
};