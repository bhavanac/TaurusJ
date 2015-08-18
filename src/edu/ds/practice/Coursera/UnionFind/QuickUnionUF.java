package edu.ds.practice.Coursera.UnionFind;

/**
 * Created by bchalla on 6/27/15.
 */
public class QuickUnionUF {

  private int[] id;

  public QuickUnionUF(int n) {
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  private int root(int i) {
    while (id[i] != i) {
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int proot = root(p);
    int qroot = root(q);
    if (proot != qroot) {
      id[proot] = qroot;
    }
  }
}
