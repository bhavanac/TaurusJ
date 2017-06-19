package edu.ds.practice.Coursera.Sort;


/**
 * Created by bchalla on 8/26/15.
 */
public class QuickSort {
  public static void sort(Comparable[] arr) {
    quickSortHelper(arr, 0, arr.length - 1);
  }

  private static void quickSortHelper(Comparable[] arr, int low, int high) {
    if (high <= low) {
      return;
    }

    Comparable key = arr[low];
    int index = findPivot(arr, key, low+1, high);
    SortUtils.swap(arr, low, index);
    quickSortHelper(arr, low, index-1);
    quickSortHelper(arr, index+1, high);
  }

  private static int findPivot(Comparable[] arr, Comparable key, int low, int high) {
    int i = low;
    int j = high;

    while (i <= j) {
      while (i <= high && SortUtils.less(arr[i], key)) {
        i++;
      }

      while (j >= low && SortUtils.less(key, arr[j])) {
        j--;
      }

      if (i < j) {
        SortUtils.swap(arr, i, j);
      }
    }

    return j;
  }
}
