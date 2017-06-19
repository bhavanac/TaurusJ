package edu.ds.practice.FB;

public class MoveZeros {
  public void moveZeroes(int[] nums) {
    int index = 0;
    int runner = 0;
    while (runner < nums.length) {
      while (runner < nums.length && nums[runner] == 0) runner++;
      if (runner >= nums.length) break;
      nums[index++] = nums[runner++];
    }

    while (index < nums.length) {
      nums[index++] = 0;
    }
  }
}
