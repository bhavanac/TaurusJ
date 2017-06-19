package edu.ds.practice.TopCoder;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKLists {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    // Solution 1
    // Read k elements from each list. To figure out the least val, -> o(klogk). If there are total n elements in all the list combined it is o(nklogk);

    // solution 2
    // Use index priority queue of size k
    // Read k elements and add it to the queue -> 0(klog k)
    // Read the min element -> o(log k) and insert new element o(log k) again -> o(2logk) -> o(logk)
    // o(klogk) + o(nlogk) -> o(nlogk) Time complexity and o(k) space complexity

    if (lists == null || lists.length == 0) {
      return null;
    }

    IndexMinPQ<Integer> minPQ = new IndexMinPQ<Integer>(lists.length);
    for(int i=0;i<lists.length;i++) {
      if (lists[i] != null) {
        minPQ.insert(i, lists[i].val);

        ListNode temp = lists[i].next;
        lists[i].next = null;
        lists[i] = temp;
      }
    }

    ListNode finalListHead = null;
    ListNode finalListTail = null;
    while (!minPQ.isEmpty()) {
      Integer element = minPQ.min();
      int minIndex = minPQ.delMin();

      if (finalListHead == null) {
        finalListHead = finalListTail = new ListNode(element);
      } else {
        finalListTail.next = new ListNode(element);
        finalListTail = finalListTail.next;
      }

      if (lists[minIndex] != null) {
        minPQ.insert(minIndex, lists[minIndex].val);

        ListNode temp = lists[minIndex].next;
        lists[minIndex].next = null;
        lists[minIndex] = temp;
      }
    }
    return finalListHead;
  }

  class IndexMinPQ<Key extends Comparable<Key>> {
    private int[] pq;
    private int[] qp;
    private Key[] keys;
    private int N;

    // pa and qp maintain a 1-index based lists
    // pq - priority queue - k is the parent of 2k and 2k+1 elements. That means both 2k and 2k+! elements are larger than the element at k
    // qp - reverse priority queue to maintain indices

    // qp[pq[i]] = pq[qp[i]] = i
    // For example if keys[4] = 35, keys[18] = 40;
    // pq[1] = 4 qp[4] = 1
    // pq[2] = 18 qp[18] = 2
    public IndexMinPQ(int maxN) {
      pq = new int[maxN+1];
      qp = new int[maxN+1];
      keys = (Key[]) new Comparable[maxN+1];
      N = 0;

      for (int i = 0; i <= maxN; i++) {
        qp[i] = -1;
      }
    }

    public void insert(int index, Key val) {
      keys[index] = val;
      N++;

      pq[N] = index;
      qp[index] = N;
      swim(N);
    }

    public int delMin() {
      Key min = keys[pq[1]];
      int minIndex = pq[1];

      exch(N, 1);
      keys[pq[N]] = null;
      qp[pq[N]] = -1;
      N--;
      sink(1);

      return minIndex;
    }

    public int minIndex() {
      return pq[1];
    }

    public Key min() {
      return keys[pq[1]];
    }

    public boolean isEmpty() {
      return N == 0;
    }

    private void swim(int k) {
      while(k > 1 && less(k, k/2)) {
        exch(k/2, k);
        k = k/2;
      }
    }

    private void sink(int k) {
      while (2*k <= N) {
        int j = 2*k;
        if (j+1 <= N && less(j+1, j)) {
          j++;
        }

        if(less(k, j)) {
          break;
        }

        exch(j, k);
        k = j;
      }
    }


    // qp[pq[i]] = pq[qp[i]] = i
    // For example if keys[4] = 35, keys[18] = 40;
    // pq[1] = 4 qp[4] = 1
    // pq[2] = 18 qp[18] = 2
    private void exch(int p, int q) {
      int temp = pq[p];
      pq[p] = pq[q];
      pq[q] = temp;

      qp[pq[p]] = p;
      qp[pq[q]] = q;
    }

    private boolean less(int p, int q) {
      return keys[pq[p]].compareTo(keys[pq[q]])  < 0;
    }
  }
}