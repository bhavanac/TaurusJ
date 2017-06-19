package edu.ds.practice;

public class TicTacToe {
  int[][] ticTacToe;

  /** Initialize your data structure here. */
  public TicTacToe(int n) {
    ticTacToe = new int[n][n];
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {
    ticTacToe[row][col] = player;
    return didThePlayerWin(player) ? player : 0;
  }

  public boolean didThePlayerWin(int player) {
    // diagonalCounts
    int n = ticTacToe.length;
    int diagonalCount = 0, otherDiagonalCount = 0;
    for (int i = 0; i < ticTacToe.length; i++) {
      int j, rowCount = 0, columnCount = 0;
      for (j = 0; j < ticTacToe[i].length; j++) {
        if (ticTacToe[i][j] == player) rowCount++;
        if (ticTacToe[j][i] == player) columnCount++;
      }
      if (rowCount == n || columnCount == n) return true;

      if (ticTacToe[i][i] == player) diagonalCount++;
      if (ticTacToe[i][n-1-i] == player) otherDiagonalCount++;
    }

    return (diagonalCount == n || otherDiagonalCount == n);
  }
}
