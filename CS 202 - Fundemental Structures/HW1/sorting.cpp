/**
* Title : Algorithm Efficiency and Sorting
* Author : Oðuz Kaan Ýmamoðlu
* ID: 21702233
* Section : 1
* Assignment : 1
* Description : The source code that includes sorting algorithms.
*/
#include "sorting.h"
#include <iomanip>
#include <thread>
#include <iostream>
#include <chrono>
#include <ctime>


// for milliseconds, use using ms = std::chrono::duration<double, std::milli>;



void printArray(int *arr, int size)
{
    cout<< '{' ;
    for(int n = 0; n < size; n++)
    {
        cout << arr[n] << ", ";
    }
    cout<< '}' << endl;
}


void partition(int theArray[], int first, int last,int &pivotIndex, int &compCount, int &moveCount)
{
   // Precondition: theArray[first..last] is an array; first <= last.
   // Postcondition: Partitions theArray[first..last] such that:
   //   S1 = theArray[first..pivotIndex-1] < pivot
   //   theArray[pivotIndex] == pivot
   //   S2 = theArray[pivotIndex+1..last] >= pivot

	// place pivot in theArray[first]

   int pivot = theArray[first]; // copy pivot
   moveCount++;
   // initially, everything but pivot is in unknown
   int lastS1 = first;           // index of last item in S1
   int firstUnknown = first + 1; // index of first item in unknown

	// move one item at a time until unknown region is empty
   for (  ; firstUnknown <= last; ++firstUnknown)
    {

      // Invariant: theArray[first+1..lastS1] < pivot
      //            theArray[lastS1+1..firstUnknown-1] >= pivot

      // move item from unknown to proper region
      compCount++;
      if (theArray[firstUnknown] < pivot)
      {  	// belongs to S1

		  ++lastS1;
    	//  swap(theArray[firstUnknown], theArray[lastS1]);
    	  int temp = theArray[firstUnknown];
    	  moveCount++;
    	  theArray[firstUnknown] = theArray[lastS1];
    	  moveCount++;
    	  theArray[lastS1] = temp;
    	  moveCount++;
      }	// else belongs to S2
   }
   // place pivot in proper position and mark its location
  // swap(theArray[first], theArray[lastS1]);
      	  int temp2 = theArray[first];
      	  moveCount++;
    	  theArray[first] = theArray[lastS1];
    	  moveCount++;
    	  theArray[lastS1] = temp2;
    	  moveCount++;
          pivotIndex = lastS1;
}

void quickSort(int *theArray, int first ,int last, int &compCount, int &moveCount)
{
// Precondition: theArray[first..last] is an array.
// Postcondition: theArray[first..last] is sorted.

	int pivotIndex;

   if (first < last)
    {

      // create the partition: S1, pivot, S2
      partition(theArray, first, last, pivotIndex, compCount, moveCount);

      // sort regions S1 and S2
      quickSort(theArray, first, pivotIndex-1, compCount, moveCount);
      quickSort(theArray, pivotIndex+1, last, compCount, moveCount);
   }
}

void insertionSort(int *theArray, int n, int &compCount, int &moveCount)
{

  for (int unsorted = 1; unsorted < n; ++unsorted)
  {

    int nextItem = theArray[unsorted];
    moveCount++;
    int loc = unsorted;
    compCount++;
    for (  ;(loc > 0) && (theArray[loc-1] > nextItem); --loc)
    {
        theArray[loc] = theArray[loc-1];
        moveCount++;
        compCount++;
    }


    theArray[loc] = nextItem;
    moveCount++;
  }
}

void insertionSort2(int *theArray, int first, int last, int &compCount, int &moveCount)
{
   for (int unsorted = first; unsorted < last; ++unsorted)
   {

    int nextItem = theArray[unsorted];
    moveCount++;
    int loc = unsorted;
    compCount++;
    for (  ;(loc > 0) && (theArray[loc-1] > nextItem); --loc)
    {
        theArray[loc] = theArray[loc-1];
        moveCount++;
        compCount++;
    }
    theArray[loc] = nextItem;
    moveCount++;
   }
}

