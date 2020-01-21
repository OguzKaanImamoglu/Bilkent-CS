/**
 * Shape Lister
 * A program that users can add and edit shapes
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
import java.util.Scanner;
public class ShapeTester
{
   public static void main(String[]args)
   {
      // Declarations 
      int choice = 0;
      Scanner in = new Scanner(System.in);
      ShapeContainer set = new ShapeContainer();
      
      // Program code
      while (choice != 10)
      {
         System.out.println("What do you want?");
         System.out.println("1 | Add a circle");
         System.out.println("2 | Add a rectangle");
         System.out.println("3 | Add a square");
         System.out.println("4 | Add a eclipse");
         System.out.println("5 | To see the container");
         System.out.println("6 | Select some shapes");
         System.out.println("7 | Find the first shape that include x and y");
         System.out.println("8 | Change the center of a shape");
         System.out.println("9 | Delete all selected");
         System.out.println("10 | Exit");
         choice = in.nextInt();
         
         if ( choice ==  1) // If user choose 1
         {
            System.out.println("Please enter the radius");
            int radius = in.nextInt();
            Circle c = new Circle(radius);
            set.add(c);
         }
           
         if ( choice ==  2) // If user choose 2
         {
            System.out.println("Please enter the width");
            int width = in.nextInt();
            System.out.println("Please enter the height");
            int h = in.nextInt();
            Rectangle r = new Rectangle(width, h);
            set.add(r);
         }
         
         if ( choice ==  3) // If user choose 3
         {
            System.out.println("Please enter the side");
            int side = in.nextInt();
            Square s = new Square(side);
            set.add(s);
         }
         
          if ( choice ==  4) // If user choose 4
         {
            System.out.println("Please enter the width");
            int width = in.nextInt();
            System.out.println("Please enter the height");
            int h = in.nextInt();  
            Eclipse e = new Eclipse( h, width);
            set.add(e);
         }
           
          
         if ( choice ==  5) // If user choose 5
         {
            System.out.println(set.toString());
         }
           
         if ( choice ==  6) // If user choose 6
         {
              int index; 
              System.out.println("Which index do you want to select?");
              index = in.nextInt();
              set.container.get(index).setSelected(true);
              
         }
            
         if ( choice ==  7) // If user choose 7
         {
               System.out.println("Please enter the x");
               int x = in.nextInt();
               System.out.println("Please enter the y");
               int y = in.nextInt();
               set.findFirstShape(x, y); 
         }
            
         if ( choice ==  8) // If user choose 8
         {
           int index; 
           System.out.println("Which index do yo want to change the center?");
           index = in.nextInt();
           System.out.println("What is center x");
           int x = in.nextInt();
           System.out.println("What is center y");
           int y = in.nextInt();
           set.container.get(index).setLocation(x , y);
       
         }
             
           if ( choice ==  9) // If user choose 9
           {
             set.removeAllSelected();
             System.out.println("asdsdasadsasadsadsad");
           }
      }
   }
}
         
         
      
         
      