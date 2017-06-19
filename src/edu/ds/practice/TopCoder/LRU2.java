package edu.ds.practice.TopCoder;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by bchalla on 10/19/15.
 */
public class LRU2<K, T> extends LinkedHashMap<K, T> {
  private int size;

  public LRU2(int N) {
    super(N,0.75f,true);
    this.size = N;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry eldest) {
    return size() > size;
  }
}
