package edu.ds.practice.DP;

/**
 * Created by bchalla on 11/15/15.
 */
public class MaximumSquareSubMatrix {
  public int maximumSquareSubMatrix(int[][] matrix) {
    // Maintain another matrix [m+1][n+1] in this way
    // dp[m][n] gives the size of the matrix formed by using the 1 (if any, otherwise 0) in the matrix[m-1][n-1]
    int m = matrix.length;
    if (m < 1) return 0;

    int n = matrix[0].length;

    int[][] dp = new int[m+1][n+1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (matrix[i-1][j-1] == 1) {
          dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
        }
      }
    }

    return dp[m][n];
  }
}
