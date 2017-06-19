package edu.ds.practice.Uber;

import java.util.Stack;


class MinStack {
  class Node {
    Node next;
    int data;

    public Node(int x) {
      this.data = x;
      this.next = null;
    }
  }

  private Node head = null;
  private int min = Integer.MAX_VALUE;
  private Stack<Integer> minimumStack = new Stack<Integer>();

  public void push(int x) {
    Node node = new Node(x);
    if (head == null) {
      head = node;
    } else {
      node.next = head;
      head = node;
    }

    if (minimumStack.isEmpty()) {
      minimumStack.push(x);
    } else {
      Integer min = minimumStack.peek();
      if (min >= x) {
        minimumStack.push(x);
      }
    }
  }

  public void pop() {
    if (head == null) {
      return;
    }

    Node temp = head;
    head = head.next;
    temp.next = null;

    Integer min = minimumStack.peek();
    if (min == temp.data) {
      minimumStack.pop();
    }
  }

  public int top() {
    if (head == null) {
      return -1;
    }
    return head.data;
  }

  public int getMin() {
    return minimumStack.isEmpty()?-1:minimumStack.peek();
  }
}
