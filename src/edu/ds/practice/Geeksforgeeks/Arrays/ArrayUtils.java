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

  public static void swapBlock(int[] m, int start1, int start2, int d) {
    while(d > 0) {
      int temp = m[start1];
      m[start1] = m[start2];
      m[start2] = temp;
      start1++;
      start2++;
      d--;
    }
  }

  public static void swap(int[] m, int left, int right) {
    int temp = m[left];
    m[left] = m[right];
    m[right] = temp;
  }
}
