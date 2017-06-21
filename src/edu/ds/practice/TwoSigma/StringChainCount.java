package edu.ds.practice.TwoSigma;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class StringChainCount {
  public int chainCount(String[] words) {
    Arrays.sort(words, (Comparator<String>) (s1, s2) -> s1.length() - s2.length());
    Set<String> set = new HashSet<>();
    for (int i = 0; i < words.length; i++) {
      set.add(words[i]);
    }

    int max = Integer.MIN_VALUE;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      int chainCount = calculateChainCount(words[i], set, map);
      map.put(words[i], chainCount);
      max = Math.max(max, chainCount);
    }
    return max;
  }

  private int calculateChainCount(String word, Set<String> set, Map<String, Integer> map) {
    // BASE CASES
    if (!set.contains(word)) return 0;
    if (word.length() == 1) return 1;

    int index = 0;
    int max = Integer.MIN_VALUE;
    while (index < word.length()) {
      String nextWord = word.substring(0, index) + word.substring(index+1);
      int chainCount = map.getOrDefault(nextWord, calculateChainCount(nextWord, set, map));
      map.put(nextWord, chainCount);
      max = Math.max(max, chainCount);
      index++;
    }

    return max+1;
  }
}
