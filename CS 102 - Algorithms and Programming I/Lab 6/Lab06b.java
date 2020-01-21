/**
 * This class is designed to convert decimals to binary
 * @author Oðuz Kaan Ýmamoðlu
 * @date: 04.12.18
 */
public class Lab06b
{
   public static void main(String[] args)
   {
      // Outputs
      convert(6);
      convert(2);
      convert(3);
      convert(8);
      convert(19000000);
      convert(203);
      convert(31);
      convert(89);
   }
   
   /**
    * Recursive method that converts decimals to binary numbers and prints
    */
   public static void convert(int num) 
   {
      if (num > 0) 
      {
         convert(num / 2);
         System.out.print(num % 2);
      } 
      else
      {
         System.out.println(" ");
      }
   }
}