package edu.ds.practice.TopCoder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by bchalla on 10/25/15.
 */
public class NumDecodings {
  public int numDecodings(String s) {
      if (s == null || s.length() == 0) {
        return 0;
      }

      int n = s.length();
      int[] memo = new int[n+1];
      memo[n] = 1;
      memo[n-1] = s.charAt(n-1) != 0 ? 1: 0;

    print(memo);

      for (int i=n-2; i>=0; i--) {
        if (s.charAt(i) == 0) continue;
        memo[i] = (Integer.parseInt(s.substring(i,i+2)) <= 26) ? memo[i+1]+memo[i+2] : memo[i+1];
        print(memo);

        List<Integer> list = new ArrayList<Integer>();

      }

      return memo[0];
    }

  void print(int[] memo) {
    for (int i=0;i<memo.length;i++) {
      System.out.print(memo[i] + " ");
    }
    System.out.println();
  }

}
