package edu.ds.practice.Uber;

import java.util.HashSet;


/**
 * Created by bchalla on 11/11/15.
 */
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length != 9 || board[0].length != 9) {
      return false;
    }

    for (int i=0; i<board.length; i++) {
      HashSet<Character> rows = new HashSet<Character>();
      HashSet<Character> columns = new HashSet<Character>();
      HashSet<Character> cubes = new HashSet<Character>();
      for (int j=0; j<board[0].length; j++) {
        if (board[j][i] != '.' && !rows.add(board[j][i])) return false;
        if (board[i][j] != '.' && !columns.add(board[i][j])) return false;
        int rowIndex = 3*(i/3);
        int columnIndex = 3*(i%3);
        if (board[rowIndex+(j/3)][columnIndex+(j%3)] != '.' && !cubes.add(board[rowIndex+(j/3)][columnIndex+(j%3)])) {
          return false;
        }
      }
    }
    return true;

  }
}
