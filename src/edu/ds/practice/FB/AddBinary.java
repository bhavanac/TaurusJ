package edu.ds.practice.FB;

public class AddBinary {
  public String addBinary(String a, String b) {
    int carry = 0;
    StringBuilder sum  = new StringBuilder();
    int i=a.length()-1,j=b.length()-1;
    while (i >= 0 || j >= 0) {
      int result = 0;
      if (i >= 0) { result += (a.charAt(i)-'0'); i--; }
      if (j >= 0) { result += (b.charAt(j)-'0'); j--; }
      sum.append((result%2) + carry);
      carry = (result)/2;
    }

    if (carry != 0) sum.append(carry);
    return sum.reverse().toString();
  }
}
