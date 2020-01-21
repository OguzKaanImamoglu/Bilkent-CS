#ifndef LIBRARYSYSTEM_H_INCLUDED
#define LIBRARYSYSTEM_H_INCLUDED
#include <string>
using namespace std;

class LibrarySystem
{
    public:
    LibrarySystem();
    ~LibrarySystem();
    void addBook( const int bookId, const string name, const int year );
    void deleteBook( const int bookId );
    void showAllBooks();
};
#endif // LIBRARYSYSTEM_H_INCLUDED
