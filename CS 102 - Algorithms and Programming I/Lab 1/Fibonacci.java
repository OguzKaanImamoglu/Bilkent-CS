/**
 * A program to show first 40 member of fibonacci series
 * @ author O�uz Kaan �mamo�lu
 * @ date 09.10.2018
 */
public class Fibonacci
{
   public static void main (String[]args)
   {
      // Initialization
      int total = 0;
      int f1 = 0;
      int f2 = 1;
      IntBag fibo = new IntBag();
      fibo.addToEnd(f1);
      fibo.addToEnd(f2);
      
      // Program Code
      for (int i = 1; i < 40; i++)
      {
      
      total = f1 + f2;
      f1 = f2;
      f2 = total;
      fibo.addToEnd(total);
      
      }
    System.out.println(fibo.toString());
   } 
}