package edu.ds.practice.FB;

public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    return (Math.abs(s.length() - t.length()) <= 2) && isOneEditDistanceHelper(s, t, s.length(), t.length());
  }

  private boolean isOneEditDistanceHelper(String s, String t, int m, int n) {
    while (m > 0 && n > 0 && s.charAt(m-1) == t.charAt(n-1)) {
      m--;
      n--;
    }
    if (m == 0) return n == 1;
    if (n == 0) return m == 1;

    return (s.substring(0, m).equals(t.substring(0, n-1))) // Insert
        || (s.substring(0, m-1).equals(t.substring(0, n))) // Remove
        || (s.substring(0, m-1).equals(t.substring(0, n-1))); // Replace
  }
}
