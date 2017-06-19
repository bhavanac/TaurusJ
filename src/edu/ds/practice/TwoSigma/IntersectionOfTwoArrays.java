package edu.ds.practice.TwoSigma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IntersectionOfTwoArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
    }

    for (int i = 0; i < nums2.length; i++) {
      if (map.containsKey(nums2[i])) {
        result.add(nums2[i]);
        map.remove(nums2[i]);
      }
    }
    return result.stream().mapToInt(i->i).toArray();
  }
}
