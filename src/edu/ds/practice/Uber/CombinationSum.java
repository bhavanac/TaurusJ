package edu.ds.practice.Uber;

import edu.ds.practice.Geeksforgeeks.Arrays.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by bchalla on 12/3/15.
 */
public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    sort(candidates);
    return combinationSumHelper(candidates, 0, target);
  }

  public List<List<Integer>> combinationSumHelper(int[] candidates, int start, int target) {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    if (target == 0 || start == candidates.length) {
      return results;
    }

    // Now try to repeat the number at i as many times as possible, then call the method recursively with the remaining sum
    for (int i = start; i<candidates.length; i++) {
      int multiply = 1;
      int temp = candidates[i];
      while(temp <= target) {
        if (temp == target) {
          List<Integer> result = new ArrayList<Integer>();
          for (int j=0; j<multiply; j++) {
            result.add(candidates[i]);
          }
          results.add(result);
        } else {
          List<List<Integer>> intermediate = combinationSumHelper(candidates, i+1, target-temp);
          Iterator<List<Integer>> iterator = intermediate.iterator();
          while (iterator.hasNext()) {
            List<Integer> result = new ArrayList<Integer>();
            for (int j=0; j<multiply; j++) {
              result.add(candidates[i]);
            }
            result.addAll(iterator.next());
            results.add(result);
          }
        }
        multiply++;
        temp = temp + candidates[i];
      }
    }
    return results;
  }

  void sort(int[] arr) {
    mergeSortHelper(arr, 0, arr.length-1);
  }

  private void mergeSortHelper(int[] arr, int low, int high) {
    if (high <= low) {
      return;
    }

    int mid = low + (high-low)/2;
    mergeSortHelper(arr, low, mid);
    mergeSortHelper(arr, mid+1, high);
    merge(arr, low, mid, high);
  }

  private void merge(int[] arr, int low, int mid, int high) {
    int[] aux = new int[arr.length];
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
      } else if (aux[j] < aux[k]) {
        arr[i] = aux[j++];
      } else {
        arr[i] = aux[k++];
      }
    }
  }
}
