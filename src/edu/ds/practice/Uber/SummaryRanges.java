package edu.ds.practice.Uber;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by bchalla on 11/11/15.
 */
public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<String>();
    if (nums == null || nums.length == 0) {
      return ranges;
    }

    int i = 0;
    int start_range = nums[0];
    int stop_range = Integer.MAX_VALUE;
    while (i<nums.length) {
      if (i == nums.length-1 || nums[i]+1 != nums[i+1]) {
        stop_range = nums[i];
        if (start_range == stop_range) {
          ranges.add(start_range+"");
        } else {
          ranges.add(start_range + "->" + stop_range);
        }

        if (i != nums.length-1 ) start_range = nums[i+1];
      }
      i++;
    }
    return ranges;
  }
}
