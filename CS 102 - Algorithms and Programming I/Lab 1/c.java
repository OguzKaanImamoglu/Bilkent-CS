/**
 * A program for editing array
 * @author Oðuz Kaan Ýmamoðlu
 * @date 09.10.2018
 */
import java.util.Scanner;
public class c
{
   public static void main (String[]args)
   {
      // Initialization
      Scanner in = new Scanner(System.in);
      int userNumber = 0;
      IntBag bag = new IntBag();
      
      // Program code
      while ( userNumber != 7 )
      {
         System.out.println("1. Create a new empty collection(any previous values are lost!");
         System.out.println("2. Read a set of positive values into the collection (use zero to indicate all the values have been entered.");
         System.out.println("3. Print the collection of values.");
         System.out.println("4. Add a value to the collection of values at a specified location");
         System.out.println("5. Remove the value at a specified location from the collection of values");
         System.out.println("6. Remove all instances of a value within the collection");
         System.out.println("7. Quit the program.");  
         System.out.print("So, what is your choice?");
         userNumber = in.nextInt();
         
         if( userNumber == 1)
         {
            bag = new IntBag();
         }
         
          if( userNumber == 2)
         {
             int num = 1;
             System.out.println("Please enter your numbers");
             while ( num != 0)
             {
                num = in.nextInt();
                if( num != 0)
                {
                bag.addToEnd(num);
                }
             } 
          }
          
          if( userNumber == 3)
          {
             System.out.println(bag.toString());
          }
          
          if( userNumber == 4)
          { 
           int value;
           int where;
           System.out.println("Which value?");
           value = in.nextInt();
           System.out.println("To where?");
           where = in.nextInt();
           bag.addToThere(value, where);
          }
          
          if( userNumber == 5)
          {
             System.out.println("Which position do you want to remove");
             int pos = in.nextInt();
             bag.remover(pos);
          }
          
           if( userNumber == 6)
           {
              System.out.println("Which value do you want to remove?");
              int valueToRemove = in.nextInt();
              bag.removeAll(valueToRemove);
           }
          
      }
      
   }
   
}