public class DepartmentTest
{
   public static void main(String[] args)
   {
      // References
      Department d1 = new Department( "Computer Science", "CS");
      Department d2 = new Department( "Information Technology", "IT");
      
      // Comparision 1
      System.out.println( d1 == d2);
      System.out.println( d1.equals(d2) );
      
      // Changing References
      d1 = new Department( "Public Relations", "PR");
      d2 = new Department( "Public Relations", "PR");
      
      // Final Comparision
      System.out.println( d1 == d2);
      System.out.println( d1.equals(d2) );
   }
}
      
      