/**
 * A class to test others
 * @ author Oðuz Kaan Ýmamoðlu
 * @ version 23.10
 */
import java.util.ArrayList;
import cs1.SimpleURLReader;
public class lab02
{
   public static void main(String[]args)
   {
      // For testing the original
      SimpleURLReader link = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~adayanik/courses/cs102/docs/housman.txt");
      System.out.println(link.getPageContents());
      System.out.println(link.getLineCount());
      
       //For testing mySimple
      MySimpleURLReader mySimple = new MySimpleURLReader("http://www.cs.bilkent.edu.tr/~adayanik/courses/cs102/docs/housman.txt");
      System.out.println(mySimple.getPageContents());
      System.out.println(mySimple.getLineCount());
      System.out.println(mySimple.getName());
      System.out.println(mySimple.getUrl());
      
       //For testing htmlfiltered
      HTMLFilteredReader link2 = new HTMLFilteredReader("http://www.cs.bilkent.edu.tr/~adayanik/courses/cs102/docs/housman.htm");
      System.out.println(link2.getPageContents());
      System.out.println(link2.getUnfilteredPageContents());
      
      // For testing superhtml and overhead
      SuperHTMLFilteredReader link3 = new SuperHTMLFilteredReader("https://docs.oracle.com/javase/tutorial/");
      ArrayList<String> list = new ArrayList<String>();
      list = link3.getLinks();
      int size = list.size();
      
      for (int i = 0; i < size; i++)
      {
         System.out.println(list.get(i));
      }
      link3.percentage();
       }
}