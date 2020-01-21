/*
 * The arctan finder
 * This program finds arctan values
 * 
 * @ Oðuz Kaan Ýmamoðlu
 * @ 06.03.2018
 */
import java.util.Scanner ;
public class Lab04d
{
   public static void main(String[]Arg)
   {
      // Initializing
      int k = 0 ;
      int n = 0 ;
      double result = 1;
      double oldresult = 0 ;
      int count = 0 ;
      
      // Input
      Scanner in = new Scanner ( System.in);
      System.out.print( "Enter x: ");
      double x = in.nextDouble();
      System.out.print( "Enter precision: ");
      double precision = in.nextDouble();
      
      // Program Code
      double test = 1 ;
      while ( precision <= test )
      {
         count++;
         result = Math.pow( (-1) , k) * Math.pow( x , ( 2 * k + 1) ) / (2 * k + 1) ;
         result = result + oldresult;
         
         System.out.println ( "Current sum: " + result ) ;
         k++;
         test = Math.pow(Math.abs(x), (2 * n + 3) ) / ( 2 * n + 3 ) ;
         n++;
         oldresult = result ;
         
      } 
     // Output and explanation
     System.out.println();
     System.out.println( "Computed with " + precision + " precision in " + count + " steps" );
     System.out.println( "arctan( " + x + ") = " + result + " radians" );
   }
}

