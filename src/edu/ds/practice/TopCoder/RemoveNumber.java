package edu.ds.practice.TopCoder;

/**
 * Created by bchalla on 10/9/15.
 */
public class RemoveNumber {
  public boolean isNumber(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }

    s = s.trim();
    // The first character can be +, -, .
    // Once you see ., you can never see a . again
    int index = 0;
    boolean dotEncountered = false;
    if(s.length() > 0) {
      if(s.charAt(index) == '+' || s.charAt(index) == '-') {
        index++;
      }
    } else {
      return false;
    }

    while(index < s.length()) {
      if (s.charAt(index) == '.') {
        if (dotEncountered || (s.length() == 1)) {
          return false;
        } else {
          dotEncountered = true;
          index++;
        }
      } else if (s.charAt(index)-'0' >= 0 && s.charAt(index)-'0' <= 9) {
        index++;
      } else if (s.charAt(index) == 'e' && index != 0 && index != s.length()-1) {
        // After e we should have an integer only, but it can be positive or negative
        index++;
        dotEncountered = true;
        if (index < s.length()-1 && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
          index++;
        }
      } else {
        return false;
      }
    }
    return true;
  }
}
