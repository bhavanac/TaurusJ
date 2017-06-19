package edu.ds.practice.TopCoder;

public class Combinations {

  public void combine(int start, String inputString, StringBuilder result) {
    for (int i = start; i < inputString.length(); ++i) {
      result.append(inputString.charAt(i));
      System.out.println(result);
      if (i < inputString.length()) {
        combine(i + 1, inputString, result);
      }
      result.setLength(result.length() - 1);
    }
  }
}