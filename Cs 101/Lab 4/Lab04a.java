/*
 * Factorial Calculator
 * This program calculates factorial of input
 * 
 * @ Oðuz Kaan Ýmamoðlu
 * @ 06.03.2018
 */
import java.util.Scanner;
public class Lab04a
{
   public static void main(String[]Arg)
   {
      // Initializing values
      Scanner in = new Scanner( System.in) ;
      int i = 1 ;
      long result = 1 ;
      System.out.print( "Please enter a number [0-13]: ") ;
      int cont = 1 ;
      
      
      // Validation
      
      if ( !in.hasNextInt() )
      {
         System.out.println( " Goodbye!" );
      }
      else
      {
         int number = in.nextInt() ;
         if ( number < 0 || number > 13 )
         {
            System.out.println( " Goodbye!" );
         }
         
         // First Input
         else
         {
            while( i <= number )
            {
               result = i * result;
               i++;
            }
            System.out.println( number + "!" + " = " + result) ;
            
            // Loop part
            while ( number <= 13 && number >= 0 ) 
            {
               
               // Validation Part 2
               if ( cont == 1)
               {
                  System.out.print( "Please enter a number [0-13]: ") ;
                  if ( !in.hasNextInt() )
                  {
                     cont = 2 ;
                     System.out.println( " Goodbye!" ); 
                  }
                  else
                  {
                     number = in.nextInt() ;
                     if ( number < 0 || number > 13 )
                     {
                        System.out.println( " Goodbye!" );
                     }
                     
                     // Result part
                     else
                     {
                        while( i <= number)
                        {
                           result = i * result;
                           i++;
                        }
                        
                        System.out.println( number + "!" + " = " + result) ;
                        i = 1 ;
                        result = 1 ;       
                     }
                  }
               }
            }   
         }
      }
   }
}
















