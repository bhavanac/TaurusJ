package edu.ds.practice.Uber;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeTravellingHashTable<K, T, V> {
  private HashMap<K, TreeMap<T, V>> map = new HashMap<K, TreeMap<T, V>>();

  /**
   * Take the key and get the treeMap.
   * lowerEntry API of treeMap is o (log n) which returns a T strictly less than time
   * @param key
   * @param time
   * @return
   */
  public V get(K key, T time) {
    if (map.containsKey(key)) {
      Map.Entry<T, V> lowerEntry = map.get(key).lowerEntry(time);
      if (lowerEntry != null) {
        return lowerEntry.getValue();
      }
    }

    return null;
  }

  /**
   * Put takes o(log n) since tree map takes o(log n) for all put, get, containsKey and remove operations
   * @param key
   * @param time
   * @param value
   */
  public void put(K key, T time, V value) {
    if (map.containsKey(key)) {
      map.get(key).put(time, value);
    } else {
      TreeMap<T, V> tvTreeMap = new TreeMap<T, V>();
      tvTreeMap.put(time, value);
      map.put(key, tvTreeMap);
    }
  }

}
