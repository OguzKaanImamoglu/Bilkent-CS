/**
* Title : Ngram Tree Header
* Author : Oguz Kaan Imamoglu
* ID: 21702233
* Section : 1
* Assignment : 2
* Description : this is the header file
*/
#ifndef NGRAMTREE_H_INCLUDED
#define NGRAMTREE_H_INCLUDED
#include <string>
#include <iostream>
#include <stdio.h>

using namespace std;

class NgramNode{
public:
private:
    string word;
    int count;
    NgramNode* leftChild;
    NgramNode* rightChild;
    NgramNode(const string word, NgramNode* left, NgramNode* right) :
    	count(1), leftChild(NULL), rightChild(NULL){
        this->word = word;
        this->leftChild = left;
        this->rightChild = right;
    }
    void countNgrams(int& count);
    void inorderPrint();
    int getHeight(int height);
    friend class NgramTree;
};

class NgramTree {
public:
	NgramTree();
	~NgramTree();
	void generateTree(string fileName, int n);
	void addNgram(string ngram);
	void printNgramFrequencies();
	int  getTotalNgramCount();
	bool isComplete();
	bool isFull();
	void addNgram2(NgramNode *& treePtr,
				  const string& newItem);

private:
	NgramNode* root;
};


#endif // NGRAMTREE_H_INCLUDED
