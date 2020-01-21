/**
 * A class that represents the shape concept
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
package shapes;
public abstract class Shape implements Locatable
{
   // Declaration
   int x,y;
   
   /**
    * Constructor
    * Initializes x and y center of shape
    */
   public Shape()
   {
      x = 0;
      y = 0;
   }
   
   public abstract double getArea();
   
   /**
    * A method to get x
    * @return: x
    */
   public int getX() 
   {
     return x;
   }
   
   /**
    * A method to get y
    * @return: y
    */
   public int getY() 
   {
     return y;
   }

   /**
    * A method to set new center for shape
    * @param x: x axis of coordinate
    * @param y: y axis of coordinate
    */
   public void setLocation(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
}



