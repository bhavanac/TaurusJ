package edu.ds.practice.FB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;


public class LetterCombinationsOfPhoneNumber {
  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) return new ArrayList<>();

    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    int index = 0; int current = 0;
    Queue<String> queue = new LinkedList<>();
    String value = map.get(digits.charAt(index++));
    char[] values = value.toCharArray();
    while (current < value.length()) {
      queue.add(String.valueOf(values[current]));
      current++;
    }

    while (index < digits.length()) {
      if (!map.containsKey(digits.charAt(index))) return new ArrayList<>();

      Queue<String> nextQueue = new LinkedList<>();
      value = map.get(digits.charAt(index));
      while (!queue.isEmpty()) {
        String element = queue.poll();
        current = 0;
        while (current < value.length()) {
          nextQueue.add(element+value.charAt(current));
          current++;
        }
      }
      queue = nextQueue;
      index++;
    }
    return queue.stream().collect(Collectors.toList());
  }
}
