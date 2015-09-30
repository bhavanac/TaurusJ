package edu.ds.practice.Coursera.Sort;

import edu.ds.practice.Coursera.BasicTypes.IndexMinPQ;
import java.util.List;
import java.util.Stack;


public class MergeSortedStreams {
  public static void merge(List<Stack<Integer>> streams) {
    if (streams == null || streams.size() == 0) {
      return;
    }

    IndexMinPQ<Integer> minPQ = new IndexMinPQ<Integer>(streams.size());
    int index = 0;
    while(index < streams.size()) {
      if (streams.get(index) != null) {
        minPQ.insert(index, streams.get(index).pop());
      }
      index++;
    }

    System.out.println("Index MinPQ");
    while(!minPQ.isEmpty()) {
      int minIndex = minPQ.minIndex();
      System.out.print(minPQ.min() + " ");

      Integer nextElement = streams.get(minIndex).empty() ? null : streams.get(minIndex).pop();
      if (nextElement != null) {
        minPQ.change(minIndex, nextElement);
      } else {
        minPQ.delMin();
      }
    }
  }
}
