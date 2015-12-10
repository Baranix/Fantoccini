/* Fantoccini.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 10, 2012 */

import java.io.IOException;
 
public class Fantoccini
{
	public static void main( String args[] )
	{
		System.out.println( "\n\n\n\"Fantoccini\"\n" );
		System.out.println( "Created by: Nikki Ebora\n            201107408872\n            BS Computer Science" );
		System.out.println( "OBJECTP Final Project" );
		System.out.println();
		System.out.println( "Fantoccini.class runs the initialization that needs to be run only once.\nYou may now run the MainMenu class file to launch the actual game. Thank you!" );
		
		initializeFiles();
		
	} // end main
	
	private static void initializeFiles()
	{
		String[] list = new String[20];
		for ( int i = 0; i < list.length; i++ )
			list[i] = "#NO SAVE DATA";
		
		Save.saveList( list );
		
	} // end initializeFiles
	
	public static void pause() 
	{
		try
		{
			System.in.read();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}