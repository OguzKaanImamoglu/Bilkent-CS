/**
 * Project App
 * This class shows project information
 * @author Oðuz Kaan Ýmamoðlu
 * @date 03.04.2018
 */
public class ProjectApp
{
   public static void main ( String [] Args )
   {
      // Projects
      Project p1 = new Project("ArcTech Business Solution",4000,30,10);
      Project p2 = new Project ("SunMarkets POS Implementation",1000,150,1);
      Project p3 = new Project ( "HealthTech Hospital", 2,2,2); // Project for deactivate slot
     
      // Output
      System.out.println( " " + p1.toString() );
      System.out.println( " " + p2.toString() );
      p3.deactivateProject();
      System.out.println( " " + p3.toString() );
      System.out.println();
      
      // Comparasion
      if ( p1.compareProjects(p2) == 1 )
      {
         System.out.println( "Project with greater cost: "); 
         System.out.println( p1.toString() + " " );
      } 
      if ( p1.compareProjects(p2) == -1)
      {
         System.out.println( "Project with greater cost: ");
         System.out.println(p2.toString() + " " );
      }
      if ( p1.compareProjects(p2) == 0 )
        System.out.println( "There is no project with greater value");
   }
}
      
      
      