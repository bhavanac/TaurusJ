package edu.ds.practice;

public class InsertionSortList {
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public void runAndVerify() {

    /// example list
    ListNode head = new ListNode(9);
    head.next = new ListNode(5);
    head.next.next = new ListNode(8);
    head.next.next.next = new ListNode(1);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(8);

    ListNode node = insertionSortList(head);
    System.out.println();
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
    System.out.println();
  }

  public ListNode insertionSortList(ListNode head) {
    if (head.next == null) return head;

    // STEP 1 - Break it down into two lists
    ListNode current = head;
    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && fast != null) {
      if (fast.next == null || fast.next.next == null) break;

      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode secondHead = slow.next;
    ListNode firstHead = current;
    slow.next = null;

    // Sort the two lists and merge them back together
    ListNode resultFirst = insertionSortList(firstHead);
    ListNode resultSecond = insertionSortList(secondHead);
    return mergeTwoSortedLinkedLists(resultFirst, resultSecond);
  }

  private ListNode mergeTwoSortedLinkedLists(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0); // NULL HEAD POINTEr
    ListNode result = dummyHead;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        result.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        result.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      result = result.next;
    }

    while (l1 != null) {
      result.next = new ListNode(l1.val);
      l1 = l1.next;
      result = result.next;
    }

    while (l2 != null) {
      result.next = new ListNode(l2.val);
      l2 = l2.next;
      result = result.next;
    }

    return dummyHead.next;
  }

  // Selection sort
  public static void selectionSort(Comparable[] list) {
    for (int i = 0; i < list.length - 1; i++) {
      int minIndex = i;
      for (int j = i+1; j < list.length; j++) {
        if (lessThan(list[j], list[minIndex])) {
          minIndex = j;
        }
      }

      // exch minIndex and i
      exch(list, minIndex, i);
    }

    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i]+ " ");
    }
  }

  // Insertion sort
  public static void insertionSort(Comparable[] list) {
    Integer[] arr = new Integer[10];
    for (int i = 1; i < list.length; i++) {
      for (int j = i-1; j >= 0; j--) {
        if (lessThan(list[j], list[j+1])) break;
        exch(list, j, j+1);
      }
    }
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i]+ " ");
    }
  }

  private static boolean lessThan(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
