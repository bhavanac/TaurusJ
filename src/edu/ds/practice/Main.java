package edu.ds.practice;

import edu.ds.practice.Coursera.BasicTypes.Bag;
import edu.ds.practice.Coursera.BasicTypes.Stack;
import edu.ds.practice.Coursera.Sort.InsertionSort;
import edu.ds.practice.Coursera.Sort.MergeSort;
import edu.ds.practice.Coursera.Sort.MergeSortedStreams;
import edu.ds.practice.Coursera.Sort.QuickSort;
import edu.ds.practice.Coursera.Sort.SelectionSort;
import edu.ds.practice.Coursera.Sort.ShuffleSort;
import edu.ds.practice.Coursera.TestRun;
import edu.ds.practice.Geeksforgeeks.Arrays.ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        QuickSort.sort(arr3);
        System.out.println("Quick sort");
        for (Integer integer: arr3) {
            System.out.print(" " + integer);
        }


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

        System.out.println(ArrayProblems.maxSumNoTwoNumbersAreAdjacent(new int[]{5, 5, 10, 100, 10, 5}));
        ArrayProblems.printLeaders(new int[]{16, 17, 4, 3, 5, 2});
        ArrayProblems arrayProblems = new ArrayProblems();
        int [] result1 = arrayProblems.decreasingFrequencyOrder(new int[]{2, 5, 2, 8, 5, 6, 8, 8});
        System.out.println();
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(60);
        list.add(-10);
        list.add(70);
        list.add(-80);
        list.add(85);
        arrayProblems.minAbsolutePair(list);
        arrayProblems.smallestAndSecondSmallest(new int[]{12, 13, 1, 10, 34, 1});
        System.out.println(arrayProblems.majorityElementInSortedArray(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,5,6,7,7,8,9,9,9,9,9,9,9,9,9},8));
        int[] result2 = arrayProblems.segregate0sAnd1s(new int[]{0,1,0,0,0,0,1,1,1,0});
        System.out.println("0,1,0,0,0,0,1,1,1,0");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }

        java.util.Stack<Integer> sorted1 = new java.util.Stack<Integer>();
        sorted1.push(4);
        sorted1.push(4);
        sorted1.push(3);
        sorted1.push(2);
        sorted1.push(1);

        java.util.Stack<Integer> sorted2 = new java.util.Stack<Integer>();
        sorted2.push(10);
        sorted2.push(9);
        sorted2.push(9);
        sorted2.push(8);
        sorted2.push(5);

        java.util.Stack<Integer> sorted3 = new java.util.Stack<Integer>();
        sorted3.push(5);
        sorted3.push(3);
        sorted3.push(3);
        sorted3.push(2);
        sorted3.push(2);

        List<java.util.Stack<Integer>> sortedStacks = new ArrayList<java.util.Stack<Integer>>();
        sortedStacks.add(sorted1);
        sortedStacks.add(sorted2);
        sortedStacks.add(sorted3);

        MergeSortedStreams.merge(sortedStacks);
    }
}
