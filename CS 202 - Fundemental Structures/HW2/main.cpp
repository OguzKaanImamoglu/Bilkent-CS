/**
* Title : Ngram Tree Main
* Author : Oguz Kaan Imamoglu
* ID: 21702233
* Section : 1
* Assignment : 2
* Description : this is the main part
*/

# include "NgramTree.h"
# include <iostream>
# include <string>
using namespace std ;
int main (int argc , char ** argv ){
NgramTree tree ;
string fileName ( argv [1]);
int n = atoi ( argv [2]);
tree . generateTree ( fileName , n);
cout << "\n Total " << n << "-gram count : "
<< tree . getTotalNgramCount () << endl ;
tree . printNgramFrequencies ();
//cout << n << "-gram tree is complete : "
//<< ( tree . isComplete () ? "Yes" : "No") << endl ; // I erased these parts because I could not implement is complete
// Before insertion of new n- grams
cout << "\n Total " << n << "-gram count : "
<< tree . getTotalNgramCount () << endl ;
tree . addNgram ("samp");
tree . addNgram ("samp");
tree . addNgram ("zinc");
tree . addNgram ("aatt");
cout << "\n Total " << n << "-gram count : "
<< tree . getTotalNgramCount () << endl ;
tree . printNgramFrequencies ();
//cout << n << "-gram tree is complete : "
//<< ( tree . isComplete () ? "Yes" : "No") << endl ;   // I erased these parts because I could not implement is complete
cout << n << "-gram tree is full : "
<< ( tree . isFull () ? "Yes " : "No") << endl ;
return 0;
}
