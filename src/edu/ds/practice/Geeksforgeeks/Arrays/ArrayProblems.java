package edu.ds.practice.Geeksforgeeks.Arrays;

import java.util.HashMap;

/**
 * Created by bchalla on 8/16/15.
 */
public class ArrayProblems {
  public static boolean doesPairExist(int[] arr, int sum) {
    if (arr == null || arr.length == 0) {
      return false;
    }

    HashMap<Integer, Integer> pairSum = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
      if (pairSum.containsKey(arr[i])) {
        return true;
      }

      pairSum.put(sum-arr[i], arr[i]);
    }
    return false;
  }

  public static int getOddOccurence(int[] arr) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    int result =0;
    for (int i = 0; i < arr.length; i++) {
      result = result ^ arr[i];
    }

    return result;
  }

  public static int largestSumContigousSubarray (int[] arr) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    int max_sum = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int max_sum_till_here = max_sum + arr[i] > arr[i] ? max_sum + arr[i] : arr[i];
      if (max_sum_till_here > max_sum) {
        max_sum = max_sum_till_here;
      }
    }
    return max_sum;
  }

  public static int largestProductSubarry (int[] arr) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    int result_product = 1;
    int max_product = 1;
    int min_product = 1;

    for (int i = 0; i < arr.length; i++) {
      // Case if number is 0
      if (arr[i] == 0) {
        max_product = 1;
        min_product = 1;
      }

      if (arr[i] > 0) {
        // Case 1 - if number is positive
        max_product = max_product * arr[i];
        min_product = Math.min(min_product * arr[i], 1);
      } else {
        // Case 2 - if number is negative
        int x = max_product;
        max_product = Math.max(min_product * arr[i], 1);
        min_product = x * arr[i];
      }

      if (result_product < max_product) {
        result_product = max_product;
      }

      System.out.println("max: " + max_product + " min: " + min_product + " result: " + result_product);
    }

    return result_product;
  }

  public static int missingNumber(int[] arr) {
    int xor1 = 1;
    int xor2 = arr[0];

    for (int i = 1; i < arr.length; i++) {
      xor2 = xor2^arr[i];
    }

    for (int i = 2; i <= arr.length+1; i++) {
      xor1 = xor1^i;
    }

    return xor1^xor2;
  }

  public static int findNumberSortedRotatedArray(int[] arr, int key) {
    return findNumber(arr, 0, arr.length-1, key);
  }

  private static int findNumber(int[] arr, int low, int high, int key) {
    if (low > high) {
      return -1;
    }
    int mid = low+((high-low)/2);
    if (arr[mid] == key) {
      return mid;
    }
    if (arr[mid] < arr[high]) {
      if (key > arr[mid] && key <= arr[high]) {
        return findNumber(arr, mid+1, high, key);
      } else {
        return findNumber(arr, low, mid-1, key);
      }
    } else {
      if (key > arr[low] && key < arr[mid]) {
        return findNumber(arr, low, mid-1, key);
      } else {
        return findNumber(arr, mid+1, high, key);
      }
    }
  }

  public static int[] mergeArrays(int[] mn, int[] n, int sizem, int sizen) {
    int i = sizem-1;
    int j = sizen-1;
    int k = mn.length-1;

    while (k >= 0) {
      if (i < 0) {
        mn[k] = n[j];
        j--;
      } else if (j < 0) {
        mn[k] = mn[i];
        i--;
      } else if (mn[i] > n[j]) {
        mn[k] = mn[i];
        i--;
      } else {
        mn[k] = n[j];
        j--;
      }
      k--;
    }
    return mn;
  }

  public static int medianOfTwoSortedArrays(int[] m, int[] n) {
    return medianHelper(m, n, 0, m.length, 0, n.length);
  }

  private static int medianHelper(int[] m, int[] n, int lowm, int highm, int lown, int highn) {
    int indexm = lowm + ((highm - lowm)/2);
    int indexn = lown + ((highn - lown)/2);
    int median1 = m[indexm];
    int median2 = n[indexn];

    if (median1 == median2) {
      return median1;
    }

    if (highm-lowm == 1 && highn-lown == 1) {
      return ((Math.max(m[lowm], n[lown])) + (Math.min(m[highm], n[highn])))/2;
    }

    if (median1 > median2) {
      return medianHelper(m, n, lowm, indexm, indexn, highn);
    } else {
      return medianHelper(m, n, indexm, highm, lown, indexn);
    }
  }

  public static int[] rotateArray(int[] m, int d) {
    return ArrayUtils.reverse(ArrayUtils.reverse(ArrayUtils.reverse(m, 0, d-1), d, m.length-1), 0, m.length-1);
  }
}
