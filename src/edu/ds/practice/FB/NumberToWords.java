package edu.ds.practice.FB;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NumberToWords {
  public static String numberToWords(int num) {
    Map<Integer, String> map = new HashMap<>();
    map.put(0, "");
    map.put(1, "Thousand");
    map.put(2, "Million");
    map.put(3, "Billion");
    map.put(4, "Trillion");
    int level = 0;
    StringBuilder sb = new StringBuilder();
    while (num != 0) {
      if (num%1000 == 0) {level++; continue;}
      sb.insert(0, map.get(level)+" ");
      sb.insert(0, convert(num%1000)+" ");
      num = num/1000;
      level++;
    }

    return sb.toString().trim();
  }

  static  String convert(int num) {
    String[] numbers = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] hundreds = {"One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred", "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"};
    Map<Integer, String> special = new HashMap<>();
    special.put(11, "Eleven");
    special.put(12, "Twelve");
    special.put(13, "Thirteen");
    special.put(14, "Fourteen");
    special.put(15, "Fifteen");
    special.put(16, "Sixteen");
    special.put(17, "Seventeen");
    special.put(18, "Eighteen");
    special.put(19, "Nineteen");
    special.put(20, "Twenty");
    Map<Integer, List<String>> map = new HashMap<>();
    map.put(0, Arrays.asList(numbers));
    map.put(1, Arrays.asList(tens));
    map.put(2, Arrays.asList(hundreds));
    StringBuilder sb = new StringBuilder();
    int level = 0;
    // Special case
    if (special.containsKey(num%100)) { sb.insert(0, special.get(num%100) + " "); num = num/100; level = level+2; }
    while (num != 0) {
      if (num%10 == 0) { level++; continue; }
      sb.insert(0, (map.get(level).get((num%10)-1)) + " ");
      level++;
      num = num/10;
    }
    return sb.toString().trim();
  }
}
