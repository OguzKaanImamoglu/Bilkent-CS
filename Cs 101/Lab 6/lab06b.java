/* The String Seperator
 * This program finds how many "bc" in input and separates the input from "bc".
 * @ Oðuz Kaan Ýmamoðlu
 * @ 27.03.2018
 */
import java.util.Scanner;
public class lab06b
{
   public static void main( String[] Args)
   {
      // Variables
      String input;
      String SUB_SEQUENCE = "bc";
      int howMany;
      int seperator;
      
      // Input
      Scanner in = new Scanner (System.in);
      System.out.print( "Enter the sequence: ");
      input = in.nextLine();
      
      // Program code
      howMany = counter ( SUB_SEQUENCE, input);
      if (howMany != 0 )
      {
      System.out.println( "The number of 'bc's in the sequence is: " + howMany);
      seperator = Seperator( SUB_SEQUENCE, input);
      System.out.println( "First part of string is " + input.substring( 0, seperator));
      System.out.println( "Second part of string is " + input.substring( seperator + 2, input.length()) );
     }
      else
      {
         System.out.println( "The string doesn't contain any substring 'bc's.");
      }
   }
   
   // For finding how many sub sequence the input include
   public static int counter( String SUB_SEQUENCE, String input)
   {
      int count = 0;
      int i = 0;
      int j = 1;
      while ( j < input.length())
      {
         if ( input.substring(i,j + 1).equalsIgnoreCase(SUB_SEQUENCE))
         {
            count++;
         }
         i++;
         j++;
       }       
      return count;
   }
   
   // For separating of the sequence
   public static int Seperator( String SUB_SEQUENCE, String input)
   {
      int t = 0;
      int z = 1;
      while (z < input.length())
      {
        if ( input.substring(t,z + 1).equalsIgnoreCase(SUB_SEQUENCE))
         {
          return t; 
         }
        t++;
        z++;
      }
      int a = -1;
      return a; 
   }
}