/**
 * A menu for all other classes
 * @ author Oðuz Kaan Ýmamoðlu
 * @ version 23.10
 */
import cs1.SimpleURLReader;
import java.util.ArrayList;
import java.util.Scanner;
public class thePoemer
{
   public static void main(String[]args)
   {
      // Variables and declaration
      Scanner in = new Scanner(System.in);
      ArrayList< MySimpleURLReader> list = new ArrayList< MySimpleURLReader>();
      int choice = 0;
      String text;
      
      while (choice != 3)
      {
         System.out.println("1 | Enter the url of poem to add to collection");
         System.out.println("2 | List all poems in the collection");
         System.out.println("3 | Quit");
         System.out.print("Your choice?");
         choice = in.nextInt();
         
         // If user choose 1
         if (choice == 1)
         {
          System.out.print("Please enter the url of poem");
          text = in.next();
          if (text.indexOf("htm") == -1)
          {
             MySimpleURLReader reader = new MySimpleURLReader(text);
             list.add(reader);
          }
          else 
          {
             HTMLFilteredReader htmlReader = new HTMLFilteredReader(text);
             list.add(htmlReader);
          }
         }
         
         // If user choose 2
         if (choice == 2)
         {
            int newChoice;
            for ( int i = 0; i < list.size(); i++)
            {
               System.out.println( i + " " + list.get(i).getName());
            }
            System.out.print("What index do you want?");
            newChoice = in.nextInt();
            if (newChoice < list.size() )
            {
               
               System.out.println(list.get(newChoice).getPageContents());
               
            }
         }
      }
   }
}