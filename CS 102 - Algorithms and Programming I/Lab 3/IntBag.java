/**
 * A class that represents a bag with integers
 * @ author Oðuz Kaan Ýmamoðlu
 * @ date 09.10.2018
 */
import java.util.*;
public class IntBag
{
   // Properties
   int[] bag;
   

   /* 
    * Constructor
    *  Creates an empty collection
    */
   public IntBag()
   {
      bag = new int [4];
      bag[0] = -1;
   }
   
   
   /* 
    * A method to expand the array to double
    * @ param arr: The array that needs to expand
    * @ returns: Doubled version of array
    */
   public int[] extendArray(int[] arr) 
   {
      int[] arr2 = new int[arr.length * 2 ];
      int count = 0;
      for (int i : arr) 
      {
         arr2[count++] = i;
      }
      return arr2;
   }
   
   /* 
    * A method to shrink the array to half
    * @ param arr: The array that needs to shrink
    * @ returns: Shrinked version of array
    */
   public int[] shrinkArray(int[] arr)
   {
     int[] arr2 = new int[arr.length / 2];
     int count = 0;
     int currentSize = this.search(-1);
     for (int i = 0; i <= currentSize; i++ )
     {
       arr2[i] = arr[i];
     }
     
     return arr2;
   }
   
   /**
    * A method to test shrinker
    */
   public void shrinker()
   {
     int currentSize = this.search(-1);
     int size = currentSize;
     for (int i = size-1; i > 0; i--)
     {
       this.remover(0);
       currentSize--;
       if(currentSize < bag.length/2)
       {
         bag = shrinkArray(bag);
       }
       System.out.println(bag.length);
     }
     bag[currentSize] = -1;
   }
      
   /*
    * A method to add a new number to end of the array
    * @ param num: The number that will be added
    */
   public void addToEnd ( int num)
   {
     int currentSize = this.search(-1);
     
     //For eliminate nagative integers
     if ( num < 0)
     {
       System.out.println("This bag is not for negative numbers");
     }
    
     
     if ( currentSize  < bag.length - 1)
     {
       currentSize++;
       bag[currentSize-1] = num;
       bag[currentSize] = -1;       
     }
     else if (currentSize >= bag.length-1)
     {
        bag = extendArray(bag);
        currentSize++;
        bag[currentSize-1] = num;
        bag[currentSize] = - 1;
     }
   }
   
     /*
    * A method to add a number into specific location of the array
    * @ param num: The number that will be inserted
    * @ param there: Where the number will be inserted
    */
   public void addToThere( int num, int there)
   {
     int currentSize = this.search(-1);
     // For eliminate nagative integers
     if (there > bag.length)
     {
       System.out.println("Location is greater than size");
     }
     else if ( num <= 0)
     {
        System.out.println("This bag is only for positive integers");
     }
      // If there is room
      else if ( currentSize + 1 < bag.length)
      {
         if (currentSize < bag.length)
         {   
            currentSize++;   
            for (int i = currentSize - 1; i > there; i--)  
            {      
               bag[i] = bag[i - 1];  
            }   
            bag[there] = num;
            bag[currentSize] = -1;
         }
      }
      
      // If there is no room
      else if (currentSize + 1 >= bag.length)
      {
         bag = extendArray(bag);
          if (currentSize < bag.length)
         {   
            currentSize++;   
            for (int i = currentSize - 1; i > there; i--)  
            {      
               bag[i] = bag[i - 1];  
            }   
            bag[there] = num;
            bag[currentSize] = -1;
         }
      }
   }
   
   public int getValueAt( int index)
   {
      return bag[index];
   }
  
   
   /*
    * A method to searched a specific value
    * @ param searchedValue: The value that will be searched
    */
   public int search( int searchedValue)
   {
      boolean found = false;
      int i = 0;
      while ( i < bag.length  && !found)
      {
         if(bag[i] == searchedValue)
         {
            found = true;
         }
         
         else
         {
            i++;
         }
      }
      if (found) 
      { 
         return i;
      }
      else 
      { 
         return -1;
      }
   }
   
   /*
    * A method for removing a member
    * @ param position: Position of the member that will be removed
    */
   public void remover( int position)
   {
      int currentSize = this.search(-1);
      bag[position] = bag[currentSize - 1];
      currentSize--;
      bag[currentSize] = -1; 
   } 
   
   /*
    * A method to find the value at specific location
    * @ param i: the location that be wanted
    */
   public void valueAt(int i)
   {
      System.out.println( bag[i]);
   }
   
   /*
    * A method that prints the size of bag
    */
   public int size()
   {
      return (this.search(-1));
   }
  
   /*
    * A method to convert the bag to String
    * @ returns: String represantation of the bag
    */
   public String toString()
   {
     int currentSize = this.search(-1);
     String result ="";
      for ( int i = 0; i < currentSize; i++)
      {
         result =  result + i + " | " + bag[i] + "\n";
      }
      return result;
   }
     /*
    * A method to remove all instances of a value
    * @ param number: The value that will be removed
    */
   public void removeAll(int number)
   {
      int currentSize = this.search(-1);
      boolean found = false;
      for (int pos = 0; pos < currentSize; pos++)
      {
         if(bag[pos] == number)
         {
            found = true;
         }
         
         if (found)
         {
            for (int i = pos + 1; i < currentSize; i++)
            {    
               bag[i - 1] = bag[i]; 
             }
            currentSize--;
            found = false;
            pos--;
            
         }
      }
       bag[currentSize] = -1;     
   } 
   
   public Iterator iterator()
   {
    IntBagIterator newBag = new IntBagIterator(this);
    return newBag;     
   }
}
         


         
         
      