package edu.ds.practice.TopCoder;

/**
 * Created by bchalla on 10/17/15.
 */
public class MinSubarrayLength {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0 || s < 0) {
      return 0;
    }

    int count = s;
    int minLength = Integer.MAX_VALUE;
    for(int e=0,sIndex=0; e<nums.length; e++) {
      count = count - nums[e];
      while (count <= 0) {
        count = count + nums[sIndex];
        if (count >= 0 && e-sIndex+1 < minLength && e-sIndex+1 > 0) {
          minLength = e-sIndex+1;
        }

        sIndex++;
      }
    }

    if (minLength == Integer.MAX_VALUE) {
      return 0;
    }
    return minLength;
  }
}
