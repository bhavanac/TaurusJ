package edu.ds.practice.Uber;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by bchalla on 11/12/15.
 */
public class HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<Integer>();
    set.add(n);
    // If it ends in a single digit number and not equal to 1, then return false;
    while (n != 1) {
      int result = 0;

      while (n != 0) {
        result += (n%10)*(n%10);
        n = n/10;
      }

      n = result;
      if (set.contains(n)) return false;
      set.add(result);
    }
    return true;
  }
}
