package edu.ds.practice.TopCoder;

import java.util.Deque;
import java.util.LinkedList;


/**
 * Created by bchalla on 11/8/15.
 */
public class Histogram {
    public int largestRectangleArea(int[] heights) {

      int maxArea = 0, currArea;
      Deque<Integer> stack = new LinkedList<Integer>();

      /*
       * [2,1,5,6,2,3]
       */


      for ( int i = 0; i <= heights.length; i++ ) {
        while ( !stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i]) ) {
          currArea = heights[stack.pop()] * (stack.isEmpty() ? i : (i-stack.peek()-1));
          maxArea = Math.max(maxArea, currArea);

          System.out.println("currArea - " + currArea + " maxArea - " + maxArea);
        }
        stack.push(i); // **
      }
      return maxArea;
    }
}
