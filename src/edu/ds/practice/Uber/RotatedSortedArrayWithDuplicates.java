package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/11/15.
 */
public class RotatedSortedArrayWithDuplicates {
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    return searchHelper(nums, 0, nums.length-1, target);
  }

  private boolean searchHelper(int[] nums, int low, int high, int target) {
    if (low > high) return false;

    int mid = ((high-low)/2)+low;
    if (nums[mid] == target) return true;

    // This means right side is sorted
    if (nums[mid] < nums[high]) {
      if (target > nums[mid] && target <= nums[high]) {
        return searchHelper(nums, mid+1, high, target);
      } else {
        return searchHelper(nums, low, mid-1, target);
      }
    }
    // This means left side is sorted
    else if (nums[mid] > nums[low]) {
      if (target >= nums[low] && target < nums[mid]) {
        return searchHelper(nums, low, mid-1, target);
      } else {
        return searchHelper(nums, mid+1, high, target);
      }
    }
    // This means nums[mid] == nums[low] == nums[high]
    else {
      return searchHelper(nums, mid+1, high, target) ||
          searchHelper(nums, low, mid-1, target);
    }
  }
}
