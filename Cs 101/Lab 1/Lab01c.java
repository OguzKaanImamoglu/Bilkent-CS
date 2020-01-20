/*A basic program to compute whr value of users 
 *This program will help user to calculate your WHR and it warns you about risky values
 * Oðuz Kaan Ýmamoðlu
 * 13.02.2018*/
import java.util.Scanner;
public class Lab01c
  {
  public static void main(String[]Arg)
  {
    // For user input
    Scanner scan = new Scanner(System.in);
    System.out.print("Please enter your waist value(cm)");
    double waist=scan.nextInt();
    System.out.print("Please enter your hip value(cm)");
    //This part includes necessary assignment for computing whr value
    double hip= scan.nextInt();
    double whr= waist/hip;
    // For user output
    System.out.println("Your WHR value is "+whr);
    System.out.print("Above 0.8 is risky for females and above 0.9 is risky for males (Heart disase risks)");
  }
}