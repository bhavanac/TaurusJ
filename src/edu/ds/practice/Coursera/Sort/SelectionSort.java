package edu.ds.practice.Coursera.Sort;

/**
 * Created by bchalla on 7/25/15.
 */
public class SelectionSort {
  public static void sort(Comparable[] arr) {
    if (arr == null || arr.length == 0 ) {
      return;
    }

    int minimumIndex;
    for (int i = 0; i < arr.length; i++) {
      minimumIndex = i;
      for (int j = i; j < arr.length; j++) {
        if (!SortUtils.less(arr[minimumIndex], arr[j])){
          minimumIndex = j;
        }
      }
      // swap arr[i] with arr[minimumIndex]
      Comparable temp = arr[i];
      arr[i] = arr[minimumIndex];
      arr[minimumIndex] = temp;
    }

    // Result after sort
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
