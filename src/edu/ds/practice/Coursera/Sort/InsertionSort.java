package edu.ds.practice.Coursera.Sort;

/**
 * Created by bchalla on 7/25/15.
 */
public class InsertionSort {

  public static void sort(Comparable[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = i-1; j >= 0; j--) {
        if (SortUtils.less(arr[j], arr[j+1])) {
          break;
        }
        SortUtils.swap(arr, j, j+1);
      }
    }

    // Result after sort
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
