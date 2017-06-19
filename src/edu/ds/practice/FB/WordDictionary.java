package edu.ds.practice.FB;

public class WordDictionary {
  Trie trie;

  /** Initialize your data structure here. */
  public WordDictionary() {
    trie = new Trie();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    trie.insert(word);
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    if (word == null || word.length() == 0) return false;
    return searchHelper(word, trie.getRoot());
  }

  public boolean searchHelper(String word, Trie.TrieNode root) {
    if (root == null) return false;
    if (word == null || word.length() == 0) return root.isWord;

    char ch = word.charAt(0);
    // if ch == '.', we need to search every single children for next character
    if (ch == '.') {
      for (int j = 0; j < root.children.length; j++) {
        if (root.children[j] != null && searchHelper(word.substring(1), root.children[j])) return true;
      }
      return false;
    } else {
      return (root.children[ch - 'a'] != null &&  searchHelper(word.substring(1), root.children[ch - 'a']));
    }
  }


  // TRIE
  class Trie {
    public class TrieNode {
      boolean isWord;
      TrieNode[] children = new TrieNode[26];
    }

    public TrieNode getRoot() {
      return root;
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
      root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      if (word == null) return;
      TrieNode ws = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (ws.children[ch - 'a'] == null) {
          ws.children[ch - 'a'] = new TrieNode();
        }
        ws = ws.children[ch - 'a'];
      }
      ws.isWord = true;
    }
  }
}