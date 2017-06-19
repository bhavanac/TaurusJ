package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/11/15.
 */
public class ISMatch {
  public boolean isMatch(String s, String p) {
    int i = 0;
    int j = 0;
    int starPos = -1;
    int matchPos = -1;
    p += '#';
    while (i < s.length()) {
      //advancing both pointers when (both characters match) or ('?' found in pattern)
      if ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '?')) { i++; j++; continue; }

      // * found in pattern, track index of *, only advancing pattern pointer
      if (p.charAt(j) == '*') { starPos = j++; matchPos = i; continue; }

      //current characters didn't match, last pattern pointer was *, current pattern pointer is not *
      //only advancing string pointer
      if (starPos >= 0) { j = starPos + 1; i = ++matchPos; continue; }

      return false;
    }
    while (j < p.length() && p.charAt(j) == '*')
      j++;
    return j == p.length() - 1;
  }
}
