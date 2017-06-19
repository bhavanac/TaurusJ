package edu.ds.practice.FB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
  class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() == 1) return intervals;

    List<Interval> result = new ArrayList<>();
    intervals.sort(new IntervalComparator());

    for (int i = 0; i < intervals.size(); i++) {
      int j = i+1;
      int maxEnd = i;
      while (j < intervals.size() && (intervals.get(maxEnd).end >= intervals.get(j).start)) {
        maxEnd = intervals.get(maxEnd).end > intervals.get(j).end ? maxEnd : j;
        j++;
      }
      result.add(new Interval(intervals.get(i).start, intervals.get(maxEnd).end));
      i = j-1;
    }
    return result;
  }

  class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
      return o1.start - o2.start;
    }
  }
}
