package edu.ds.practice;

public class AllTypesOfQuickSorts {
  public static void quickSort(Comparable[] a) {
    quickSortHelper(a, 0, a.length-1);

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]+ " ");
    }
  }

  private static void quickSortHelper(Comparable[] a, int low, int high) {
    if (high <= low) return;

    int index = findPivot(a, low, high);
    quickSortHelper(a, low, index-1);
    quickSortHelper(a, index+1, high);
  }

  private static int findPivot(Comparable[] a, int low, int high) {
    // Solve this corner case to have clean code below
    if (high-low == 1) {
      if (lessThan(a[low], a[high])) return low;
      exch(a, low, high);
      return low;
    }

    Comparable v = a[low];

    int i = low;
    int j = high+1;

    while (true) {
      while(lessThan(a[++i], v)) {
        if (i >= high) break;
      }

      while (lessThan(v, a[--j])) {
        if (j <= low) break;
      }

      if (j <= i) break;

      exch(a, i, j);
    }
    exch(a, low, j);
    return j;
  }

  private static boolean lessThan(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
