package edu.ds.practice.FB;

import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKLists {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public class IndexNode {
    int index;
    ListNode listNode;
    IndexNode(int k, ListNode node) { this.index = k; this.listNode = node; }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode result = new ListNode(-1); // DUMMY HEAD;
    ListNode head = result;
    PriorityQueue<IndexNode> pq = new PriorityQueue<>((Comparator<IndexNode>) (node1, node2) -> node1.listNode.val - node2.listNode.val);
    // Initial offer
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] == null) continue;

      pq.offer(new IndexNode(i, lists[i]));
      lists[i] = lists[i].next;
    }

    while (!pq.isEmpty()) {
      IndexNode in = pq.poll();
      result.next = in.listNode;
      result = result.next;

      // Get the next element from the same indexed queue
      if (lists[in.index] != null) {
        pq.offer(new IndexNode(in.index, lists[in.index]));
        lists[in.index] = lists[in.index].next;
      }
    }

    return head.next;
  }
}
