package edu.ds.practice.TopCoder;

/**
 * Created by bchalla on 10/17/15.
 */
public class SubsetSum {
  public boolean isSubsetSum(int[] nums, int sum) {
    if (nums == null || nums.length == 0 || sum < 0) {
      return false;
    }

    return isSubsetSumHelper(nums, nums.length-1, sum);
  }

  private boolean isSubsetSumHelper(int[] nums, int lastIndex, int sum) {
    // subset[i][j] is true if there is a subset of [0..j-1] with a sum equal to i
    boolean subset[][] = new boolean[sum+1][lastIndex+1];

    // If sum == 0, then it is true
    for(int i=0;i<=lastIndex;i++) {
      subset[0][i] = true;
    }


    // If sum != 0, with 0 element sin the subset, it is false
    for(int i=0;i<=sum;i++) {
      subset[i][0] = false;
    }

    // Fill the matrix in bottom up manner
    for (int i=1; i<=sum; i++) {
      for (int j=1; j<=lastIndex; j++) {
        subset[i][j] = subset[i][j-1];
        if (i > nums[j-1]) {
          subset[i][j] = subset[i][j] || subset[i-nums[j-1]][j-1];
        }
      }
    }

    return subset[sum][lastIndex];
  }
}
