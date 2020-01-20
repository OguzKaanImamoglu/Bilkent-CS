/*
 * A simple program to compute a restaurants expenses and profit
 * This program will help you about computing profit of restaurant depnds on Gross Sales value that you will enter
 * Oðuz Kaan Ýmamoðlu
 * 13.02.2018
 */
import java.util.Scanner;
public class Lab01b
{
  public static void main(String[]Arg)
  {
    // This part includes constant values which necessary to compute expenses
     final double FOOD_COST_PERCENT = 0.3;
    final double STAFF_COST_PERCENT = 0.28;
    final double OVERHEAD_PERCENTAGE = 0.12;
    // This part is for user input
    Scanner in= new Scanner(System.in);
    System.out.print( "Please enter your Gross Sales value(tl)");
    int grossSales=in.nextInt();
    // This part includes neccesary assignments for expenses
    double FoodCost = grossSales* FOOD_COST_PERCENT;
    double StaffCost = grossSales*STAFF_COST_PERCENT;
    double Overhead = grossSales*OVERHEAD_PERCENTAGE;
    int foodCost = (int)FoodCost;
    int staffCost = (int)StaffCost;
    int overhead = (int)Overhead;
    int profit = grossSales-(foodCost+staffCost+overhead);
    // After this part users can get their outputs
    System.out.print("Gross Sales        ");
    System.out.println(grossSales + "tl");
    System.out.println("**************************");
    System.out.println("Food cost:   " + FOOD_COST_PERCENT + ",  "+ foodCost);
    System.out.println("Staff Cost:  " + STAFF_COST_PERCENT  + ", "+staffCost);
    System.out.println("Overhead:    " + OVERHEAD_PERCENTAGE + ", "+overhead);
    System.out.println("**************************");
    System.out.println("Profit           " + profit + "tl");
  }
}