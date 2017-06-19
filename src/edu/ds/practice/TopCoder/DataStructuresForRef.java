package edu.ds.practice.TopCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


/**
 * Created by bchalla on 11/3/15.
 */
public class DataStructuresForRef {
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  Set<Integer> set = new HashSet<Integer>();
  Deque<Integer> deque = new LinkedList<Integer>();
  Stack<Character> stack = new Stack<Character>();


  // Break the line up into words. We define a word to be a sequence of non-whitespace characters
  String input = "hkhkhuhi";
  List<String> words = Arrays.asList(input.split("\\s"));

  public DataStructuresForRef() {

    // Hash Map
    // Put - for adding. Also it returns the previous value associated with the key.
    // containsKey - for searching
    // Remove - returns the key removed.
    map.put(1, 2);
    map.containsKey(1);
    map.remove(1);

    // Hash Set
    // Add - for adding. Also it returns true if the element was not already present. False otherwise
    set.add(1);
    set.contains(1);
    set.remove(1);

    // Deque
    // Double ended queue
    // element - retrieves but not removes the head of the queue, the first element in the queue
    // getFirst - same as above
    // removeFirst - removes the first element in the queue
    // removeLast - removes the last element in the queue
    // getLast - retrieves but not removes the tail of the queue
    // Offer - Adds at first
    deque.offer(1);


    // Priority Queue
    // Peek - just get the min/max accoriding to what we used
    // Poll - removes the min/max
    PriorityQueue<Integer> minH = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxH = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        int result = o1.compareTo(o2);
        if (result > 0) {
          return -1;
        } else if (result < 0) {
          return 1;
        } else {
          return 0;
        }
      }
    });

    int minHnum = minH.peek();
    if (minHnum < 1) {
      maxH.offer(minH.poll());
    }





    StringBuilder output = new StringBuilder();
    output.append(System.getProperty("line.separator")); // append the line separator
  }



}
