package edu.ds.practice;

import java.util.LinkedList;


public class MinStack {
    LinkedList<Integer> list;
    LinkedList<Integer> minList;

    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public void push(int x) {
        list.push(x);
        if (!minList.isEmpty()) {
            if (minList.peek() < x) return;
        }
        minList.push(x);
    }

    public void pop() {
        int poppedElement = list.pop();
        if (minList.peek() == poppedElement) { minList.pop(); }
    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        return minList.peek();
    }
}
