package edu.ds.practice.TopCoder;

import java.util.List;


/**
 * Created by bchalla on 10/21/15.
 */
public class TwoDBoardWord {
  public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for (int y=0; y<board.length; y++) {
      for (int x=0; x<board[y].length; x++) {
        if (exist(board, y, x, w, 0)) return true;
      }
    }
    return false;
  }

  private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    if (i == word.length) return true;
    if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    if (board[y][x] != word[i]) return false;
    board[y][x] ^= 256;
    boolean exist = exist(board, y, x+1, word, i+1)
        || exist(board, y, x-1, word, i+1)
        || exist(board, y+1, x, word, i+1)
        || exist(board, y-1, x, word, i+1);
    board[y][x] ^= 256;
    return exist;
  }



  public boolean exist2(char[][] board, String word) {
    if (word == null || word.length() == 0) {
      return false;
    }

    char[] chars = word.toCharArray();
    boolean[][] visited = new boolean[board.length][];
    for (int i=0; i<board.length; i++) {
      visited[i] = new boolean[board[i].length];
      for (int j=0;j<visited[i].length;j++) {
        visited[i][j] = false;
      }
    }

    for (int i=0; i<board.length;i++) {
      for (int j=0; j<board[i].length;j++) {
        if (board[i][j] == chars[0]) {
          if (chars.length == 1) return true;

          visited[i][j] = true;
          if (checkIfExists(board,visited, chars, i,j, 1)) {
            return true;
          }
          visited[i][j] = false;
        }
      }
    }

    return false;
  }

  private boolean checkIfExists(char[][] board, boolean[][] visited, char[] chars, int i, int j, int index) {
    if (index < chars.length) {
      char temp = chars[index];
      if (valid(board, i, j-1) && !visited[i][j-1] && board[i][j-1] == temp) {
        visited[i][j-1] = true;
        if (checkIfExists(board, visited, chars, i,j-1,index+1)) {
          return true;
        }
        visited[i][j-1] = false;
      }

      if (valid(board, i-1, j) && !visited[i-1][j] && board[i-1][j] == temp) {
        visited[i-1][j] = true;
        if (checkIfExists(board, visited, chars, i-1,j,index+1)) {
         return true;
        }
        visited[i-1][j] = false;
      }

      if (valid(board, i, j+1) && !visited[i][j+1] && board[i][j+1] == temp) {
        visited[i][j+1] = true;
        if (checkIfExists(board, visited, chars, i,j+1,index+1)) {
          return true;
        }
        visited[i][j+1] = false;
      }

      if (valid(board, i+1, j) && !visited[i+1][j] && board[i+1][j] == temp) {
        visited[i+1][j] = true;
        if (checkIfExists(board, visited, chars, i+1,j,index+1)) {
          return true;
        }
        visited[i+1][j] = false;
      }
    } else {
      return true;
    }
    return false;
  }

  private boolean valid(char[][] board, int i, int j) {
    if (i < 0 || i>=board.length) {
      return false;
    }

    if (j < 0 || j>=board[i].length) {
      return false;
    }


    List<Integer> blah;
    return true;
  }
}
