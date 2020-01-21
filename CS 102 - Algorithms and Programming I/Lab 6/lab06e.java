/**
 * This class is designed to show factorial of a number
 * @author Oğuz Kaan İmamoğlu
 * @date: 04.12.18
 */
public class lab06e
{ 
   public static void main (String [] Args)
   {
      // Variables
      int n1 = 5;
      int n2 = 4;
      int n3 = 8;
      int n4 = 0;
      
      // Outputs
      System.out.println(fact(n1));   
      System.out.println(fact(n2));   
      System.out.println(fact(n3)); 
      System.out.println(fact(n4));   
   }
   
   /**
    * A recursive method that computes factorial of a number
    */
   public static int fact( int n)
   {
      if ( n > 0 )
      {
         return  n * fact(n-1);
      }
      else
      {
         return 1;
      }
      
   }
}