/**
* Title : Algorithm Efficiency and Sorting
* Author : Oðuz Kaan Ýmamoðlu
* ID: 21702233
* Section : 1
* Assignment : 1
* Description : The header part
*/

#ifndef SORTING_H_INCLUDED
#define SORTING_H_INCLUDED
using namespace std;

void quickSort(int *arr, int f ,int l, int &compCount, int &moveCount);
void insertionSort(int *arr, int size, int &compCount, int &moveCount);
void hybridSort(int *arr, int size, int &compCount, int &moveCount);
void printArray(int *arr, int size);
void performanceAnalysis();
void randomArrayFill(int* arrayFill1,int* arrayFill2,int* arrayFill3, int size);
int getRandomNumber();



#endif // SORTING_H_INCLUDED
