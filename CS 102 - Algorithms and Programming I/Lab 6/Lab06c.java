import java.util.ArrayList;
/**
 * This class is designed to control is a array lexicographic or not
 * @author Oðuz Kaan Ýmamoðlu
 * @date: 04.12.18
 */
public class Lab06c
{
   public static void main(String[]args)
   {
      // Initializations
      ArrayList<String> test = new ArrayList<String>();
      ArrayList<String> test2 = new ArrayList<String>();
      ArrayList<String> test3 = new ArrayList<String>();
      
      // List 1 adding
      test.add("Ahmet");
      test.add("Beril");
      test.add("Zem");
      test.add("Dniz");
      test.add("Erhan Erkut");
      
      System.out.println(lexiMethod(test, 0));
      
      //List 3 adding
      test3.add("Alperen");
      test3.add("Efekan");
      test3.add("Komutan");
      test3.add("Mustafa");
      test3.add("Zeynep");
      
      System.out.println(lexiMethod(test3, 0));
      
      //List 2 adding
      test2.add("Selami");
      test2.add("Mustafa");
      test2.add("Aysen");
      test2.add("Kerem");
      test2.add("Sevval");
      
     System.out.println(lexiMethod(test2, 0)); 
   }
   
   public static boolean lexiMethod( ArrayList<String> list, int i)
   {
      if (list.get(i).compareToIgnoreCase(list.get(i + 1)) > 0)
      {
         return false; 
      }
      i++;
      if (i + 1 >= list.size())
      {
         return true;
      }
      return lexiMethod( list, i);       
   }
}
      