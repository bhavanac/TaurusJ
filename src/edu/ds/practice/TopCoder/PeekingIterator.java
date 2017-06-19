package edu.ds.practice.TopCoder;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator<T> implements Iterator<T> {

  Iterator<T> _iterator;
  T currentValue = null;
  public PeekingIterator(Iterator<T> iterator) {
    this._iterator = iterator;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public T peek() {
    if (currentValue == null && _iterator.hasNext()) {
      currentValue = _iterator.next();
    }
    return currentValue;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public T next() {
    T retVal = null;
    if (currentValue == null && _iterator.hasNext()) {
      retVal = _iterator.next();
    } else {
      retVal = currentValue;
      currentValue = null;
    }
    return retVal;
  }

  @Override
  public void remove() {
    return;
  }

  @Override
  public boolean hasNext() {
    if (currentValue == null && _iterator.hasNext()) {
      return true;
    } else if (currentValue != null) {
      return true;
    }
    return false;
  }
}