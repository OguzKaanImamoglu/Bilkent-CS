import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * A class for making merge sort
 * @author Oðuz Kaan Ýmamoðlu
 * @date 11.12.18
 */
public class Lab07
{
    /**
     * This method merges two sorted arrays
     * @param Str1: Array 1 that will be merged
     * @param Str2: Array 2 that will be merged
     */
    public static String[] mergeSorted(String[] str1 , String[] str2){
        int length1 = str1.length;
        int length2 = str2.length;
        
        String[] result = new String[length1+ length2];
        int a = 0;
        int b = 0;
        int c = 0;
        
        while(a < length1 && b < length2)
        {
            if(str1[a].compareTo(str2[b]) < 0 )
            {
                result[c] = str1[a];
                c++;
                a++;
            }
            else if (str1[a].compareTo(str2[b]) >= 0 ) 
            {
                result[c] = str2[b];
                c++;
                b++;
            }
            else
            {
               result[c] = str1[a];
               c++;
               b++;
               a++;
            }
        }
        
        while(a < length1)
        {
            result[c] = str1[a];
            c++;
            a++;
        }
        
        while(b < length2)
        {
            result[c] = str2[b];
            c++;
            b++;
        }
        return result;
    }
    
    /**
     * This method sorts the array
     * @param arr: Array that will be sorted
     */
    public static String[] sort(String[] arr){
        int a = 0;
        int b = 0;
        int middlePoint = arr.length / 2;
        String left[] = new String[middlePoint];
        String right[] = new String[arr.length-middlePoint];
     
        if(arr.length <= 1)
        {
            return arr;
        }
        for(int i = 0; i < middlePoint ; i++)
        {
            left[a] = arr[i];
            a++;
        }
        for(int i = middlePoint; i < arr.length;i++)
        {
            right[b] = arr[i];
            b++;
        }
        left = sort(left);
        right = sort(right);
        return mergeSorted(left,right);
    }

    
    public static void main(String[] args) throws FileNotFoundException
    {
        //Q1
        String[] A = {"cat" , "hog"};
        String[] B = {"dog", "frog"};
        String[] C = mergeSorted(A,B);
        System.out.println(Arrays.toString(C));
         
        //Q2
        String[] arrayToSorted = {"hog" , "cat", "frog", "dog", "aaa"};
        String [] newSorted  = sort(arrayToSorted);
        System.out.println(Arrays.toString(newSorted));
        
        //Q3
        
        // Reading File
        ArrayList<String> result = new ArrayList<>();
        Scanner s = new Scanner(new FileReader("housman.txt"));
        while (s.hasNext()) 
        {
           result.add(s.next());
        }
   
        // Adding context of the file into array
        String[] theArray = new String[result.size()];
        for (int i = 0; i < result.size(); i++)
        {
           theArray[i] = result.get(i);
        }
        String [] theFinalArray  = sort(theArray);
        for (int i = 0; i < theFinalArray.length ; i++ )
        {
           while (theFinalArray[i].equals(theFinalArray[i+1]))
           {
              i++;
              if ( i + 1 >= theFinalArray.length)
              {
                 break;
              }
           }
           System.out.println(theFinalArray[i]);
        }
                              
                              
        
    }
}

