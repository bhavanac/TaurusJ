package edu.ds.practice.FB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class RemoveAndMakeValidParanthesis {
  public List<String> removeInvalidParentheses(String s) {
    List<String> res = new ArrayList<>();
    if (s == null) return null;

    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    queue.add(s);
    visited.add(s);

    boolean found = false; // this is the find the level at which we found answer. so don't generate variations after that
    while (!queue.isEmpty()) {
      // First check if the queue.poll() is valid or not, if not, then get all variations of it by removing one leve
      String element = queue.poll();
      if (isValid(element)) {
        res.add(element);
        found = true;
      }

      if (found) continue;
      for (int i = 0; i < element.length(); i++) {
        if (!(element.charAt(i) == ')' || element.charAt(i) == '(')) continue;

        String temp = element.substring(0, i) + element.substring(i+1);

        if (!visited.contains(temp)) {
          queue.add(temp);
          visited.add(temp);
        }
      }
    }

    return res;
  }

  // helper function checks if string s contains valid parantheses
  boolean isValid(String s) {
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') count++;
      if (c == ')' && count-- == 0) return false;
    }

    return count == 0;
  }
}
