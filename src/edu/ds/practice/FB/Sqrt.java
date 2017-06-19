package edu.ds.practice.FB;

public class Sqrt {
  public int mySqrt(int x) {
    int start = 0, end = x;
    int ans = x;
    while (end > start) {
      int mid = end + (start-end)/2;
      if (mid <= x/mid)  {
        ans = mid;
        start = mid+1;
      } else {
        end = mid-1;
      }
    }
    return ans;
  }
}
