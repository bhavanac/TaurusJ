package edu.ds.practice.Coursera.UnionFind;

/**
 * Created by bchalla on 6/27/15.
 */
public class QuickFindUF {

  int id[];
  int size;

  public QuickFindUF(int n) {
    size = n;
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return (id[p] == id[q]);
  }

  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];

    for (int i = 0; i < size; i++) {
      if (id[i] == pid) {
        id[i] = qid;
      }
    }
  }
}
