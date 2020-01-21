/**
 * A class that represents the rectangle concept
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
package shapes;
public class Rectangle extends Shape implements Selectable
{
   // Declarations
   int  width, height;
   boolean selected;
   int x,y;
  
   /**
     * Constructor
     * initializes sides and selected
     * @param width: the value of width
     * @param height: the value of height
     */
   public Rectangle(int width, int height)
   {
     super();
     this.width = width;
     this.height = height;
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
     return width * height;
   }
   
   /**
    * A method to find wheter the shape include x and y
    * return: object if it include x and y
    */
   public Shape contains(int x, int y) 
   {
      this.x = super.getX();
      this.y = super.getY();
      if ( Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y,2)) <= Math.sqrt( Math.pow(height/2,2) + Math.pow(width/2,2)) )
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
      result = "This shape is a rectangle with sides " + width + " - " + height  + " and this shape is " + isSelected ;
      return result;
   }
   
}