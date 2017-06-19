package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/11/15.
 */
public class IntToRoman {
  public String intToRoman(int num) {
    int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] literals = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    int index = 0;
    StringBuilder strBuilder = new StringBuilder();
    while (num != 0) {
      while ((num/values[index]) == 0){
        index++;
      }

      num = num-values[index];
      strBuilder.append(literals[index]);
    }

    return strBuilder.toString();
  }
}
