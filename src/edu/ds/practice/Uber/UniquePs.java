package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/12/15.
 */
public class UniquePs {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (obstacleGrid[i][j] == 1) { obstacleGrid[i][j] = -1; }
      }
    }

    if (obstacleGrid[0][0] == 0) { obstacleGrid[0][0] = 1; }
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (obstacleGrid[i][j] == -1) {
          continue;
        }

        if (j+1 < n) {
          if (obstacleGrid[i][j+1] == -1) {
            obstacleGrid[i][j+1] = -1;
          } else {
            obstacleGrid[i][j+1] += obstacleGrid[i][j];
          }
        }

        if (i+1 < m) {
          if (obstacleGrid[i+1][j] == -1) {
            obstacleGrid[i+1][j] = -1;
          } else {
            obstacleGrid[i+1][j] += obstacleGrid[i][j];
          }
        }
      }
    }
    return (obstacleGrid[m-1][n-1] == -1 ? 0 : obstacleGrid[m-1][n-1]) ;
  }
}
