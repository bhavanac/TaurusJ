package edu.ds.practice.FB;

public class SparseMatrix {
  public int[][] multiply(int[][] A, int[][] B) {
    int[][] result = new int[A.length][];

    for (int i = 0; i < A.length; i++) {
      int b = A[i].length;
      result[i] = new int[b];
      for (int j = 0; j < b; j++) {
        for (int k = 0; k < b; k++) {
          result[i][j] += (A[i][k] * B[k][j]);
        }
      }
    }
    return result;
  }
}
