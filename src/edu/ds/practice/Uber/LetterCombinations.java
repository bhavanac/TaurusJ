package edu.ds.practice.Uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LetterCombinations {
  public List<String> letterCombinations(String digits) {
    HashMap<Character, char[]> map = new HashMap<Character, char[]>();
    map.put('2', "abc".toCharArray());
    map.put('3', "def".toCharArray());
    map.put('4', "ghi".toCharArray());
    map.put('5', "jkl".toCharArray());
    map.put('6', "mno".toCharArray());
    map.put('7', "pqrs".toCharArray());
    map.put('8', "tuv".toCharArray());
    map.put('9', "wxyz".toCharArray());

    return letterCombinationsHelper(digits, map, 0);
  }

  public List<String> letterCombinationsHelper(String digits, HashMap<Character, char[]> map, int start) {
    if (start >= digits.length() || !map.containsKey(digits.charAt(start))) {
      return new ArrayList<String>();
    }

    char[] currentChars = map.get(digits.charAt(start));
    List<String> currentStrs = letterCombinationsHelper(digits, map, start+1);
    List<String> resultStrs = new ArrayList<String>();
    for (int i = 0; i<currentChars.length; i++) {
      System.out.println(currentChars[i]);
      if (currentStrs != null && currentStrs.size() > 0) {
        Iterator<String> iterator = currentStrs.iterator();
        while (iterator.hasNext()) {
          resultStrs.add(currentChars[i] + iterator.next());
        }
      } else {
        resultStrs.add(currentChars[i]+"");
      }
    }
    return resultStrs;
  }
}
