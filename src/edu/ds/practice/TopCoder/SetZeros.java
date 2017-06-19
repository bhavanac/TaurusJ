package edu.ds.practice.TopCoder;

/**
 * Created by bchalla on 10/4/15.
 */
public class SetZeros {
  public void setZeroes(int[][] matrix) {
    int col0 = matrix[0][0];
    int row0 = matrix[0][0];
    int rows = matrix.length;
    int cols = matrix[0].length;

    // Calculate row0 and col0
    for (int i=0;i<rows;i++) {
      if(matrix[i][0] == 0) {
        col0 = 0;
      }
    }

    for (int i=0;i<cols;i++) {
      if (matrix[0][i] == 0) {
        row0 = 0;
      }
    }



    for (int i = 1; i < rows; i++) {
      cols = matrix[i].length;
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = matrix[0][j] = 0;
        }
      }
    }

    // Make all zero rows 0
    for (int i = 1; i < rows; i++) {
      if (matrix[i][0] == 0) {
        cols = matrix[i].length;
        for (int j = 1; j < cols; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    // Make all zero columns 0
    cols = matrix[0].length;
    for (int i = 1; i < cols; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < rows; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    // Now do row0 and col0
    if (row0 == 0) {
      cols = matrix[0].length;
      for(int k=0; k<cols; k++) {
        matrix[0][k] = 0;
      }
    }
    if (col0 == 0) {
      rows = matrix.length;
      for (int k=0; k<rows; k++) {
        matrix[k][0] = 0;
      }
    }
  }
}
