package edu.ds.practice.FB;

public class ExcelSheetColumn {
  public String convertToTitle(int n) {
    String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();


    while (n-1 >= 26) {
      sb.append(chars[(n/26)-1]);
      n = n%26;
    }

    sb.append(chars[n-1]);
    return sb.toString();
  }
}
