/**
* Title : Ngram Tree Source
* Author : Oguz Kaan Imamoglu
* ID: 21702233
* Section : 1
* Assignment : 2
* Description : this is the source file
*/
using namespace std;
# include <string>
#include "NgramTree.h"
#include<cmath>
#include <stdlib.h>
#include <fstream>

NgramTree::NgramTree()
{
	root = NULL;
}

NgramTree::~NgramTree()
{}

void NgramTree::addNgram(string ngram)
{
    addNgram2(root,ngram);
}

void NgramTree::addNgram2(NgramNode *& treePtr,
				  const string& newItem)

{
   if (treePtr == NULL)
   {
	 treePtr = new NgramNode(newItem, NULL, NULL);
   }
   // else search for the insertion addNgram2()
   else if (newItem< treePtr->word)
      // search the left subtree
      addNgram2(treePtr->leftChild, newItem);

   else  if (newItem > treePtr->word) // search the right subtree
      addNgram2(treePtr->rightChild, newItem);
    else
        treePtr->count++;
}  // end

int  NgramTree::getTotalNgramCount()
{
	int count = 0;
	NgramNode* ptr = root;
	ptr->countNgrams(count);
	return count;
}

void NgramTree::printNgramFrequencies()
{
	NgramNode* ptr = root;
	ptr->inorderPrint();
}


bool NgramTree::isFull()
{
	int nodeCount, height = 0;
	nodeCount = this->getTotalNgramCount();
	height = root->getHeight(height);
	if (pow(2,height)-1 != nodeCount)
		return false;
	else
		return true;
}

void NgramTree::generateTree(string fileName, int n)
{
	ifstream thefile;
	thefile.open(fileName.c_str());
	string thestring;

	while (thefile >> thestring)
	{
		if (thestring.length() >= n)
        {

			for (int i = 0; i <= thestring.length() - n; i++)
				addNgram(thestring.substr(i,n));
		}
	}

}


void NgramNode::countNgrams(int& count)
{
	if(this != NULL)
    {
		count++;
		leftChild->countNgrams(count);
		rightChild->countNgrams(count);
	}
}

void NgramNode::inorderPrint()
{
	if(this != NULL)
    {
		this->leftChild->inorderPrint();
	    cout<<"appears time(s) " << this->word.c_str() <<"  " << this->count << endl;
		this->rightChild->inorderPrint();
	}
}

int NgramNode::getHeight(int h)
{
	if(this != NULL)
    {
		h++;
		h = max(leftChild->getHeight(h), rightChild->getHeight(h));
	}
	return h;
}


