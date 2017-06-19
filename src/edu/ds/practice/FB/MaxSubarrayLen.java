package edu.ds.practice.FB;

import java.util.HashMap;
import java.util.Map;


public class MaxSubarrayLen {
  public int maxSubArrayLen(int[] nums, int k) {
    int sum = 0, max = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) max = Math.max(max, i+1);
      if (map.containsKey(sum-k)) {
        max = Math.max(max, (i - map.get(sum-k)));
      }
      if (!map.containsKey(nums[i])) map.put(nums[i],i);
    }
    return max;
  }
}
