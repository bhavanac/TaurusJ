package edu.ds.practice.Coursera.BasicTypes;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by bchalla on 7/19/15.
 */
public class Stack<T> implements Iterable<T> {

  private class Node {
    T item;
    Node next;
  }

  private Node first = null;
  private int N;

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  public void push(T item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  public T pop() {
    Node removed = first;
    first = first.next;
    N--;
    return removed.item;
  }

  @Override
  public Iterator<T> iterator() {
    return new StackIterator(N);
  }

  public class StackIterator implements Iterator<T> {
    private Node current = first;
    private int size;

    StackIterator(int N) {
      this.size = N;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      if (size != size()) {
        throw new ConcurrentModificationException();
      }

      T returnItem = current.item;
      current = current.next;
      return returnItem;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
