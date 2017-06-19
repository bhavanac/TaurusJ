package edu.ds.practice.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by bchalla on 11/19/15.
 */
public class WordBreak {
  public List<String> wordBreak(String s, Set<String> wordDict) {
    List<String> results = new ArrayList<String>();
    for(int i=s.length()-1; i >= 0; i--) {
      if (wordDict.contains(s.substring(i)))
        break;
      if (i == 0)
        return results;
    }

    for(int j=0; j<s.length()-1; j++) {
      List<String> strs = new ArrayList<String>();
      if (wordDict.contains(s.substring(0, j+1))) {
        strs = wordBreak(s.substring(j+1, s.length()), wordDict);
      }

      if (strs.size() != 0) {
        for (int k=0;k<strs.size();k++) {
          results.add(s.substring(0, j+1) + " " + strs.get(k));
        }
      }
    }
    if (wordDict.contains(s)) results.add(s);
    return results;
  }
}