void hybridSort2(int *theArray, int first, int last, int &compCount, int &moveCount)
{
    if (last-first+1 < 10)
    {
       insertionSort2(theArray,first, last, compCount, moveCount);
    }

    else
    {
        int pivotIndex;
        partition(theArray,first,last, pivotIndex, compCount, moveCount);

        //sort subarrays s1 s2
        hybridSort2(theArray,first,pivotIndex-1,compCount, moveCount);
        hybridSort2(theArray, pivotIndex + 1,last,compCount, moveCount);
    }


}

void hybridSort(int* arr, int size, int& compCount, int& moveCount)
{
    hybridSort2(arr, 0, size -1, compCount, moveCount);
}



int getRandomNumber()
{
	int randomNumber = 0;



	randomNumber = rand() % 1500; //keep random numbers under 1500

	return randomNumber;
}


void randomArrayFill(int* arrayFill1,int* arrayFill2,int* arrayFill3, int size)
{
	for (int i = 0; i < size ; i++)
	{
		arrayFill1[i]=getRandomNumber();
		arrayFill2[i] = arrayFill1[i];
        arrayFill3[i] = arrayFill1[i];
	}
}



void performanceAnalysis()
{

   double qtime[10];
   double itime[10];
   double htime[10];

   int qcomp[10];
   int qmov[10];
   int icomp[10];
   int imov[10];
   int hcomp[10];
   int hmov[10];
   int size = 1500;

    for (int i = 0; i < 10; i++)
    {
       int a1[size];
       int a2[size];
       int a3[size];
       randomArrayFill(a1,a2,a3,size);
       int moveCount;
       int compCount;
       chrono::time_point< chrono::system_clock > startTime;
       chrono::duration< double, milli > elapsedTime;

        //quick
        moveCount = 0;
        compCount = 0;
        startTime = chrono::system_clock::now();
        quickSort(a1,0, size-1, compCount, moveCount);
        elapsedTime = chrono::system_clock::now() - startTime;
        qmov[i] = moveCount;
        qcomp[i] = compCount;
        qtime[i] = elapsedTime.count();

        //insertion
        moveCount = 0;
        compCount = 0;
        startTime = chrono::system_clock::now();
        insertionSort(a2,size, compCount, moveCount);
        elapsedTime = chrono::system_clock::now() - startTime;
        imov[i] = moveCount;
        icomp[i] = compCount;
        itime[i] = elapsedTime.count();

        //hybrid
        moveCount = 0;
        compCount = 0;
        startTime = chrono::system_clock::now();
        hybridSort(a3, size , compCount, moveCount);
        elapsedTime = chrono::system_clock::now() - startTime;
        hmov[i] = moveCount;
        hcomp[i] = compCount;
        htime[i] = elapsedTime.count();

        size = size + 1500;
    }


   // elapsedTime.count()

    cout<<"-----------------------------------------------------"<<endl;
    cout<<"Part a - Time analysis of Quick Sort" << endl;
    cout<<"Array Size    Time Elapsed(ms)    compCount    moveCount"<<endl;
    size = 1500;
    for (int i = 0; i < 10; i++)
    {
        cout << left << setw(15) << size << left << setw(20) << qtime[i]  << left << setw(15) << qcomp[i] << left << setw(20)  << qmov[i] << endl;
        size = size + 1500;
    }

    cout<<"-----------------------------------------------------"<<endl;
    cout<<"Part b - Time analysis of Insertion Sort" << endl;
    cout<<"Array Size    Time Elapsed(ms)    compCount    moveCount"<<endl;
    size = 1500;
    for (int i = 0; i < 10; i++)
    {
        cout << left << setw(15) << size << left << setw(20) << itime[i]  << left << setw(15) << icomp[i] << left << setw(20)  << imov[i] << endl;
        size = size + 1500;
    }

    cout<<"-----------------------------------------------------"<<endl;
    cout<<"Part c - Time analysis of Hybrid Sort" << endl;
    cout<<"Array Size    Time Elapsed(ms)    compCount    moveCount"<<endl;
    size = 1500;
    for (int i = 0; i < 10; i++)
    {
        cout << left << setw(15) << size << left << setw(20) << htime[i]  << left << setw(15) << hcomp[i] << left << setw(20)  << hmov[i] << endl;
        size = size + 1500;
    }
}
