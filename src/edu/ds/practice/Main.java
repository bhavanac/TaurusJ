package edu.ds.practice;

import edu.ds.practice.Coursera.BasicTypes.Bag;
import edu.ds.practice.Coursera.BasicTypes.Stack;
import edu.ds.practice.Coursera.Sort.InsertionSort;
import edu.ds.practice.Coursera.Sort.SelectionSort;
import edu.ds.practice.Coursera.Sort.ShuffleSort;
import edu.ds.practice.Coursera.TestRun;
import edu.ds.practice.Geeksforgeeks.Arrays.ArrayProblems;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("My first GitHub commit !");

        TestRun.runQuickFindUF();
        TestRun.runQuickUnionUF();

        Integer[] arr = {4,10,6,7,2,3,1,1,123};
        SelectionSort.sort(arr);
        System.out.println();

        Integer[] arr2 = {1,2,3,4};
        InsertionSort.sort(arr2);
        System.out.println();

        Integer[] arr3 = {4,10,6,7,2,3,1,1,123};
        ShuffleSort.shuffle(arr3);

        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<10; i++) {
            stack.push(i);
        }

        System.out.println();
        for (Integer integer: stack) {
            System.out.print(" " + integer);
        }

        System.out.println(ArrayProblems.doesPairExist(new int[]{4, 10, 6, 7, 2, 3, 1, 1, 123}, 149));
        System.out.println("-7, -3, -4, -1, 2, 1, -5");
        System.out.println(ArrayProblems.largestProductSubarry(new int[]{-7, -3, -4, -1, 2, 1, -5}));
        System.out.println(ArrayProblems.missingNumber(new int[]{1,2, 6,8,4,3,7}));
        System.out.println(ArrayProblems.findNumberSortedRotatedArray(new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 114));
        int[] mn = new int[10];
        mn[0] = 1;
        mn[1] = 2;
        int[] n = new int[] { 6,8,10, 32, 33, 34,45, 70};

        System.out.println("1,2,5,5,6,7,8,8,90");
        System.out.println(ArrayProblems.medianOfTwoSortedArrays(new int[]{1,5,6,7,8}, new int[]{2,5,8,90}));
        int [] result = ArrayProblems.rotateArray(new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }




    }



}
