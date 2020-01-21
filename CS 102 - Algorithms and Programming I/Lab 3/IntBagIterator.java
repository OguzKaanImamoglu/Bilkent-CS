/** 
 * The intarator class for iterate Intbag
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
import java.util.*;
public class IntBagIterator implements Iterator, IntIterator
{
   // Properties
   IntBag aBag;
   int index;
   
   /** 
    * Constructor
    * @param bag: a bag object
    */
   public IntBagIterator( IntBag bag)
   {
      aBag = bag;
      index = 0;
   }
   
   // @ override
   /**
    * A method that returns result as a Object
    * return: Integer version.
    */
   public Object next()
   {
      int result = aBag.getValueAt(index);
      index++;
      return (Integer) (result);
   }
   
   // @ override
   /**
    * A method to determine set is over or not
    * return: true if there is still place
    */
   public boolean hasNext()
   {
      if ( index < aBag.size() )
         return true;
      else
         return false;
   }
   
    // @ override
   /**
    * A method that returns result as a primitive int
    * return: int version.
    */
   public int nextInt()
   {
      int result = (int)this.next();
      return result;
   }
}