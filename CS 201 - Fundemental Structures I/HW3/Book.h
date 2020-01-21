#ifndef BOOK_H_INCLUDED
#define BOOK_H_INCLUDED
#include <string>
using namespace std;

class Book
{
    public:
   // Book();
    Book(string name, int no, int editon);
    ~Book();
    string getTitle();
    int getId();
    int getYear();

    private:
    int id;
    int year;
    string title;
};


#endif // BOOK_H_INCLUDED
