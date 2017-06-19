package edu.ds.practice.TopCoder;

/**
 * Created by bchalla on 10/12/15.
 */
public class reverseNumber {
    public int reverse(int x) {
      if (x == 0) {
        return 0;
      }

      while (x%10 == 0) {
        x = x/10;
      }

      boolean positive = true;
      if (x < 0) {
        positive = false;
        // Edge case if it is equal to Integer.MIN_VALUE, then reverse integer overflows, so return 0 now.
        if (x == Integer.MIN_VALUE) {
          return 0;
        }
        x = x*-1;
      }

      int val = reverseHelper(x);
      return (positive ? val : (-1*val));
    }

    private int reverseHelper(int x) {
      long sum = 0;
      while(x != 0) {
        long digit = x%10;
        x = x/10;
        if (!inRange((sum*10)+digit)) {
          return 0;
        }
        sum = (sum*10)+digit;
      }
      return (int) sum;
    }

    private boolean inRange(long x) {
      if (x > Integer.MAX_VALUE) {
        return false;
      }
      return true;
    }
  }

