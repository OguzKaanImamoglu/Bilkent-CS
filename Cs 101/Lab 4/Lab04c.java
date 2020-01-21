/*
 * Triangle maker
 * This program makes triangle from the inputs
 * 
 * @ Oðuz Kaan Ýmamoðlu
 * @ 06.03.2018
 */
import java.util.Scanner ;
public class Lab04c
{
   public static void main(String[]Arg)
   {
      // For input
      Scanner in = new Scanner(System.in) ;
      System.out.print( "Please enter a character ( If you enter longer than a character first character will be taken)") ;
      char ch = in.nextLine().charAt(0);
      int space = 1 ;
    
      // Validate
      System.out.print( "Please enter a number") ;
      if ( !in.hasNextInt())
      {
         System.out.println( "You must enter an integer" );
      }
      
      // Program Code
      else
      {
         int width = in.nextInt() ;
         System.out.println( " " ) ;
         
         while ( width >= 1)
         {
            int oldWidth = width;
            width-- ; 
                      
            while ( oldWidth >= 1)
            {
               System.out.print( ch ) ;
               oldWidth-- ;
               
               if ( oldWidth < 1)
               {
                  System.out.print( "\n") ;
                  int oldSpace = space ;
                  
                   while ( space > 0 )
                  {
                     space-- ;
                     System.out.print ( " " ) ;
                  }
                   
                   while ( space <= oldSpace )
                   {
                      space++ ;
                   }
               }
            }
         }
      }
   }
}

