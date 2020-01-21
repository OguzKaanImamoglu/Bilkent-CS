/*
 * The Prime Divisor Finder
 * This program finds prime divisors of input
 * 
 * @ Oðuz Kaan Ýmamoðlu
 * @ 06.03.2018
 */

import java.util.Scanner;
public class Lab04b
{
  public static void main(String[]Arg)
  {
    // For input
    Scanner in = new Scanner (System.in);
    System.out.print( "Enter an integer: ");
    int input = in.nextInt();
    System.out.println();
    
    // Inýtýalizing
    int number = input ;
    int i = 2 ; 
    int prime = 1 ;
    
    // Explanation for output
    System.out.print( "Prime divisors of " +  input + ": " );
    
    // Loops 
    while ( i <= input )
    {
      
      while ( number % i == 0 )
      {
       number = number / i ;
       
       if ( i != prime )
       {
         prime = i ;
         System.out.print ( prime + " " ) ;
       }
      }
      i++ ;
    }
    System.out.println();
  }
}
                   
              
                             
              
         
        
              



            
   

