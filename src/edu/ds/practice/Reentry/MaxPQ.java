package edu.ds.practice.Reentry;

public class MaxPQ<Key extends Comparable<Key>> {

  // N Represents initial max capacity
  int N;

  // current N
  int size;

  // pq[] holds the elements using 1-index
  Key[] pq;

  public MaxPQ(int N) {
    this.N = N;
    this.pq = (Key[]) new Object[N+1];
  }

  /**
   * Insert the element v into PQ
   * @param v - element that needs to be inserted
   */
  public void insert(Key v) {
    if (size > pq.length/2) resize(2*pq.length);

    size++;
    pq[size] = v;

    // Since we added it at the end, we need to do bottom-up reheapify
    swim(size);
  }

  /**
   * Return the max element
   * @return
   */
  public Key max() {
    if (size > 1) {
      return pq[1];
    }
    return null;
  }

  /**
   * Return and Remove the max element
   */
  public Key delMax() {
    if (size > 1) {
      Key result = pq[1];
      exch(1,size);

      // Remove the N
      size--;

      // Sink the top
      sink(1);
    }
    return null;
  }

  public boolean isEmpty() {
    return (size > 0);
  }

  public int size() {
    return size;
  }

  ///////////////////////////////////
  /// PRIVATE METHODS ///////////////
  ///////////////////////////////////
  private void resize(int newSize) {
    Key[] temp = (Key[]) new Object[newSize+1];
    for (int i = 0; i < size; i++) {
      temp[i] = pq[i];
    }
    pq = temp;
  }

  private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
      exch(k/2, k);
      k = k/2;
    }
  }

  private void sink(int k) {
    while (2*k <= size) {
      int j = 2*k;
      if (j < size && less(j, j+1)) j++;
      if (!less(k, j)) break;

      exch(k, j);
      k=j;
    }
  }

  private void exch(int i, int k) {
    Key temp = pq[i];
    pq[i] = pq[k];
    pq[k] = temp;
  }

  private boolean less(int i, int j) {
    Key first = pq[i];
    Key second = pq[j];
    return (first.compareTo(second) < 0);
  }

}
