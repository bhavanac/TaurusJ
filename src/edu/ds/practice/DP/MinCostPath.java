package edu.ds.practice.DP;

/**
 * Created by bchalla on 11/15/15.
 */
public class MinCostPath {
  public int minCostPath(int[][] matrix, int m, int n) {
    // Maintain another matrix [m+1][n+1] in this way
    // dp[m][n] gives the cost to reach m, n from 0,0

    int[][] dp = new int[matrix.length][matrix[0].length];

    // Initialize the column costs
    for (int i=1; i<=m; i++) {
      dp[i][0] = dp[i-1][0] + matrix[i][0];
    }

    // Initialize the row costs
    for (int i = 0; i <= n; i++) {
      dp[0][i] = dp[0][i-1] + matrix[0][i];
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+matrix[i][j];
      }
    }

    return dp[m][n];
  }
}
