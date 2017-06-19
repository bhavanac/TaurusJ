package edu.ds.practice.Uber;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by bchalla on 11/11/15.
 */
public class LRUCache2 {

  private int size;
  private Map<Integer,Integer> map;
  public LRUCache2(int capacity) {
    this.size = capacity;
    map = new LinkedHashMap<Integer,Integer>(16,0.75f,true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return this.size() > size;
      }
    };
  }

  public int get(int key) {
    return map.containsKey(key) ? map.get(key): -1;
  }

  public void set(int key, int value) {
    map.put(key, value);
  }
}
