package edu.ds.practice.FB;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MinMeetingRooms {
  public class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
  }

  public int minMeetingRooms(Interval[] intervals) {
    if (intervals.length == 0) return 0;

    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });

    PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.length, (Comparator<Interval>) (o1, o2) -> o1.end - o2.end);

    queue.offer(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      Interval interval = queue.poll();
      if (intervals[i].start >= interval.end) {
        interval.end = intervals[i].end;
      } else {
        queue.offer(intervals[i]);
      }
      queue.offer(interval);
    }
    return queue.size();
  }
}
