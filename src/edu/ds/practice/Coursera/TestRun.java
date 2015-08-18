package edu.ds.practice.Coursera;

import edu.ds.practice.Coursera.UnionFind.QuickFindUF;
import edu.ds.practice.Coursera.UnionFind.QuickUnionUF;

/**
 * Created by bchalla on 6/27/15.
 */
public class TestRun {

  public static void runQuickFindUF() {
    QuickFindUF quickFindUF = new QuickFindUF(10);
    quickFindUF.union(1,3);
    quickFindUF.union(4,5);
    quickFindUF.union(8,3);
    quickFindUF.union(2,7);
    quickFindUF.union(9,0);
    quickFindUF.union(9,1);
    quickFindUF.union(4,8);
    quickFindUF.union(0,5);
    System.out.println(quickFindUF.connected(2,7) ? "PASSED" : "FAILED");
    System.out.println(quickFindUF.connected(3,7) ? "FAILED" : "PASSED");
    System.out.println(quickFindUF.connected(3,8) ? "PASSED" : "FAILED");
    System.out.println(!quickFindUF.connected(6,7) ? "PASSED" : "FAILED");
    System.out.println(!quickFindUF.connected(2,9) ? "PASSED" : "FAILED");
  }

  public static void runQuickUnionUF() {
    QuickUnionUF quickUnionUF = new QuickUnionUF(10);
    quickUnionUF.union(1,3);
    quickUnionUF.union(4,5);
    quickUnionUF.union(8,3);
    quickUnionUF.union(2,7);
    quickUnionUF.union(9,0);
    quickUnionUF.union(9,1);
    quickUnionUF.union(4,8);
    quickUnionUF.union(0,5);
    System.out.println(quickUnionUF.connected(2,7) ? "PASSED" : "FAILED");
    System.out.println(quickUnionUF.connected(3,7) ? "FAILED" : "PASSED");
    System.out.println(quickUnionUF.connected(3,8) ? "PASSED" : "FAILED");
    System.out.println(!quickUnionUF.connected(6,7) ? "PASSED" : "FAILED");
    System.out.println(!quickUnionUF.connected(2,9) ? "PASSED" : "FAILED");
  }

}
