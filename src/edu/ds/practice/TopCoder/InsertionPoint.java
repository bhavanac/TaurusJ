package edu.ds.practice.TopCoder;

/**
 * Created by bchalla on 10/19/15.
 */
public class InsertionPoint {
  public char findInsPoint(String sortedString, char c)
  {
    char[] list = sortedString.toCharArray();
    return list[findInsPointHelper(list, 0, list.length-1, c)%list.length];
  }

  int findInsPointHelper(char[] list, int low, int high, char c) {
    while (low < high) {
      int mid = ((high-low)/2) + low;
      if ( c < list[mid]) {
        high = mid-1;
      } else if (c > list[mid]) {
        low = mid+1;
      } else {
        return mid+1;
      }
    }

    return (c < list[low])  ? low : low+1;
  }
}
