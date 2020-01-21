/**
 * A program to use iterator interface of Java
 * @author O�uz Kaan �mamo�lu
 * @date 06.11.2018
 */
import java.util.*;
public class TestIterators
{
   public static void main ( String[] args)
   {
        IntBag bag = new IntBag();
        bag.addToEnd(3);
        bag.addToEnd(4);
        bag.addToEnd(6);
        bag.addToEnd(8);
        Iterator i = new IntBagIterator(bag);
      
        while (i.hasNext()) 
        {
            System.out.println(i.next());
            Iterator j = new IntBagIterator(bag);
           // Iterator j = bag.iterator();
            while (j.hasNext())
            {
                System.out.println("--"+j.next());
            }
        }
    }
}
