/**
 * The Gambling Machine
 * This program is designed for gambling depends on dice values
 * @author Oðuz Kaan Ýmamoðlu
 * @date 27.03.2018
 */
import java.util.Scanner;
public class lab06c
{
   public static void main (String [] Args)
   {
      // Variables
      double totalMoney;
      double bet;
      int prediction;
      int dice;
      double change;
      
      // Input
      Scanner in = new Scanner (System.in);
      System.out.print ( "Enter your total money: ");
      totalMoney = in.nextInt();
  
   // Program Code
   prediction = 1;
   while ( totalMoney > 0 && (prediction == 1 || prediction == 2) )
   {
      System.out.println();
      System.out.print( "Enter prediction: ");
      prediction = in.nextInt();
      if ( prediction == 1 || prediction == 2 )
      {
      System.out.print( "Enter the amount of money you want to bet: ");
      bet = in.nextInt();
      if ( bet > totalMoney)
      {
         System.out.println( "Your money is not enough!");
      }
      else
       {
         dice = roller();
         System.out.println ( "The value of die is " + dice );
         change = gain( prediction, bet, dice);
         totalMoney = totalMoney + change;
         System.out.println( "Your total money is " + totalMoney);
       }
      }
    }
   }
   // Method for rolling a die
   /**
    * Dice roller
    * @return roll
    * 
    */
   public static int roller ( )
   {
      int die;
      die = (int)( Math.random() * 6 + 1 ) ;
      return die;
   }
   
   // Method for calculating gain or loss
   /**
    * A sample methp+++od
    * @param prediction of the user
    * @param bet of the user
    * @param dice roll
    * @return gain osf the user
    */
   public static double gain ( int prediction, double bet, int dice)
   {
      double gain = 0;
      if ( prediction == 1)
      {
         if ( dice == 1 || dice == 3 || dice == 5)
         {
            gain = bet / 2;
         }
         else
         {
            gain = -bet;
         }
      }
      if ( prediction == 2 )
      {
         if ( dice == 2 || dice == 4 || dice == 6)
         {
            gain = bet / 2;
         }
         else
         {
            gain = -bet;
         }
      }
      return gain ;
    }
}