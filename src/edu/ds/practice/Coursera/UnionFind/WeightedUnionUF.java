package edu.ds.practice.Coursera.UnionFind;

/**
 * Created by bchalla on 6/27/15.
 */
public class WeightedUnionUF {

  private int[] id;
  // Size is the number of elements with i as the root
  private int[] size;

  public WeightedUnionUF(int n) {
    id = new int[n];
    size = new int[n];

    for (int i = 0; i < n; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }

  private int root(int p) {
    while (p != id[p]) {
      p = id[p];
    }
    return p;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int proot = root(p);
    int qroot = root(q);
    if (size[p] > size[q]) {
      id[qroot] = proot;
      size[p] += size[q];
    } else {
      id[proot] = qroot;
      size[q] += size[p];
    }
  }
}
