package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/11/15.
 */
public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    int m = s== null ? 0 : s.length();
    int n = t== null ? 0 : t.length();

    if (Math.abs(m-n) > 1) return false;
    int i=0,j=0;
    while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
      i++;
      j++;
    }

    if (i == s.length()) return (t.length()-j == 1);
    if (j == t.length()) return (s.length()-i == 1);

    return s.substring(i+(s.length()>=t.length() ? 1: 0)).equals(t.substring(j+(t.length()>=s.length()?1:0)));
  }
}
