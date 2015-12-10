/* Save.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 10, 2012 */

import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Save
{
	public static void game( UserPlayer player, int slot )
	{
		/* Saving the List of Game Data */
		File data = createFolder( "Data" );
		String[] list = Load.list( data + File.separator + "saveList.dat" );
		list[slot] = ( slot + 1 ) + "#" + player.getAttr().getName();
		saveList( list );
		
		/* Saving the actual Game Data */
		File dir = createFolder( "Save" );
		/* Saving Character Data */
		String filename = ( slot + 1 ) + player.getAttr().getName();
		saveFile( dir + File.separator + filename + ".dat", player );
		
	} // end Save.game
	
	public static UserPlayer chooseSave( UserPlayer player )
	{
		String list[] = Load.list( "Data" + File.separator + "saveList.dat" );
		Load.displayList( list );
		
		Scanner input = new Scanner( System.in );
		char overwrite='n';
		int slot;
		boolean done=false;
		
		do
		{
			System.out.println( "Choose a slot to save your game: " );
			slot = input.nextInt() - 1;
			
			if ( list[slot].charAt(0) == '#' )
			{
				player.slot = slot;
				done = true;
			}
			else
			{
				System.out.println( "Are you sure you want to overwrite this save file? [y/n] " );
				String temp = input.next();
				overwrite = temp.charAt(0);
				if ( overwrite == 'y' || overwrite == 'Y' )
				{
					player.slot = slot;
					done = true;
				}
			}
		}while( !done );
		
		return player;
	} // end chooseSave
	

	private static void saveFile( String filename, String[] list )
	{
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		
		try
		{
			fos = new FileOutputStream( filename );
			out = new ObjectOutputStream( fos );
			out.writeObject( list );
			out.close();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	} // end saveFile (for String[])
	
	private static void saveFile( String filename, UserPlayer player )
	{
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		
		try
		{
			fos = new FileOutputStream( filename );
			out = new ObjectOutputStream( fos );
			out.writeObject( player );
			out.close();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	} // end saveFile (for Character)
	

	public static void saveList( String[] list )
	{
		File data = createFolder( "Data" );
		saveFile( data + File.separator + "saveList.dat", list );
	} // end saveList
	
	
	private static File createFolder( String folderName )
	{
		File dir = new File( folderName );
		if ( dir.exists()==false )
			dir.mkdir();
		
		return dir;
	} // end createFolder
	
} // end Save