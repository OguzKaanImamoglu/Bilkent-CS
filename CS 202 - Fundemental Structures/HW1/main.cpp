
/**
* Title : Algorithm Efficiency and Sorting
* Author : Oðuz Kaan Ýmamoðlu
* ID: 21702233
* Section : 1
* Assignment : 1
* Description : This Code is the main part to test sorting algorithms
*/

#include "sorting.h"
#include <iostream>
#include <chrono>
#include <ctime>


int main()
{
    int compCount = 0;
    int moveCount = 0;



    int quick[] = {22,11,6,7,30,2,27,24,9,1,20,17};
    int insertion[] = {22,11,6,7,30,2,27,24,9,1,20,17};
    int hybrid[] = {22,11,6,7,30,2,27,24,9,1,20,17};

    printArray(quick,12);
    quickSort(quick,0,11,compCount,moveCount);
    moveCount = 0;
    compCount = 0;
    printArray(quick,12);
    //////////////////////////////////////////////
    printArray(insertion,12);
    insertionSort(insertion,12,compCount,moveCount);
    moveCount = 0;
    compCount = 0;
    printArray(insertion,12);
    ///////////////////////////////////////////
    printArray(hybrid,12);
    hybridSort(hybrid, 12 , compCount,moveCount);
    moveCount = 0;
    compCount = 0;
    printArray(hybrid,12);

    performanceAnalysis();

}
