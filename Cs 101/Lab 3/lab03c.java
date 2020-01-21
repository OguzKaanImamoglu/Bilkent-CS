/*
 * Dice roller
 * This program will help the users to compare random dice numbers with users' number
 * 
 * @ Oðuz Kaan Ýmamoðlu
 * @ 27.02.2018
 */
import java.util.Scanner;
public class lab03c
{
  public static void main(String[]Arg)
  {
   
    //For dice rolling
    int first = (int)( Math.random() * 6 + 1 ) ;
    int second = (int)( Math.random() * 6 + 1 ) ;
    int third = (int)( Math.random() * 6 + 1 ) ;
    
    // For initialize other values
    int smaller = 0 ;
    int equal = 0 ;
    int greater = 0 ;
    
    // For user input and warning
    
    Scanner in = new Scanner( System.in);
    System.out.print( "Please enter an integer between 1-6: ");
   
    if ( !in.hasNextInt() )
   {
      System.out.println( "Invalid input, you must enter integer" );
   }
   
   else
   {
    
    int userNumber = in.nextInt();
    
    if ( (userNumber < 1) || userNumber > 6) 
    {
      System.out.println( "You must enter an integer between 1-6" );
    }
    
    else
    {
    
      if ( first < userNumber )
      {
        smaller = smaller + 1 ;
      }
    
       if ( second < userNumber )
      {
        smaller = smaller + 1 ;
      }
    
       if ( third < userNumber )
      {
        smaller = smaller + 1 ;
      }
    
       if ( first > userNumber )
      {
        greater = greater + 1 ;
      }
    
       if ( second > userNumber )
      {
        greater = greater + 1 ;
      }
    
       if ( third > userNumber )
      {
        greater = greater + 1 ;
      }
     
        if ( first == userNumber )
      {
        equal = equal + 1 ;
      }
      
        if ( second == userNumber )
      {
        equal = equal + 1 ;
      }
    
        if ( third == userNumber )
      {
        equal = equal + 1 ;
     }
         // Output part
     
     System.out.print( " first roll = " + first + " , " );
     System.out.print( " second roll = " + second + " , " );
     System.out.println( " third roll = " + third );
     System.out.println( "# of rolls smaller : " + smaller );
     System.out.println( "# of rolls equals to : " + equal );
     System.out.println( "# of rolls greater : " + greater );
    }
   }
 }
}
    
    