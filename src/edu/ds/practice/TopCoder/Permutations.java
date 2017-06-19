package edu.ds.practice.TopCoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


interface IPermutations<T> {
  /**
   * @return all distinct permutations of the given values.
   * For example, generate([1,2,3]) returns {[1,2,3], [1,3,2], [2,3,1], [2,1,3], [3,1,2], [3,2,1]}.
   */
  Collection<List<T>> generate(Collection<T> values);
}

public class Permutations implements IPermutations<String>{

  @Override
  public Collection<List<String>> generate(Collection<String> values) {
    if (values == null || values.size() == 0) {
      return null;
    }

    Collection<List<String>> results = new ArrayList<List<String>>();
    Iterator<String> iterator = values.iterator();
    while (iterator.hasNext()) {
      results.add(permutationHelper(iterator.next().toCharArray(),0));
    }
    return results;
  }

  public List<String> permutationHelper(char[] charArray, int low) {
    List<String> results = new ArrayList<String>();
    if (low == charArray.length-1) {
      results.add(String.valueOf(charArray[low]));
    }

    for (int i = low; i < charArray.length; i++) {
      swap(charArray, low, i);
      List<String> strings = permutationHelper(charArray, low+1);
      if (strings != null) {
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
          results.add(String.valueOf(charArray[low] + iterator.next()));
        }
      }
      swap(charArray, i, low);
    }

    return results;
  }

  public void swap(char[] charArray, int i, int j) {
    char temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
  }
}
