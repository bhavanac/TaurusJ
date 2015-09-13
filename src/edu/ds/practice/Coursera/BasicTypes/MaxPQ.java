package edu.ds.practice.Coursera.BasicTypes;

/**
 * @bchalla
 */
public class MaxPQ<Key extends Comparable<Key>>
{
  private Key[] pq;             // heap-ordered complete binary tree
  private int N = 0;            // in pq[1..N] with pq[0] unused

  // create a priority queue of initial capacity max
  public MaxPQ(int max) {
    pq = (Key[]) new Comparable[max+1];
  }

  // insert a key into the priority queue
  void insert(Key v)
  {
    pq[++N] = v;
    swim(N);
  }

  // return and remove the largest key
  Key delMax() {
    if (N >= 1) {
      Key maxKey = pq[1];
      exch(1, N);
      pq[N] = null;
      N--;
      sink(1);
      return maxKey;
    }
    return null;
  }

  // Is the priority queue empty?
  boolean isEmpty() {
    return N == 0;
  }

  // number of keys in the priority queue
  int size() {
    return N;
  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j) {
    Key temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
      exch(k/2, k);
      k = k/2;
    }
  }

  private void sink(int k) {
    while(2*k <= N) {
      int j = 2*k;
      if (j<N && less(2*k, 2*k+1)) {
        j = 2*k+1;
      }
      if (less(j, k)) {
        break;
      }
      exch(j, k);
      k = j;
    }
  }
}
