/* Fibonacci Program
 * This program shows Fibonacci series until an arbitrary number
 * @ Oðuz Kaan Ýmamoðlu
 * @ 13.03.2018
 */
import java.util.Scanner;
public class Lab05d
{
   public static void main(String[]args)
   {
      // Variables
      int i;
      int line;
      int input = 0;
      long result = 1;
      long n = 1;
      long pre_n = 0;
      int test = 1;
      
      // Scanner
      Scanner in = new Scanner (System.in);
      
      // For repetation
      do
      {
         System.out.print( "Enter a positive integer: ");
         
         // Validation
         if ( !in.hasNextInt() )
       {
          System.out.println ( "You must enter integer" );
          test = 0 ;
       }
       
       else
       {
         input = in.nextInt();
       }
       
      } while ( input <= 0 && test == 1 );
      
      if ( input > 0 )
      System.out.println( input + " Fibonacci numbers are:");

      // Program Code
      for ( i = 0 ; i < input ; i++ )
      {
         for ( line = 0 ; line < 5 && i < input ; line++)
         {
            System.out.printf( "%15d" , result  );
            result = n + pre_n ;
            pre_n = n ;
            n = result ;
            i++ ;
            
         }
         System.out.print( "\n");
         line = 0;
         i--;
      }
   }
}