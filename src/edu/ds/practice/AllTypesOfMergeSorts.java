package edu.ds.practice;

public class AllTypesOfMergeSorts {
  private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
    for (int i = low; i <= high; i++) {
      aux[i] = a[i];
    }

    int i = low;
    int j = mid+1;
    for (int k = low; k <= high; k++) {
      if (i > mid) a[k] = aux[j++];
      else if (j > high) a[k] = aux[i++];
      else if (lessThan(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];
    }
  }

  // Merge sort Top down
  public static void mergeTD(Comparable[] a) {
    if (a == null || !(a.length > 1)) return;

    Comparable[] aux = new Comparable[a.length];
    mergeTDHelper(a, aux, 0, a.length-1);


    // Result after sort
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
  }

  // Merge sort Top down
  public static void mergeSortBottomUp(Comparable[] a) {
    if (a == null || !(a.length > 1)) return;

    int n = a.length;
    Comparable[] aux = new Comparable[a.length];

    for (int len=1; len<n; len*=2) {
      for (int i = 0; i < n - len; i+=(len+len)) {
        int low = i;
        int mid = i+len-1;
        int high = Math.min(mid+len, n-1);
        merge(a, aux, low, mid, high);
      }
    }

    // Result after sort
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
  }

  private static void mergeTDHelper(Comparable[] a, Comparable[] aux, int low, int high) {
    if (high <= low) return;

    int mid = low + (high-low)/2;
    mergeTDHelper(a, aux, low, mid);
    mergeTDHelper(a, aux, mid+1, high);
    merge(a, aux, low, mid, high);
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
