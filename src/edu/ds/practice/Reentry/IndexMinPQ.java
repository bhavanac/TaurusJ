package edu.ds.practice.Reentry;

public class IndexMinPQ<Item extends Comparable<Item>> {
  int capacity;
  int N; // Number of elements in the PQ
  int[] pq; // pq[i] = item
  int[] qp; // qp[k] = i so that pq[qp[k]] = item
  Item[] items; // which store the actual array

  /**
   * Creates a priority queue of maxN with possible indices between 0 and maxN-1
   * @param maxN
   */
  IndexMinPQ(int maxN) {
    this.capacity = maxN;
    pq = new int[maxN+1];
    qp = new int[maxN+1];
    items = (Item[]) new Comparable[maxN+1];

    for (int i = 0; i <= maxN; i++) {
      qp[i] = -1;
    }
  }

  /**
   * insert item; associate it with key
   * @param k
   * @param item
   */
  public void insert(int k, Item item) {
    N++;

    qp[k] = N;
    pq[N] = k;
    items[k] = item;

    swim(N);
  }

  /**
   * Change the item associated with the key
   * @param k
   * @param item
   */
  public void change(int k, Item item) {
    items[k] = item;

    swim(qp[k]);
    sink(qp[k]);
  }

  /**
   * Is k associated with any item
   * @param k
   * @return
   */
  public boolean contains(int k) {
    return items[k] != null;
  }

  /**
   * remove k and its associated item
   */
  public void delete(int k) {
    int indexInPq = qp[k];
    if (indexInPq != -1) {
      exch(indexInPq, N);
      items[qp[N]] = null;
      qp[N] = -1;
      N--;
    }

    sink(indexInPq);
  }

  /**
   * return a minimal item
   */
  public Item min() {
    return items[pq[1]];
  }

  /**
   * Return a minimal item's index
   */
  public int minIndex() {
return pq[1];
  }

  /**
   * Remove a minimal item and return its index
   */
  public int delMin() {
    int returnIndex = minIndex();
    delete(pq[1]);
    return returnIndex;
  }

  /**
   * Is the priority queue empty
   */
  public boolean isEmpty() {
return false;
  }

  /**
   * number of items in queue
   */
  public int size() {
return N;
  }

  private boolean less(int i, int j) {
    return items[pq[i]].compareTo(items[pq[j]]) < 0;
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
}

