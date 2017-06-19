package edu.ds.practice.TwoSigma;

public class GameOfLife {
  public void gameOfLife(int[][] board) {
    int m = board.length;
    for (int i=0; i < board.length; i++) {
      int n = board[i].length;
      for (int j=0; j < board[i].length; j++) {
        int live = 0;
        int dead = 0;
        // top, left, bottom, right
        if (isInternal(i-1,j,m,n))  { if (board[i-1][j] == 1 || board[i-1][j] == -1) live++; else dead++; }
        if (isInternal(i+1,j,m,n))  { if (board[i+1][j] == 1 || board[i+1][j] == -1) live++; else dead++; }
        if (isInternal(i,j-1,m,n))  { if (board[i][j-1] == 1 || board[i][j-1] == -1) live++; else dead++; }
        if (isInternal(i,j+1,m,n))  { if (board[i][j+1] == 1 || board[i][j+1] == -1) live++; else dead++; }

        // diagonal
        if (isInternal(i-1,j-1,m,n))  { if (board[i-1][j-1] == 1 || board[i-1][j-1] == -1) live++; else dead++; }
        if (isInternal(i-1,j+1,m,n))  { if (board[i-1][j+1] == 1 || board[i-1][j+1] == -1) live++; else dead++; }
        if (isInternal(i+1,j-1,m,n))  { if (board[i+1][j-1] == 1 || board[i+1][j-1] == -1) live++; else dead++; }
        if (isInternal(i+1,j+1,m,n))  { if (board[i+1][j+1] == 1 || board[i+1][j+1] == -1) live++; else dead++; }

        if (board[i][j] == 1) {
          if (live < 2) board[i][j] = -1;
          if (live > 3) board[i][j] = -1;
        } else {
          if (live == 3) board[i][j] = 2;
        }
      }
    }

    for (int i=0; i < board.length; i++) {
      for (int j=0; j < board[i].length; j++) {
        if (board[i][j] == -1) board[i][j] = 0;
        else if (board[i][j] == 2) board[i][j] = 1;
      }
    }
  }

  boolean isInternal(int i, int j, int m, int n) {
    return (i>=0 && i<m) && (j>=0 && j<n);
  }
}
