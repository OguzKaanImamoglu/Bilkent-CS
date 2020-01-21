/**
 * This class is designed to print a special serie
 * @author Oðuz Kaan Ýmamoðlu
 * @date: 04.12.18
 */
public class Lab06d
{
   public static void main(String []args)
   {
      // Variables
      int n1 = 3;
      int n2 = 2;
      
     // Calling printer method
     printer((int) Math.pow(10, n1 - 1), (int) Math.pow(10, n1)) ; 
     printer((int) Math.pow(10, n2 - 1), (int) Math.pow(10, n2)) ;      
   }
   
   /**
    * This method prints suitable numbers
    * @param i: first value
    * @param end: max value
    */
   public static void printer( int i, int end)
   {
      if ( i < end )
      {
         if (check(i))
         {
            System.out.println(i);
            i = i + 2;
            printer(i , end);
         }
         
         else
         {
            i = i + 2;
            printer(i , end); 
         }
      }
   } 
   
  /**
   * This method checks wheter the number is suitable or not
   * @param n: the number
   */
   public static boolean check(int n)
   {
      int lastDecimal;
      int previous;
      
      if ( n > 1)
      {
         lastDecimal = n % 10;
         previous = ( n / 10 ) % 10;
         if ( lastDecimal > previous )
         {
            return check( n/10 );
           
         }
         else
         {
            return false;
         }
      }
      else
      {
         return true;
      }
   }
}