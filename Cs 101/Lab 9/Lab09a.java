import java.util.Scanner;
import java.util.ArrayList;
/**
 * A program for genarating numbers and showing some significant ones
 * @author Oðuz Kaan Ýmamoðlu
 * @date 17.04.2018
 */
public class Lab09a
{
   public static void main(String[]args)
   {
      // Declaration
      Scanner in = new Scanner(System.in);
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      int n;
      String separator1;
      String separator2;
      String start;
      String end;
      int number;
      int maxEven;
      int maxOdd;
      
      //Assignments
      separator1 = "*************************************************";
      separator2 = "-------------------------------------------------";
      start = "Start of lab09a";
      end = "End of lab09a";
      maxEven = -1;
      maxOdd = -1;
      n = 1;
      
      // Program Code
      while (n != 0 )
      {
         numbers.clear();
         System.out.println(start + "\n");
         System.out.print("Please enter the number of integers that will be generated: ");
         n = in.nextInt();
         System.out.println(separator1);
         
         for (int i = 0; i < n; i++)
         {
            number = (int)(Math.random()*2000 + 1);
            numbers.add(number);
            System.out.println("Index: " + i + "  Value: " + numbers.get(i) );
         }
         System.out.println(separator1);
         for ( int i = 0; i < n; i++)
         {
            
            if ( numbers.get(i) > maxEven &&  numbers.get(i) % 2 == 0 )
            {
               maxEven = numbers.get(i);
            }
            
            if ( numbers.get(i) > maxOdd &&  numbers.get(i) % 2 == 1 )
            {
               maxOdd = numbers.get(i);
            }     
         }
         
         if ( n == 0)
         {
            System.out.println("No number generated");
         }
         
         else
         {
            System.out.println( "Greatest of odd numbers in the list: " + maxOdd );
            System.out.println( "Greatest of even numbers in the list: " + maxEven + "\n" );
         }
         System.out.println(end + "\n" + separator2 + "\n" );  
         maxEven = -1;
         maxOdd = -1;
      }
   }
}