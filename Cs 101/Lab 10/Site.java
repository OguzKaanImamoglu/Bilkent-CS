
public class Site
{
   // Data Members
   private final int MAX_HOUSES = 10;
   public House[] houseList = new House[MAX_HOUSES];
   private int houseCount = 0;
   private String siteName;
   private int residents;
   
   // Constructor
   
   
   
   // Add House
   public boolean addHouse( String name, String adress, int resident, double fee)
   {
      if (houseCount < MAX_HOUSES)
      {
         House h = new House( name, adress, resident, fee);
         houseList.add(h);
         houseCount++;
         return true;
         updateTotalResidents(h);
      }
      else
      {
         return false;
      }
   }
   
   public void updateTotalResidents(House h)
   {
      residents = residents + h.getResidents();
   }
   
   public String viewHouses()
   {
      String result;
      for (int i = 0; i < size.houseList ; i++)
      {
      result = houseList(super.toString());
      return result;
      }
   }
   
   
   
   
   
   
   
   
   
   
   
}
   
   