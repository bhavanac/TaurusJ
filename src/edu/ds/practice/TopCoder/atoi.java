package edu.ds.practice.TopCoder;

import edu.ds.practice.Coursera.BasicTypes.IndexMinPQ;


public class atoi {
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }

    str = str.trim();
    System.out.println(str);
    int index = 0;
    boolean positive = true;
    if (str.length() > 0) {
      if(str.charAt(index) == '+') {
        index++;
      } else if(str.charAt(index) == '-') {
        positive = false;
        index++;
      }
    } else {
      return 0;
    }

    long number = 0;
    int endIndex = findEndIndex(str, index);
    boolean outOfRange = false;
    while(index < endIndex) {
      int digit = str.charAt(index) - '0';
      if (!(digit >= 0 && digit <= 9)) {
        break;
      }
      int place = endIndex-index-1;
      long intermediate = digit;
      while(place != 0) {
        if (!isInIntRange(intermediate*10L)) {
          outOfRange = true;
          break;
        }
        intermediate*=10;
        place--;
      }
      if (!isInIntRange(number+intermediate)) {
        outOfRange = true;
        break;
      }
      number+=intermediate;
      index++;
    }

    if (outOfRange && !positive) {
      return Integer.MIN_VALUE;
    } else if (outOfRange && positive) {
      return Integer.MAX_VALUE;
    } else {
      return (int) (!positive ? (-1)*number : number);
    }
  }

  private boolean isInIntRange(long l) {
    if (l > Integer.MAX_VALUE) {
      return false;
    }
    return true;
  }

  private int findEndIndex(String str, int beginIndex) {
    int index = beginIndex;
    while(index < str.length()) {
      int digit = str.charAt(index) - '0';
      if (!(digit >= 0 && digit <= 9)) {
        return index;
      }
      index++;
    }
    return index;
  }
}
