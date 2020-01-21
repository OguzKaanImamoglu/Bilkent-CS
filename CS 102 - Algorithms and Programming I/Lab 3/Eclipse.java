/**
 * A class that represents the eclipse concept
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
public class Eclipse extends Shape implements Selectable
{
   // Declarations
   int radius;
   boolean selected;
   int x, y, height, width;
   
    /**
     * Constructor
     * initializes height, width, selected and center
     * @param height, width: the value of a height and width
     */
   public Eclipse( int height, int width)
   {
      super();
      this.height = height;
      this.width = width;
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
      area = height/2 * width/2 * Math.PI;
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
      if ( Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y,2)) <= Math.sqrt(Math.pow(height, 2) + Math.pow(width,2)) ) 
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
      result = "This shape is a eclipse with height " + height + " width " + width + " and this shape is " + isSelected ;
      return result;
   }
}
   
   