package edu.ds.practice.FB;

public class MinimumWindow {
  public String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";
    char[] schars = new char[256]; //schars will always hold the current window counts
    char[] tchars = new char[256]; //tchars will always hold all the t counts;

    for (int i = 0; i < t.length(); i++) {
      tchars[t.charAt(i)]++;
    }

    int i = 0;
    int start = 0;
    int minimumWindowStart = 0;
    int minimumWindowLen = Integer.MAX_VALUE;
    int count = 0;

    while (i < s.length()) {
      schars[s.charAt(i)]++;

      if ((tchars[s.charAt(i)] != 0) && (schars[s.charAt(i)] <= tchars[s.charAt(i)])) {
        count++;
      }

      if (count == t.length()) {
        // Remove all the unnecessary characters
        while ((schars[s.charAt(start)] > tchars[s.charAt(start)]) || tchars[s.charAt(start)] == 0) {
          schars[s.charAt(start)]--;
          start++;
        }

        // Get the minimum window calculations
        int minWindow = i - start + 1;
        if (minWindow < minimumWindowLen) {
          minimumWindowStart = start;
          minimumWindowLen = minWindow;
        }
      }
      i++;
    }

    if (minimumWindowLen == Integer.MAX_VALUE) {
      return "";
    }

    return s.substring(minimumWindowStart, minimumWindowStart+minimumWindowLen);
  }
}
