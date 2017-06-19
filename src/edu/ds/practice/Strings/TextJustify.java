package edu.ds.practice.Strings;

import java.util.ArrayList;
import java.util.List;


public class TextJustify {
  public List<String> fullJustify(String[] words, int maxWidth)
  {
    int len = words.length;
    int idx = 0;
    List<String> output = new ArrayList<String>();
    List<String> line = new ArrayList<String>();
    int curlength = 0;
    // Walk the list, assembling lines
    while (idx < len) {
      String nextWord = words[idx++];
      int speculLength = curlength + nextWord.length();
      if (speculLength <= maxWidth) { // the word fits, and will be added to the current line
        line.add(nextWord);
        curlength = speculLength + 1; // include the space between it and the next word. This may put us over (which is fine)
        continue;
      } else { // The word does not fit on this line. Process and reset the line
        output.add(process(line, maxWidth));
        line = new ArrayList<String>();
        curlength = 0;
        speculLength = nextWord.length();

        // Having done that, add the new word as the beginning of the next line
        // If we were covering the hyphenation case, we would want to check to see if we needed to hyphenate and be prepared
        // to split the word (remembering to account for the extra hyphen character) and insert the second half to be treated
        // as a new word by the loop. That would probably mean using indexes rather than the iterator
        line.add(nextWord);
        curlength = speculLength + 1;
      }
    }
    // We have run out of words. Because the last line is allowed to not span the width, we need to handle it specially
    // curlength will include a space trailing the each word including the last, which we want to remove
    if (! line.isEmpty())
    {
      StringBuilder lastLine = new StringBuilder(process(line, curlength - 1));
      for(int i=0; i<maxWidth-(curlength-1); i++) lastLine.append(" ");
      output.add(lastLine.toString());
    }
    return output;
  }

  private String process(List<String> words, int lineLength)
  {
    StringBuilder output = new StringBuilder();

    if (words.size() > 1) { // length one lines are special - we can't insert any spaces, so we shouldn't
      // Consider the line {"really", "just", "enough", "to"}, length 25 (from the example)
      int nonSpaces = 0;
      for (String word : words)
      {
        nonSpaces += word.length(); // nonSpaces is now 6 + 4 + 6 + 2 = 18
      }
      int spaces = lineLength - nonSpaces; // how many spaces do we need to add? It will be at least one per space slot. it is 7 in the example
      int spaceSlots = words.size() - 1; // there are this many 'gaps' to put spaces in. It is 3 in the example
      int spacesPerSlot = spaces / spaceSlots; // we put this many spaces in each. It is 7/3 = 2 in the example
      int extraSpaces = spaces % spaceSlots; // And need this many 'uneven' spaces. It is 7 % 3 = 1 in the example

      // Thus, we want to have three (2 + 1) spaces between the first and second word, and two in the other slots, for a total length of 3 + 2 + 2 + 18 = 25 characters

      // Build the string
      for (int i = 0; i < words.size() - 1; i++) // We don't want to apply this to the last word
      {
        String word = words.get(i);
        output.append(word);
        // This is the lazy way, we could build this string only once and re-use it
        for (int j = 0; j < spacesPerSlot; j++) {output.append(" ");}
        if (extraSpaces > 0) {
          output.append(" "); // if we have extra spaces to distribute, use one. Thus, if we had more than one they would be distributed evenly in the front of the line
          extraSpaces -= 1;
        }
      }

      output.append(words.get(words.size() - 1)); // append the last word
      return output.toString();
    } else {
      StringBuilder lastWord = new StringBuilder(words.get(words.size() - 1));
      for(int i=0; i<lineLength-words.get(words.size() - 1).length(); i++) lastWord.append(" ");
      return lastWord.toString();

    }

  }
}