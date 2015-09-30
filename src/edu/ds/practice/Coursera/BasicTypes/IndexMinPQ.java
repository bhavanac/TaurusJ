package edu.ds.practice.Coursera.BasicTypes;


/**
 * This is very useful for merging sorted input streams.
 * You can always take the first input from all streams and add it to the priority queue.
 * Remove the delMin, you will know the index from where you removed it, so read the stream
 * from that index.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {

  private int[] pq;
  private int[] qp;
  private Key[] keys;
  private int N = 0;

  public IndexMinPQ(int maxN) {
    pq = new int[maxN+1];
    qp = new int[maxN+1];
    keys = (Key[]) new Comparable[maxN+1];

    for (int i = 0; i <= maxN; i++) {
      qp[i] = -1;
    }
  }

  public boolean isEmpty() {
    return (N == 0);
  }

  public boolean contains(int k) {
    return (qp[k] != -1);
  }

  public void insert(int k, Key key) {
    keys[k] = key;
    qp[k] = ++N;
    pq[N] = k;

    swim(N);
  }

  public void change(int k, Key item) {
    keys[k] = item;

    swim(qp[k]);
    sink(qp[k]);
  }

  public void delete(int k) {
    int indexInPQ = qp[k];
    if (indexInPQ != -1) {
      exch(indexInPQ, N);
      keys[pq[N]] = null;
      qp[pq[N]] = -1;
      N--;

      sink(indexInPQ);
    }
  }

  public Key min() {
    return keys[pq[1]];
  }

  public int minIndex() {
    return pq[1];
  }

  public int delMin() {
    int minIndex = pq[1];

    /* Exchange first element with the last element and sink */
    exch(1, N);
    keys[pq[N]] = null;
    qp[pq[N]] = -1;
    N--;

    sink(1);
    return minIndex;
  }

  public int size() {
    return N;
  }

  private boolean less(int i, int j) {
    return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
  }

  private void exch(int i , int j) {
    int tempPQ = pq[i];
    pq[i] = pq[j];
    pq[j] = tempPQ;

    // Now change it in qp as well
    qp[pq[i]] = i;
    qp[pq[j]] = j;
  }

  private void swim(int i) {
    while (i > 1 && less(i, i/2)) {
      exch(i, i/2);
      i = i/2;
    }
  }

  private void sink(int i) {
    while (2*i <= N) {
      int k = 2*i;
      if (k+1 <= N && less(k+1, k)) {
        k = k+1;
      }

      if (less(i, k)) {
        break;
      }

      exch(k, i);
      i = k;
    }
  }

  /*
   * pq[2] = 23 pq[4] = 45
   * qp[23] = 2 qp[45] = 4
   * key[23] = 100 key[45] = 400
   *
   * pq[2] = 45 pq[4] = 23
   * qp[23] = 4 qp[45] = 2
   *
   *
   */

}
