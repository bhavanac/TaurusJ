package edu.ds.practice.TopCoder;

/**
 * Created by bchalla on 10/20/15.
 */
public class MinimumPerfectSquares {
  public int num_squares(int n){
    int[] table = new int[n+1];
    double max = Math.floor(Math.sqrt(n));
    double squared;

    for (int i=0; i<=n; i++){
      table[i] = i;
    }
    print(table);
    for (int i=2; i<=max; i++){
      for (int j=0; j<=n; j++){
        squared = Math.pow(i,2.0);
        if (squared <= j)
          table[j] = Math.min(table[j], table[j-(int) squared]+1);

        print(table);
      }
    }
    return table[n];
  }


  void print(int[] table) {
    for(int i=0; i<table.length; i++) {
      System.out.print(table[i] + " ");
    }
    System.out.println();
  }
}
