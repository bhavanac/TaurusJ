package edu.ds.practice.TopCoder;


import java.util.*;


class KompressorFixture {
  protected String uncompressed;
  protected String compressed;
  protected Hashtable<String, Character> grammar;

  public KompressorFixture() {
    uncompressed = compressed = "";
    grammar = new Hashtable<String, Character>();
  }
}


public class Kompressor {
    protected Hashtable<String, Character> grammar;
    
    public Kompressor(Hashtable<String, Character> grammar) {
        this.grammar = grammar;
    }

    public String uncompress(String compressed) {
      // Invert this and creat another map
      Map<Character, String> invert = new HashMap<Character, String>();
      Iterator<String> iterator = grammar.keySet().iterator();
      while (iterator.hasNext()) {
        String temp = iterator.next();
        invert.put(grammar.get(temp), temp);
      }

      StringBuilder sb = new StringBuilder();
      for (int i=0; i<compressed.length(); i++) {
        // CASE 1 - if it doesn't exist in my invert
        char element = compressed.charAt(i);
        if (invert.containsKey(element)) {

          // CASE 2 - - if it exists
          String result = uncompressHelper(element+"", invert);
          sb.append(uncompressHelper(element+"", invert));
          invert.put(element, result);
        } else {
          sb.append(element);
        }
      }


      return sb.toString();
    }


  public String uncompressHelper(String element, Map<Character, String> invert) {
    // Base case is no character in the element can be found in invert
    StringBuilder sb = new StringBuilder();
    char[] charArray = element.toCharArray();
    for(int i =0; i<charArray.length; i++) {
      if (invert.containsKey(charArray[i])) {
        sb.append(uncompressHelper(invert.get(charArray[i]), invert));
      } else {
        sb.append(charArray[i]);
      }
    }
    return sb.toString();
  }

    //<editor-fold desc="Main">
    public static void main(String[] args) {
        KompressorFixture fixture = createFixture();

        Kompressor kompressor = new Kompressor(fixture.grammar);
        String uncompressed = kompressor.uncompress(fixture.compressed);
        System.out.println("uncompressed: \"" + uncompressed + "\"");
    }
    //</editor-fold>

    //<editor-fold desc="Test fixture constructor">
    protected static KompressorFixture createFixture() {
        KompressorFixture fixture = new KompressorFixture();

        // Original text:
        fixture.uncompressed = "All these things, and a thousand like them, came to pass " +
                "in and close upon the dear old year one thousand seven hundred and seventy-five.";

        // This is the 2gram compressed text
        fixture.compressed = "All +s\"!ings#/a 6/lik\"+m#cam\"to pass " +
                "i(/clos\"upo(!\"d04l%y04n\"65*(hu&re%5*nty-fi*.";

        // With corresponding grammar
        String[][] grammar = {
                {"23", "6"},
                {"th", "!"},
                {"e ", "\""},
                {", ", "#"},
                {"an", "$"},
                {"d ", "%"},
                {"nd", "&"},
                {" t", "'"},
                {"n ", "("},
                {"se", ")"},
                {"ve", "*"},
                {"!e", "+"},
                {"$%", "/"},
                {"ea", "0"},
                {"r ", "1"},
                {"!o", "2"},
                {"us", "3"},
                {"1o", "4"},
                {"/)", "5"},
        };

        for (String[] pair : grammar) {
            fixture.grammar.put(pair[0], pair[1].charAt(0));
        }

        return fixture;
    }
    //</editor-fold>

}
