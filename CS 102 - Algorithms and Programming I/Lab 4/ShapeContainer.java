/**
 * A class for addin, finding and removing shapes
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
package shapes;
import java.util.Iterator;
import java.util.ArrayList;
public class ShapeContainer implements Iterable
{
     // Declaration 
     ArrayList<Shape> container;
   
    /** Constructor
      * This constructor initialize the list
      */
      public ShapeContainer() 
     {
       container = new ArrayList<Shape>();
      }
    
    /**
     * A method to  add new selectable shapes
     * @param s: the selectable shape
     */
     public void add(Shape s)
     {
       if ((s instanceof Selectable)) 
       {
          container.add(s);
       }
     }
  
     /**
      * A method to find all shapes that include x and y
      * @param x: x axis coordinate
      * @param y: y axis coordinate
      * @return how many shape that include x and y
      */
     public int selectAllAt(int x, int y)
     {
        int count = 0;
        for (Shape shape : container)
        {
           Shape theShape = ((Selectable)shape).contains(x, y);
           if (theShape != null)
           {
              ((Selectable)theShape).setSelected(true);
              count++;
           }
        }
        return count;
     }
  
     /**
      * A method to return size of container
      * @ return size of array list
      */
     public int size()
     {
        return container.size();
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
          total = total + ((Shape)container.get(i)).getArea();
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
          if( ((Selectable)container.get(i)).contains(x, y) != null)
          {
             System.out.println("Shape was found at location " + i + " and its info : \n " + container.get(i).toString());
             foundFirst = true;
             ((Selectable)container.get(i)).setSelected(!((Selectable)container.get(i)).getSelected());
          }
          else
          {
             System.out.println("There is no shape found");
          }
       } 
    }
    
    /**
    * A method to return r of little circle taht include x and y
    * @param x: x axis of coordinate
    * @param y: y axis of coordinate
    * @return r of little circle
    */
    public int minRadius(int x, int y)
    {
         int min = 0;
         int point;
         ArrayList<Circle> circles = new ArrayList<Circle>();
         
         for (Shape shape : container)
         {
          Shape theShape = ((Selectable)shape).contains(x, y);  
          if (theShape != null && (theShape instanceof Circle))
          {
             circles.add((Circle)theShape);
             min = circles.get(0).getRadius();
          }
         }
      
      for (int i = 0; i < circles.size() ; i++)
       {
           if( circles.get(i).getRadius() < min)
           {
              min = circles.get(i).getRadius();
           }
       }
      return min;
//       
//       point = (Integer) 1000 / (min + 1) ;
//       return point;
//  
    }
    
    /**
    * A method to remove all selecteds
    */
    public void removeAllSelected()
    {
       for (int i = 0; i < container.size() ; i++)
       {
          if ( ((Selectable)container.get(i)).getSelected())
          {
             container.remove(i);
             i--;
          }
       }
    }
    
  /**
   * A method that returns a shape Iterator
   */
  public Iterator<Shape> iterator()
  {
    return container.iterator();
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
          