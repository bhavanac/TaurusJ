package edu.ds.practice.TopCoder;

import java.util.Deque;
import java.util.LinkedList;


public class MaxSlidingWindow {
   /*
    Deque - Double ended queue
    add -> adds element at the tail
    addFirst -> adds element at the head;
    addLast -> adds element at the tail;

    element -> peek element at the head
    getFirst -> peek element at the head
    getLast -> peek element at the tail

    remove -> removes element at the head
    removeFirst -> removes element at the head
    removeLast -> removes element at the tail

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

    */



  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return nums;
    }

    Deque<Integer> deque = new LinkedList<Integer>();
    int windowStart = 0;
    int windowEnd = k-1;
    int[] result = new int[nums.length-k+1];
    int resultIndex = 0;
    for (int i=0;i<nums.length;i++) {
      if (!deque.isEmpty() && deque.element() < windowStart) {
        deque.removeFirst();
      }

      if (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
        deque.removeLast();
      }

      deque.offer(i);

      if (i == windowEnd) {
        result[resultIndex++] = nums[deque.getFirst()];
        windowStart++;
        windowEnd++;
      }
    }

    return result;
  }
}
