/*
 * A basic program for computing area of an triangular prism
 * This programm will help user to compute surface area of users prism
 * 
 * @author Oðuz Kaan Ýmamoðlu
 * @date 20.02.2018
 */
import java.util.Scanner;
public class lab02c
{
  public static void main(String[]Arg)
  {
    //For user input
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter height of the triangle(cm)");
    double h = in.nextDouble();
    System.out.print("Please enter base side of the triangle(cm)");
    double b = in.nextDouble();
    System.out.print("Please enter long side of the triangle(cm)");
    double a = in.nextDouble();
    System.out.print("Please enter short side of the triangle(cm)");
    double c = in.nextDouble();
    System.out.print("Please enter length of the prism (cm)");
    double l = in.nextDouble();
    
    // Assignments
    double Paint = 0.01;
    double area = (b * h) + (a + b + c)*l;
    double totalPaint = Paint * area;
    int TotalPaint =(int) totalPaint;
    
    //Output
     System.out.println("We will paint a triangular prism");
     System.out.println("The height of triangle is " + h );
     System.out.println("The sides of triangle are " + a + " , " + b + " and " + c );
     System.out.println("The length of the triangular prism is " + l );
     System.out.println("The area of the prism with respect to given parameters is " + area );
     System.out.println("The required amount of color to paint one centimeter square area is " + Paint + " liters.");
     System.out.println("The total color amount required for painting is " + TotalPaint + " liters.");
     System.out.println("---End of Lab02c-");
  }
}
    
  