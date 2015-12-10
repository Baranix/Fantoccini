/* MainMenu.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 10, 2012 */

import java.util.Scanner;
import java.io.File;

public class MainMenu
{
	public static void main( String args[] )
	{
	
		switch( displayMenu() )
		{
			case 1 : CharacterCreation.main();
					break;
			case 2 : Load.main( Load.list( "Data" + File.separator + "saveList.dat" ) );
					break;
		};
	} // end main
	
	private static int displayMenu()
	{
		System.out.println( "MAIN MENU" );
		System.out.println( "1. New Game\n2. Load Game\n3. Exit\n\nChoice: " );
		Scanner i = new Scanner( System.in );
		
		return i.nextInt();
	} // end displayMenu

} // end MainMenu