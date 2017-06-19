package edu.ds.practice.Uber;

public class WordBreak {
  private boolean dictionaryContains(String word) {
    String dictionary[] =
        {"mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like", "ice", "cream"};
    for (int i = 0; i < dictionary.length; i++)
      if (dictionary[i].equals(word)) return true;
    return false;
  }

  public boolean wordBreak(String str) {
    if (str == null || str.length() == 0) {
      return false;
    }

    for(int i=1; i<=str.length();i++) {
      if (dictionaryContains(str.substring(0, i))) {
        if (i == str.length()) {
          return true;
        }

        return wordBreak(str.substring(i));
      }
    }

    return false;
  }



  public boolean wordBreakDP(String str) {
    if (str == null || str.length() == 0) {
      return false;
    }

    // wb[i] = true if str[0...i-1] can be broken down into words in the dictionary
    boolean wb[] = new boolean[str.length()+1];
    for(int j=1; j<=str.length(); j++) {
      if (wb[j] == false && dictionaryContains(str.substring(0, j))) {
        wb[j] = true;
      }

      if (wb[j] == true) {
        if (j == str.length()) {
          return true;
        }

        for (int i=j+1; i<=str.length();i++) {
          if (wb[i] == false && dictionaryContains(str.substring(j, i))) {
            wb[i] = true;
          }

          if (j == str.length() && wb[j] == true) {
            return true;
          }
        }
      }
    }

    return false;
  }
}
