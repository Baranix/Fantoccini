/* Load.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: August 13, 2012 */

import java.util.StringTokenizer;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Load
{
	public static void main( String[] list )
	{
		displayList( list );
		
		Scanner input = new Scanner( System.in );
		System.out.print( "Choose: " );
		int slot = input.nextInt() - 1;
		
		StringTokenizer saveData = new StringTokenizer( list[slot], "#");
		String filename = saveData.nextToken() + saveData.nextToken() + ".dat";
		
		UserPlayer p = loadCharacter( filename );
		p.displayStats();
		
		System.out.print( "Would you like to load this save file? [y/n] " );
		String temp = input.next();
		char ans = temp.charAt(0);
		if ( ans == 'y' || ans == 'Y' )
			StartBattle.main( p );
		
	} // end main
	
	public static UserPlayer loadCharacter( String filename )
	{
		FileInputStream fis = null;
		ObjectInputStream ins = null;
		UserPlayer p = null;
		
		try
		{
			fis = new FileInputStream( "Save" + File.separator + filename );
			ins = new ObjectInputStream( fis );
			p = ( UserPlayer )ins.readObject();
			ins.close();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		catch ( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		
		return p;
		
	} // end loadCharacter
	
	public static void displayList( String[] list )
	{
		StringTokenizer saveData = null;
		
		for ( int i = 0; i < list.length; i++ )
		{
			saveData = new StringTokenizer( list[i], "#" );
			while( saveData.hasMoreTokens() )
			{
				System.out.print( saveData.nextToken() + " " );
			}
			System.out.println();
		}
		
	} // end displayList
	
	public static String[] list( String filename )
	{
		FileInputStream fis = null;
		ObjectInputStream ins = null;
		String[] list = null;
		
		try
		{
			fis = new FileInputStream( filename );
			ins = new ObjectInputStream( fis );
			list = ( String[] )ins.readObject();
			ins.close();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		catch ( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		
		return list;
	}

} // end Load