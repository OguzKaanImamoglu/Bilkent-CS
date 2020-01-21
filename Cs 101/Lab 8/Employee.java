
public class Employee
{
   // Constants
   public static final int WORKING_DAY = 261;
   
   // Properties
   private String employeeName;
   private double dailyRate;
   private String department;
   private String project;
   private String deptInfo;
   
   // Constructor
   public Employee ( String name, double rate, String project, String department, String code)
   {
      this.setEmployeeName(name);
      this.setDailyRate(rate);
      this.setProject(project);
      Department d1 = new Department(name, code);
      this.setDepartment( department);
      deptInfo = d1.toString();
   }
   
   // Copy Constructor
   /* I will add a copy constructer here
    * 
    * 
    */
   
   // Accessor Methods
   public String getEmployeeName()
   {
      return employeeName;
   }
   
   public double getDailyRate()
   {
      return dailyRate;
   }
   
   public String getProject()
   {
      return project;
   }
   
   public String getDepartment()
   {
      return department;
   }
   
   // Mutator Methods
   
   public void setEmployeeName( String name)
   {
      employeeName = name;
   }
   
   public void setDailyRate( double rate)
   {
      dailyRate = rate;
   }
   
   public void setProject( String pname)
   {
      project = pname;
   }
   
   public void setDepartment( String dept)
   {
      department = dept;
   }
   
   
   // Other Methods
   public double calculateYearlySalary()
   {
      double salary;
      salary = dailyRate * WORKING_DAY;
      return salary;
   }
   
   public String toString()
   {
      String result;
      result = "Employee Name: " + this.getEmployeeName() + "   Yearly Salary: " + this.calculateYearlySalary() + "\n" + deptInfo  ;
      return result;
   }
}
      
   
   