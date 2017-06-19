package edu.ds.practice.FB;

import java.util.Arrays;
import java.util.Comparator;


public class MeetingIntervals {
  class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

  public boolean canAttendMeetings(Interval[] intervals) {
    if (intervals.length == 1) return true;
    Arrays.sort(intervals, new IntervalComparator());

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i-1].end > intervals[i].start) return false;
    }

    return true;
  }

  class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
      return o1.start - o2.start;
    }
  }
}
