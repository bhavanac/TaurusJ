package edu.ds.practice.DP;

/**
 * Created by bchalla on 11/15/15.
 */
public class LongestIncreasingSubsequence {
  public int longestIncreasingSubsequence(int[] n) {
    int[] dp = new int[n.length+1];

    for (int i = 0; i < n.length; i++) {
      int max_ending_here = 1;
      for (int j = 0; j < i; j++) {
        if (n[j] <= n[i]) {
          max_ending_here = Math.max(dp[j] + 1, max_ending_here);
        }
      }
      dp[i] = max_ending_here;
    }

    // Pick max of all dp values;
    int maxSoFar = 1;
    for (int i = 0; i < n.length; i++) {
      maxSoFar = Math.max(maxSoFar, dp[i]);
    }

    return maxSoFar;
  }
}
