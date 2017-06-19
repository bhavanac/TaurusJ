package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/11/15.
 */
public class ReverseLinkedList {
  //Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode current = head;
    ListNode prev = null;

    while (current != null) {
      ListNode next = current.next;

      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}
