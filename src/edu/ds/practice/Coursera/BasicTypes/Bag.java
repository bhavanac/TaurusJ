package edu.ds.practice.Coursera.BasicTypes;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by bchalla on 7/19/15.
 */
public class Bag<Item> implements Iterable<Item> {

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator(N);
  }

  private class Node {
    Item item;
    Node next;
  }

  private Node first = null;
  private int N;

  public int size() {
    return N;
  }

  public void add(Item item) {
    Node oldfirst = first;
    Node node = new Node();
    node.item = item;
    node.next = oldfirst;
    first = node;
    N++;
  }

  private class ListIterator implements Iterator<Item> {
    private Node current;
    private int size;

    ListIterator(int N) {
      current = first;
      size = N;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if (size != size()) {
        throw new ConcurrentModificationException();
      }

      Node next = current;
      current = current.next;
      return next.item;
    }

    @Override
    public void remove() {
      throw new NotImplementedException();
    }
  }
}
