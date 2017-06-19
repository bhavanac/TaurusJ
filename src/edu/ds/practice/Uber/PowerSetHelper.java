package edu.ds.practice.Uber;

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
// set = {1,2,3}
// powerset = {{}, {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}}
import java.util.List;
import java.util.ArrayList;
class PowerSetHelper {
  public static List<List<Integer>> powerset(int[] nums) {
    if (nums.length == 0) {
      return null;
    }

    List<List<Integer>> results = new ArrayList<List<Integer>>();
    powerSetHelper(nums, 0, results, new ArrayList<Integer>());
    return results;
  }


  // result = {}, {1},{1,2}, {1,2,3} , {1,3}, {2, 3}, {2}, {1}
  // {}, {}, index = 0 => j=0, j<3 currrent -> {1}
  // 1, {1, 2} =>
  // 2, {1,2, 3} =>
  //


  public static void powerSetHelper(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
    result.add(new ArrayList<Integer>(current));

    for(int j=index; j<nums.length;j++) {
      current.add(nums[j]);
      powerSetHelper(nums, j+1, result, current);
      current.remove(current.size()-1);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3};
    List<List<Integer>> results = powerset(nums);
    System.out.println(results);
    for(int i = 0; i< results.size(); i++) {
      List<Integer> current = results.get(i);
      for (int j=0; j<current.size(); j++) {
        System.out.print(current.get(j));
      }
      System.out.println();
    }
  }
}
