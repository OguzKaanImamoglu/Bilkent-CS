#include "Book.h"
using namespace std;
#include "BookStore.h"
#include <string>
#include <exception>
#include <stdexcept>
#include <bits/stdc++.h>

BookStore :: BookStore()
{
    books = NULL;
    bookNo = 0;
}

BookStore:: ~BookStore()
{
    delete[]books;
}

BookStore:: BookStore(const BookStore& bsToCopy )
{
    bookNo = bsToCopy.bookNo;
    if (bookNo != 0)
    {
    books = new Book[bookNo];
    for (int i = 0; i < bookNo; i++)
        books[i] = bsToCopy.books[i];
    }

    else
    {
        books = NULL;
    }
}

BookStore& BookStore:: operator=( const BookStore& right)
{
    if (&right != this)
    {
        bookNo = right.bookNo;
        if (bookNo != 0)
        {
            books = new Book [bookNo] ;
            for(int i = 0; i < bookNo; i++)
            {
                books[i] = right.books[i];
            }
        }

        else
        {
            books = NULL;
        }
    }
    return *this;
}

Book& BookStore:: operator[](const string title)
{
  bool exist = false;
  int index;
  for(int i = 0; i < bookNo; i++)
  {
      if (books[i].title == title)
      {
          exist = true;
          index = i;
      }
  }

  if (!exist)
  {
      throw invalid_argument("Cannot access a non-existing book (" + title + ")");
  }
  return books[index];
}

void BookStore:: addBook( const string bookTitle, const double bookPrice )
{
    bool exist = false;
    for (int i = 0; i < bookNo ; i++)
    {
        if (books[i].title == bookTitle)
            exist = true;
    }

    if (exist)
        throw invalid_argument("Cannot add an already existing book (" + bookTitle + ")");

    else
    {
        bookNo++;
        Book* p = books;
        books = new Book[bookNo];
        for(int i = 0; i < bookNo - 1; i++)
        {
           books[i] = p[i];
        }
        Book b(bookTitle, bookPrice);
     //   b.editionYears = NULL;
        books[bookNo - 1] = b;
        delete[]p;
    }
}

 void BookStore:: removeBook( const string bookTitle )
 {
     bool exist = false;

     for (int i = 0; i < bookNo; i++)
     {
         if (books[i].title == bookTitle )
         {
             exist = true;
             for(int j=i; j<(bookNo-1); j++)
			{
				books[j]=books[j+1];
			}

            bookNo--;
         }
     }

     if(!exist)
     {
         throw invalid_argument("Cannot remove a non-existing book (" + bookTitle + ")");
     }
 }

ostream& operator<<( ostream& out, const BookStore& b )
{
   for (int i = 0; i < b.bookNo; i++)
   {
       cout<<b.books[i]<<endl;
   }
   return out;
}
