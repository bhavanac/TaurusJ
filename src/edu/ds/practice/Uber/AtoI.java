package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/11/15.
 */
public class AtoI {
  public int mynormalAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }

    str = str.trim();
    int index = 0;
    boolean positive = true;
    if (str.charAt(index) == '+') {
      index++;
    } else if (str.charAt(index) == '-') {
      positive = false;
      index++;
    }

    int number = 0;
    while (index < str.length()) {
      int digit = getChar(str, index);
      if (digit == -1) return 0;

      number += (digit * Math.pow(10, str.length()-index-1));
      index++;
    }


    return (!positive ? (-1) * number : number);
  }

  private int getChar(String str, int index) {
    int digit = str.charAt(index) - '0';
    if (digit >= 0 && digit <= 9) {
      return digit;
    }

    return -1;
  }




  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }

    str = str.trim();
    System.out.println(str);
    int index = 0;
    boolean positive = true;
    if (str.charAt(index) == '+') {
      index++;
    } else if (str.charAt(index) == '-') {
      positive = false;
      index++;
    }

    long number = 0;
    int endIndex = findEndIndex(str, index);
    while (index < endIndex) {
      // This is for cases 12iii -> should return 12
      int digit = str.charAt(index) - '0';
      if (!(digit >= 0 && digit <= 9)) {
        break;
      }

      // Instead of doing Math.pow(10, place), we do this to see if the number
      // is going out of range for Int
      int place = endIndex - index - 1;
      long intermediate = digit;
      while (place != 0) {
        if (!isInIntRange(intermediate * 10L)) {
          return positive ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        intermediate *= 10;
        place--;
      }

      // After getting the intermediate number, we need to check if the number+intermediate is still in init range
      // Otherwise return MAx and Min values
      if (!isInIntRange(number + intermediate)) {
        return positive ? Integer.MAX_VALUE: Integer.MIN_VALUE;
      }
      number += intermediate;
      index++;
    }
    return (int) (!positive ? (-1) * number : number);
  }

  private boolean isInIntRange(long l) {
    if (l > Integer.MAX_VALUE) {
      return false;
    }
    return true;
  }

  private int findEndIndex(String str, int beginIndex) {
    int index = beginIndex;
    while (index < str.length()) {
      int digit = str.charAt(index) - '0';
      if (!(digit >= 0 && digit <= 9)) {
        return index;
      }
      index++;
    }
    return index;
  }
}
