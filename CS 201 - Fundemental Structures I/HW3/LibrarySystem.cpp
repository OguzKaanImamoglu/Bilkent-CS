#include "LibrarySystem.h"
#include <iostream>
#include "List.h"     // header file
#include "Book.h"
using namespace std;

    List* library;


    LibrarySystem::LibrarySystem()
    {
        List* library = new List();
    }

    LibrarySystem::~LibrarySystem()
    {
        delete library;
    }

    void LibrarySystem::addBook(const int bookId, const string name, const int year)
    {
        Book newBook(name, bookId, year);
        int index = library->getLength();
        library->insert(index, newBook);
    }

    void LibrarySystem::deleteBook(const int bookId)
    {

        ListNode* cur = library->head;

        for ( int i = 0; i < library->getLength(); i++)
        {

            if (cur->item->getId() = bookId)
            {
                library->remove(i);
            }
            cur = cur->next;
        }
    }

    void LibrarySystem::showAllBooks()
    {
        ListNode* cur = library->head;
        cout<<"Book id    "<<"Book Name   "<<"Book Year   "<<endl;
        for( int i = 0; i < library.getLength(); i++)
        {
           cout<< cur->item->getId() << "   " << cur->item->getTitle() << "   " << cur->item->getYear() << "   "<<endl;
           cur = cur->next;
        }
    }


