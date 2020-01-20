/*
 * Student Info System
 * This program shows user to some personal infos and preparing a schedule for them
 * 
 * @author Oðuz Kaan Ýmamoðlu
 * @date 20.02.2018
 */
import java.util.Scanner;
public class lab02b
{
  public static void main(String[]Arg)
  {
  
    //For user input
    Scanner in= new Scanner(System.in);
    System.out.println( "Student information");
    System.out.print( "Enter ID: " );
    String id = in.nextLine();
    System.out.print( "Enter fullname: ");
    String name = in.nextLine();
    System.out.println();
    System.out.println("Course information");
    
    System.out.print("Enter the first course: " );
    String first = in.nextLine();
    System.out.print("Enter the second course: " );
    String second = in.nextLine(); 
    System.out.print("Enter the third course: " );
    String third = in.nextLine();
    System.out.print("Enter the fourth course: " );
    String fourth = in.nextLine();
    System.out.println();
    
    // For schedule
    System.out.println("The student is " + '"' + name + '"' + ". His/her ID is " + id);
    System.out.println("Schedule");
    System.out.println("| Hour   | Mon    | Tues   |");
    System.out.print("| 8:40   |");
    System.out.printf("%-8s", first );
    System.out.print("|");
    System.out.printf("%-8s" , third);
    System.out.println("|");
    System.out.print("| 9:40   |");
    System.out.printf("%-8s" , first);
    System.out.println("| -      |");
    System.out.print("|10:40   | -      |");
    System.out.printf("%-8s" , fourth);
    System.out.println("|");
    System.out.print("|11:40   |");
    System.out.printf("%-8s" , second );
    System.out.println("| -      |");
    System.out.println();
    System.out.println("--End of Lab02b--");
  }
}