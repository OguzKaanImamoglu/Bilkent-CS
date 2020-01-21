#ifndef LIST_H_INCLUDED
#define LIST_H_INCLUDED
//#include <string>
using namespace std;
#include "Book.h"
#include <iostream>


typedef Book ListItemType;

class List{

// constructors and destructor:
public:
   List();                  // default constructor
   List(const List& aList); // copy constructor
   ~List();                 // destructor

   // list operations:
   bool isEmpty() const;

   int getLength() const;

   bool retrieve(int index,
		            ListItemType& dataItem) const;

   bool insert(int index, ListItemType newItem);

   bool remove(int index);

//   private:

   struct ListNode{      // a node on the list
      ListItemType item; // a data item on the list
      ListNode *next;    // pointer to next node
   };


   int       size;  // number of items in list
   ListNode *head;  // pointer to linked list
				    // of items

   ListNode *find(int index) const;
   // Returns a pointer to the index-th node
   // in the linked list
};
#endif // LIST_H_INCLUDED
