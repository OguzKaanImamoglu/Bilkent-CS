public class House
{
   // Properties
   private String ownerName;
   private String adress;
   private int residents;
   private double serviceChargePerResident;
   
   // Constructor
   
   public House ( String name, String adress, int resident, double charge)
   {
      this.setOwnerName(name);
      this.setAdress(adress);
      this.setResidents(resident);
      this.setCharge( charge);
   }
   
   // Accessor Methods
   
   public String getOwnerName()
   {
      return ownerName;
   }
   
   public String getAdress()
   {
      return adress;
   }
    
   public int getResidents()
   {
      return residents;
   }
     
   public double getCharge()
   {
      return serviceChargePerResident;
   }
     
     
     // Mutator Methods
     
    public void setOwnerName(String name)
    {
        ownerName = name;
    }
    
    public void setAdress ( String adr)
    {
       adress = adr;
    }
    
    public void setResidents ( int number)
    {
       residents = number;
    }
    
    public void setCharge ( double value)
    {
       serviceChargePerResident = value;
    }
    
    // Other Methods
    
    public double calculateTotalServiceFee()
    {
       double fee;
       fee = this.getResidents() * this.getCharge();
       return fee;
    }
    
    public String toString()
    {
       String result;
       result = "Owner: " + this.getOwnerName() + "\n Adress: " + this.getAdress() + "\n Residents: " + this.getResidents() + "\n Monthly Fee: " + this.getCharge();
       return result;
    }
}
    