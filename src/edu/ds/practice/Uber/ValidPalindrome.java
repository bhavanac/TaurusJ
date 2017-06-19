package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/11/15.
 */
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    int len = s.length();
    int i = 0;
    int j = len-1;
    while (i < len && j >= 0 && i < j) {
      while (i < len && !isAlphaNumeric(s.charAt(i))) {
        i++;
      }
      while (j >= 0 && !isAlphaNumeric(s.charAt(j))) {
        j--;
      }

      if (!(i < len && j >= 0 && i < j)) break;
      if (s.charAt(i) != Character.toUpperCase(s.charAt(j)) && s.charAt(i) != Character.toLowerCase(s.charAt(j))) return false;
      i++;
      j--;
    }
    return true;
  }

  private boolean isAlphaNumeric(char c) {
    if ((c-'a' >= 0 && c-'a' <= 26) || (c-'A' >= 0 && c-'A' <= 26) || (c-'0' >= 0 && c-'0' <= 9)) {
      return true;
    }
    return false;
  }
}
