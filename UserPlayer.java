/* UserPlayer.java
 * Fantoccini
 * 
 * By: Nikki Ebora
 * 201107408872
 * Last Updated: September 5, 2012 */
 
import java.util.Scanner;

public class UserPlayer extends Character
{

	public int slot;
	
	public void levelUp()
	{
		System.out.println( "\n\nLevel up!" );
		
		// Let the user add more attribute points to the current ones
		super.setAttr( attributePoints ( super.getAttr() ) );
		
	} // end levelUp
	
	public Attributes attributePoints( Attributes p )
	{
		int pts;
		Scanner i = new Scanner( System.in );

		pts = 5; // initialize pts to 5
		do{
			System.out.println( "\nCurrent stats:" );
			System.out.println( "Level: " + p.getLVL() );
			System.out.println( "Strength: " + p.getSTR() );
			System.out.println( "Agility: " + p.getAGI() );
			System.out.println( "Magic: " + p.getMAG() );
			System.out.println( "Health: " + p.getHP() );
			System.out.println( "Mana: " + p.getMP() );
			
			System.out.println( "\nRemaining attribute points: " + pts );
			System.out.println( "Add an attribute point to:\n1. Strength\n2. Agility\n3. Magic\n\nChoice: " );
				
			switch( i.nextInt() )
			{
				case 1: p.setSTR( p.getSTR() + 1 );
						break;
				case 2: p.setAGI( p.getAGI() + 1 );
						break;
				case 3:	p.setMAG( p.getMAG() + 1 );
						break;
				default: pts++;
			};
				
			pts--;
		
		}while( pts > 0 ); // do while there are pts left
			
		return p;
	} // end attributePoints

} // end UserPlayer