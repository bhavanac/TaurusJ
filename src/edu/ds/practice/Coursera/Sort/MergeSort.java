package edu.ds.practice.Coursera.Sort;

/**
 * Created by bchalla on 8/26/15.
 */
public class MergeSort {
  /*
   * Merge sort works the following way. We use divide and conquer. Divide the array into two partitions
   * Sort them separately and merge them. This requires an auxilary space, but it still has the time
   * complexity of o(log n)
   */
  public static void sort(Comparable[] arr) {
    mergeSortHelper(arr, 0, arr.length-1);
  }

  private static void mergeSortHelper(Comparable[] arr, int low, int high) {
    if (high <= low) {
      return;
    }

    int mid = low + (high-low)/2;
    mergeSortHelper(arr, low, mid);
    mergeSortHelper(arr, mid+1, high);
    merge(arr, low, mid, high);
  }

  private static void merge(Comparable[] arr, int low, int mid, int high) {
    Comparable[] aux = new Comparable[arr.length];
    for (int i = low; i <= high; i++) {
      aux[i] = arr[i];
    }

    int j = low;
    int k = mid+1;
    for (int i = low; i <=high ; i++) {
      if (j > mid) {
        arr[i] = aux[k++];
      } else if (k > high) {
        arr[i] = aux[j++];
      } else if (SortUtils.less(aux[j], aux[k])) {
        arr[i] = aux[j++];
      } else {
        arr[i] = aux[k++];
      }
    }
  }
}
