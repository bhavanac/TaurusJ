package edu.ds.practice.TopCoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MinimumWindowSubstring {
  public String minWindow3(String s, String t) {
    if (s==null || t==null || s.length() == 0 || t.length() == 0) {
      return "";
    }

    int m = s.length();
    int n = t.length();
    if (n > m) {
      return "";
    }

    int[] require = new int[128];
    for (int i=0;i<128;i++) {
      require[i]=0;
    }

    for (int i=0; i<n; i++) {
      require[t.charAt(i)]++;
    }

    int minIndex = 0;
    int minLength = Integer.MIN_VALUE;
    int count = 0;
    for(int sIndex=0,e=0; e<m; e++) {
      require[s.charAt(e)]--;
      if (require[s.charAt(e)] >=0) count++;
      while(count == n) {
        if (e-sIndex+1 < minLength) {
          minLength = e-sIndex+1;
          minIndex = sIndex;
        }

        require[s.charAt(sIndex)]++;
        if (require[s.charAt(sIndex)] > 0) {
          count--;
        }
        sIndex++;
      }
    }

    if (minLength == Integer.MIN_VALUE) {
      return "";
    }
    return s.substring(minIndex, minIndex+minLength);
  }




  public String minWindow(String s, String t) {
    if (s == null || s.length() == 0 || t == null || t.length() == 0)
    {
      return "";
    }

    System.out.println(s);

    int m = s.length();
    int n = t.length();
    if (n <= 0 || m < n) return "";


    int require[] = new int[128];
    for (int i=0;i<128;i++) {
      require[i] = 0;
    }

    for (int i = 0; i < n; ++i) {
      require[t.charAt(i)]++;
    }

    int count = 0;
    int minLen = Integer.MAX_VALUE, minIndex = 0;
    for (int sIndex = 0, e = 0; e < m; ++e) {
      require[s.charAt(e)]--;
      if (require[s.charAt(e)] >= 0) count++;
      while (count == n) {
        if (e - sIndex + 1 < minLen) {
          minLen = e - sIndex + 1;
          minIndex = sIndex;
        }
        require[s.charAt(sIndex)]++;
        if (require[s.charAt(sIndex)] > 0) count--;
        sIndex++;
      }
    }

    if (minLen == Integer.MAX_VALUE) return "";
    return s.substring(minIndex, minIndex+minLen);
  }


  public String minWindow2(String s, String t) {
    if (s == null || s.length() == 0 || t == null || t.length() == 0)
    {
      return "";
    }
    int tCount = t.length();
    int sCount = s.length();
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    Set<Character> set = new HashSet<Character>();

    for (int i=0;i<tCount;i++) {
      map.put(t.charAt(i), map.containsKey(t.charAt(i)) ? map.get(t.charAt(i))+1 : 1);
      set.add(t.charAt(i));
    }

    // "ADOBECODEBANC"
    // "AABC"
    int minIndex = 0;

    int finalMinIndex = 0;
    int minLength = Integer.MAX_VALUE;
    int i = 0;
    while (i < sCount) {
      if (tCount > 0) {
        // This means we have not yet found all the characters in t in the string
        // so keep looking
        if (set.contains(s.charAt(i)) && map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > 0) {
          // This means we found a character which is needed
          tCount--;
          map.put(s.charAt(i), map.get(s.charAt(i))-1);
        }
        i++;
      } else {
        if (minLength > i-minIndex) {
          minLength = i-minIndex;
          finalMinIndex = minIndex;
        }

        map.put(s.charAt(minIndex), 1);
        if (set.contains(s.charAt(minIndex)) && map.containsKey(s.charAt(minIndex)) && map.get(s.charAt(minIndex)) >= 0) {
          tCount++;
        }

        minIndex++;
      }
    }

    if (minLength == Integer.MAX_VALUE)
    {
      return "";
    }
    return s.substring(finalMinIndex, finalMinIndex+minLength);
  }
}

