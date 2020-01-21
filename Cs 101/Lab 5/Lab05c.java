/* Substring Finder
 * This program finds and sorts all substring from input.
 * @ Oðuz Kaan Ýmamoðlu
 * @ 13.03.2018
 */
import java.util.Scanner;
class Lab05c
{
   public static void main(String args[])
   {
      // Variables
      String string, sub;
      int n = 0;
      int c, length;
      int limit = 1;
      
      // Input
      Scanner in = new Scanner(System.in);
      System.out.println("Enter a string to print it's all substrings");
      string  = in.nextLine();
      length = string.length();
      c = length - 1  ;
      
      // Program code
      System.out.println("Substrings of \""+string+"\" are:");
      
      for ( ;  c >= 0 ; )
      {
         int oldc = c;
         for(; n < limit;  )
         {
            c++;
            sub = string.substring(n,c);
            n++;
            System.out.println(sub); 
         }
         limit++;;
         c = oldc;
         c--;
         n = 0;
      }
   }
}