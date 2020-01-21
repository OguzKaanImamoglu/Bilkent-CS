/**
 * Project Infos
 * This class include project information
 * @author Oðuz Kaan Ýmamoðlu
 * @date 03.04.2018
 */
public class Project
{
   // Constants
   public static final double TAX = 17;
   public static final int OVERHEAD = 50000;
   public static final int EMP_HOURS_WEEK = 40;
   
   // Properties
   public static int projectCounter = 1000;
   private String projectId;
   private String projectName;
   private String projectType;
   private int personHours;
   private int ratePerHour;
   private int projectWeeks;
   private int resources;
   
   /**
    * Constructor
    * @ param name: Name of the project
    * @ param hour: Total hour for project
    * @ param rate: Rate per hour
    * @ param week: Week count of project
    */
   public Project(String name, int hour, int rate, int week) 
   {
      
      this.setProjectName(name);
      this.setPersonHours( hour );
      this.setRatePerHour( rate);
      this.setProjectWeeks( week);
      this.setProjectId();
      this.setProjectType(projectCost());
      resources = this.calculatePersonResources(hour, week);
   }
   
   // Accessor Methods
   
   // returns Project Id
   public String getProjectId()
   {
      return projectId;
   }
    // returns Project Name
   public  String getProjectName()
   {
      return projectName;
   }
    
   // Returns project type
   public  String getProjectType()
   {
      return projectType;
   }
    // returns Person Hours
   public  int getPersonHours()
   {
      return personHours;
   }
   // returns Rate Per Hour
   public int getRatePerHour()
   {
      return ratePerHour;
   }
    // returns Project Weeks
   public int getProjectWeeks()
   {
      return projectWeeks;
   }
   
   // Mutator Methods
   
   // Determines Project Name
   public void setProjectName( String name)
   {
      projectName = name;
   }
   // Determines PersonHours
   public void setPersonHours( int hour )
   {
      if ( hour > 0 )
         personHours = hour;
      else
         personHours = 0;
   }
   // Determines Rate Per Hour
   public void setRatePerHour( int rate )
   {
      if ( rate > 0 )
         ratePerHour = rate;
      else
         ratePerHour = 0;
   }
   // Determines Project Weeks
   public void setProjectWeeks( int weeks )
   {
      if ( weeks > 0 )
         projectWeeks = weeks;
      else
         projectWeeks = 0;
   }
   // Determines Project Id
   private void setProjectId()
   {
      projectId = "2018-" + projectCounter;
      projectCounter++;  
   }
   // Determines Project Type
   public void setProjectType(double cost)
   {
      if ( cost > 500000)
         projectType = "m";
      else if ( cost > 100000)
         projectType = "a";
      else if ( cost > 0 )
         projectType = "s";
      else
         projectType = "i";
   }
   
   // Other Methods
   
   /**
    * Inactivates The Project
    * This method set inactive an arbitrary project and displays it
    */
   public String deactivateProject()
   {
     projectType = "i"; 
     return projectType;
   }
   /**
    * Computes Project Cost
    * @ return Cost of the project
    */
   public double projectCost( )
   {
      double projectCost = (personHours * ratePerHour) ;
      double rate = TAX/100;
      
      if ( projectCost > 20000 )
      {
         projectCost = projectCost + OVERHEAD ;
      }
      
      projectCost = (projectCost * rate) + projectCost ;
      
      return projectCost;
   }
   /**
    * Computes Human Resources
    * @ return How many people is required for the project
    */
   public int calculatePersonResources ( int personHours, int projectWeeks)
   {
      int resources;
      resources =( personHours) / (projectWeeks * EMP_HOURS_WEEK);
      return resources;
   }
   /**
    * Compares The Costs Of Projects
    * @ param Other Project
    * @ return Positive, Negative or Neutral Value
    */
   public int compareProjects(Project other)
   {
      if ( projectCost() > other.projectCost())
         return 1;   
      else if ( projectCost() == other.projectCost() )
         return 0;
      else
         return -1 ;
   }
   /*
    * Converts all data to string
    * @ return String version of the data
    */
   public String toString()
   {
      String result;
      if ( projectType.equals("i"))
      {
         result = "\n----------Inactive Project----------" +
                  "\nProject name: " + this.getProjectName() + 
                  "\nProject Id: " + getProjectId();
      }
      else
      {
         result = "Project name: " + this.getProjectName() + 
                      "\nProject Id: " + this.getProjectId() +
                      "\nProject Type: " + this.getProjectType() +
                      "\nTeam Size: " + resources +
                      "\nEstimated Project Cost: " + this.projectCost() +
                      "\n";
      }
      return result;  
   }
}
       
   