/* Multi Menu
 * This Program is a simple menu that is processing arbitrary
 * @ Oðuz Kaan Ýmamoðlu
 * @ 13.03.2018
 */
import java.util.Scanner;
public class Lab05b
{
   public static void main( String[]Arg)
   {
      // Initialization and input part
      Scanner in = new Scanner( System.in);
      String selection ;
      double x;
      double precision;
      double result = 1 ;
      // Loop
      do
      {
         System.out.println ( "=== Make Your Selection ===");
         System.out.println ( "1) Common characthers");
         System.out.println ( "2) 1/(1-x) calculation)");
         System.out.println ( "3) Exit");
         System.out.print( "Your selection :");
         selection = in.nextLine();

     
     
      // Selection 3 
      if( selection.equals( "3" ) )
            {
            System.out.println( "Goodye!");
             }
     // Selection 2 
     if( selection.equals( "2") )
            {
              System.out.println( "=== 1/(1-x) Calculation ===");
              System.out.print( "Enter x : (-1,1) ");
              x = in.nextDouble();
              System.out.print( "Enter precision: ");
              precision = in.nextDouble();
              System.out.println ( "Current result is : " + result );
              result = result + x;
              
              for( double increment = x ; Math.abs(increment) >= precision ;  )
              {
                 System.out.println ( "Current result is : " + result );
                 increment = x * increment;
                 result = result + increment;
              }
              System.out.println( "Current result is: " + result);
              System.out.println( "Result is: " + result);
            }
     // Selection 1
     if( selection.equals( "1") )
     {
       // Input   
      String a = "";
      String b = "";
      String c = "";
      System.out.println( "=== Common Characters Program ==");
      System.out.print( "Enter a string: ");
      a = in.nextLine();
      System.out.print( "Enter another string: ");
      b = in.nextLine();
      a = (a.toLowerCase());
      b = (b.toLowerCase());
      
      // Program body
      for (int i = 0; i < a.length() ; i++)
      {
         
         char ch = a.charAt(i);
         if (b.indexOf(ch) != -1 )
         {
            if ( c.indexOf(ch) ==  -1 )
            { 
             c = c + " " + ch  ;
            }
         }
      }
      System.out.print("Common letters are:" + c  );
        
   }
     System.out.println();
      }  while( !selection.equals("3"));
}
}