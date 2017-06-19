package edu.ds.practice.Geeksforgeeks.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    int curr_sum = 0;
    int max_sum_till_here = 0;
    for (int i = 0; i < arr.length; i++) {
      curr_sum = curr_sum + arr[i];
      if (curr_sum > max_sum_till_here) {
        max_sum_till_here = curr_sum;
      }

      if (curr_sum < 0) {
        curr_sum = 0;
      }
    }
    return max_sum_till_here;
  }

  public static int largestProductSubarry (int[] arr) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    Integer.valueOf('2');

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

  public static int maxSumNoTwoNumbersAreAdjacent(int[] m) {
    int incl=m[0];
    int excl=0;

    for (int i = 0; i < m.length; i++) {
      int oldincl = incl;
      incl = excl + m[i];
      excl = Math.max(oldincl, excl);
    }

    return Math.max(incl, excl);
  }

  public static void printLeaders(int[] m) {
    int max = Integer.MIN_VALUE;
    System.out.println();
    for (int i = m.length-1; i >= 0; i--) {
      if (m[i] > max) {
        System.out.print(m[i] + " ");
        max = m[i];
      }
    }
  }

  class Element implements Comparable<Element> {
    int value;
    int first_index;
    int count;

    public Element(int value, int first_index) {
      this.value = value;
      this.first_index = first_index;
      this.count = 1;
    }


    @Override
    public int compareTo(Element o) {
      if (this.count > o.count) {
        return 1;
      } else if (this.count < o.count) {
        return -1;
      } else {
        // compare their first indices
        if (this.first_index < o.first_index) {
          return 1;
        } else {
          return -1;
        }
      }
    }
  }

  public int[] decreasingFrequencyOrder(int[] m) {
    HashMap<Integer, Element> counts = new HashMap<Integer, Element>();
    for (int i = 0; i < m.length; i++) {
      if (counts.containsKey(m[i])) {
        // If it contains key, just update the count
        counts.get(m[i]).count++;
      } else {
        Element element = new Element(m[i], i);
        counts.put(m[i], element);
      }
    }

    TreeMap<Integer, Element> sortedElements = sortByValue(counts);
    int index = 0;
    for(Map.Entry<Integer, Element> entry: sortedElements.descendingMap().entrySet()) {
      Element element = entry.getValue();
      int count = element.count;
      while (count > 0) {
        m[index++] = element.value;
        count--;
      }
    }

    return m;
  }

  private TreeMap<Integer, Element> sortByValue(HashMap<Integer, Element> counts) {
    ValueComparator valueComparator = new ValueComparator(counts);
    TreeMap<Integer, Element> treeMap = new TreeMap<Integer, Element>(valueComparator);
    treeMap.putAll(counts);
    return treeMap;
  }

  private class ValueComparator implements Comparator{
    Map map;

    public ValueComparator(Map map) {
      this.map = map;
    }

    @Override
    public int compare(Object keyA, Object keyB) {
      Comparable valueA = (Comparable) map.get(keyA);
      Comparable valueB = (Comparable) map.get(keyB);
      return valueA.compareTo(valueB);
    }
  }

  public void minAbsolutePair(List<Integer> list) {
    int min_leftIndex = 0;
    int min_rightIndex = list.size()-1;
    int min_absoluteSum = Integer.MAX_VALUE;

    Collections.sort(list);
    int leftIndex = 0;
    int rightIndex = list.size()-1;
    while(leftIndex > rightIndex) {
      int currentSum = list.get(leftIndex) + list.get(rightIndex);

      if (currentSum > 0) {
        rightIndex--;
      } else {
        leftIndex ++;
      }

      if (Math.abs(currentSum) < Math.abs(min_absoluteSum)) {
        min_absoluteSum = currentSum;
        min_leftIndex = leftIndex;
        min_rightIndex = rightIndex;
      }
    }

    System.out.println("Left Index - " + list.get(min_leftIndex) + " Right Index - " + list.get(min_rightIndex) + " Min Sum - " + min_absoluteSum);
  }

  public void smallestAndSecondSmallest(int[] m) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int i = 0; i < m.length; i++) {
      if (m[i] < first) {
        second = first;
        first = m[i];
      } else if (m[i] < second && m[i] != first) {
        second = m[i];
      }
    }

    System.out.println("First smallest - " + first + ", Second smallest - " + second);
  }

  public boolean majorityElementInSortedArray(int[] m, int x) {
    int first_index = binarySearch(m, 0, m.length-1, x);
    System.out.println("First Index - " + first_index);

    int minCount = m.length/2;

    if (first_index == -1) {
      return false;
    }

    if (first_index+minCount < m.length -1 && m[first_index + minCount] == x) {
      return true;
    }

    return false;
  }

  private int binarySearch(int[] m, int start, int end, int x) {
    // if there are only two elements and both are not equal to x, return -1
    if (end < start) {
      return -1;
    }

    if (end-start <= 1) {
      if (m[end] != x && m[start] != x) {
        return -1;
      }
      return (m[end] == x ? end : start);
    }

    // Recursion for binary search
    int mid = start + (end-start)/2;
    if (m[mid] >= x) {
      return binarySearch(m, start, mid, x);
    } else {
      return binarySearch(m, mid, end, x);
    }
  }

  public int[] segregate0sAnd1s(int[] m) {
    int left = 0;
    int right = m.length-1;

    while (left < right) {
      while(m[left] == 0) {
        left++;
      }
      while(m[right] == 1) {
        right--;
      }

      if (left < right) {
        ArrayUtils.swap(m, left, right);
      }
    }

    return m;
  }
}
