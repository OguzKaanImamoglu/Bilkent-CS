#include<iostream>
#include <cstdlib>
using namespace std;

#include <vector>
#include <cmath>
#include <chrono>
#include <ctime>
#include <bits/stdc++.h>
#include <ratio>

using namespace std::chrono;

vector <int> v0;
vector <int> v1;
vector <int> v2;
vector <int> v3;
vector <int> v4;
vector <int> v5;



int i;
/**
 *Cubic maximum contiguous subsequence sum algorithm
 */
int maxSubSum1(const vector <int> & a)
{
    int maxSum = 0;

    for (int i = 0; i<a.size(); i++)
    {
        for(int j = i; j< a.size(); j++)
        {
            int thisSum = 0;

            for(int k = i; k<=j; k++)
            {
                thisSum += a[k];
            }
            if (thisSum > maxSum)
            {
                maxSum = thisSum;
            }
        }

    }
     return maxSum;
}

/**
 *Quadratic function
 */
 int maxSubSum2( const vector <int> & a)
 {
     int maxSum = 0;

     for(int i = 0; i < a.size(); i++)
     {
         int thisSum = 0;
         for (int j = i; j < a.size(); j++)
         {
             thisSum += a[j];

             if(thisSum>maxSum)
                maxSum = thisSum;
         }
     }
     return maxSum;
 }

 /**
 *Recursive one
 */
 int maxSumRec(const vector<int> &a, int left, int right)
 {
     if(left == right)
     {
         if(a[left] > 0)
            return a[left];
         else
            return 0;
     }

     int center = (left + right) / 2;
     int maxLeftSum = maxSumRec(a,left,center);
     int maxRightSum = maxSumRec(a, center + 1, right);

     int maxLeftBorderSum = 0, leftBorderSum = 0;
     for(int i = center; i >= left; i--)
     {
         leftBorderSum += a[i];
         if(leftBorderSum > maxLeftBorderSum)
            maxLeftBorderSum = leftBorderSum;
     }

     int maxRightBorderSum = 0, rightBorderSum = 0;
     for (int j = center + 1; j <= right; j++)
     {
         rightBorderSum += a[j];
         if( rightBorderSum > maxRightBorderSum)
            maxRightBorderSum = rightBorderSum;
     }

     return max( max(maxLeftSum, maxRightSum),maxLeftBorderSum + maxRightBorderSum);
 }

/**
*Linear time one
*/
int maxSubSum4(const vector <int> & a)
{
    int maxSum = 0, thisSum = 0;

    for (int j = 0; j < a.size(); j++)
    {
        thisSum += a[j];

        if(thisSum > maxSum)
            maxSum = thisSum;
        else if( thisSum < 0)
            thisSum = 0;
    }
    return maxSum;
}
main()
{
   for(int j = 0; j < 2000; j++)
   {
      i = rand() % 200 + (-100);
      v0.push_back(i);
   }

   for(int j = 0; j < 3500; j++)
   {
      i = rand() % 200 + (-100);
      v1.push_back(i);
   }


   for(int j = 0; j < 5000; j++)
   {
      i = rand() % 200 + (-100);
      v2.push_back(i);
   }

   for(int j = 0; j < 1000000; j++)
   {
      i = rand() % 200 + (-100);
      v3.push_back(i);
   }

   for(int j = 0; j < 5000000; j++)
   {
      i = rand() % 200 + (-100);
      v4.push_back(i);
   }

   for(int j = 0; j < 10000000; j++)
   {
      i = rand() % 200 + (-100);
      v5.push_back(i);
   }


    // Declare necessary variables
    std::chrono::time_point< std::chrono::system_clock > startTime;
    std::chrono::duration< double, milli > elapsedTime;
    // Store the starting time
    startTime = std::chrono::system_clock::now();


    // Code block

          maxSubSum1(v5);     // These lines are commented, when I want to test one of them I uncomment it, I write the code like
    //    maxSubSum1(v1);     // this because otherwise it would be very long code.
    //    maxSubSum1(v2);
    //    maxSubSum2(v0);
    //    maxSubSum2(v1);
    //    maxSubSum2(v2);
    //    maxSumRec(v3,0, v3.size()-1);
    //    maxSumRec(v4,0, v4.size()-1);
    //    maxSumRec(v5,0, v5.size()-1);
    //    maxSubSum4(v3);
    //    maxSubSum4(v4);
    //    maxSubSum4(v5);


    // Compute the number of milliseconds that passed since the starting time
    elapsedTime = std::chrono::system_clock::now() - startTime;
    cout << "Execution took " << elapsedTime.count() << " milliseconds." << endl;


}
