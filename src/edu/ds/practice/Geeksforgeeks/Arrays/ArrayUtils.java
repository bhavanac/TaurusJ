package edu.ds.practice.Geeksforgeeks.Arrays;

/**
 * Created by bchalla on 8/16/15.
 */
public class ArrayUtils {

  public static int[] reverse(int[] m, int low, int high) {
    while(low < high) {
      int temp = m[low];
      m[low] = m[high];
      m[high] = temp;
      low++;
      high--;
    }

    return m;
  }

}
