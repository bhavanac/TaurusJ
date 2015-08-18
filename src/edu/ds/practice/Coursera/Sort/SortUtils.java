package edu.ds.practice.Coursera.Sort;

/**
 * Created by bchalla on 7/25/15.
 */
public class SortUtils {

  public static boolean less(Comparable item1, Comparable item2) {
    if (item1.compareTo(item2) != 1) {
      return true;
    }
    return false;
  }

  public static void swap(Comparable[] arr, int index1, int index2) {
    Comparable temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

}
