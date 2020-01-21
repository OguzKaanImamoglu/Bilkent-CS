/**
 * This class is designed to show how many e in a string
 * @author Oðuz Kaan Ýmamoðlu
 * @date: 04.12.18
 */
public class lab06a
{
   public static void main ( String []args)
   {
      // Varibles 
      String s1 ="unalorkastoskaftikba";
      String s2 = "elife";
      String s3 = "elelellele";
      
      // Outputs
      System.out.println(countChar(s1));
      System.out.println(countChar(s2));
      System.out.println(countChar(s3));   
   }
    
   /**
    * A recursive method that counts how may e in a String
    */
   public static int countChar(String str) {

    if(str.length() == 0)
    {
        return 0;
    }

    if (!(str.substring(0,1).equals("e"))) 
    {
        return countChar(str.substring(1));
    } 
    
    else 
    {
        return 1 + countChar(str.substring(1));
    }
  }
}
            

