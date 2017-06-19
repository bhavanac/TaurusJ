package edu.ds.practice.TopCoder;

public class GameOfLife {
  public void gameOfLife(int[][] board) {
    // State machine rules
    // 0 -> dead to dead
    // 1 -> live to live
    // 2 -> live to dead
    // 3 -> dead to live
    for(int i=0; i<board.length;i++) {
      for(int j=0; j<board[i].length;j++) {
        calculateKCell(board,i,j);
      }
    }

    for(int i=0; i<board.length;i++) {
      for(int j=0; j<board[i].length;j++) {
        board[i][j] = board[i][j]%2;
      }
    }
  }

  // Returns 1 if it is live cell and 0 if it is dead cell
  void calculateKCell(int[][] board, int m, int n) {
    int liveCellsCount = 0;

    for (int i = m-1; i <= m+1 ; i++) {
      for (int j = n-1; j <= n+1 ; j++) {
        if (i == m && j == n) {
          continue;
        }

        if (inRange(board, i, j) && (board[i][j] == 1 || board[i][j] == 2)) {
          liveCellsCount++;
        }
      }
    }

    // Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    // Any live cell with two or three live neighbors lives on to the next generation.
    // Any live cell with more than three live neighbors dies, as if by over-population..
    if (board[m][n] == 1) {
      if (liveCellsCount < 2) {
        board[m][n] = 2; // return that it is dead;
      } else if (liveCellsCount == 2 || liveCellsCount == 3) {
        board[m][n] = 1; // return that it is still alive;
      } else if (liveCellsCount > 3) {
        board[m][n] = 2; // return that it dies
      }
    } else {
      //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
      if (liveCellsCount == 3) {
        board[m][n] = 3; // return that it is alive;
      }
    }
  }

  boolean inRange(int[][] board, int m, int n) {
    int rows = board.length;
    int columns = board[0].length;

    if ((m >= 0 && m <= rows-1) && (n >= 0 && n <= columns-1)) {
      return true;
    }
    return false;
  }
}