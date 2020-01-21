package lab05;

public class SOS 
{
   int a= 3;

   public static final int INVALID_ROWCOL = -1;
   public static final int ROWCOL_NOT_EMPTY = -2;
   public static final int INVALID_LETTER = -3;
   final char EMPTY = '.';
   
   private char[][] board;
   
   private int playerScore1;
   
   private int playerScore2;
   
   private int turn;
   
   private int availableCells;
   private int dimension;
   
   public SOS(int dimension)
   {
     this.dimension = dimension;
     board = new char[dimension][dimension];
     for (int i = 0; i < dimension; i++) 
     {
       for (int j = 0; j < dimension; j++) 
       {
         board[i][j] = 46;
       }
     }
     
     playerScore1 = 0;
     playerScore2 = 0;
     turn = 1;
     availableCells = (dimension * dimension);
   }
   
   public int getPlayerScore1()
   {
     return playerScore1;
   }
   
   public int getPlayerScore2()
   {
     return playerScore2;
   }

   private void increasePlayerScore(int increment)
   {
     if (turn == 1) 
     {
       playerScore1 += increment;
     } else 
     {
       playerScore2 += increment;
     }
   }
   


   private void changeTurn()
   {
     if (turn == 1) 
     {
       turn = 2;
     } else 
     {
       turn = 1;
     }
   }
   
   public int getTurn() 
   {
     return turn;
   }

   public boolean isGameOver()
   {
     if (availableCells == 0) 
     {
       return true;
     }
     return false;
   }
   
   public int play(char letter, int rowIndex, int columnIndex)
   {
     int roundScore = 0;
     

     rowIndex--;
     columnIndex--;
     

     if ((rowIndex < 0) || (rowIndex >= dimension) || (columnIndex < 0) || (columnIndex >= dimension))
     {
       return -1;
     }
     

     if (board[rowIndex][columnIndex] != '.') {
       return -2;
     }
     

     if (letter == 's')
     {
       board[rowIndex][columnIndex] = 115;
       availableCells -= 1;
       

       if ((dimension - rowIndex > 2) && 
         (board[(rowIndex + 1)][columnIndex] == 'o') && (board[(rowIndex + 2)][columnIndex] == 's'))
       {
         roundScore++;
       }
       

       if ((dimension - rowIndex > 2) && (columnIndex >= 2) && 
         (board[(rowIndex + 1)][(columnIndex - 1)] == 'o') && (board[(rowIndex + 2)][(columnIndex - 2)] == 's'))
       {
         roundScore++;
       }
       

       if ((columnIndex >= 2) && 
         (board[rowIndex][(columnIndex - 1)] == 'o') && (board[rowIndex][(columnIndex - 2)] == 's'))
       {
         roundScore++;
       }
       

       if ((rowIndex >= 2) && (columnIndex >= 2) && 
         (board[(rowIndex - 1)][(columnIndex - 1)] == 'o') && (board[(rowIndex - 2)][(columnIndex - 2)] == 's'))
       {
         roundScore++;
       }
       

       if ((rowIndex >= 2) && 
         (board[(rowIndex - 1)][columnIndex] == 'o') && (board[(rowIndex - 2)][columnIndex] == 's'))
       {
         roundScore++;
       }
       

       if ((rowIndex >= 2) && (dimension - columnIndex > 2) && 
         (board[(rowIndex - 1)][(columnIndex + 1)] == 'o') && (board[(rowIndex - 2)][(columnIndex + 2)] == 's'))
       {
         roundScore++;
       }
       

       if ((dimension - columnIndex > 2) && 
         (board[rowIndex][(columnIndex + 1)] == 'o') && (board[rowIndex][(columnIndex + 2)] == 's'))
       {
         roundScore++;
       }
       

       if ((dimension - rowIndex > 2) && (dimension - columnIndex > 2) && 
         (board[(rowIndex + 1)][(columnIndex + 1)] == 'o') && (board[(rowIndex + 2)][(columnIndex + 2)] == 's'))
       {
         roundScore++;
       }
       

     }
     else if (letter == 'o')
     {
       board[rowIndex][columnIndex] = 111;
       availableCells -= 1;
       

       if ((dimension - rowIndex > 1) && (rowIndex >= 1) && 
         (board[(rowIndex - 1)][columnIndex] == 's') && (board[(rowIndex + 1)][columnIndex] == 's'))
       {
         roundScore++;
       }
       

       if ((dimension - columnIndex > 1) && (columnIndex >= 1) && 
         (board[rowIndex][(columnIndex - 1)] == 's') && (board[rowIndex][(columnIndex + 1)] == 's'))
       {
         roundScore++;
       }
       

       if ((dimension - rowIndex > 1) && (rowIndex >= 1) && (dimension - columnIndex > 1) && (columnIndex >= 1))
       {

         if ((board[(rowIndex - 1)][(columnIndex - 1)] == 's') && (board[(rowIndex + 1)][(columnIndex + 1)] == 's'))
         {
           roundScore++;
         }
         if ((board[(rowIndex - 1)][(columnIndex + 1)] == 's') && (board[(rowIndex + 1)][(columnIndex - 1)] == 's'))
         {
           roundScore++;
         }
       }
     }
     else
     {
       return -3;
     }
     
     if (roundScore == 0) {
       changeTurn();
     } else
       increasePlayerScore(roundScore);
     return roundScore;
   }
   
   public void printBoard()
   {
     System.out.print("  ");
     for (int j = 1; j <= dimension; j++) {
       System.out.print(j + " ");
     }
     System.out.println();
     for (int i = 0; i < dimension; i++) {
       System.out.print(i + 1 + " ");
       for (int j = 0; j < dimension; j++) {
         System.out.print(board[i][j] + " ");
       }
       System.out.println();
     }
   }
   
   public char getCellContents(int x, int y)
   {
     return board[x][y];
   }
   
   public int getDimension()
   {
     return dimension;
   }  
 }
