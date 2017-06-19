package edu.ds.practice.DP;

/**
 * Created by bchalla on 11/19/15.
 */
public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    int i = 0;
    int j = 0;
    int starPos = -1;
    int matchPos = -1;
    p += '#';
    while (i < s.length()) {
      if ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '?')) { i++; j++; continue; }
      if (p.charAt(j) == '*') { starPos = j++; matchPos = i; continue; }
      if (starPos >= 0) { j = starPos + 1; i = ++matchPos; continue; }
      return false;
    }
    while (j < p.length() && p.charAt(j) == '*')
      j++;
    return j == p.length() - 1;
  }
}
