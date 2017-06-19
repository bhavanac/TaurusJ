package edu.ds.practice.FB;

public class RegularExpression {
  public static boolean isMatch(String s, String p) {
    if (p.length() == 0) {
      return s.length() == 0;
    }

    // CASE 1 if p's length is 1
    // CASE 2 if p's second char is *
    if (p.length() == 1 || p.charAt(1) != '*') {
      // Length of string cannot be less than 0
      if (s.length() < 1) return false;

        // Characters in s and p are not equal OR p's char is not . return false
      else if ((s.charAt(0) != p.charAt(0)) && (p.charAt(0) != '.')) { return false; }

        // Check substrings of remaining string
      else {
        return isMatch(s.substring(1), p.substring(1));
      }
    }

    // Special CASE where second char is a *
    else {
      // [a-Z]* can match 0 characters also
      if (isMatch(s, p.substring(2)))  { return true; }

      int i = 0;
      while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
        if (isMatch(s.substring(i+1), p.substring(2))) { return true; }
        i++;
      }
      return false;
    }
  }
}