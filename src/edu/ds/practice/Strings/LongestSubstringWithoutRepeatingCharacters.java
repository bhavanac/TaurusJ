package edu.ds.practice.Strings;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
  public int longestLengthOfSubstring(String str) {
    /*
     * Given a string, find the length of the longest substring without repeating characters.
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
     * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     *
     * Map<Character, Index> map. We will store the characters in the string with indices.
     * Lets say we find a, which is in the middle, take the index
     * New Begin Index = index+1;
     * Remove old Begin Index till index from the map
     *
     */

    int len = str.length();
    int idx = 0;
    int beginIndex = 0;

    int longestLength = Integer.MIN_VALUE;
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    while (idx < len) {
      // If you find the character in the map already, we need to recompute it
      if (map.containsKey(str.charAt(idx))) {
        // Recompute the length till here and see if it greater than longer length
        if (longestLength < idx-beginIndex) longestLength = idx-beginIndex;

        int newBeginIndex = map.get(str.charAt(idx))+1;
        // Remove old values from the map
        int lastIndex = map.get(str.charAt(idx));
        for (int i = beginIndex; i <= lastIndex; i++) {
          map.remove(str.charAt(i));
        }
        beginIndex = newBeginIndex;
        map.put(str.charAt(idx), idx);
      } else {
        map.put(str.charAt(idx), idx);
      }
      idx++;
    }
    return longestLength;
  }
}
