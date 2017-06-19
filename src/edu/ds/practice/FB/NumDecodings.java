package edu.ds.practice.FB;

public class NumDecodings {
  public int numDecodings(String s) {
    if (s.length() <= 0) return s.length();
    if (s.length() == 1 && isValid(s, 0, 1)) return 1;
    if (s.length() == 2) {
      if (isValid(s, 0, 2) && (isValid(s, 0, 1) && isValid(s, 1, 2))) return 2;
      else if (isValid(s, 0, 2) || (isValid(s, 0, 1) && isValid(s, 1, 2))) return 1;
      else return 0;
    }

    int result = 0;
    if (isValid(s, 0, 1)) result += numDecodings(s.substring(1));
    if (s.length() >= 2 && isValid(s, 0, 2)) result += numDecodings(s.substring(2));
    return result;
  }

  boolean isValid(String s, int startIndex, int endIndex) {
    int number = getNumber(s, startIndex, endIndex);
    return ((number >= 1) && (number <= 26));
  }

  private int getNumber(String s, int startIndex, int endIndex) {
    int result = 0;
    for (int i = startIndex; i < endIndex; i++) {
      result *= 10;
      result += (s.charAt(i)-'0');
    }
    return result;
  }
}
