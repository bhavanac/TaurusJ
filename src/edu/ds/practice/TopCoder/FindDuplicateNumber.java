package edu.ds.practice.TopCoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FindDuplicateNumber {
  public int findDuplicate(int[] nums) {
    quickSort(nums);
    int duplicateNumber = 0;
    for(int i=1;i<nums.length;i++) {
      if (nums[i] == nums[i-1]) {
        duplicateNumber = nums[i];
        break;
      }
    }
    return duplicateNumber;
  }

  void quickSort(int[] nums) {
    if (nums.length == 0) {
      return;
    }
    quickSortHelper(nums, 0, nums.length-1);
  }

  void quickSortHelper(int[] nums, int low, int high) {
    if (high <= low) {
      return;
    }

    int pivot = findPivot(nums, low, high);
    // swap pivot with low
    int temp = nums[low];
    nums[low] = nums[pivot];
    nums[pivot] = temp;

    quickSortHelper(nums, low, pivot-1);
    quickSortHelper(nums, pivot+1, high);
  }

  int findPivot(int[] nums, int low, int high) {
    int index = low;
    int i = low+1;
    int j = high;

    while(i <= j) {
      while(i <= high && nums[i] <= nums[index]) {
        i++;
      }

      while(j >= low+1 && nums[j] >= nums[index]) {
        j--;
      }

      if (i < j) {
        // swap them
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }

    return j;
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int i=0;i<nums.length;i++) {
      if (map.containsKey(Integer.valueOf(nums[i]))) {
        return new int[]{map.get(Integer.valueOf(nums[i]))+1,i+1};
      }
      map.put(Integer.valueOf(target-nums[i]),i);
    }

    return null;
  }

  public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if (nums.length < 3) {
      return list;
    }

    quickSort(nums);
    for(int i=0;i<nums.length-2;i++) {
      if(i != 0 && nums[i] == nums[i-1]) {
        continue;
      }

      List<List<Integer>> listTwoSums = findTwoSum(nums, i);
      if (listTwoSums != null && listTwoSums.size() > 0) {
        for(List<Integer> listTwoSum: listTwoSums) {
          List<Integer> newList = new ArrayList<Integer>();
          newList.add(nums[i]);
          newList.addAll(listTwoSum);
          list.add(newList);
        }
      }
    }

    return list;
  }

  public List<List<Integer>> findTwoSum(int[] nums, int start) {
    int target = 0-nums[start];
    int i = start+1;
    int j = nums.length-1;


    List<List<Integer>> list = new ArrayList<List<Integer>>();
    while(i < nums.length-1 && j > start && i<j) {
      if (nums[i]+nums[j] > target) {
        j--;
      } else if (nums[i]+nums[j] < target) {
        i++;
      } else {
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(nums[i]);
        newList.add(nums[j]);
        list.add(newList);
        i++;
        j--;
      }
    }

    return null;
  }



}
