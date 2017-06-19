package edu.ds.practice.DP;

/**
 * Created by bchalla on 11/15/15.
 */
public class UglyNumbers {
  public int getNthUglyNumber(int n) {
    int i2 = 0, i3 = 0, i5 = 0;
    int nextUglyNumber = 1;
    int nextMultipleOf2 = 2;
    int nextMultipleOf3 = 3;
    int nextMultipleOf5 = 5;
    int[] uglyNumbers = new int[n+1];
    uglyNumbers[0] = 1;

    for (int i=1; i<n; i++) {
      nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
      uglyNumbers[i] = nextUglyNumber;
      if (nextUglyNumber == nextMultipleOf2) {
        i2 = i2+1;
        nextMultipleOf2 = uglyNumbers[i2]*2;
      }

      if (nextUglyNumber == nextMultipleOf3) {
        i3 = i3+1;
        nextMultipleOf3 = uglyNumbers[i3]*3;
      }

      if (nextUglyNumber == nextMultipleOf5) {
        i5 = i5+1;
        nextMultipleOf5 = uglyNumbers[i5]*5;
      }
    }

    return nextUglyNumber;
  }
}
