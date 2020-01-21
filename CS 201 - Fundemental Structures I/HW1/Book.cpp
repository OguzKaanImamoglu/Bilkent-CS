#include <iostream>
using namespace std;
//#include<Book.h>
#include "Book.h"
#include <bits/stdc++.h>
#include <string>

Book:: Book (const string bookTitle /*=""*/, const double bookPrice /*= 0*/)
{
    title = bookTitle;
    price = bookPrice;
    editionNo = 0;
    editionYears = NULL;
}

Book :: ~Book()
{
    if(editionYears)
        delete [] editionYears;
}

Book :: Book (const Book& bookToCopy)
{
    title = bookToCopy.title;
    price = bookToCopy.price;
    editionNo = bookToCopy.editionNo;

    if(editionNo != 0)
    {
       editionYears = new int[editionNo];
       for(int i = 0; i < editionNo; i++)
        editionYears[i] = bookToCopy.editionYears[i];
    }

    else
    {
        editionYears = NULL;
    }
}

Book& Book:: operator =(const Book& right)
{
    if (&right != this)
    {
       title = right.title;
       price = right.price;
       editionNo = right.editionNo ;

        if(editionNo != 0)
        {
           editionYears = new int[editionNo];
           for(int i = 0; i < editionNo; i++)
           editionYears[i] = right.editionYears[i];
        }

        else
        {
            editionYears = NULL;
        }
    }
    return *this;
}

void Book:: addEdition( const int newEditionYear )
{
    editionNo++;
    int* p = editionYears;

    editionYears = new int [editionNo];
    for(int i = 0; i < editionNo - 1; i++)
    {
        editionYears[i] =p[i];
    }
    editionYears[editionNo-1] = newEditionYear;
    delete [] p;
}

ostream& operator<<( ostream& out, const Book& book )
{
    if (book.editionNo == 0)
    {
        cout<<book.title << ", " <<book.price << " TL  (None)" << endl;
    }

    else if (book.editionNo == 1)
    {
        cout<<book.title << ", " <<book.price << " TL  (" << book.editionYears[0] << " )" << endl;
    }

    else
    {
        cout<<book.title << ", " <<book.price << " TL  (";

        for (int i = 0; i < book.editionNo - 1 ; i++)
            cout<< book.editionYears[i] << ", " ;
        cout<<book.editionYears[book.editionNo - 1] << " )" << endl;
    }
    return out;
}

istream& operator>>(istream& in, Book& b)
{
    string s;
    int x = 0;
    cout<<"Enter all edition years for " << b.title << endl;
    getline(cin,s);
    delete [] b.editionYears;
    b.editionNo = 0;
    b.editionYears = new int (b.editionNo);

    // Vector of string to save tokens
    vector <string> tokens;

    // stringstream class check1
    stringstream check1(s);

    string intermediate;

    // Tokenizing w.r.t. space ' '
//    while(getline(check1, intermediate, ' '))
//    {
//        tokens.push_back(intermediate);
//    }

     for(int i = 0; i < s.length(); i++)
     {

         if (s.at(i) != ' ')
         {
             for(int j = i; j < s.length(); j++)
             {
                 if (s.at(j) == ' ' || j == s.length() - 1)
                 {
                     tokens.push_back(s.substr(i,j + 1));
                     i = j;
                     break;
                 }
             }
         }
     }

     for(int i = 0; i < tokens.size(); i++)
     {
         stringstream convert(tokens[i]);
         convert >> x;
         b.addEdition(x);
     }


 return in;
}
