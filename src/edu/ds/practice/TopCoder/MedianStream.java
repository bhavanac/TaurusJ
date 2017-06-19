package edu.ds.practice.TopCoder;

import java.util.PriorityQueue;


/**
 * Created by bchalla on 10/20/15.
 */
public class MedianStream {
  private PriorityQueue<Integer> minH = new PriorityQueue<Integer>();
  private PriorityQueue<Integer> maxH = new PriorityQueue<Integer>(1, (o1, o2) -> o2.compareTo(o1));

  // Adds a number into the data structure.
  public void addNum(int num) {

    // If both PQs are empty, add it to maxHeap;
    if (minH.size() == 0 && maxH.size() == 0) {
      maxH.offer(num);
    } else if (minH.size() == maxH.size()) {
      // If minHeap == maxHeap. Check min element from minHeap and see if it is less than the num
      int minHnum = minH.peek();
      if (minHnum < num) {
        maxH.offer(minH.poll());
        minH.offer(num);
      } else {
        maxH.offer(num);
      }
    } else if (maxH.size() > minH.size()) {
      int maxHnum = maxH.peek();
      if (maxHnum > num) {
        minH.offer(maxH.poll());
        maxH.offer(num);
      } else {
        minH.offer(num);
      }
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (maxH.size() == 0 && minH.size() == 0) {
      return 0.0;
    } else if (maxH.size() > minH.size()) {
      return maxH.peek();
    } else {
      return ((maxH.peek() + minH.peek())/2.0);
    }
  }

}
