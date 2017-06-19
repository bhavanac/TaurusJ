package edu.ds.practice.TwoSigma;

public class PowerOf4 {
  public boolean isPowerOfFour(int num) {
    return Integer.toString(num, 4).matches("10*");
  }
}
