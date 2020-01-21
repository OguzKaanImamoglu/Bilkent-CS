#include "LibrarySystem.h"
#include <iostream>
using namespace std;

main()
{
LibrarySystem LS;

LS.addBook( 1000, "Machine Learning", 2017 );
LS.addBook( 1200, "Data Mining", 2015 );
LS.addBook( 1300, "Problem S. with C++", 2015 );
LS.addBook( 1400, "C++ How to Program", 2016 );
LS.addBook( 1200, "Data Mining", 2015 );
LS.deleteBook( 1300 );
LS.deleteBook( 2000 );
LS.addBook( 1500, "Pattern Recognition", 2000 );
cout << endl;
LS.showAllBooks();
return 0;

}
