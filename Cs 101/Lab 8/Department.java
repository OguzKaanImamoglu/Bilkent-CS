public class Department
{
   // Properties
   private String deptName;
   private String deptCode;
   
   // Constructor
   public Department ( String name, String code)
   {
      this.setDeptName( name);
      this.setDeptCode( code);
   }
   
   // Accessor Methods
   public String getDeptName()
   {
      return deptName;
   }
   
   public String getDeptCode()
   {
      return deptCode;
   }
   
   // Mutator Methods
    public void setDeptName( String name )
    {
       deptName = name;
    }
    
     public void setDeptCode( String code )
    {
       deptCode = code;
    }
     
     // Other methods
     
     public boolean equals( Department other)
     {
        if ( deptName.equals( other.getDeptName() ))
           return true;
        else
           return false;
     }
     
     
     public String toString()
     {
        String result;
        result = "Dept Name: " + this.getDeptName() + "  Dept Code: " + this.getDeptCode() + " " ;
        return result;
     }
}
    
   
   
   
   
   