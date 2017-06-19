package edu.ds.practice.Coursera.BasicTypes;

import java.util.Iterator;


/**
 * Created by bchalla on 10/19/15.
 */
public class Queue<T> implements Iterable<T> {
  class Node {
    T val;
    Node prev;
    Node next;

    public Node(T data) {
      this.val = data;
      prev = null;
      next = null;
    }
  }

  private Node head;
  private Node tail;
  private int N;

  public Queue() {
    head = tail = null;
    N=0;
  }

  public int getSize() {
    return N;
  }

  public void Enqueue(T data) {
    Node node = new Node(data);
    if (tail == null) {
      head = tail = node;
    } else {
      tail.next = node;
      node.prev = tail;
      tail = node;
    }
    N++;
  }

  public T Dequeue() {
    T returnValue = null;
    if (tail != null) {
      Node temp = head.next;
      returnValue = head.val;
      head.next = null;
      head = temp;
      head.prev = null;
    }
    N--;
    return returnValue;
  }

  public void print() {
    if (head == null) {
      return;
    }

    Node current = head;
    while (current != null) {
      System.out.print(current.val + "->");
      current = current.next;
    }
    System.out.println();
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }
}
