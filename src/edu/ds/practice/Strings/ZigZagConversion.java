package edu.ds.practice.Strings;

/**
 * Created by bchalla on 11/16/15.
 */
public class ZigZagConversion {
  public String convert(String s, int numRows) {
    StringBuilder[] sb = new StringBuilder[numRows];
    int len = s.length();
    for (int i=0; i<numRows; i++) sb[i] = new StringBuilder();

    int i = 0;
    while (i < len) {
      for(int idx=0; idx<numRows && i<len; idx++) {
        sb[idx].append(s.charAt(i++));
      }
      /*
            03
          12
        21
      30 */
      for(int idx=numRows-2; idx>0 && i<len; idx--) {
        sb[idx].append(s.charAt(i++));
      }
    }

    StringBuilder result = new StringBuilder();
    for (int idx=0; idx<numRows; idx++) {
      result.append(sb[idx].toString());
    }
    return result.toString();
  }
}
