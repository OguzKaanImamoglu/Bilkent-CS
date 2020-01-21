/*
 * The menu program
 * This program will help customers to find the foods which they want
 * 
 * @ Oðuz Kaan Ýmamoðlu
 * @ 27.02.2018
 */
import java.util.Scanner;
public class Lab03a
{
  public static void main(String[]Arg)
  {
    // For user input
    Scanner in = new Scanner(System.in);
    System.out.print("Find (m)ain course or (d)essert: ");
    String MainDessert = in.next();
    
    // If customer wants main course
    if( ( MainDessert.equals ("m") ) || ( MainDessert.equals ("M") ) )
    {
      System.out.print("Does it have meat?( 1-Yes / 2-No): ");
      String Meat = in.next();
      
      if( Meat.equals ("1") )
      {
        System.out.println( "Sorry, vegeterian options only");
      }
      
      else if(Meat.equals ("2") )
      {
        System.out.println( "You are searching for four cheese pizza");
      }
      
      else
      {
        System.out.println( "No matching menu items");
      }
    }
    
    // If customer wants dessert
    else 
      if ( ( MainDessert.equals ("d") ) || ( MainDessert.equals ("D") ) )
        
    {
      System.out.print( "Does it contains apple? (1-Yes / 2-No) : ");
      String apple = in.next();
      
      if ( apple.equals ("1") )
      {
        System.out.println( "You are searching for apple pie");
      }
      
      else if ( apple.equals ("2") )
      {
        System.out.println( "You are searching for Creme Brulee");
      }
      
      else
      {
        System.out.println( "No matching menu items");
      }
    }
   
    // For invalid input
    else
    {
      System.out.println( "No matching menu items");
    }
   
  }

}
