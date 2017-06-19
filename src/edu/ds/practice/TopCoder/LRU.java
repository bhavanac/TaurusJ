package edu.ds.practice.TopCoder;

import edu.ds.practice.Coursera.BasicTypes.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by bchalla on 10/19/15.
 */
public class LRU{
  private Map<String, Node> _map = new HashMap<String, Node>();
  private Node head=null;
  private Node tail=null;
  private int N;
  private int size;

  class Node {
    Object val;
    Node prev;
    Node next;

    public Node(Object data) {
      this.val = data;
      prev = null;
      next = null;
    }
  }

  public LRU(int N) {
    this.N = N;
    this.size = 0;
  }

  public void insert(String key, Object value) {
    if (_map.containsKey(key)) {
      Node node = _map.get(key);
      node.val = value;

      // Now remove it from the middle of the queue and make it head
      moveNodeToFirst(node);
    } else {
      if (size >= N) {
        removeLeastRecentlyAccessed();
      }

      Node node = new Node(value);
      if (head == null) {
        head = tail = node;
      } else {
        head.prev = node;
        node.next = head;
        head = head.prev;
      }
      size++;
    }
  }

  public Object lookup(String key) {
    if (_map.containsKey(key)) {
      Node node = _map.get(key);

      // Now remove it from the middle of the queue and make it head
      moveNodeToFirst(node);
      return node.val;
    } else {
      return null;
    }
  }

  public void moveNodeToFirst(Node node) {
    if (node == head) {
      return;
    } else if (node == tail) {
      tail = node.prev;
      tail.next = null;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }


    node.prev = null;
    node.next = null;

    head.prev = node;
    node.next = head;
    head = node;
    return;
  }

  public void removeLeastRecentlyAccessed() {
    if (tail != null) {
      Node temp = tail.prev;

      tail.next = tail.prev = null;
      if (temp != null) temp.next = null;
      tail = temp;
    }
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
}
