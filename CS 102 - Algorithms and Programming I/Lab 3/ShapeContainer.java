/**
 * A class for addin, finding and removing shapes
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
import java.util.ArrayList;
public class ShapeContainer
{
   // Declaration 
   ArrayList<Selectable> container;
   
    /** Constructor
      * This constructor initialize the list
      */
    public ShapeContainer() 
   {
     container = new ArrayList<Selectable>();
    }
    
    /**
     * A method to  add new selectable shapes
     * @param s: the selectable shape
     */
    public void add(Selectable s)
    {
       container.add(s);
    }
    
     /**
     * A method to compute total area of list
     * @return: the total area
     */
    public double getArea()
    {
       double total = 0;
       
       for( int i = 0; i < container.size() ; i++)
       {
          total = total + container.get(i).getArea();
       }
       return total;
    }
    
     /**
     * A method to find the first shape includes x and y
     * @param x: the x axis coordinate
     * @param y: the y axis coordinate
     */
    public void findFirstShape(int x, int y)
    {
       boolean foundFirst = false;
       for ( int i = 0; i < container.size() && !foundFirst ; i++)
       {
          if( container.get(i).contains(x, y) != null)
          {
             System.out.println("Shape was found at location " + i + " and its info : \n " + container.get(i).toString());
             foundFirst = true;
             container.get(i).setSelected(!container.get(i).getSelected());
          }
          else
          {
             System.out.println("There is no shape found");
          }
       } 
    }
    
     /**
     * A method to remove all selecteds
     */
    public void removeAllSelected()
    {
       for (int i = 0; i < container.size() ; i++)
       {
          if ( container.get(i).getSelected())
          {
             container.remove(i);
             i--;
          }
       }
    }
    
     /**
     * A method to convert to string
     * @return: String version of shape info
     */
    public String toString()
    {
       String result = "Elements of this set: \n " ;
       for( int i = 0; i < container.size() ; i++)
       {
          result = result + container.get(i).toString() + " \n" ;
       }
    result = result + "And finally total area of set is " + this.getArea();   
    return result;
    }
}
          