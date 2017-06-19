package edu.ds.practice.TwoSigma;

public class StringCompression {
  public String stringCompression(String s) {
    if (s == null || s.length() <= 1) return s;
    StringBuilder sb = new StringBuilder();
    int count = 1;
    int index = 0;
    while (index < s.length()) {
      while (index < s.length()-1 && (s.charAt(index) == s.charAt(index+1))) {
        index++;
        count++;
      }
      if (count == 1) {
        sb.append(s.charAt(index));
      } else {
        sb.append(s.charAt(index)+String.valueOf(count));
      }
      count = 1;
      index++;
    }

    return sb.toString();
  }
}
