/*
 * The cake sharer
 * This program shares the cake among people
 * @ Oðuz Kaan Ýmamoðlu
 * @ 27.03.2018
 */
import java.util.Scanner;
public class Lab06a
{
   public static void main (String [] args)
   {
      // Variables
      double radius;
      double h;
      int people;
   
      // Input
      Scanner in = new Scanner (System.in);
      System.out.print("Enter radius of the cake: ");
      radius = in.nextDouble();
      System.out.print("Enter height of cake: ");
      h = in.nextDouble();
      
      // Program Code
      people = 1;
      while ( h >= 0 && radius >= 0 && people > 0)
      {
         System.out.print( "Enter number of people: ");
         people = in.nextInt();
         if ( people > 0)
         {
         System.out.print( "Number of people is " + people + ". Volume of a slice is ");
         System.out.println( Slice(radius,h, people));
         }
      }
   }                   
      
      // For Computing Volume & Slice
      public static double Slice (double radius, double h, int people )
     {
       final double PI = Math.PI;
       double volume = PI * radius * radius * h ;
       double slice = volume / people;
       return slice;
     }
    
}