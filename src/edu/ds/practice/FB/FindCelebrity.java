package edu.ds.practice.FB;

public class FindCelebrity {
  public int findCelebrity(int n) {
    for (int i = 0; i < n; i++) {
      int j = 0;
      for (j = 0; j < n; j++) {
        if (i == j || knows(j, i)) continue;

        // j can be our next celebrity
        if (j > i) i = j;
        break;
      }

      if (j == n) {
        // i can be a celebrity. Make sure he doesn't know anyone to return his label
        int k = 0;
        for (k = 0; k < n; k++) {
          if (i == k) continue;
          if (knows(i, k)) break;
        }

        if (k == n) return i;
      }
    }
    return -1;
  }

  private boolean knows(int j, int i) {
    return false;
  }
}
