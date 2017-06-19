package edu.ds.practice.DP;

/**
 * Created by bchalla on 11/19/15.
 */
public class UniquePaths {
  public int uniquePaths(int m, int n) {
    int[][] pathCount = new int[m][n];
    pathCount[0][0]=1;
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (j+1 < n) {
          pathCount[i][j+1] += pathCount[i][j];
        }

        if (i+1 < m) {
          pathCount[i+1][j] += pathCount[i][j];
        }
      }
    }
    return pathCount[m-1][n-1];
  }
}
