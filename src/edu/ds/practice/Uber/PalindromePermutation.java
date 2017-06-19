package edu.ds.practice.Uber;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
  public boolean canPermutePalindrome(String s) {
    Set<Character> charSet = new HashSet<Character>();
    for (int i=0; i<s.length(); i++) {
      if (charSet.contains(s.charAt(i))) {
        charSet.remove(s.charAt(i));
      } else {
        charSet.add(s.charAt(i));
      }
    }

    return (charSet.size() == 0 || charSet.size() == 1);
  }
}
