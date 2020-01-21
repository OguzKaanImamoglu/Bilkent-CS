/* The Triangle Maker
 * This program makes a triangle with arbitrary values
 * @ Oðuz Kaan Ýmamoðlu
 * @ 13.03.2018
 */
import java.util.Scanner;
public class Lab05a
{
   public static void main(String[]Arg)
   {
      // Inýtializing
      int input;
      int n;
      int count;
      int subsinput;
      
      // For input
      Scanner in = new Scanner( System.in);
      System.out.print( "Please enter a character" ) ;
      char ch = in.nextLine().charAt(0);
      
      // Validation
      System.out.print( "Enter an integer");
      if ( !in.hasNextInt())
      {
         System.out.println( "You must enter an integer" );
      }
      else
      {
         input = in.nextInt() ;
         subsinput = input;
         
         // Program code
         n = input - 1;
         for( ; input > 0 ; input--)
         {
            for ( count = input - n ; count > 0 ; count--)
            {
               System.out.print( ch);
            }
            System.out.print("\n");
            n = n -2 ;
         }
         
         n = subsinput - 1 ;
         for( ; n > 0; n--)
         {
            for ( int count2 = n; count2 > 0 ; count2--)
            {
               System.out.print( ch );
            }
            System.out.print("\n");
         }
      }                 
   }
}