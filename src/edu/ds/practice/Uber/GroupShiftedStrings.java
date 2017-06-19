package edu.ds.practice.Uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by bchalla on 11/11/15.
 */
public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> keys = new HashMap<String, List<String>>();
    // The keys are formulated as number of chars in the string and difference between it and subsequent char
    // For eg - abc, key is 3,1,1 for zab key is 3,1,1 only a-z since a < z we add 26 so 1-26+26 = 1
    for (int i=0; i<strings.length; i++) {
      String element = strings[i];
      StringBuilder sb = new StringBuilder();
      sb.append(element.length());

      for (int j=1; j<element.length(); j++) {
        char f = element.charAt(j-1);
        char s = element.charAt(j);
        if (s < f) {
          sb.append(s-f+26);
        } else {
          sb.append(s-f);
        }
      }

      String key = sb.toString();
      if (keys.containsKey(key)) {
        keys.get(key).add(element);
      } else {
        List<String> results = new ArrayList<String>();
        results.add(element);
        keys.put(key, results);
      }
    }

    List<List<String>> results = new ArrayList<List<String>>();
    for (Map.Entry<String, List<String>> entry: keys.entrySet()) {
      Collections.sort(entry.getValue());
      results.add(entry.getValue());
    }

    return results;
  }
}
