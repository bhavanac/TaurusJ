package edu.ds.practice.Coursera.Sort;

import java.util.Random;

/**
 * Created by bchalla on 7/26/15.
 */
public class ShuffleSort {
  public static void shuffle(Comparable[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    Random random = new Random();
    for (int i = 1; i < arr.length; i++) {
      int r = random.nextInt(i);
      SortUtils.swap(arr, r, i);
    }

    // Result after sort
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
