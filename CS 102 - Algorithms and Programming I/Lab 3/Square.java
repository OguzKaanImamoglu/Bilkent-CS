/**
 * A class that represents the square concept
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
public class Square extends Rectangle implements Selectable
{
     // properties
      int side;
      boolean selected;
      int x,y;

    /**
     * Constructor
     * initializes side and selected
     * @param side: the value of a side
     */
     public Square(int side) 
     {
       super(side, side);
       this.side = side;
       selected = false;
     }
       
    /**
     * A method to find wheter the shape include x and y
     * return: object if it include x and y
     */
    public Shape contains(int x, int y) 
   {
      this.x = super.getX();
      this.y = super.getY();
      if ( Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y,2)) <= Math.sqrt( 2*Math.pow(side/2,2)) )
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
    * @return: selecte
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
      result = "This shape is a square with side " + side + " and this shape is " + isSelected ;
      return result;
   }

 
   
 
}