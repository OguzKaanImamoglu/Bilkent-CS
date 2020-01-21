import java.util.Arrays;
public class EmployeeApp
{
   public static void main( String[] Args)
   {
      // Projects
      Project p1 = new Project ("ArcTech Business Solution",4000,30,10);
      
      // Employees
      Employee e1 = new Employee("Zana Karakus", 100, "ArcTech Business Solution", "Information Technology", "IT");
      Employee e2 = new Employee("Rocca Denis", 200, "ArcTech Business Solution", "Human Resources", "HR");
      Employee e3 = new Employee("Jamie Anders", 300, "ArcTech Business Solution", "Human Resources", "HR");
      Employee e4 = new Employee("Zana Karakus", 100, "ArcTech Business Solution", "Information Technology", "IT");
      
      // Output
      System.out.println("Employees:" + "\n");
      
      System.out.println(e1.toString());
      System.out.println(p1.toString() + "\n");
      System.out.println(e2.toString());
      System.out.println(p1.toString() + "\n");
      System.out.println(e3.toString());
      System.out.println(p1.toString() + "\n");
      System.out.println(e4.toString());
      System.out.println(p1.toString());
      System.out.println("- - - - - - - - -end employee list- - - - - - - - - \n");
      
      // Matching Departments
      
      int count = 0;
      if (e1.getDepartment().equals(e2.getDepartment()))
      {
         count++;
         System.out.println("Employees with matching departments (" + count + ") \n");
         System.out.println(e1.toString());
         System.out.println(p1.toString() + "\n");
         System.out.println(e2.toString());
         System.out.println(p1.toString() + "\n");
      }
      
      if (e1.getDepartment().equals(e3.getDepartment()))
      {
         count++;
         System.out.println("Employees with matching departments (" + count + ") \n");
         System.out.println(e1.toString());
         System.out.println(p1.toString() + "\n");
         System.out.println(e3.toString());
         System.out.println(p1.toString() + "\n");
      }
      
      if (e1.getDepartment().equals(e4.getDepartment()))
      {
         count++;
         System.out.println("Employees with matching departments (" + count + ") \n");
         System.out.println(e1.toString());
         System.out.println(p1.toString() + "\n");
         System.out.println(e4.toString());
         System.out.println(p1.toString() + "\n");
      }
      
      if (e2.getDepartment().equals(e3.getDepartment()))
      {
         count++;
         System.out.println("Employees with matching departments (" + count + ") \n");
         System.out.println(e2.toString());
         System.out.println(p1.toString() + "\n");
         System.out.println(e3.toString());
         System.out.println(p1.toString() + "\n");
      }
      
      if (e2.getDepartment().equals(e4.getDepartment()))
      {
         count++;
         System.out.println("Employees with matching departments (" + count + ") \n");
         System.out.println(e2.toString());
         System.out.println(p1.toString() + "\n");
         System.out.println(e4.toString());
         System.out.println(p1.toString() + "\n");
      }
      
      if (e3.getDepartment().equals(e4.getDepartment()))
      {
         count++;
         System.out.println("Employees with matching departments (" + count + ") \n");
         System.out.println(e3.toString());
         System.out.println(p1.toString() + "\n");
         System.out.println(e4.toString());
         System.out.println(p1.toString() + "\n");
      }
      
      else
      {
         System.out.println("No more matches found");
      }  
   }
}
      
   
      