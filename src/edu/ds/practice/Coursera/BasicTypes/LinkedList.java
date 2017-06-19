package edu.ds.practice.Coursera.BasicTypes;

/*
 * A simple linkedlist with a head and tail.
 */
public class LinkedList<T> {
  class Node {
    T data;
    Node next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  public Node head;
  private Node tail;

  public void add(T data) {
    if (head == null) {
      head = new Node(data);
      tail = head;
    } else {
      Node newNode = new Node(data);
      tail.next = newNode;
      tail = tail.next;
    }
  }

  public void print() {
    Node temp = head;
    while (temp != null) {
      if (temp.next == null) {
        System.out.print(temp.data);
      } else {
        System.out.print(temp.data + "->");
      }
      temp = temp.next;
    }
    System.out.println("");
  }

  public Node reverseXNodes(Node head, int x) {
    Node current = head;
    Node end = current;
    Node next = null;
    int index = 0;
    while (++index != x && end != null) {
      end = end.next;
    }

    if (index == x && end != null) {
      next = end.next;
      end.next = null;
    } else {
      return current;
    }

    head = reverseG(current);
    // find end
    Node prevEnd = head;
    while(prevEnd.next != null) {
      prevEnd = prevEnd.next;
    }
    current = next;

    while (current != null) {
      index = 0;
      end = current;
      while (++index != x && end != null) {
        end = end.next;
      }

      if (index == x && end != null) {
        next = end.next;
        end.next = null;

        prevEnd.next = reverseG(current);
        while(prevEnd.next != null) {
          prevEnd = prevEnd.next;
        }
        current = next;
      } else {
        prevEnd.next = current;
        break;
      }
    }

    return head;
  }


  public Node reverseG(Node head) {
    Node prev = null;
    Node current = head;
    Node next = current.next;

    while(next != null) {
      Node temp = next.next;
      next.next = current;
      current.next = prev;

      prev = current;
      current = next;
      next = temp;
    }

    return current;
  }

  public void reverse() {
    Node prev = null;
    Node current = head;
    Node next = current.next;

    while(next != null) {
      Node temp = next.next;
      next.next = current;
      current.next = prev;

      prev = current;
      current = next;
      next = temp;
    }

    head=current;
  }

  public void pairwiseSwap() {
    // Edge case where only one element is present
    if (this.head == null || this.head.next == null) {
      return;
    }

    Node current = this.head;
    Node next = current.next;
    Node prev = null;

    this.head = next;

    while(true) {
      current.next = next.next;
      next.next = current;
      if(prev != null) {
        prev.next = next;
      }

      if (current.next == null || current.next.next == null) {
        break;
      }

      prev = current;
      current = current.next;
      next = current.next;
    }
  }

  public Node pairwiseSwapForXNodes(Node head, int x) {
    // Edge case where only one element is present
    if (head == null) {
      return head;
    }

    Node current = head;
    Node end = findXNode(current, x);
    Node prev = null;
    Node next = null;

    if (end != null) {
      next = end.next;
      end.next = null;
      head = end;
    } else {
      return head;
    }

    while(true) {
      current = reverseG(current);
      Node nextPrev = findXNode(current, x);
      if (prev != null) {
        prev.next = current;
      }
      prev = nextPrev;
      current = next;

      end = findXNode(current, x);
      if (end != null) {
        next = end.next;
        end.next = null;
      } else {
        prev.next = current;
        break;
      }
    }

    return head;
  }

  public Node findXNode(Node current, int x) {
    int index = 0;
    Node temp = current;
    while(++index != x && (temp != null && temp.next != null)) {
      temp = temp.next;
    }

    if (index != x) {
      return null;
    }

    return temp;
  }

}
