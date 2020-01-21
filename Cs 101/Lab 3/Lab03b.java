/*
 * Drinks Menu
 * This program will help user to choose a drink and compute payment for this drink
 * 
 * @ Oðuz Kaan Ýmamoðlu
 * 27.02.2018
 */
import java.util.Scanner;
public class Lab03b
{
   public static void main(String[]Arg) 
   {
      // Initializing
      int water = 50;
      int orange = 100;
      int milk = 150;
      Scanner in = new Scanner(System.in);
      
      // Options
      System.out.println( "Drink Options :");
      System.out.println( "   (1) Water");
      System.out.println( "   (2) Orange Juice");
      System.out.println( "   (3) Milk"); 
      
      // Input
      System.out.print( "Enter choice : "); 
      
      
      // Warning 
      
      if ( !in.hasNextInt() )
      {
         System.out.println ( "Invalid selection" );
      }
      
      else
      {
         int choice = in.nextInt();
         
         if ( choice > 3 || choice <= 0 )
         {
            System.out.println( "Invalid selection");
         }
         
         
         // If choice is water
         if ( choice == 1 )
         {
            System.out.println ( "Water price = " + water + " units" );
            System.out.print( "Enter Payment Amount :");
            
            if ( !in.hasNextInt() )
            {
               System.out.println ( "Invalid payment amount, you must enter integer   " );
            }
            
            else
            {
               
               int payment = in.nextInt();
               
               if( payment >= water )
               {
                  System.out.print( "Thank you for order. Your change = " + ( payment - water) + "   " );
               }
               
               else
               {
                  System.out.println( "Payment amount is not sufficent" + "   ");
               }
            }
         }
         
         // If choice orange juice
         if ( choice == 2)
         {
            System.out.println ( "Orange Juice Price = " + orange + " units" );
            System.out.print( "Enter Payment Amount :");
            
            if ( !in.hasNextInt() )
            {
               System.out.println ( "Invalid payment amount, you must enter integer   " );
            }
            
            else
            {
               
               int payment = in.nextInt();
               
               if( payment >= orange )
               {
                  System.out.print( "Thank you for order. Your change = " + ( payment - orange) + "    " );
               }
               
               else
               {
                  System.out.println( "Payment amount is not sufficent   ");
               }
            }
         }
         
         // If choice is milk
         if ( choice == 3)
         {
            System.out.println ( "Milk price = " + milk + " units" );
            System.out.print( "Enter Payment Amount :");
            
            if ( !in.hasNextInt() )
            {
               System.out.println ( "Invalid payment amount, you must enter integer    " );
            }
            
            else
            {
               
               int payment = in.nextInt();
               
               if( payment >= milk )
               {
                  System.out.print( "Thank you for order. Your change = " + ( payment - milk) + "    " );
               }
               
               else
               {
                  System.out.println( "Payment amount is not sufficent    ");  
               }
            }
         }
      }
   }
}


