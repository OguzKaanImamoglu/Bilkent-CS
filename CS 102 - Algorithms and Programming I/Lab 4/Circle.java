/**
 * A class that represents the circle concept
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
package shapes;
public class Circle extends Shape implements Selectable
{
   // Declarations
   int radius;
   boolean selected;
   int x, y;
   
    /**
     * Constructor
     * initializes radius and selected
     * @param radius: the value of a radius
     */
   public Circle( int radius)
   {
      super();
      this.radius = radius;
      selected = false;
      x = 0;
      y = 0;
   }
   
   
    //@Override
   /** A method to find area of shape
     * return area
     */
   public double getArea()
   {
      double area;
      area = radius * radius * Math.PI;
      return area;
   }
   
    /**
    * A method to find wheter the shape include x and y
    * return: object if it include x and y
    */
   public Shape contains(int x, int y) 
   {
      this.x = super.getX();
      this.y = super.getY();
      if ( Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y,2)) <= radius ) 
         return this;
      else
         return null;
   }
   
    // @ override
   /**
    * A method to set the variable selected
    * @param: the select state
    */
   public void setSelected ( boolean isSelected)
   {
      selected = isSelected;
   }
   
   
   // @ override
   /**
    * A method to get the variable selected
    * @return: selected
    */
   public boolean getSelected()
   {
      return selected;
   }
    
   public void setRadius(int radius)
   {
      this.radius = radius;
   }
  
  public int getRadius()
  {
    return radius;
  }
      
   
   /**
    * A method to convert to string
    * @return: String version of shape info
    */
   public String toString()
   {
      String isSelected;
      if (selected)
      {
         isSelected = "selected";
      }
      
      else
      {
          isSelected = "not selected";
      }
      
      String result;
      result = "This shape is a circle with radius " + radius + " and this shape is " + isSelected ;
      return result;
   }
}